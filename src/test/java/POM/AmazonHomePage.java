package POM;

import com.testutilities.ActionsHelperUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.testutilities.WaitUtilities.waitForVisibilityOfElementInSeconds;

public class AmazonHomePage {
    private ActionsHelperUtility actionsHelperUtility = null;

    public AmazonHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        actionsHelperUtility = ActionsHelperUtility.getInstance(driver);
    }

    @FindBy(xpath="//span[contains(text(),'Hello, Darshan')]")
    private WebElement helloText;

    @FindBy(id="nav-cart-count-container")
    private WebElement cartContainer;

    private WebElement getCartContainer(){
        return cartContainer;
    }

    private WebElement getHelloText(){
        return helloText;
    }

    public boolean isHelloTextDisplayed(){
        try{
            waitForVisibilityOfElementInSeconds(getHelloText(), 30);
            return getHelloText().isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public boolean  isCartContainerDisplayed(){
        try{
            waitForVisibilityOfElementInSeconds(getCartContainer(),30);
            return getCartContainer().isDisplayed();
        }catch(Exception e){
            return false;
        }
    }

    public void clickOnCartIcon(){
        waitForVisibilityOfElementInSeconds(getCartContainer(),30);
        getCartContainer().click();
    }
}
