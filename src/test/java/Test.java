import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.apache.commons.lang.RandomStringUtils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class Test {


    @org.junit.Test
    public void name() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\ddd\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\ddd\\src\\main\\resources\\geckodriver.exe");
        String url = "https://www.istockphoto.com/";

        ChromeDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        Thread.sleep(2000);

        System.out.println(driver.getTitle());
        assertThat(url, is(driver.getCurrentUrl()));


        Thread.sleep(1000);
        driver.findElementByXPath("//li[@class='wide-header']/a[@data-nav='nav=nav_Join']").click();
        Thread.sleep(1000);

        driver.findElementByXPath("//*[@id='register_email']").sendKeys(emailGeneration());



        String pass = passGeneration();
        driver.findElementByXPath("//input[@ng-model='register['password']']").sendKeys(pass);
        driver.findElementByXPath("//[@placeholder='Confirm password']").sendKeys(pass);

        driver.findElement(new By.ById("register-button"));


        driver.close();
    }

    private String emailGeneration() {
        return random(5, true, false) + "@gmail.com";
    }

    private String passGeneration() {
        return random(5, true, true);
    }
}
