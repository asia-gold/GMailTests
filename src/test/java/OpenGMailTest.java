import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.GMailHomePage;
import pageobjects.GooglePage;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Asia on 16.02.2017.
 */
public class OpenGMailTest {

    private WebDriver driver;
    private GooglePage googlePage;
    private GMailHomePage gmailHomePage;
    private static final String BASE_URL = "https://www.google.com.ua/";


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL);
        googlePage = new GooglePage(driver);
    }
/*
    @After
    public void tearDown() {
        driver.quit();
    }
*/
    @Test
    public void testOpenGMail() {
        googlePage.clickMailLink();
        gmailHomePage = new GMailHomePage(driver);
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        assertEquals(gmailHomePage.getGmailHomeTitle(), driver.getTitle());
        gmailHomePage.clickCreateAccountLink();
        System.out.println(driver.getTitle());
    }
}
