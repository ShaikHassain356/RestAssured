package PracticeJava;

import java.util.Scanner;

public class PalindromeCheck {
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number that u want to check the palindrome");

        int num=sc.nextInt();
        int actualnum=num;

        int reverednum=0;

        while (num!=0)
        {
            int digit=num%10; //this will extract the last digit
            reverednum =reverednum*10+digit;
            num=num/10; //this will removed last digit

        }

        if (reverednum==actualnum)
        {
            System.out.println("given number is palindrome number");
        }
        else {
            System.out.println("given number is not a palindrome number");
        }
    }
}
