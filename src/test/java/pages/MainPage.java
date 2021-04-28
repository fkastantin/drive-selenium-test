package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends PageBase {

    protected By goToDriverBy = By.xpath("//a[@data-action='go to drive']");

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        this.driver.get("https://www.google.com/intl/en/drive/");
    }

    public LoginPage getLoginPage(){
        return new LoginPage(driver);
    }

    public LoginPage test(){
        // Click "Go to drive" button
        WebElement goToDriverButton = waitUntilVisibleAndReturnElement(goToDriverBy);
        goToDriverButton.click();

        return new LoginPage(driver);
    }

}
