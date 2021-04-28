package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase{

    final String SIGN_IN_URI = "https://accounts.google.com/signin/v2/identifier?service=wise&passive=true&continue=http%3A%2F%2Fdrive.google.com%2F%3Futm_source%3Den&utm_medium=button&utm_campaign=web&utm_content=gotodrive&usp=gtd&ltmpl=drive&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    private final By emailInputBy = By.xpath("//input[@type='email']");
    private final By passwordInputBy = By.xpath("//input[@type='password']");
    private final By submitButtonBy = By.className("VfPpkd-RLmnJb");
    //private final By welcomeMessageBy = By.xpath("//header[@class='xNklye']/div[@class='B1tEqd']/h1[@class='x7WrMb']");

    public LoginPage(WebDriver driver){
        super(driver);
        driver.get(SIGN_IN_URI);
    }


    public DashboardPage login(String email, String password){
        WebElement emailInput = waitUntilVisibleAndReturnElement(emailInputBy);
        emailInput.sendKeys(email);

        WebElement submitForm = waitUntilVisibleAndReturnElement(submitButtonBy);
        submitForm.click();

        WebElement passwordInput = waitUntilVisibleAndReturnElement(passwordInputBy);
        passwordInput.sendKeys(password);

        submitForm = waitUntilVisibleAndReturnElement(submitButtonBy);
        submitForm.click();

        return new DashboardPage(driver);
    }
}
