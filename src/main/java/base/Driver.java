
package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Driver {

    private static final Logger logger = LoggerFactory.getLogger(Driver.class); //NOPMD

    private FirefoxDriver getNewFirefoxDriverInstance() {

           System.setProperty("webdriver.gecko.driver", "C:\\Users\\Teee\\Desktop\\VossAssessment\\geckodriver.exe");
        System.setProperty("webdriver.gecko.driver",  "C:\\Users\\Teee\\Desktop\\VossAssessment\\chromedriver.exe");
        return new FirefoxDriver();

    }
    
  
   
 
    public void get(String arg0) {
        this.webDriver.get(arg0);
    }

    private static Driver instance;
    WebDriver webDriver;

    public static Driver getInstance() {
        if (instance == null) {
            instance = new Driver();
        }
        return instance;
    }

    public static WebDriver getWebInstance() {
        if (instance == null) {
            instance = new Driver();
        }

        return instance.webDriver;
    }

    public <V> V wait(int timeOutInSeconds, Function<? super WebDriver, V> isTrue) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, timeOutInSeconds);

        return wait.until(isTrue);
    }

    public <V> V wait(int timeOutInSeconds, Function<? super WebDriver, V> isTrue, Class<? extends Throwable> ignoreException) {
        WebDriverWait wait = new WebDriverWait(this.webDriver, timeOutInSeconds);

        return wait.ignoring(ignoreException).until(isTrue);
    }

    public WebDriver.Options manage() {
        return this.webDriver.manage();
    }

    public static void implicitlyWait(long seconds) {
        instance.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void quit() {
        this.webDriver.quit();
    }

    public void reset() {
        this.webDriver = getNewFirefoxDriverInstance();
        webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    protected Driver() {

    }

    public static Optional<JavascriptExecutor> getExecutor() {
        WebDriver checkdriver = Driver.getWebInstance();

        final JavascriptExecutor executor;

        if (checkdriver instanceof JavascriptExecutor) {

            executor = (JavascriptExecutor) checkdriver;

        } else {
            executor = null;
        }
        return Optional.ofNullable(executor);
    }
}