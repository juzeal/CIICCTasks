package tasks.task7;

import java.util.*;

public class task7 {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter first num:");
        int a = s.nextInt();
        System.out.println("Enter Second num:");
        int b = s.nextInt();
        
        Operands arith =  new Operands(a, b);
        System.out.println("Sum: " + arith.sum());
        System.out.println("Difference: " + arith.diff());
        System.out.println("Product: " + arith.prod());
        System.out.println("Quotient: " + arith.quot());
        s.close();
    }
}

class Operands {
    int a;
    int b;

    public Operands(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int sum() {
        int sum = a + b;
        return sum;
    }

    public int diff() {
        int diff = a - b;
        return diff;
    }

    public int prod() {
        int prod = a * b;
        return prod;
    }

    public float quot() {
        int quot = a / b;
        return quot;
    }
}
