package PracticeJava;

import java.util.Scanner;

public class ReverseEachCharacterInAString {

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the string that u want to reverse");

        String actual=sc.nextLine();

        String reversed="";

        for (int i=actual.length()-1;i>=0;i--)
        {
            reversed=reversed+actual.charAt(i);
        }

        System.out.println("String after reversed is "+reversed);

        System.out.println("Enter the String two");
        String s2=sc.nextLine();

        StringBuilder sb=new StringBuilder(s2);
        sb.reverse();
        System.out.println("after reversing the string using string builder "+sb);

        System.out.println("Enter the string three");
        String s3=sc.nextLine();

        StringBuffer sb2=new StringBuffer(s3);
        sb2.reverse();
        System.out.println("after reversing the string using string buffer "+sb2);


    }
}
