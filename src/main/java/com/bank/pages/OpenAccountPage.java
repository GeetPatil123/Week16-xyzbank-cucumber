package com.bank.pages;

import com.bank.utilities.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OpenAccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(OpenAccountPage.class.getName());

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;

    @CacheLookup
    @FindBy(css = "#userSelect")
    WebElement customerNameSelect;

    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement currencyDropDown;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement processButton;

    public void clickingOnTheOpenAccountButton() {
        clickOnElement(openAccount);
        log.info("Clicking On Open An Account Button : " + openAccount.toString());
    }

    public void selectingCreatedCustomerFromTheCustomerNameDropDown(String cName) {
        clickOnElement(customerNameSelect);
        log.info("Clicking On The Customer Name Drop Down : " + customerNameSelect.toString());
        selectByVisibleTextFromDropDown(customerNameSelect, cName);
        log.info("Selecting Customer Name From The Drop Down : " + customerNameSelect.toString());
    }

    public void selectingTheCurrencyFromCurrencyDropDown(String currency) {
        clickOnElement(currencyDropDown);
        log.info("Clicking On The Currency Drop Down : " + currencyDropDown.toString());
        selectByVisibleTextFromDropDown(currencyDropDown, currency);
        log.info("Selecting The Desired Currency From Currency Drop Down : " + currencyDropDown.toString());
    }

    public void clickingOnTheProcessButton() {
        clickOnElement(processButton);
        log.info("Clicking On The Process Button : " + processButton.toString());
    }

    public void verifyingAccountCreationText() {
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Account created successfully";
        String actualAlertText = alert.getText().substring(0, 28);
        Assert.assertEquals(actualAlertText, expectedAlertText, "Invalid Message Prompt...!!!");
        alert.accept();
    }
}
