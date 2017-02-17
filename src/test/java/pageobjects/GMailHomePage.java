package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Asia on 16.02.2017.
 */
public class GMailHomePage {

    @FindBy(linkText = "Создать аккаунт")
    private WebElement createAccountLink;

    private final WebDriver driver;
    private static final String GMAIL_HOME_TITLE = "Gmail";

    public GMailHomePage(WebDriver driver) {
        if (!GMAIL_HOME_TITLE.equals(driver.getTitle())) {
            System.out.println(driver.getTitle());
            throw new IllegalStateException("This is not a GMail Page");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickCreateAccountLink() {
        createAccountLink.click();
    }

    public String getGmailHomeTitle() {
        return GMAIL_HOME_TITLE;
    }
}
