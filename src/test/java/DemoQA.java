import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoQA {
    public void setup() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();//maximize window
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void visitUrl(){

    }
}
