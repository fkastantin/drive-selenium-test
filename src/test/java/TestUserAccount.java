import org.junit.Before;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MainPage;

import java.io.*;
import java.util.Properties;

public class TestUserAccount extends TestBase{

    String EMAIL = "liyeb65698@zefara.com";
    String PASSWORD = "3shQgn%kWD_m;jYm";

    @Before
    public void readUserCredentials(){
        String path = "src/test/resources/config.properties";
        File file = new File(path);

        try (InputStream input = new FileInputStream(path)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            EMAIL = prop.get("user.email").toString();
            PASSWORD = prop.get("user.password").toString();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        /*
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new FileReader(file));

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try{
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }





    protected DashboardPage login(){
        MainPage mainPage = new MainPage(this.driver);
        LoginPage loginPage = mainPage.getLoginPage();
        DashboardPage dashboard = loginPage.login(EMAIL, PASSWORD);

        return dashboard;
    }
}
