package PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class DataProviderDemo {

WebDriver driver;
@Parameters("browser")
@BeforeClass()
void setup(String browser)
{

    switch (browser.toLowerCase())
    {
        case "chrome": driver=new ChromeDriver(); break;
        case "edge": driver=new EdgeDriver(); break;
        case "firefox": driver=new FirefoxDriver();

        default:
            System.out.println("you have entered the wrong browser");
    }
}

@Test(dataProvider = "testdata")
void login(String username,String password)

{
    driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(username);
    driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();

    boolean qafoxtitle_status= driver.findElement(By.xpath("//a[normalize-space()='Qafox.com']")).isDisplayed();
    if (qafoxtitle_status==true)
    {
      driver.findElement(By.cssSelector("aside[id='column-right'] a:nth-child(1)")).click();
        Assert.assertTrue(true);
    }
    else
    {
        Assert.fail();
    }
}
    @AfterClass
    void close()
    {
    driver.quit();
    }

    @org.testng.annotations. DataProvider(name="testdata", indices = {1,3})// 1 and 3 test data only passes to the test method
    Object[][] dataprovidermethod()
    {
       Object[][] logindata= {
               {"xyz@gmail.com","123456"},
               {"abc@gmail.com","365479"},
               {"def@gmail.com","798555"},
               {"hassainshaik347@gmail.com","H@$$@in1104"},
               {"tuv@gmail.com","5452452"}
       };
       return logindata;
    }

}


