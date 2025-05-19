package Practice.W3SchoolsHowTo;

public class SmallestElementInAArray {

    public static void main(String[]args)
    {
        int[] myint={200, 150, 3, 222, 12, 1, -1, 30, -30,-20};

        int smallestelement=0;

        for (int i=0; i<myint.length; i++)
        {
            if (smallestelement>myint[i])
            {
                smallestelement=myint[i];
            }
        }

        System.out.println("smallest Element in the given array is "+smallestelement);
    }
}
