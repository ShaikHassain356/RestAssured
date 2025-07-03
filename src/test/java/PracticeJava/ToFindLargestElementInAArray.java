package PracticeJava;

import java.util.Scanner;

public class ToFindLargestElementInAArray {
    public static void main(String []args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the array");
        int size=sc.nextInt();
        int[] array=new int[size];

        System.out.println("Enter the "+size +" Integer values");

        for (int i=0;i<size;i++)
        {
            System.out.println("Enter the value at the position "+i);
            array[i]=sc.nextInt();
        }

        int largest=array[0];
        int position=0;
        for (int i=1;i<array.length;i++)
        {
            if (array[i]>largest)
            {
                largest=array[i];
                position=i;
            }

        }
        System.out.println("The largest element in the array is "+largest +" at the position "+"array"+"["+position+"]");
    }
}
