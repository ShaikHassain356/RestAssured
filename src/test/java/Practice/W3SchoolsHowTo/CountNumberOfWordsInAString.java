package Practice.W3SchoolsHowTo;

import java.util.Scanner;

public class CountNumberOfWordsInAString {

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string the words u want to count");

        String s=sc.nextLine();

        int count= s.split("\\s+").length; // + after \\s represents is there are extra spaces between the words

        System.out.println("number of words in a given strings are "+count);


    }
}
