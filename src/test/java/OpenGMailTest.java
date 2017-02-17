import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.GMailHomePage;
import pageobjects.GmailRegistrationPage;
import pageobjects.GooglePage;
import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * Created by Asia on 16.02.2017.
 */
@RunWith(Parameterized.class)
public class OpenGMailTest {

    private WebDriver driver;
    private GooglePage googlePage;
    private GMailHomePage gmailHomePage;
    private GmailRegistrationPage gmailRegistrationPage;
    private static final String BASE_URL = "https://www.google.com.ua/";

    private String firstName;
    private String lastName;
    private String gmailAddress;
    private String password;
    private String passwordAgain;
    private String day;
    private String month;
    private String year;
    private String gender;
    private String phone;
    private String email;

    public OpenGMailTest(String firstName, String lastName, String gmailAddress, String password, String passwordAgain,
                         String day, String month, String year, String gender, String phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gmailAddress = gmailAddress;
        this.password = password;
        this.passwordAgain = passwordAgain;
        this.day = day;
        this.month = month;
        this.year = year;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        googlePage = new GooglePage(driver);
    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] {
                {"TestFirstName", "TestLastName", "test", "testpassword", "testpassword", "1", "1", "1989", "Женский",
                "950000000", "test@gmail.com"},
                //{"FirstName", "LastName", "test", "password", "password", "1", "1", "1989", "Мужской",
                 //       "950000000", "test@gmail.com"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void testOpenGMail() {
        googlePage.clickMailLink();
        gmailHomePage = new GMailHomePage(driver);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        assertEquals(gmailHomePage.getGmailHomeTitle(), driver.getTitle());
        gmailHomePage.clickCreateAccountLink();
        System.out.println(driver.getTitle());
        gmailRegistrationPage = new GmailRegistrationPage(driver);
        enterDataInFields();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void enterDataInFields() {
        gmailRegistrationPage.typeFirstName(firstName);
        gmailRegistrationPage.typeLastName(lastName);
        gmailRegistrationPage.typeGmailAddress(gmailAddress);
        gmailRegistrationPage.typePassword(password);
        gmailRegistrationPage.typePasswordAgain(passwordAgain);
        gmailRegistrationPage.typeBirthDay(day);
        gmailRegistrationPage.selectBirthMonth(month);
        gmailRegistrationPage.typeBirthYear(year);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,350)");
        gmailRegistrationPage.selectGender(gender);
        gmailRegistrationPage.typeRecoveryPhoneNumber(phone);
        gmailRegistrationPage.typeRecoveryEmailAddress(email);
    }
}
