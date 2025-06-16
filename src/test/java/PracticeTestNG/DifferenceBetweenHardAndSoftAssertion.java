package PracticeTestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DifferenceBetweenHardAndSoftAssertion {

    @Test(enabled = false)
    void hardassert()
    {
        System.out.println("print before hard assertion");
        Assert.assertEquals("Hassain","hassain");
        System.out.println("print after hard assertion");
    }

    @Test
    void softassert()
    {
        System.out.println("print before soft assertion");
        SoftAssert as=new SoftAssert();
        as.assertEquals("Hassain","hassain");
        System.out.println("print after soft assertion");
        as.assertAll();
    }
}
