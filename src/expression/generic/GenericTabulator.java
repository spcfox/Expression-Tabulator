package expression.generic;

import expression.exceptions.ExpressionException;
import expression.generic.operations.TripleExpression;
import expression.generic.parser.ExpressionParser;
import expression.generic.calculators.*;
import parser.ParseException;

public class GenericTabulator implements Tabulator {
    public static void printTable(Object[][][] table, int x1, int y1, int z1) {
        for (int x = x1; x - x1 < table.length;  x++) {
            int i = x - x1;
            for (int y = y1; y - y1 < table[i].length; y++) {
                int j = y - y1;
                for (int z = z1; z - z1 < table[i][j].length; z++) {
                    int k = z - z1;
                    printLine(x, y, z, table[i][j][k]);
                }
            }
        }
    }

    private static void printLine(int x, int y, int z, Object value) {
        System.out.printf("x = %s\ty = %s\tz = %s\tf(x, y, z) = %s%n", x, y, z, value);
    }

    @Override
    public Object[][][] tabulate(String mode, String expression, int x1, int x2, int y1, int y2, int z1, int z2) throws ParseException {
        Tabulator<?> tabulator = switch (mode) {
            case "i" -> new Tabulator<>(CheckedIntegerCalculator.calculator);
            case "d" -> new Tabulator<>(DoubleCalculator.calculator);
            case "bi" -> new Tabulator<>(BigIntegerCalculator.calculator);
            case "u" -> new Tabulator<>(IntegerCalculator.calculator);
            case "p" -> new Tabulator<>(IntegerModCalculator.calculator);
            case "b" -> new Tabulator<>(ByteCalculator.calculator);
            default -> throw new IllegalArgumentException("Incorrect mode");
        };
        return tabulator.tabulate(expression, x1, x2, y1, y2, z1, z2);
    }

    private record Tabulator<T extends Number>(Calculator<T> calculator) {
        public Object[][][] tabulate(String expressionStr, int x1, int x2, int y1, int y2, int z1, int z2) throws ParseException {
            Object[][][] table = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
            TripleExpression expression = ExpressionParser.parse(expressionStr, calculator);
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    for (int z = z1; z <= z2; z++) {
                        try {
                            table[x - x1][y - y1][z - z1] = expression.evaluate(
                                    calculator.valueOf(x),
                                    calculator.valueOf(y),
                                    calculator.valueOf(z),
                                    calculator
                            );
                        } catch (ExpressionException ignored) {
                        }
                    }
                }
            }
            return table;
        }
    }
}
