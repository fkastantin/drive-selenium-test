import org.junit.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MainPage;
import pages.PageBase;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import java.util.*;


public class LoginLogoutTest extends TestUserAccount{

    @Test
    public void testLogin() {
        DashboardPage dashboard = login();
        
        Assert.assertTrue("Is the user signed in", dashboard.isSignedIn());
    }

    @Test
    public void testLogout(){
        DashboardPage dashboard = login();

        dashboard.logout();

        Assert.assertFalse("Is the user logout", dashboard.isSignedIn());
    }

}
