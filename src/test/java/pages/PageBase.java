package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;


public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    
    protected By bodyBy = By.tagName("body");
    
    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public PageBase(WebDriver driver, String URL) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.driver.get(URL);
    }
    
    protected WebElement waitUntilVisibleAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    } 

    protected WebElement waitUntilPresenceAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
    
    public String getBodyText() {
        WebElement bodyElement = this.waitUntilVisibleAndReturnElement(bodyBy);
        return bodyElement.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
