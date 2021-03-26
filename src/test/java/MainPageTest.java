
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\yaros\\IdeaProjects\\test-selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
        driver.manage().window().maximize();
        driver.get("https://www.citrus.ua");
    }

    @Test
    public void  findProductTest() throws InterruptedException {
        mainPage = new MainPage(driver);
        mainPage.hoverAudio();
        ContentTitlePage contentTitlePage = mainPage.clickAcousticButton();

        Thread.sleep(2000);
        contentTitlePage.sendMaximumPrice(899);
        Thread.sleep(8000);
        contentTitlePage.clickAllBrands();
        //Thread.sleep(5000);
        contentTitlePage.selectBrand(Brand.JBL);
        contentTitlePage.clickAllColors();
        contentTitlePage.selectColor(Color.ORANGE);
        String exPrice = contentTitlePage.getPriceText();
        assertEquals("899", exPrice, "You not found product");

    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
