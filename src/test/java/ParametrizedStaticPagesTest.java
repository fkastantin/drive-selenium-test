import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.PageBase;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParametrizedStaticPagesTest extends TestBase {

    final String PAGE_URL;
    public ParametrizedStaticPagesTest(String pageUrl){
        this.PAGE_URL = pageUrl;
    }

    @Parameterized.Parameters
    public static Collection input(){
        return Arrays.asList("https://www.google.com/intl/hu/drive/",
                "https://www.google.com/intl/en/drive/",
                "https://www.google.com/intl/fr/drive/");
    }

    @Test
    public void testWebPage(){
        PageBase page = new PageBase(driver, PAGE_URL);
        Assert.assertFalse(page.getBodyText().isEmpty());
    }

}
