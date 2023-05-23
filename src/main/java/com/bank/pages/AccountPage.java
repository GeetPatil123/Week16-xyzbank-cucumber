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

public class AccountPage extends Utility {
    private static final Logger log = LogManager.getLogger(AccountPage.class.getName());

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositButton;

   @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterAmount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositButtonAfterAmount;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawButton;

    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement enterWithdrawalAmount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement withdrawalButton;

    public void clickingOnTheDepositButton() {
        clickOnElement(depositButton);
        log.info("Clicking On Deposit Button : " + depositButton.toString());
    }

    public void enteringTheAmountInToTheAmountTextBox(int amount) {
        sendTextToElement(enterAmount, String.valueOf(amount));
        log.info("Entering The Amount Into Amount Field : " + enterAmount.toString());
    }

    public void clickingOnDepositButtonAfterEnteringTheAmount() {
        clickOnElement(depositButtonAfterAmount);
        log.info("Clicking On Deposit Button : " + depositButtonAfterAmount.toString());
    }

    public void clickingOnTheWithdrawButton() {
        clickOnElement(withdrawButton);
        log.info("Clicking On Withdraw Button : " + withdrawalButton.toString());
    }

    public void enteringTheWithdrawalAmountInToTheAmountTextBox(int withdrawAmount) {
        sendTextToElement(enterWithdrawalAmount, String.valueOf(withdrawAmount));
        log.info("Entering Withdrawal Amount Into Withdraw Amount Field : " + enterWithdrawalAmount.toString());
    }

    public void clickingOnTheWithdrawButtonAfterEnteringTheAmount() {
        clickOnElement(withdrawalButton);
        log.info("Clicking On Withdraw Button : " + withdrawalButton.toString());
    }

    public void verifyingTheDepositSuccessfulMessageText() {
        String expectedDepositText = "Deposit Successful";
        String actualDepositText = driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        Assert.assertEquals(actualDepositText, expectedDepositText, "Invalid Transaction Text...!!!");
    }

    public void verifyingTheWithdrawalSuccessfulMessageText() {
        String expectedWithdrawText = "Transaction successful";
        String actualWithdrawText = driver.findElement(By.xpath("//span[@class='error ng-binding']")).getText();
        Assert.assertEquals(actualWithdrawText, expectedWithdrawText, "Invalid Transaction Text...!!!");

    }

}
