package testScripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    public WebDriver getDriver(){
        return this.driver.get();
    }

    public void setupDriver(){
        setDriver(WebDriverManager.chromedriver().create());
    }

    @BeforeMethod
    public void beforeMethod(){
        setupDriver();
    }

    @AfterMethod
    public void cleanupMethod(){
        this.driver.get().quit();
        this.driver.remove();
    }

}
