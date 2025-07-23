package tasks.task9;

import static java.lang.Math.*; // Static import for Math class methods

public class task9 {

    /**
     * Adds two integers using Math.addExact().
     * @param a The first integer.
     * @param b The second integer.
     * @return The sum of a and b.
     * @throws ArithmeticException if the result overflows an int.
     */
    public static int add(int a, int b) {
        return addExact(a, b);
    }

    /**
     * Subtracts the second integer from the first using Math.subtractExact().
     * @param a The first integer.
     * @param b The second integer.
     * @return The difference of a and b.
     * @throws ArithmeticException if the result overflows an int.
     */
    public static int subtract(int a, int b) {
        return subtractExact(a, b);
    }

    /**
     * Multiplies two integers using Math.multiplyExact().
     * @param a The first integer.
     * @param b The second integer.
     * @return The product of a and b.
     * @throws ArithmeticException if the result overflows an int.
     */
    public static int multiply(int a, int b) {
        return multiplyExact(a, b);
    }

    /**
     * Divides two integers using Math.floorDiv().
     * Note: floorDiv performs floor division, which rounds towards negative infinity.
     * @param a The dividend.
     * @param b The divisor.
     * @return The result of floor division of a by b as a float.
     * Casting to float is done at the end as per method signature.
     * Handles division by zero by returning Float.NaN and printing an error.
     */
    public static float divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Float.NaN; // Not a Number, a common way to indicate invalid float result
        }
        return (float) floorDiv(a, b);
    }

    public static void main(String[] args) {
        // Demonstrate the math operations here

        int num1 = 10;
        int num2 = 5;
        int num3 = -7;
        int num4 = 3;
        int num5 = 0; // For division by zero test

        System.out.println("--- Basic Math Operations ---");

        // Addition
        System.out.println(num1 + " + " + num2 + " = " + add(num1, num2)); // 10 + 5 = 15
        System.out.println(num1 + " + " + num3 + " = " + add(num1, num3)); // 10 + (-7) = 3
        // Uncomment the line below to see an ArithmeticException (integer overflow)
        // System.out.println(Integer.MAX_VALUE + " + 1 = " + add(Integer.MAX_VALUE, 1));

        System.out.println("\n--- Subtraction ---");
        // Subtraction
        System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2)); // 10 - 5 = 5
        System.out.println(num3 + " - " + num2 + " = " + subtract(num3, num2)); // -7 - 5 = -12
        // Uncomment the line below to see an ArithmeticException (integer underflow)
        // System.out.println(Integer.MIN_VALUE + " - 1 = " + subtract(Integer.MIN_VALUE, 1));


        System.out.println("\n--- Multiplication ---");
        // Multiplication
        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2)); // 10 * 5 = 50
        System.out.println(num3 + " * " + num4 + " = " + multiply(num3, num4)); // -7 * 3 = -21
        // Uncomment the line below to see an ArithmeticException (integer overflow)
        // System.out.println(Integer.MAX_VALUE + " * 2 = " + multiply(Integer.MAX_VALUE / 2 + 1, 2));


        System.out.println("\n--- Division (Floor Division) ---");
        // Division (using floorDiv, which rounds towards negative infinity)
        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));   // 10 / 5 = 2.0 (floorDiv(10,5) = 2)
        System.out.println(num1 + " / " + num4 + " = " + divide(num1, num4));   // 10 / 3 = 3.0 (floorDiv(10,3) = 3)
        System.out.println(num3 + " / " + num4 + " = " + divide(num3, num4));   // -7 / 3 = -3.0 (floorDiv(-7,3) = -3)
        System.out.println(num2 + " / " + num3 + " = " + divide(num2, num3));   // 5 / -7 = -1.0 (floorDiv(5,-7) = -1)

        // Division by zero test - this is handled inside the divide method, so it won't crash the program here
        System.out.println(num1 + " / " + num5 + " = " + divide(num1, num5)); // 10 / 0 = Error
    }
}