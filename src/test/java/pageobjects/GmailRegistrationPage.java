package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Asia on 16.02.2017.
 */
public class GmailRegistrationPage {

    @FindBy(id = "FirstName")
    private WebElement firstNameTextField;

    @FindBy(id = "LastName")
    private WebElement lastNameTextField;

    @FindBy(id = "GmailAddress")
    private WebElement gmailAddressTextField;

    @FindBy(id = "Passwd")
    private WebElement passwordTextField;

    @FindBy(id = "PasswdAgain")
    private WebElement passwordAgainTextField;

    //private final WebDriver driver;
}
