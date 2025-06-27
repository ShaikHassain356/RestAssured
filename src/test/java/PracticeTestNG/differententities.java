package PracticeTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.By.xpath;

public class differententities {
    public static void main(String[]args)
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf((WebElement) xpath("hello")));

        Select dropdown=new Select(driver.findElement(By.xpath("hello")));

        dropdown.selectByIndex(1);
        dropdown.selectByValue("hassain");
        dropdown.selectByVisibleText("Hassain");
        dropdown.getFirstSelectedOption();
    }
}
