package Practice.W3SchoolsHowTo;

import java.util.Scanner;

public class CountLettersOfAStringUserInput {

    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the required string that u want to count the letters");

        String s=sc.nextLine();

        int count=0;

        for (int i=0; i<s.length();i++)
        {
            count+=1;
        }

        System.out.println("given string is " +s+", number of letters in a given string is "+count);

    }
}
