package Practice.W3SchoolsHowTo;

import java.util.Scanner;

public class AddThreeNumbersWithUserInput {

    public static void main(String []args)
    {

        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the value of x");
        int x=sc.nextInt();

        System.out.println("Enter the value of y");
        int y= sc.nextInt();

        System.out.println("Enter the value of z");
        int z= sc.nextInt();

        int result=x+y+z;
        System.out.println("sum of three numbers are: "+result);
    }
}
