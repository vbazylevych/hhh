import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertTrue;

public class Test {

    @org.junit.Test
    public void name() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\ddd\\src\\main\\resources\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\ddd\\src\\main\\resources\\geckodriver.exe");
        String url = "https://feerie.com.ua/ru";

        ChromeDriver driver = new ChromeDriver();
        driver.get(url);

        Thread.sleep(2000);

        System.out.println(driver.getTitle());
        assertThat(url, is(driver.getCurrentUrl()));

        driver.manage().window().maximize();
        Thread.sleep(1000);
        driver.findElementByXPath("//*[@id='block-superfish-1']/div/div[3]").click();
        WebElement city = driver.findElementById("detect_city");
        assertTrue(city.getText().contains("Киев"));


        driver.close();
    }
}
