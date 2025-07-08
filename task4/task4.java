package task4;
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter word: ");
        String inputWord = s.nextLine();
        Palindrome p = new Palindrome();
        if (p.checkPalindrome(inputWord) == true) {
            System.out.println("The input string is palindrome");
        }
        else {
            System.out.println("The input string is not palindrome");
        }
        s.close();
    }
}

class Palindrome {
    String word;

    public boolean checkPalindrome(String wordToCheck) {
        StringBuilder w = new StringBuilder(wordToCheck);
        return wordToCheck.equals(w.reverse().toString());
    }
}
