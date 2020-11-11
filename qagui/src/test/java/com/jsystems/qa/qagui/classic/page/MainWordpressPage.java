package com.jsystems.qa.qagui.classic.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage {

    public MainWordpressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String textElementSelector = "#lpc-titles h1 span:nth-child(1)";
//    @FindBy(css = "h1.lpc-headline-title span:nth-child(1)")
    @FindBy(css = textElementSelector)
    private WebElement textElement_1;
//    public WebElement textElement_1 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(1)"));

    @FindBy(css = "#lpc-titles h1 span:nth-child(2)")
    public WebElement textElement_2;
//    public WebElement textElement_2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));

    @FindBy(css = "#lpc-paragraphs p")
    public WebElement textElement_3;
//    public WebElement textElement_2 = driver.findElement(By.cssSelector("h1.lpc-headline-title span:nth-child(2)"));

    public static final String loginIconSelector = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in";
    @FindBy(css = loginIconSelector)
    public WebElement loginIcon;
//    public WebElement loginIcon = driver.findElement(By.cssSelector(loginIconSelector));


    public WebElement getTextElement_1() {
        waitForElementToBeVisibility(By.cssSelector(textElementSelector));
        return textElement_1;
    }
}
