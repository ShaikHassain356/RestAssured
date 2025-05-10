package Practice;

import java.util.Scanner;

public class scanner {
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the name");
        String myname= sc.nextLine();
        System.out.println("Enter the age");
        int age= sc.nextInt();
        System.out.println("Hi "+myname +" your age is "+age);
    }
}
