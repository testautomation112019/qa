package com.jsystems.qa.qagui.cucumber;

import com.jsystems.qa.qagui.ConfigurationGui;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigStepCucumber {
    protected WebDriver driver;

    //    String chromePath;
    String fireFoxPath;
    {
        try {
//            chromePath = Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe")
//                    .toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe")
                    .toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Before
    public  void setUpAll() {
        System.out.println("=====================@Before Cucumber test");
        WebDriverManager.chromedriver().setup();
    }


    public WebDriver setUp() {

        if(ConfigurationGui.MACHINE.equals("local")) {
            setUpLocalDriver();
        }
        else {
            setUpRemoteDriver();
        }


        setDriver();
        return driver;
    }

    private void setUpLocalDriver() {
        setupSystemProperties();
        if(ConfigurationGui.BROWSER.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    private void setupSystemProperties() {
//        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);
    }

    private void setDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    private void setUpRemoteDriver() {
        DesiredCapabilities cap;

        if(ConfigurationGui.BROWSER.equals("firefox")) {
            cap = DesiredCapabilities.firefox();
        } else {
            cap = DesiredCapabilities.chrome();
        }

        cap.setPlatform(Platform.LINUX);
        cap.setVersion("");

        driver = null;
        try {
            driver = new RemoteWebDriver(new URL(ConfigurationGui.REMOTE_URL), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";
//            status = "++++++++++";
            scenario.write("Scenario passed");
        } else {
            status = "(✖╭╮✖)";
//            status = "-------------";
            scenario.embed(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES),"images/png");
            scenario.write("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        driver.quit();
        driver = null;
    }


}
