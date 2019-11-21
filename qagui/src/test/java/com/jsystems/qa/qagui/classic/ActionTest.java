package com.jsystems.qa.qagui.classic;

import com.jsystems.qa.qagui.ConfigurationGui;
import com.jsystems.qa.qagui.classic.page.LoginPage;
import com.jsystems.qa.qagui.classic.page.MainWordpressPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static com.jsystems.qa.qagui.classic.page.LoginPage.usernameOrEmailSelector;
import static com.jsystems.qa.qagui.classic.page.MainWordpressPage.loginIconSelector;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("FrontTest")
public class ActionTest extends ConfigFrontend {


    @Tag("Action")
    @Test
    public void actionTest() {

        driver.navigate().to(ConfigurationGui.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.loginIcon.click();

        Actions action = new Actions(driver);
        action.moveToElement(
                mainPage.loginIcon,
                5, 5);
        action.clickAndHold();
        action.moveByOffset(5, 5);
        action.release();
        action.build().perform();
    }

    @Tag("Action")
    @Test
    public void actionNextTest() {

        driver.navigate().to(ConfigurationGui.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.waitForElementToBeVisibility(By.cssSelector(loginIconSelector));
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainPage.loginIcon.click();
        LoginPage loginPage = new LoginPage(driver);
        mainPage.waitForElementToBeVisibility(By.id(usernameOrEmailSelector));

        // akcje możemy budować wielo-etapowe
        Actions action = new Actions(driver);
        action.moveToElement(loginPage.usernameInput)
                .click()
                .sendKeys(loginPage.usernameInput, ConfigurationGui.LOGIN)
                .moveToElement(loginPage.usernameButton)
                // jak po . klikniecie Ctrl + space to rozwinie wam się lista dostępnych metod z klasy Actions
                .click()
                .build()
                .perform();

        loginPage.waitForElementToBeVisibility(loginPage.inputPassword, 15);
        assertTrue(loginPage.inputPassword.isDisplayed());
    }

    @Tag("Action")
    @Test
    public void testBasicRInteraction() {
        Actions do42 = new Actions(driver);
        do42.sendKeys(Keys.chord(Keys.CONTROL, "l")).perform();
        do42.sendKeys(Keys.ESCAPE).perform();
        do42.sendKeys("41 + 1").perform();
        do42.sendKeys(Keys.ENTER).perform();
    }

}
