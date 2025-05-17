package Practice.W3SchoolsHowTo;

public class SumOfArrayElements {
    public static void main(String []args)
    {
        int[] myArray = {1, 5, 10, 25};

        int sum=0;

        for (int i=0; i<myArray.length;i++)
        {
            sum+=myArray[i];
        }
        System.out.println("sum of array elements are: "+sum);
    }
}
