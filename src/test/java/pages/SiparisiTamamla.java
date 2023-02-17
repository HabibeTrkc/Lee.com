package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SiparisiTamamla {

    public SiparisiTamamla() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "(//*[@class='cl-checkmark'][1])[3]")
    public WebElement mesafeliSatsSozlesmesi;

    @FindBy(xpath = "(//input[@class='cl-checkout-tab-section-button cl-big-button'][1])[3]")
    public WebElement siparisiTamamlaButton;

    @FindBy(xpath = "//*[@class='log-out']")
    public WebElement uyeliktenCikisYap;
}
