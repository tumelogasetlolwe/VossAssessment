/**
 *
 * @author Tumelo
 */
package test;

import base.Driver;
import base.Framework;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.Login;


public class LoginTest {
    private ExtentReports extent;
    private ExtentTest test;
    @Before
    public void setUp() {
        Framework.resetDriver();
        Framework.generateRandomNumber(0);
        extent = new ExtentReports();
        new ExtentHtmlReporter("test-output/report.html");
    }

//execute test
    @Test
    public void execute() {
      //  test = extent.createTest("Tumelo Gasetlolwe on the logic");
        try {
          Login.LoadWebsite();
            Driver.implicitlyWait(2000);
          Login.ClickOnLoginAutomation();
          Login.EnterEmail("ttyeyo@gmail.com");
            Driver.implicitlyWait(2000);
           Login.EnterPassword("tumicious");
          Login.ClickOnSignIn();
           Driver.implicitlyWait(3000);
           Login.ClickOnDropdown();
           Login.ClickOnSignOut();
            Login.LoadWebsite();
            Login.VerifyTitle();
            Driver.implicitlyWait(2000);
            Login.ClickOnFillOutForms();
            Driver.implicitlyWait(2000);
            Login.EnterName("Dladla");
            Login.EnterMessage("I have mastered the art of testing.,.,.,.");
           Thread.sleep(4000);
            Login.ClickOnSubmit();
            Driver.implicitlyWait(2000);
            Login.EnterName2("Teeeeeeeee");
            Login.EnterMessage2("But learning never stops............!!!");
            Thread.sleep(4000);
            Login.solveCaptcha();
            Thread.sleep(1000);
           Login.ClickOnSubmit2();
            Login.LoadWebsite();
            Thread.sleep(4000);
            Login.ClickOnFakePricing();
            Thread.sleep(4000);
            Login.ClickOnPurchase();
          //  boolean testPassed = true;
          //  if (testPassed) {
           //     test.pass("Test Passed");
          //  } else {
          //      test.fail("Test Failed");
          //  }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    @After
    public void cleanUp() {
       
    }

}
