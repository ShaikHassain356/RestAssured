package Practice.W3SchoolsHowTo;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class SortingArray {
    public static void main(String[]args)
    {
        String[] cars={"BMW", "Audi", "Porsche", "Jaguar", "Astro Martin", "Volvo"};

        //Arrays.sort(cars);//ascending order

        Arrays.sort(cars, Collections.reverseOrder()); // Descending order


        for (String name :cars)
        {
            System.out.println(name);
        }

    }
}
