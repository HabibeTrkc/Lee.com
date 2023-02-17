package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SepetimPage {

    public SepetimPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//img[@title='Sepetim']")
    public WebElement sepetim;

    @FindBy(xpath = "//div[@class='cl-empty-cart-container']")
    public WebElement sepetimBosAlani;

    @FindBy(xpath = "//button[@class='cl-product-card-button deleteshoppingcartitem']")
    public WebElement sepetiBosalt;

    @FindBy(xpath = "//button[@class='cl-big-button cl-order-completed-page-button cl-delete-btn cl-remove-cart-button']")
    public WebElement sepetiBosaltOnayla;

    @FindBy(xpath = "//button[@class='cl-big-button cl-order-completed-page-button']")
    public WebElement alisveriseBaslaButton;

    @FindBy(xpath="//div[@class='cl-input-plus-button']")
    public WebElement sepetiBirArtirButton;
}
