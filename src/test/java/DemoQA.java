import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DemoQA {

    WebDriver driver;

    @BeforeAll
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();//maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    //@Test
    public void visitUrl() {
        driver.get("https://demoqa.com/");
        String titleActual = driver.getTitle();
        String titleExpected = "DEMOQA";
        Assertions.assertTrue(titleActual.equals(titleExpected));
    }

    @Test
    public void fillupUserForm(){
        driver.get("https://demoqa.com/text-box");
        //driver.findElement(By.id("userName")).sendKeys("Test User");
        //driver.findElement(By.cssSelector("[type=text]")).sendKeys("Test User");
        List<WebElement> txtFields = driver.findElements(By.className("form-control"));
        txtFields.get(0).sendKeys("Test User");
        txtFields.get(1).sendKeys("testUser@test.com");
        txtFields.get(2).sendKeys("Gulshan");
        txtFields.get(3).sendKeys("Dhaka");
        //Scroll Down
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,250)","");
        //Button Submit
        List<WebElement> btnSubmit = driver.findElements(By.tagName("button"));
        btnSubmit.get(1).click();
    }
    //@AfterAll
    public void tearDown(){
        driver.quit();
    }
}
