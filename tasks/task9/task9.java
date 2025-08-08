package tasks.task9;

import static java.lang.Math.*;

public class task9 {

   
    public static int add(int a, int b) {
        return addExact(a, b);
    }

   
    public static int subtract(int a, int b) {
        return subtractExact(a, b);
    }

   
    public static int multiply(int a, int b) {
        return multiplyExact(a, b);
    }

   
    public static float divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return Float.NaN; 
        }
        return (float) floorDiv(a, b);
    }

    public static void main(String[] args) {
     

        int num1 = 10;
        int num2 = 5;
        int num3 = -7;
        int num4 = 3;
        int num5 = 0; 

        System.out.println("--- Basic Math Operations ---");

        System.out.println(num1 + " + " + num2 + " = " + add(num1, num2));
        System.out.println(num1 + " + " + num3 + " = " + add(num1, num3));

        System.out.println("\n--- Subtraction ---");
        System.out.println(num1 + " - " + num2 + " = " + subtract(num1, num2)); 
        System.out.println(num3 + " - " + num2 + " = " + subtract(num3, num2)); 


        System.out.println("\n--- Multiplication ---");
        System.out.println(num1 + " * " + num2 + " = " + multiply(num1, num2));
        System.out.println(num3 + " * " + num4 + " = " + multiply(num3, num4)); 
        


        System.out.println("\n--- Division (Floor Division) ---");
        
        System.out.println(num1 + " / " + num2 + " = " + divide(num1, num2));   
        System.out.println(num1 + " / " + num4 + " = " + divide(num1, num4));   
        System.out.println(num3 + " / " + num4 + " = " + divide(num3, num4));   
        System.out.println(num2 + " / " + num3 + " = " + divide(num2, num3));   

        
        System.out.println(num1 + " / " + num5 + " = " + divide(num1, num5));
    }
}