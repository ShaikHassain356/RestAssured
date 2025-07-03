package PracticeJava;

import java.util.Scanner;

public class SwappingOfTwoVariableValuesWithoutUsingThirdVariable {

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the value of a");

        int a=sc.nextInt();

        System.out.println("Enter the value of b");

        int b=sc.nextInt();

        a=a+b;
        b=a-b;
        a=a-b;

        System.out.println("after swapping the values, value of a is "+a+" and the value of b is "+b);

    }
}
