package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "BirthDay")
    private WebElement birthDayTextField;

    @FindBy(id = "BirthYear")
    private WebElement birthYearTextField;

    @FindBy(id = "HiddenGender")
    private WebElement genderDropDown;

    @FindBy(id = "RecoveryPhoneNumber")
    private WebElement phoneTextField;

    @FindBy(id = "RecoveryEmailAddress")
    private WebElement emailTextField;

    private final WebDriver driver;
    private static final String GMAIL_REG_PAGE = "Зарегистрируйтесь в Google";

    public GmailRegistrationPage(WebDriver driver) {
        if(!GMAIL_REG_PAGE.equals(driver.getTitle())) {
            System.out.println(driver.getTitle());
            throw new IllegalStateException("This is not a Gmail Registration Page");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void typeFirstName(String firstName) {
        firstNameTextField.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        lastNameTextField.sendKeys(lastName);
    }

    public void typeGmailAddress(String gmailAddress) {
        gmailAddressTextField.sendKeys(gmailAddress);
    }

    public void typePassword(String password) {
        passwordTextField.sendKeys(password);
    }

    public void typePasswordAgain(String passwordAgain) {
        passwordAgainTextField.sendKeys(passwordAgain);
    }

    public void typeBirthDay(String day) {
        birthDayTextField.sendKeys(day);
    }

    public void selectBirthMonth(String month) {
        driver.findElement(By.id(":0")).click();
        if(month=="10") {
            driver.findElement(By.id(":a")).click();
        } else {
            if(month=="11") {
                driver.findElement(By.id(":b")).click();
            } else {
                if(month == "12") {
                    driver.findElement(By.id(":c")).click();
                } else {
                    driver.findElement(By.id(":" + month)).click();
                }
            }
        }
    }

    public void typeBirthYear(String year) {
        birthYearTextField.sendKeys(year);
    }

    public void selectGender(String gender) {
        driver.findElement(By.id(":d")).click();
        if(gender=="Женский") {
            driver.findElement(By.id(":e")).click();
        } else {
            if(gender=="Мужской") {
                driver.findElement(By.id(":f")).click();
            } else {
                if(gender=="Другой") {
                    driver.findElement(By.id(":g")).click();
                } else {
                    if(gender=="Не указан") {
                        driver.findElement(By.id(":h")).click();
                    }
                }
            }
        }
    }

    public void typeRecoveryPhoneNumber(String phone) {
        phoneTextField.sendKeys(phone);
    }

    public void typeRecoveryEmailAddress(String email) {
        emailTextField.sendKeys(email);
    }
}
