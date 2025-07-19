import java.util.*;
public class task5 {
    public static void main(String[] args) {
        ArrayList<Integer> inputnums = new ArrayList<>();
        System.out.println("Enter first number: ");
        Scanner input1 = new Scanner(System.in);
        int tempnum = input1.nextInt();
        inputnums.add(tempnum);
        System.out.println("Enter second number: ");
        Scanner input2 = new Scanner(System.in);
        tempnum = input2.nextInt();
        inputnums.add(tempnum);
        System.out.println("Enter third number: ");
        Scanner input3 = new Scanner(System.in);
        tempnum = input3.nextInt();
        inputnums.add(tempnum);
        System.out.println(inputnums);
        if(inputnums.stream().distinct().count() <= 1) {
            System.out.println("All numbers are equal");}
            else {
                Collections.sort(inputnums, Collections.reverseOrder());
                System.out.println("Largest number is: " + inputnums.get(0));
            }
    }
}