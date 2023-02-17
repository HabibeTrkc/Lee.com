package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;


public class KrediKartiBilgileri {

    public KrediKartiBilgileri(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//input[@id='CardholderName']")
    public WebElement kartSahibiAdi;

    @FindBy(xpath = "//input[@id='CardNumber']")
    public WebElement cardNumber;

    @FindBy(xpath = "//select[@id='ExpireMonth']")
    public WebElement cardSonAy;

    @FindBy(xpath = "//select[@id='ExpireMonth']/option[12]")
    public WebElement cardSonAySec;

    @FindBy(xpath = "//select[@id='ExpireYear']")
    public WebElement cardSonYil;

    @FindBy(xpath = "//select[@id='ExpireYear']/option[15]")
    public WebElement cardSonYilSec;

    @FindBy(xpath = "//input[@class='form-control credit-card-code']")
    public WebElement cvvNumbers;




}
