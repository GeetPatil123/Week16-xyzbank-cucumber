package com.bank.pages;

import com.bank.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CustomerLoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(CustomerLoginPage.class.getName());

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerLoginButton;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement selectYourName;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//button[@class='btn logout']")
    WebElement logoutTab;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement customerLogin;

    public void clickingOnCustomerLoginButton() {
        clickOnElement(customerLoginButton);
        log.info("Clicking On Customer Login Button : " + customerLogin.toString());
    }

    public void selectingCustomerNameFromYourNameDropDown(String yName) {
        clickOnElement(selectYourName);
        log.info("Clicking On Customer Name Selection Drop Down : " + selectYourName.toString());
        selectByVisibleTextFromDropDown(selectYourName, yName);
        log.info("Selecting Customer Name From The Drop Down : " + selectYourName.toString());
    }

    public void clickingOnTheLoginButton() {
        clickOnElement(loginButton);
        log.info("Clicking On Login Button : " + loginButton.toString());
    }

    public boolean verifyingTheLogoutTabIsDisplayedOrNot() {
        boolean isLogoutTabPresent = driver.findElement(By.xpath("//button[@class='btn logout']")).isDisplayed();
        log.info("Verifying Whether The Logout Tab Is Displayed Or Not : ");
        return isLogoutTabPresent;
    }

    public void clickingOnTheLogoutTab() {
        clickOnElement(logoutTab);
        log.info("Clicking On Logout Tab : " + logoutTab.toString());
    }

    public void clickingOnTheLoginAfterSelectingCustomerName() {
        clickOnElement(customerLogin);
        log.info("Clicking On Login Tab After Selecting Customer Name : " + customerLogin.toString());
    }
    public void verifyThatYourNameTextIsDisplayed(){
        String actualText = driver.findElement(By.xpath("//label[normalize-space()='Your Name :']")).getText();
        Assert.assertEquals(actualText, "Your Name :", "Invalid Message Prompt...!!!");
    }
}
