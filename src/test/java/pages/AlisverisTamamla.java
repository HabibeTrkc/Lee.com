package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AlisverisTamamla {

    public AlisverisTamamla() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='text']")
    public WebElement hediyePaketiEkle;

    @FindBy(xpath = "//input[@id='discountcouponcode']")
    public WebElement indirimKuponu;

    @FindBy(xpath = "//button[@id='applydiscountcouponcode']")
    public WebElement indirimKodUygulaButton;

    @FindBy(xpath = "//*[@class='cl-toast-container']")
    public WebElement kuponUygulanamadiText;

    @FindBy(xpath = "//button[@id='checkout']")
    public WebElement satinAlButton;
}
