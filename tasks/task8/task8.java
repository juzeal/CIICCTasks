package tasks.task8;

public class task8 {

    public static void main(String[] args) {
        System.out.println("Processing parameters (4, 5, 10):");
        int[] result1 = calculateSums(4, 5, 10);
        System.out.println("Total sum: " + result1[0]);
        System.out.print("Cumulative sums: ");
        for (int i = 1; i < result1.length; i++) {
            System.out.print(result1[i] + (i < result1.length - 1 ? ", " : ""));
        }
        System.out.println();

        System.out.println("\nProcessing parameters (1, 2, 3):");
        int[] result2 = calculateSums(1, 2, 3);
        System.out.println("Total sum: " + result2[0]);
        System.out.print("Cumulative sums: ");
        for (int i = 1; i < result2.length; i++) {
            System.out.print(result2[i] + (i < result2.length - 1 ? ", " : ""));
        }
        System.out.println();

        System.out.println("\nProcessing parameters (7):");
        int[] result3 = calculateSums(7);
        System.out.println("Total sum: " + result3[0]);
        System.out.print("Cumulative sums: ");
        for (int i = 1; i < result3.length; i++) {
            System.out.print(result3[i] + (i < result3.length - 1 ? ", " : ""));
        }
        System.out.println();

        System.out.println("\nProcessing no parameters:");
        int[] result4 = calculateSums();
        System.out.println("Total sum: " + result4[0]);
        System.out.print("Cumulative sums: ");
        if (result4.length > 1) {
            for (int i = 1; i < result4.length; i++) {
                System.out.print(result4[i] + (i < result4.length - 1 ? ", " : ""));
            }
        } else {
            System.out.print("N/A");
        }
        System.out.println();
    }

    public static int[] calculateSums(int... numbers) {
        int totalSum = 0;
        int[] results = new int[1 + numbers.length];
        int currentCumulativeSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            int param = numbers[i];
            totalSum += param;

            currentCumulativeSum = (param * (param + 1)) / 2;
            results[i + 1] = currentCumulativeSum;
        }

        results[0] = totalSum; 
        return results;
    }
}