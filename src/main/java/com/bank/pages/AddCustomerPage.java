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

public class AddCustomerPage extends Utility {
    private static final Logger log = LogManager.getLogger(AddCustomerPage.class.getName());

    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickAddCustomer;


    public void clickingOnAddCustomerButton() {
        clickOnElement(addCustomer);
        log.info("Clicking On Add Customer Button : " + addCustomer.toString());
    }

    public void enteringFirstNameInToFirstNameField(String fName) {
        sendTextToElement(firstName, fName);
        log.info("Entering First Name Into First Name Filed : " + firstName.toString());
    }

    public void enteringLastNameInToLastNameField(String lName) {
        sendTextToElement(lastName, lName);
        log.info("Entering Last Name Into Last Name Field : " + lastName.toString());
    }

    public void enteringPostCodeInToPostCodeField(String pCode) {
        sendTextToElement(postCode, pCode);
        log.info("Entering Postcode Into Postcode Field : " + postCode.toString());
    }

    public void clickingOnAddCustomer() {
        clickOnElement(clickAddCustomer);
        log.info("Clicking On Add Customer Button : " + clickAddCustomer);
    }

    public void verifyingTheCustomerAddedAlert() {
        Alert alert = driver.switchTo().alert();
        String expectedAlertText = "Customer added successfully with customer ";
        String actualAlertText = alert.getText().substring(0, 42);
        Assert.assertEquals(expectedAlertText, actualAlertText);
        alert.accept();
    }
}
