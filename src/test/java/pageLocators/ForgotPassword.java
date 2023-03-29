package pageLocators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgotPassword {
    @FindBy(name = "username")
    WebElement username;

    @FindBy(xpath = "//button[@type='button'][contains(@class,'cancel')]")
    WebElement cancelBtn;

    @FindBy(xpath = "//button[@type='submit'][contains(@class,'reset')]")
    WebElement resetBtn;

    @FindBy(xpath = "//h6[contains(@class,'orangehrm-forgot-password-title')]")
    WebElement resetPasswordMessage;

    /**
     * Action
     */

    public void resetPassword() {
        username.sendKeys("tony");
        resetBtn.click();
        resetPasswordMessage.isDisplayed();
    }


}
