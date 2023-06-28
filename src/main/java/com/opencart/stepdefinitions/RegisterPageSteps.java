package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("The registration form is populated with valid random data")
    public void theRegistrationFormIsPopulatedWithValidRandomData() {
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail("dan", "@yahoo.com");
        String password = DataFakerManager.getRandomPassword(8, 20);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
    }

    @And("The privacyPolicyToggle is enable")
    public void thePrivacyPolicyToggleIsEnable() {
        try {
            registerPage.switchOnThePrivacyToggle(driver);
        } catch (InterruptedException e) {
            System.out.println("Error");
        }
    }

    @And("continueButton is clicked")
    public void continuebuttonIsClicked() throws InterruptedException {
        registerPage.clickOnContinueButton();
    }
}
