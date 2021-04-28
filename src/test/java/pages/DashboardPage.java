package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class DashboardPage extends GoogleAccountPage{

    // Search box
    protected final By searchBoxBy = By.xpath("//input[@class='gb_gf']");
    protected final By searchButtonBy = By.xpath("//button[@class='gb_pf gb_qf']");

    // Search message
    protected final By searchMessageBy = By.xpath("//span[@role='presentation']|//div[@role='heading'][@class='Q62IOe']");

    public DashboardPage(WebDriver driver){
        super(driver);
    }


    public DashboardPage search(String keywords){
        WebElement searchBox = waitUntilVisibleAndReturnElement(searchBoxBy);
        searchBox.clear();
        searchBox.sendKeys(keywords);

        waitUntilVisibleAndReturnElement(searchButtonBy).click();
        return this;
    }

    public Boolean isSearchResultShown(){
        try{
            WebElement searchBox = waitUntilVisibleAndReturnElement(searchMessageBy);
            return searchBox.getText().contains("Search results") || searchBox.getText().contains("Did you mean");
        }catch(NoSuchElementException e){
            return false;
        }
    }

}
