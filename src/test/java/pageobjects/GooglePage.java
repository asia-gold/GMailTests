package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by Asia on 16.02.2017.
 */
public class GooglePage {

    @FindBy(linkText = "Почта")
    WebElement mailLink;

    private final WebDriver driver;
    private static final String GOOGLE_TITLE = "Google";

    public GooglePage(WebDriver driver) {
        if (!GOOGLE_TITLE.equals(driver.getTitle())) {
            System.out.println(driver.getTitle());
            throw new IllegalStateException("This is not a Google Search Page");
        }
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void clickMailLink() {
        mailLink.click();
    }
}
