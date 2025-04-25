package Practice;

import org.testng.annotations.Test;

public class MathClass {
    @Test
    void mathclass()
    {
        int x=10,y=20;
        int result= Math.addExact(x,y);
        System.out.println(result);
        System.out.println(Math.sqrt(x+y));
    }
}
