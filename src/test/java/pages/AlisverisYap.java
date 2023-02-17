package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AlisverisYap {

    public AlisverisYap() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id=\"cl-header\"]/div[3]/div/nav/ul/li")
    public WebElement uckatgri;

    @FindBy(xpath = "//*[@id=\"cl-header\"]/div[3]/div/nav/ul/li[1]")
    public WebElement jeansButton;

    @FindBy(xpath = "//*[@id=\"cl-header\"]/div[3]/div/nav/ul/li[2]")
    public WebElement KadinButton;

    @FindBy(xpath = "//*[@id=\"cl-header\"]/div[3]/div/nav/ul/li[3]")
    public WebElement ErkekButton;

    @FindBy(xpath = "//select[@id='products-orderby']")
    public WebElement urunSiralamaButton;

    @FindBy(xpath = "//*[@id=\"products-orderby\"]/option[2]")
    public WebElement fiyatArtanSiralama;

    @FindBy(xpath = "//*[@id='cl-product-grid']/div[1]")
    public WebElement ilkUrun;

    @FindBy(xpath = "//*[@id='size-select']")
    public WebElement bedenButton;

    @FindBy(xpath = "//*[@id='size-select']/option[19]")
    public WebElement tumBedenlerListesi;

    @FindBy(xpath = "//button[@id='remember-cart-button-60a3eaed0580cf0001abb6c1']")
    public WebElement gelinceHaberVerButton;

    @FindBy(xpath = "//div[@class='cl-add-to-basket']")
    public WebElement sepeteEkle;
}
