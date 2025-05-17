package Practice.W3SchoolsHowTo;

import java.util.Scanner;

public class ReverseAString {

    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the string that u want to reverse");

        String s=sc.nextLine();

        String reversestring="";

        for (int i=s.length()-1; i>=0;i--)
        {
            reversestring=reversestring+s.charAt(i);
        }

        System.out.println("after reversing the string "+reversestring);

        //using built in methods

        StringBuffer sb=new StringBuffer(s);
        System.out.println(sb.reverse());

        StringBuilder sbuilder=new StringBuilder(s);
        System.out.println(sbuilder.reverse());
    }
}
