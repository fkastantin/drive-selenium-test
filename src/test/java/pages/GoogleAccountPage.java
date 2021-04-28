package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.sql.Time;


public class GoogleAccountPage extends PageBase {
    
    protected final By logoutButtonBy = By.id("gb_71");
    protected final By userDropDownBy = By.xpath("//header//a[contains(@href, 'https://accounts.google.com')]");


    public GoogleAccountPage(WebDriver driver){
        super(driver);
    }

    public void clickUserAccountDropdown(){
        WebElement userDropDown = waitUntilVisibleAndReturnElement(userDropDownBy);
        userDropDown.click();
    }

    public void logout(){
        WebElement userDropDown = waitUntilVisibleAndReturnElement(userDropDownBy);
        userDropDown.click();

        WebElement logoutButton = waitUntilVisibleAndReturnElement(logoutButtonBy);
        logoutButton.click();
    }

    public Boolean isSignedIn(){
        // Check if the page has logout button
        try{
            WebElement userDropDown = waitUntilVisibleAndReturnElement(userDropDownBy);
            userDropDown.click();

            return true;
        }catch(NoSuchElementException e){
            System.out.println("NoSuchElementException is handled");
            return false;
        }
        catch(TimeoutException e){
            System.out.println("TimeoutException is handled");
            return false;
        }
        catch(Exception e){
            System.out.println("Exception is handled");
            return false;
        }
    }
}
