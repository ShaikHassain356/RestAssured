package PracticeJava;

import java.util.Scanner;

public class PrimeNumberCheck {
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number that u want to check whether it is prime or not");
        int num=sc.nextInt();

        boolean isprime=true;

        if (num<=1)
        {
            isprime=false;
        }

        else
        {
            for (int i=2;i<=Math.sqrt(num);i++)
            {
                if (num%i==0)
                {
                    isprime=false;
                    break;
                }
            }
        }

        if (isprime)
        {
            System.out.println("given number is a prime number");
        }
        else
        {
            System.out.println("given number is not a prime number");
        }
        sc.close();
    }
}
