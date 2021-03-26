import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContentTitlePage {

    private WebDriver driver;

    public ContentTitlePage(WebDriver driver) {
        this.driver = driver;
    }

    private By minimumPrice = By.xpath("//div/input[contains(@class, 'el-input__inner')]");
    private By maximumPrice = By.xpath("(//div/input[contains(@class, 'el-input__inner')])[2]");
    private By allBrands = By.xpath("//div[@class='filter-itm__title'][contains(.,'Бренд')]/following-sibling::div[@class='more-button']/span");
    private By checkJBL = By.xpath("//a[text()='JBL']");
    private By allColors = By.xpath("//div[@class='filter-itm__title'][contains(.,'Цвет')]/following-sibling::div[@class='more-button']/span");
    private By selectOrange = By.xpath("//a[text()= 'Оранжевый' or text() = 'Помаранчевий']");
    private By selectRed = By.xpath("//a[text()='Красный']");
    private By price = By.xpath("//div[@class='prices__price']//span[@class='price']");
    private By unFocus = By.xpath("//i[@class='icon-arrow down']");
    /*public ContentTitle sendMinimumPrice() {
        driver.findElement(minimumPrice).sendKeys("899");
        return this;
    }*/

    public void sendMaximumPrice(int price) {
        methodForWait();
        driver.findElement(maximumPrice).sendKeys(Keys.CONTROL + "a");
        driver.findElement(maximumPrice).sendKeys(String.valueOf(price));
        driver.findElement(unFocus).click();
    }

    public ContentTitlePage clickAllBrands() {
        methodForWait();
        driver.findElement(allBrands).click();
        return this;
    }

    private void methodForWait() {
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void selectBrand(Brand brand){
        methodForWait();
        switch (brand) {
            case JBL : driver.findElement(checkJBL).click();
        }
    }

    public void selectColor(Color color){
        methodForWait();
        switch (color) {
            case ORANGE:
                driver.findElement(selectOrange).click();
                break;
            case RED:
                driver.findElement(selectRed).click();
                break;
        }
    }

    public ContentTitlePage clickAllColors() {
        methodForWait();
        driver.findElement(allColors).click();
        return this;
    }

    public String getPriceText() {
        return driver.findElement(price).getText();
    }
}