import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By audioTitle = By.xpath("(//div/ul//span[text()='Аудио'])[2]");
    private By acousticTitle =  By.xpath("(//div/ul//span[text()='Акустика'])");

    public MainPage hoverAudio() {
        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(audioTitle)).build().perform();
        return this;
    }

    public ContentTitlePage clickAcousticButton() {
        driver.findElement(acousticTitle).click();
        return new ContentTitlePage(driver);
    }
}
