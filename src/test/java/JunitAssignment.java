import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JunitAssignment {
    WebDriver driver;
    @BeforeAll
    public void setup(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void practiceWebForm(){
        driver.get(("https://www.digitalunite.com/practice-webform-learners"));
        driver.findElement(By.id("edit-name")).sendKeys("Mohammad Naim");
        driver.findElement(By.id("edit-number")).sendKeys("01974575472");
        driver.findElements(By.className("onetrust-close-btn-handler")).get(0).click();
        WebElement txtCalendar= driver.findElement(By.id("edit-date"));
        txtCalendar.click();
        txtCalendar.sendKeys("10/10/2023");
        txtCalendar.sendKeys(Keys.ENTER);
        scroll();
        driver.findElement(By.id("edit-email")).sendKeys("naimakanda@test.com");
        driver.findElement(By.id("edit-tell-us-a-bit-about-yourself-")).sendKeys("Hello, myself Mohammad Naim Akanda. I'm a student of Road to sdet batch 08 ");
        driver.findElement(By.id("edit-uploadocument-upload")).sendKeys(System.getProperty("user.dir")+"/src/test/resources/ss.png");
        scroll();
        driver.findElement(By.id("edit-age")).click();
        driver.findElement(By.id("edit-submit")).click();
        driver.switchTo().alert().accept();
        String lineActual=driver.findElement(By.tagName("h1")).getText();
        Assertions.assertTrue(lineActual.contains("Thank you for your submission!"));

    }
    public void scroll(){
       JavascriptExecutor js= (JavascriptExecutor) driver;
       js.executeScript("window.scrollBy(0,600)");
    }
    @AfterAll
    public void quitBrowser(){
        driver.quit();
    }
}
