package com.jsystems.qa.qagui.classic;

import com.jsystems.qa.qagui.ConfigurationGui;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Platform;
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

public class ConfigFrontend {
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

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUpEach() throws MalformedURLException {


//        driver = new ChromeDriver();
//        driver = new FirefoxDriver();

        if(ConfigurationGui.MACHINE.equals("local")) {
            setUpLocalDriver();
        }
        else {
            setUpRemoteDriver();
        }

        setupDriver();
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

    private void setupDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDownEach() {
        driver.quit();
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
}
