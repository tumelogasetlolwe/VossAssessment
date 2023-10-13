

/**
 *
 * @author Tumelo
 */

package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import base.Driver;
import base.SeleniumUtil;




public class Login {

    //loading website and maximizing the window
    public static void LoadWebsite() {
        Driver.getWebInstance().manage().window().maximize();
        Driver.getInstance().get(SeleniumUtil.BASE_URL_STRING);

        
    }

    //method used to click on the ‘OK’ button of the alert.
    public static void ClickOkay() {
        Driver.getWebInstance().switchTo().alert().accept();

    }

    public static void VerifyTitle() {
      String actualTitle =  Driver.getWebInstance().getTitle();
        String expectedTitle = "Automation Practice - Ultimate QA";
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Page title is as expected: " + actualTitle);
        } else {
            System.out.println("Page title is not as expected. Actual title is: " + actualTitle);
        }

    }

    public static WebElement ClickLoginAutomation() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"post-507\"]/div/div/div/div[2]/div/div[1]/div/div/div/div/ul/li[6]/a")));
    }
    public static WebElement ClickSignUp() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.cssSelector("#signin2")));
    }
     public static void EnterEmail(String email) {

        Driver.getInstance().wait(3000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"user[email]\"]"))).sendKeys(email);
    }
    public static void EnterPassword(String password) {

        Driver.getInstance().wait(3000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"user[password]\"]"))).sendKeys(password);
    }


    public static WebElement ClickSignIn() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("/html/body/main/div/div/article/form/div[5]/button")));
    }

    public static WebElement ClickDropdown() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("/html/body/header/div[2]/div/nav/ul/li[2]/button")));

    }


    public static WebElement ClickSignOut() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"header-dropdown-menu\"]/li[4]/a")));

    }

    public static WebElement ClickFillOutForms() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"post-507\"]/div/div/div/div[2]/div/div[1]/div/div/div/div/ul/li[4]/a")));
    }


public static void EnterName(String name) {

    Driver.getInstance().wait(3000,
            ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_name_0\"]"))).sendKeys(name);
}
    public static void EnterMessage(String message) {

        Driver.getInstance().wait(3000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_message_0\"]"))).sendKeys(message);
    }
    public static void solveCaptcha() {
        WebElement captchaElement = Driver.getInstance().wait(2000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/div/p/span")));

        String captchaText = captchaElement.getText();

        // Extract the two numbers (X and Y)
        String[] numbers = captchaText.split(" \\+ ");
        int num1 = Integer.parseInt(numbers[0]);
        int num2 = Integer.parseInt(numbers[1]);

        // Calculate the result
        int result = num1 + num2;

        // Find the input field for the answer
        WebElement inputField = Driver.getInstance().wait(2000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/div/p/input")));

        inputField.sendKeys(Integer.toString(result));
    }

    // Enter the result in the input field

        public static WebElement ClickSubmit() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_form_0\"]/div[2]/form/div/button")));

    }
    public static WebElement ClickSubmit2() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_form_1\"]/div[2]/form/div/button")));

    }
    public static void EnterName2(String name) {

        Driver.getInstance().wait(3000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_name_1\"]"))).sendKeys(name);
    }
    public static void EnterMessage2(String message) {

        Driver.getInstance().wait(3000,
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"et_pb_contact_message_1\"]"))).sendKeys(message);
    }




    public static WebElement ClickFakePricing() {
        return Driver.getInstance().wait(5, ExpectedConditions.
                presenceOfElementLocated(By.xpath("//*[@id=\"post-507\"]/div/div/div/div[2]/div/div[1]/div/div/div/div/ul/li[3]/a")));

    }

public static WebElement ClickPurchase() {
    return Driver.getInstance().wait(5, ExpectedConditions.
            presenceOfElementLocated(By.xpath("//*[@id=\"post-5050\"]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[4]/a")));

}



    // Function to Take screenshot
// Now you can do whatever you need to do with it, for example copy somewhere
        //FileUtils.copyFile(scrFile.toPath(), new File("c:\\tmp\\screenshot.png").toPath());

 //  }
       public static void ClickOnSignIn() {
           ClickSignIn().click();

       }
    public static void ClickOnLoginAutomation() {
        ClickLoginAutomation().click();

    }

    public static void ClickOnDropdown() {
        ClickDropdown().click();

    }

    public static void ClickOnSignOut() {
        ClickSignOut().click();

    }

    public static void ClickOnFillOutForms() {
        ClickFillOutForms().click();

    }

    public static void ClickOnSubmit() {
        ClickSubmit().click();

    }
   public static void ClickOnSubmit2() {
       ClickSubmit2().click();

    }

    public static void ClickOnFakePricing() {
        ClickFakePricing().click();

    }
    public static void ClickOnPurchase() {
        ClickPurchase().click();

    }

    }
