package Practice.W3SchoolsHowTo;

import java.util.Scanner;

public class ConvertStringToArray {
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the String that u want to convert it to array");

        String s=sc.nextLine();

        char[] mychararray=s.toCharArray();

        System.out.println(mychararray[3]);

        for (char c:mychararray)
        {
            System.out.println(c);
        }
    }
}
