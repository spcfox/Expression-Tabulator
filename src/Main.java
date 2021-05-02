import expression.generic.GenericTabulator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x1 = -2;
        int x2 = 2;
        int y1 = -2;
        int y2 = 2;
        int z1 = -2;
        int z2 = 2;
        Object[][][] table;
        System.out.println("Enter expression:");
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        String mode = (args.length > 0) ? args[0].substring(1) : "u";
        try {
            table = new GenericTabulator().tabulate(mode, expression, x1, x2, y1, y2, z1, z2);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            e.printStackTrace();
            return;
        }
        GenericTabulator.printTable(table, x1, y1, z1);
    }
}
