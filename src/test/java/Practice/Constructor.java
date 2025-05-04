package Practice;

import org.testng.annotations.Test;

public class Constructor {
    static int year;
    static String carname;

      Constructor(int yr, String name)
    {
        year=yr;
        carname=name;
    }


    public static void main(String []args)
    {
        Constructor cr=new Constructor(1968, "bently");
        System.out.println("the car manufacture year is "+year +" and car name is "+carname);
    }
}
