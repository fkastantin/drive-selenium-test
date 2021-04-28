import org.junit.Assert;
import org.junit.Test;
import pages.MainPage;
import pages.PageBase;

public class StaticPagesTest extends TestBase{

    @Test
    public void testPageTitle(){
        MainPage mainPage = new MainPage(this.driver);

        Assert.assertTrue(mainPage.getTitle().contains("Google Drive"));
    }

    @Test
    public void testStaticPage(){
        driver.get("https://www.google.com/intl/en/drive/");
        PageBase page = new PageBase(driver);

        Assert.assertFalse(page.getBodyText().isEmpty());
    }

    @Test
    public void testMultipleStaticPage(){

    }
}
