# Expression Tabulator

Simple math parser and calculator.
It parses an expression as a function of three variables `x`, `y`, `z`
and calculate its value in the interval from -2 to 2.

Supported operation:
`+`, `-`, `*`, `/`, `abs`, `mod`, `square`

You can pass the calculation mode as a command line argument.
Supported 6 modes:

| Mode  | Description                                  |
|-------|----------------------------------------------|
| `-u`  | Calculation in `int` _(default)_             |
| `-i`  | Calculation in `int` with  overflow checking |
| `-i`  | Calculation in `byte`                        |
| `-d`  | Calculation in `double`                      |
| `-bi` | Calculation in `BigInteger`                  |
| `-p`  | Calculation in `group of Int modulo 1009`    |


Build:
```
javac -cp src -d out src/Main.java
```

Run:
```
java -cp out Main examples/test.elf examples/out.asm
```

## Example

```
> java -cp out Main -d
Enter expression:
x*x + 1.3*y/z
x = -2  y = -2  z = -2  f(x, y, z) = 5.3
x = -2  y = -2  z = -1  f(x, y, z) = 6.6
x = -2  y = -2  z = 0   f(x, y, z) = -Infinity
x = -2  y = -2  z = 1   f(x, y, z) = 1.4
x = -2  y = -2  z = 2   f(x, y, z) = 2.7
x = -2  y = -1  z = -2  f(x, y, z) = 4.65
x = -2  y = -1  z = -1  f(x, y, z) = 5.3
x = -2  y = -1  z = 0   f(x, y, z) = -Infinity
x = -2  y = -1  z = 1   f(x, y, z) = 2.7
x = -2  y = -1  z = 2   f(x, y, z) = 3.35
x = -2  y = 0   z = -2  f(x, y, z) = 4.0
x = -2  y = 0   z = -1  f(x, y, z) = 4.0
x = -2  y = 0   z = 0   f(x, y, z) = NaN
x = -2  y = 0   z = 1   f(x, y, z) = 4.0
x = -2  y = 0   z = 2   f(x, y, z) = 4.0
x = -2  y = 1   z = -2  f(x, y, z) = 3.35
x = -2  y = 1   z = -1  f(x, y, z) = 2.7
x = -2  y = 1   z = 0   f(x, y, z) = Infinity
x = -2  y = 1   z = 1   f(x, y, z) = 5.3
x = -2  y = 1   z = 2   f(x, y, z) = 4.65
x = -2  y = 2   z = -2  f(x, y, z) = 2.7
x = -2  y = 2   z = -1  f(x, y, z) = 1.4
x = -2  y = 2   z = 0   f(x, y, z) = Infinity
x = -2  y = 2   z = 1   f(x, y, z) = 6.6
x = -2  y = 2   z = 2   f(x, y, z) = 5.3
x = -1  y = -2  z = -2  f(x, y, z) = 2.3
x = -1  y = -2  z = -1  f(x, y, z) = 3.6
x = -1  y = -2  z = 0   f(x, y, z) = -Infinity
x = -1  y = -2  z = 1   f(x, y, z) = -1.6
x = -1  y = -2  z = 2   f(x, y, z) = -0.30000000000000004
x = -1  y = -1  z = -2  f(x, y, z) = 1.65
x = -1  y = -1  z = -1  f(x, y, z) = 2.3
x = -1  y = -1  z = 0   f(x, y, z) = -Infinity
x = -1  y = -1  z = 1   f(x, y, z) = -0.30000000000000004
x = -1  y = -1  z = 2   f(x, y, z) = 0.35
x = -1  y = 0   z = -2  f(x, y, z) = 1.0
x = -1  y = 0   z = -1  f(x, y, z) = 1.0
x = -1  y = 0   z = 0   f(x, y, z) = NaN
x = -1  y = 0   z = 1   f(x, y, z) = 1.0
x = -1  y = 0   z = 2   f(x, y, z) = 1.0
x = -1  y = 1   z = -2  f(x, y, z) = 0.35
x = -1  y = 1   z = -1  f(x, y, z) = -0.30000000000000004
x = -1  y = 1   z = 0   f(x, y, z) = Infinity
x = -1  y = 1   z = 1   f(x, y, z) = 2.3
x = -1  y = 1   z = 2   f(x, y, z) = 1.65
x = -1  y = 2   z = -2  f(x, y, z) = -0.30000000000000004
x = -1  y = 2   z = -1  f(x, y, z) = -1.6
x = -1  y = 2   z = 0   f(x, y, z) = Infinity
x = -1  y = 2   z = 1   f(x, y, z) = 3.6
x = -1  y = 2   z = 2   f(x, y, z) = 2.3
x = 0   y = -2  z = -2  f(x, y, z) = 1.3
x = 0   y = -2  z = -1  f(x, y, z) = 2.6
x = 0   y = -2  z = 0   f(x, y, z) = -Infinity
x = 0   y = -2  z = 1   f(x, y, z) = -2.6
x = 0   y = -2  z = 2   f(x, y, z) = -1.3
x = 0   y = -1  z = -2  f(x, y, z) = 0.65
x = 0   y = -1  z = -1  f(x, y, z) = 1.3
x = 0   y = -1  z = 0   f(x, y, z) = -Infinity
x = 0   y = -1  z = 1   f(x, y, z) = -1.3
x = 0   y = -1  z = 2   f(x, y, z) = -0.65
x = 0   y = 0   z = -2  f(x, y, z) = 0.0
x = 0   y = 0   z = -1  f(x, y, z) = 0.0
x = 0   y = 0   z = 0   f(x, y, z) = NaN
x = 0   y = 0   z = 1   f(x, y, z) = 0.0
x = 0   y = 0   z = 2   f(x, y, z) = 0.0
x = 0   y = 1   z = -2  f(x, y, z) = -0.65
x = 0   y = 1   z = -1  f(x, y, z) = -1.3
x = 0   y = 1   z = 0   f(x, y, z) = Infinity
x = 0   y = 1   z = 1   f(x, y, z) = 1.3
x = 0   y = 1   z = 2   f(x, y, z) = 0.65
x = 0   y = 2   z = -2  f(x, y, z) = -1.3
x = 0   y = 2   z = -1  f(x, y, z) = -2.6
x = 0   y = 2   z = 0   f(x, y, z) = Infinity
x = 0   y = 2   z = 1   f(x, y, z) = 2.6
x = 0   y = 2   z = 2   f(x, y, z) = 1.3
x = 1   y = -2  z = -2  f(x, y, z) = 2.3
x = 1   y = -2  z = -1  f(x, y, z) = 3.6
x = 1   y = -2  z = 0   f(x, y, z) = -Infinity
x = 1   y = -2  z = 1   f(x, y, z) = -1.6
x = 1   y = -2  z = 2   f(x, y, z) = -0.30000000000000004
x = 1   y = -1  z = -2  f(x, y, z) = 1.65
x = 1   y = -1  z = -1  f(x, y, z) = 2.3
x = 1   y = -1  z = 0   f(x, y, z) = -Infinity
x = 1   y = -1  z = 1   f(x, y, z) = -0.30000000000000004
x = 1   y = -1  z = 2   f(x, y, z) = 0.35
x = 1   y = 0   z = -2  f(x, y, z) = 1.0
x = 1   y = 0   z = -1  f(x, y, z) = 1.0
x = 1   y = 0   z = 0   f(x, y, z) = NaN
x = 1   y = 0   z = 1   f(x, y, z) = 1.0
x = 1   y = 0   z = 2   f(x, y, z) = 1.0
x = 1   y = 1   z = -2  f(x, y, z) = 0.35
x = 1   y = 1   z = -1  f(x, y, z) = -0.30000000000000004
x = 1   y = 1   z = 0   f(x, y, z) = Infinity
x = 1   y = 1   z = 1   f(x, y, z) = 2.3
x = 1   y = 1   z = 2   f(x, y, z) = 1.65
x = 1   y = 2   z = -2  f(x, y, z) = -0.30000000000000004
x = 1   y = 2   z = -1  f(x, y, z) = -1.6
x = 1   y = 2   z = 0   f(x, y, z) = Infinity
x = 1   y = 2   z = 1   f(x, y, z) = 3.6
x = 1   y = 2   z = 2   f(x, y, z) = 2.3
x = 2   y = -2  z = -2  f(x, y, z) = 5.3
x = 2   y = -2  z = -1  f(x, y, z) = 6.6
x = 2   y = -2  z = 0   f(x, y, z) = -Infinity
x = 2   y = -2  z = 1   f(x, y, z) = 1.4
x = 2   y = -2  z = 2   f(x, y, z) = 2.7
x = 2   y = -1  z = -2  f(x, y, z) = 4.65
x = 2   y = -1  z = -1  f(x, y, z) = 5.3
x = 2   y = -1  z = 0   f(x, y, z) = -Infinity
x = 2   y = -1  z = 1   f(x, y, z) = 2.7
x = 2   y = -1  z = 2   f(x, y, z) = 3.35
x = 2   y = 0   z = -2  f(x, y, z) = 4.0
x = 2   y = 0   z = -1  f(x, y, z) = 4.0
x = 2   y = 0   z = 0   f(x, y, z) = NaN
x = 2   y = 0   z = 1   f(x, y, z) = 4.0
x = 2   y = 0   z = 2   f(x, y, z) = 4.0
x = 2   y = 1   z = -2  f(x, y, z) = 3.35
x = 2   y = 1   z = -1  f(x, y, z) = 2.7
x = 2   y = 1   z = 0   f(x, y, z) = Infinity
x = 2   y = 1   z = 1   f(x, y, z) = 5.3
x = 2   y = 1   z = 2   f(x, y, z) = 4.65
x = 2   y = 2   z = -2  f(x, y, z) = 2.7
x = 2   y = 2   z = -1  f(x, y, z) = 1.4
x = 2   y = 2   z = 0   f(x, y, z) = Infinity
x = 2   y = 2   z = 1   f(x, y, z) = 6.6
x = 2   y = 2   z = 2   f(x, y, z) = 5.3
```
