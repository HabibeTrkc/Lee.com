package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@title='Hesabım']")
    public WebElement hesabmButton;

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement Email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//input[@class='login-button']")
    public WebElement logn;
}
