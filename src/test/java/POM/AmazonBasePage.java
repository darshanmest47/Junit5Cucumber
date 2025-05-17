package POM;

import com.testutilities.ActionsHelperUtility;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.testutilities.WaitUtilities.*;


public class AmazonBasePage {
    private ActionsHelperUtility actionsHelperUtility = null;

    public AmazonBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actionsHelperUtility = ActionsHelperUtility.getInstance(driver);
    }

    /*Example of Encapsulation*/

    @FindBy(css = "#nav-link-accountList >a")
    private WebElement accountList;

    @FindBy(xpath = "//span[text()='Sign in']")
    private WebElement signInButton;

    private WebElement getAccountList() {
        return accountList;
    }

    private WebElement getSignInButton() {
        return signInButton;
    }

    public void clickAccountList() {
        waitForVisibilityOfElementInSeconds(getAccountList(), 100);
        actionsHelperUtility.moveToElementAndClick(getAccountList());
    }

    public void clickSignInButton() {
        waitForVisibilityOfElementInSeconds(getSignInButton(), 100);
        getSignInButton().click();
    }
}
