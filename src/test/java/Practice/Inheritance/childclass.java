package Practice.Inheritance;

import org.testng.annotations.Test;

public class childclass extends superclass {


    @Test
    void cl()
    {
        System.out.println(name);
        System.out.println(age);
        print();
        print2("Hassain");
    }

}