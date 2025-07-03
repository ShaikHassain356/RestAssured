package PracticeJava;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number");
        int num=sc.nextInt();
        int a=0, b=1;

        System.out.println("Fibonacci series: " +a +" " +b+" ");

        for (int i=0;i<=num;i++)
        {
            int c=a+b;
            System.out.println(c +" ");
            a=b;
            b=c;
        }

        sc.close();
    }
}
