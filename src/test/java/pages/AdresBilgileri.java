package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdresBilgileri {

    public AdresBilgileri() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='add-new-address-button'])[1]")
    public WebElement yeniAdresEkle;

    @FindBy(xpath = "(//input[@id='address_attribute_5eae2115f6f875754ba14134'][1])[2]")
    public WebElement adresBasligi;

    @FindBy(xpath = "//*[@id='ShippingNewAddress_Address1']")
    public WebElement adres;

    @FindBy(xpath = "//select[@id='ShippingNewAddress_CountryId']")
    public WebElement ilButton;

    @FindBy(xpath = "//*[@id=\"ShippingNewAddress_CountryId\"]/option[82]")
    public WebElement iller;

    @FindBy(xpath = "//*[@id='ShippingNewAddress_StateProvinceId']")
    public WebElement ilceButton;

    @FindBy(xpath = "//select[@id='ShippingNewAddress_NeighborhoodId']")
    public WebElement mahalleButton;

    @FindBy(xpath = "//select[@id='ShippingNewAddress_NeighborhoodId']/option")
    public WebElement mahalleler;

    @FindBy(xpath = "//input[@class='cl-big-button save-address-button temp-shipping-save-button']")
    public WebElement adresKaydetButton;

    @FindBy(xpath = "//input[@title=\"Devam Et\"][1]")
    public WebElement devamEtButtonAdresSonrasi;
}
