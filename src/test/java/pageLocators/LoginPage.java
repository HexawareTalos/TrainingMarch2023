package pageLocators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement login;

    @FindBy(xpath = "//p[text()='Forgot your password? '] ")
    WebElement forgotPassword;


    /**
     * All Actions
     */

    public void login(){
        username.sendKeys("Admin");
        password.sendKeys("admin123");
        login.click();
    }

    public void clickForgotPassword(){
        forgotPassword.click();
    }

}
