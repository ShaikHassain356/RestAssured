package PracticeJava;

import java.util.Scanner;

public class FactorialUsingIteration {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the number");
        int num=sc.nextInt();

        long factorial=1;

        for (int i=1;i<=num;i++)
        {
            factorial*=i;
        }
        System.out.println("Factorial of a number is "+factorial);
    }
}
