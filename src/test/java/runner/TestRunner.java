package runner;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import utilities.CommonFunctions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber.html",
                "json:target/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"stepDefinitions","utilities"},
        tags = "@regression"
)
public class TestRunner extends AbstractTestNGCucumberTests {
	
    @Parameters({ "browser" })
    @BeforeTest
    public static void setUpBrowser(String browser) {
        CommonFunctions.getBrowserInstantiation(browser);
    }
    
	@AfterTest
	public void closeBrowser() {
		CommonFunctions.closeBrowser();
	}

}
