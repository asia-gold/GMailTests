package pageobjects;

import objects.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

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
    private HashMap<String, String> idMonth;
    private HashMap<String, String> idGender;
    private static final String GMAIL_REG_PAGE = "Зарегистрируйтесь в Google";
    private User user;

    public GmailRegistrationPage(WebDriver driver, User user) {
        if(!GMAIL_REG_PAGE.equals(driver.getTitle())) {
            System.out.println(driver.getTitle());
            throw new IllegalStateException("This is not a Gmail Registration Page");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
        this.user = user;
    }

    public void typeFirstName() {
        firstNameTextField.sendKeys(user.getFirstName());
    }

    public void typeLastName() {
        lastNameTextField.sendKeys(user.getLastName());
    }

    public void typeGmailAddress() {
        gmailAddressTextField.sendKeys(user.getGmailAddress());
    }

    public void typePassword() {
        passwordTextField.sendKeys(user.getPassword());
    }

    public void typePasswordAgain() {
        passwordAgainTextField.sendKeys(user.getPasswordAgain());
    }

    public void typeBirthDay() {
        birthDayTextField.sendKeys(user.getDay());
    }

    public void selectBirthMonth() {
        idMonthInitialization();
        String id = idMonth.get(user.getMonth());
        driver.findElement(By.id(":0")).click();
        driver.findElement(By.id(id)).click();
    }

    public void typeBirthYear() {
        birthYearTextField.sendKeys(user.getYear());
    }

    public void selectGender() {
        idGenderInitialization();
        String id = idGender.get(user.getGender());
        driver.findElement(By.id(":d")).click();
        driver.findElement(By.id(id)).click();
    }

    public void typeRecoveryPhoneNumber() {
        phoneTextField.sendKeys(user.getPhone());
    }

    public void typeRecoveryEmailAddress() {
        emailTextField.sendKeys(user.getEmail());
    }

    public void idMonthInitialization() {
        idMonth = new HashMap<String, String>();
        idMonth.put("1", ":1");
        idMonth.put("2", ":2");
        idMonth.put("3", ":3");
        idMonth.put("4", ":4");
        idMonth.put("5", ":5");
        idMonth.put("6", ":6");
        idMonth.put("7", ":7");
        idMonth.put("8", ":8");
        idMonth.put("9", ":9");
        idMonth.put("10", ":a");
        idMonth.put("11", ":b");
        idMonth.put("12", ":c");
    }

    public void idGenderInitialization() {
        idGender = new HashMap<String, String>();
        idGender.put("Женский", ":e");
        idGender.put("Мужской", ":f");
        idGender.put("Другой", ":g");
        idGender.put("Не указан", ":h");
    }
}
