import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    WebDriver driver;

    private String seleniumUrl;
    private String driverPath;
    private String projectDir;
    private String dataProviderDir;
    private String driversDir;

    public BaseTest(){
        this.projectDir=System.getProperty("user.dir");
        this.dataProviderDir=projectDir+"//src//test//dataprovider//";
        this.driversDir=projectDir+"//src//test//resources//";
    }

    @BeforeMethod(alwaysRun = true)
    public void setupBeforeSuite(ITestContext context) {

        seleniumUrl = "https://www.garbarino.com/";
        driverPath = driversDir+"chromedriver.exe";

        try {
                System.setProperty("webdriver.chrome.driver", driverPath);
                // Initialize browser
                driver=new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        } catch (Exception e) {
            throw new IllegalStateException("Can't start selenium browser", e);
        }

        driver.get(seleniumUrl);

    }

    @AfterMethod(alwaysRun = true)
    public void setupAfterSuite() {
        driver.quit();
    }

}


