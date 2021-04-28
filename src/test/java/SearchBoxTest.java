import org.junit.Assert;
import org.junit.Test;
import pages.DashboardPage;

import java.util.Random;

public class SearchBoxTest extends TestUserAccount{

    @Test
    public void testFileSearch(){
        DashboardPage dashboard = login();

        dashboard.search("my file");

        Assert.assertTrue("Search result is shown", dashboard.isSearchResultShown());
    }

    @Test
    // https://www.baeldung.com/java-random-string
    public void testRandomFileSearch(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        String[] randomStrings = new String[10];
        for(int j=0;j<randomStrings.length;j++){
            int targetStringLength = (int) (random.nextFloat() * 20) + 1; // return random number between 1 and 20
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();

            randomStrings[j] = generatedString;
        }

        // First login
        DashboardPage dashboard = login();

        for(String s : randomStrings){
            dashboard.search(s);
            Assert.assertTrue("Search result is shown", dashboard.isSearchResultShown());
        }
    }


}
