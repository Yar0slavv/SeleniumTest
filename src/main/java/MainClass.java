import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainClass {
    static WebDriver driver;

    public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaros\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
      /*  driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.citrus.ua");

//        MainPage mainPage = new MainPage(driver);
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.hoverAudio();
        mainPage.clickAcousticButton();*/
    }
}
