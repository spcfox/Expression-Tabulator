package expression.generic.parser;

import expression.generic.calculators.Calculator;
import expression.generic.operations.*;
import parser.*;

public class ExpressionParser {
    public static <T extends Number> TripleExpression parse(String expression, Calculator<T> calculator) throws ParseException {
        return new Parser<T>(expression, calculator).parseExpression();
    }

    private static class Parser<T extends Number> extends BaseParser {
        private final Calculator<T> calculator;

        public Parser(CharSource source, Calculator<T> calculator) {
            super(source);
            nextChar();
            this.calculator = calculator;
        }

        private Parser(String expression, Calculator<T> calculator) {
            this(new StringSource(expression), calculator);
        }

        private TripleExpression parseExpression() throws ParseException {
            final TripleExpression result = parseSubExpression(false);
            if (eof()) {
                return result;
            }
            throw new UnexpectedEndException("End of expression expected");
        }

        private TripleExpression parseSubExpression(boolean inBrackets) throws ParseException {
            TripleExpression expression = parseTerm();
            while (true) {
                skipWhitespace();
                if (testAndSkip('+')) {
                    expression = new Add(expression, parseTerm());
                } else if (testAndSkip('-')) {
                    expression = new Subtract(expression, parseTerm());
                } else {
                    break;
                }
            }

            if (inBrackets) {
                expect(')');
            }

            return expression;
        }

        private TripleExpression parseTerm() throws ParseException {
            TripleExpression term = parseFactor();
            while (true) {
                skipWhitespace();
                if (testAndSkip('*')) {
                    term = new Multiply(term, parseFactor());
                } else if (testAndSkip('/')) {
                    term = new Divide(term, parseFactor());
                } else if (testAndSkip("mod")) {
                    term = new Mod(term, parseFactor());
                } else {
                    break;
                }
            }
            return term;
        }

        private TripleExpression parseFactor() throws ParseException {
            skipWhitespace();
            if (testAndSkip('(')) {
                return parseSubExpression(true);
            } else if (testAndSkip('-')) {
                return parseUnaryMinus();
            } else if (ch >= '0' && ch <= '9') {
                return parseConst();
            } else if (ch >= 'x' && ch <= 'z') {
                return parseVariable();
            } else if (testAndSkip("abs")) {
                checkArgumentAfterKeyword();
                return new Abs(parseFactor());
            } else if (testAndSkip("square")) {
                checkArgumentAfterKeyword();
                return new Square(parseFactor());
            }
            throw new UnexpectedSymbolException(
                    String.format("Unexpected symbol in at position %d: '%c' - %d", source.getPosition(), ch, (int) ch)
            );
        }

        private void checkArgumentAfterKeyword() throws ParseException {
            if (Character.isLetter(ch) || (ch >= '0' && ch <= '9')) {
                throw new UnexpectedEndException(
                        String.format("Unexpected symbol after keyword at position %d: '%c' - %d", source.getPosition(), ch, (int) ch)
                );
            }
        }

        private TripleExpression parseUnaryMinus() throws ParseException {
            if (ch >= '0' && ch <= '9') {
                return parseConst(true);
            }
            skipWhitespace();
            return new Negate(parseFactor());
        }

        private TripleExpression parseConst() throws ParseNumberException {
            return parseConst(false);
        }

        private TripleExpression parseConst(boolean negative) throws ParseNumberException {
            final StringBuilder sb = new StringBuilder();
            if (negative) {
                sb.append('-');
            }

            if (ch >= '0' && ch <= '9') {
                sb.append(ch);
                nextChar();
            }

            while (ch >= '0' && ch <= '9' || ch == '.') {
                sb.append(ch);
                nextChar();
            }
            skipWhitespace();
            try {
                return new Const<T>(calculator.valueOf(sb.toString()));
            } catch (NumberFormatException e) {
                throw new ParseNumberException("Incorrect number: " + sb, e);
            }
        }

        private TripleExpression parseVariable() {
            final String name = String.valueOf(ch);
            nextChar();
            skipWhitespace();
            return new Variable(name);
        }
    }
}
