package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;



public class MyStepdefs {

    LoginPage login = new LoginPage();
    SepetimPage sepet = new SepetimPage();
    AlisverisYap alisverisYap = new AlisverisYap();
    AlisverisTamamla alisverisTamamla = new AlisverisTamamla();
    JavascriptExecutor js = (JavascriptExecutor) (Driver.getDriver());
    AdresBilgileri adresBilgileri = new AdresBilgileri();
    KrediKartiBilgileri krediKartiBilgileri = new KrediKartiBilgileri();
    SiparisiTamamla siparisiTamamla = new SiparisiTamamla();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    Random rnd = new Random();
    Integer random = rnd.nextInt(3) + 1;
    Faker faker = new Faker();


    @When("Kullanici url adresine gider.")
    public void kullaniciUrlAdresineGider() {
        Driver.getDriver().get(ConfigReader.getProperty("baseUrl"));
    }

    @And("Anasayfada pop up ve bildirim var ise tiklanir.")
    public void anasayfadaPopUpBildirimVarIseTiklanir() throws InterruptedException {
        Thread.sleep(5000);
        try {
            Alert alert = Driver.getDriver().switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }
    }

    @And("Daha onceden olusturlmus uyelik bilgileri ile giris yapilir.")
    public void dahaOncedenOlusturlmusUyelikBilgileriIleGirisYapilir() {
        ReusableMethods.waitForClickablility(login.hesabmButton, 10);
        login.hesabmButton.click();
        ReusableMethods.scrollToElement(Driver.getDriver(), login.Email);
        login.Email.click();
        login.Email.sendKeys(ConfigReader.getProperty("userMail"));
        ReusableMethods.scrollToElement(Driver.getDriver(), login.password);
        login.password.click();
        login.password.sendKeys(ConfigReader.getProperty("password"));
        WebElement element = (Driver.getDriver()).findElement(By.className("login-button"));
        while (element == null || !element.isDisplayed()) {
            js.executeScript("window.scrollBy(0, 100)");
            element = (Driver.getDriver()).findElement(By.className("login-button"));
        }
        login.logn.click();

    }

    @And("Giris yapildi basarili console de bilgisi gosterilir.")
    public void girisYapildiBasariliConsoleDeBilgisiGosterilir() {
        ReusableMethods.waitForClickablility(sepet.sepetim, 10000);
        if (sepet.sepetim.isEnabled()) {
            System.out.println("Basarili Bir Sekilde Giris Yaptiniz");
        } else
            System.out.println("Giris Yapilamadi Tekrar Deneyiniz");
    }


    @Then("Sepete girilir")
    public void sepeteGirilir() throws InterruptedException {
        sepet.sepetim.click();

    }

    @And("Sepete urun olup olmadigi kontrol edilir.Urun Urunler var ise sepet temizlenir.")
    public void sepeteUrunOlupOlmadigiKontrolEdilirUrunUrunlerVarIseSepetTemizlenir() {
        List<WebElement> bosYazisi = Driver.getDriver().findElements(By.xpath("//div[@class='cl-empty-cart-container']"));

        if (bosYazisi.size() != 0) {
        } else {
            wait.until(ExpectedConditions.elementToBeClickable(sepet.sepetiBosalt));
            sepet.sepetiBosalt.click();
            wait.until(ExpectedConditions.elementToBeClickable(sepet.sepetiBosaltOnayla));
            sepet.sepetiBosaltOnayla.click();
        }
    }

    @And("Jeans kadin erkek kategorilerinden herhangi biri random secilir.")
    public void jeansKadinErkekKategorilerindenHerhangiBiriRandomSecilir() throws InterruptedException {
        sepet.alisveriseBaslaButton.click();
        ReusableMethods.waitForClickablility(alisverisYap.uckatgri, 20000);
        Driver.getDriver().findElement(By.xpath("//*[@id=\"cl-header\"]/div[3]/div/nav/ul/li[" + random + "]")).click();
        ReusableMethods.waitForClickablility(alisverisYap.uckatgri, 50);
    }

    @And("Urun listeleme sayfasindan siralama artan fiyat olarak secilir.")
    public void urunListelemeSayfasindanSiralamaArtanFiyatOlarakSecilir() {
        alisverisYap.urunSiralamaButton.click();
        alisverisYap.fiyatArtanSiralama.click();

    }

    @Then("Ilk urunun icerisine girilir.")
    public void ilkUrununIcerisineGirilir() throws InterruptedException {
        Thread.sleep(5000);
        ReusableMethods.scrollToElement(Driver.getDriver(), alisverisYap.ilkUrun);
        alisverisYap.ilkUrun.click();

    }


    @And("Acilan urunun bedeni random olarak secilir.Tukenen beden secildi ise tekrar bir urun secilir.")
    public void acilanUrununBedeniRandomOlarakSecilirTukenenBedenSecildiIseTekrarBirUrunSecilir() {
        ReusableMethods.waitForClickablility(alisverisYap.bedenButton, 50);
        ReusableMethods.scrollToElement(Driver.getDriver(), alisverisYap.bedenButton);
        alisverisYap.bedenButton.click();
        List<WebElement> bedenler = Driver.getDriver().findElements(By.xpath("//*[@id='size-select']/option[not(contains(text(), 'tükendi')) and not(contains(text(), 'Beden Seçiniz'))]"));

        Select select = new Select(alisverisYap.bedenButton);
        List<WebElement> bedenSecenekleri = new ArrayList<WebElement>();
        for (WebElement option : select.getOptions()) {
            if (!option.getText().contains("tükendi") && !option.getText().contains("Beden Seçiniz")) {
                bedenSecenekleri.add(option);
                break;
            }
        }
        int rndBeden = rnd.nextInt(bedenSecenekleri.size());
        alisverisYap.bedenButton.click();
        bedenSecenekleri.get(rndBeden).click();

    }

    @And("Random secilen urun bedeni sepete eklenir.")
    public void randomSecilenUrunBedeniSepeteEklenir() {

        ReusableMethods.waitForClickablility(alisverisYap.sepeteEkle, 50);
        alisverisYap.sepeteEkle.click();
    }


    @Then("Sepete gidilir.")
    public void sepeteGidilir() throws InterruptedException {
        Thread.sleep(10000);
        ReusableMethods.scrollToElement(Driver.getDriver(), sepet.sepetim);
        ReusableMethods.waitForClickablility(sepet.sepetim, 50);
        sepet.sepetim.click();
        ReusableMethods.waitForClickablility(sepet.sepetim, 50);
    }

    @And("Hediye paketi istiyorum secilir.")
    public void hediyePaketiIstiyorumSecilir() {
        alisverisTamamla.hediyePaketiEkle.click();
    }

    @And("Promosyon kodu rastgele girilir.")
    public void promosyonKoduRastgeleGirilir() throws InterruptedException {
        alisverisTamamla.indirimKuponu.sendKeys(faker.number().digits(9));
        ReusableMethods.waitForClickablility(alisverisTamamla.indirimKodUygulaButton, 10000);
        alisverisTamamla.indirimKodUygulaButton.click();
    }

    @Given("Cikan hata mesaji console yazdirilir.")
    public void cikanHataMesajiConsoleYazdirilir() throws InterruptedException {
        for (int i = 0; i < 10; i++) {

            try {
                System.out.println(Driver.getDriver().findElement(By.id("toast-container")).getText());
                break;
            } catch (Exception e) {
                Thread.sleep(1000);
                alisverisTamamla.indirimKodUygulaButton.click();
            }
        }

    }

    @And("Satin al butonuna bas ve ilerle.")
    public void satinAlButonunaBasVeIlerle() throws InterruptedException {
        Thread.sleep(5000);
        ReusableMethods.scrollToElement(Driver.getDriver(), alisverisTamamla.satinAlButton);
        alisverisTamamla.satinAlButton.click();
    }


    @And("Teslimat adresi bilgilerine rastgele adres ekle.")
    public void teslimatAdresiBilgilerineRastgeleAdresEkle() throws InterruptedException {
        ReusableMethods.scrollToElement(Driver.getDriver(), adresBilgileri.yeniAdresEkle);
        adresBilgileri.yeniAdresEkle.click();
        adresBilgileri.adresBasligi.sendKeys(faker.address().streetName());
        adresBilgileri.ilButton.click();

        Select ilSecenekleri = new Select(adresBilgileri.ilButton);
        List<WebElement> ilOptions = ilSecenekleri.getOptions();
        if (ilOptions.size() > 1) {
            int ilRandom = rnd.nextInt(ilOptions.size() - 1) + 1;
            ilSecenekleri.selectByIndex(ilRandom);
        } else if (ilOptions.size() == 1) {
            ilSecenekleri.selectByIndex(0);
        }
        Thread.sleep(5000);
        adresBilgileri.ilceButton.click();
        Thread.sleep(5000);
        Select ilceSecenekleri = new Select(adresBilgileri.ilceButton);
        List<WebElement> ilceOptions = ilceSecenekleri.getOptions();
        if (ilceOptions.size() > 1) {
            int ilceRandom = rnd.nextInt(ilceOptions.size() - 1) + 1;
            ilceSecenekleri.selectByIndex(ilceRandom);
        } else if (ilceOptions.size() == 1) {
            ilceSecenekleri.selectByIndex(0);
        }
        Thread.sleep(5000);
        adresBilgileri.mahalleButton.click();
        Thread.sleep(5000);
        Select mahalleSecenekleri = new Select(adresBilgileri.mahalleButton);
        List<WebElement> mahalleOptions = mahalleSecenekleri.getOptions();
        if (mahalleOptions.size() > 1) {
            int mahalleRandom = rnd.nextInt(mahalleOptions.size() - 1) + 1;
            mahalleSecenekleri.selectByIndex(mahalleRandom);
        } else if (mahalleOptions.size() == 1) {
            mahalleSecenekleri.selectByIndex(0);
        } else {
        }

        Thread.sleep(5000);
        adresBilgileri.adres.sendKeys(faker.address().fullAddress());
        ReusableMethods.scrollToElement(Driver.getDriver(), adresBilgileri.adresKaydetButton);
        adresBilgileri.adresKaydetButton.click();
        Thread.sleep(5000);
        adresBilgileri.devamEtButtonAdresSonrasi.click();
    }


    @And("Kredi karti bilgilerini hatali gir.")
    public void krediKartiBilgileriniHataliGir() throws InterruptedException {
        ReusableMethods.waitForClickablility(krediKartiBilgileri.kartSahibiAdi, 5000);
        krediKartiBilgileri.kartSahibiAdi.click();
        krediKartiBilgileri.kartSahibiAdi.sendKeys(faker.name().fullName());
        Thread.sleep(3000);
        krediKartiBilgileri.cardNumber.click();
        krediKartiBilgileri.cardNumber.sendKeys(faker.number().digits(16));
        Thread.sleep(3000);
        krediKartiBilgileri.cardSonAy.click();
        krediKartiBilgileri.cardSonAySec.click();
        Thread.sleep(3000);
        krediKartiBilgileri.cardSonYil.click();
        krediKartiBilgileri.cardSonYilSec.click();
        Thread.sleep(3000);
        krediKartiBilgileri.cvvNumbers.click();
        krediKartiBilgileri.cvvNumbers.sendKeys(faker.number().digits(3));


    }

    @And("Siparisi tamamla.Cikan hata mesajini console yazdir.")
    public void siparisiTamamlaCikanHataMesajiniConsoleYazdir() throws InterruptedException {
        Thread.sleep(3000);
        siparisiTamamla.mesafeliSatsSozlesmesi.click();
        ReusableMethods.scrollToElement(Driver.getDriver(), siparisiTamamla.siparisiTamamlaButton);
        siparisiTamamla.siparisiTamamlaButton.click();
        Thread.sleep(5000);
        for (int i = 0; i < 20; i++) {
            try {
                Alert odemeBilgileriHatali = Driver.getDriver().switchTo().alert();
                System.out.println(odemeBilgileriHatali.getText());
                odemeBilgileriHatali.accept();
                break;
            } catch (Exception e) {
                siparisiTamamla.siparisiTamamlaButton.click();
            }
        }

    }

    @And("Sepete don ve urun adedini bir artir.")
    public void sepeteDonVeUrunAdediniBirArtir() throws InterruptedException {
        ReusableMethods.waitForClickablility(sepet.sepetim, 10000);
        ReusableMethods.scrollToElement(Driver.getDriver(), sepet.sepetim);
        Thread.sleep(2000);
        sepet.sepetim.click();
        ReusableMethods.scrollToElement(Driver.getDriver(), sepet.sepetiBirArtirButton);
        sepet.sepetiBirArtirButton.click();

    }


    @Then("Uyelikten cikis yap.")
    public void uyeliktenCikisYap() {
        ReusableMethods.scrollToElement(Driver.getDriver(), login.hesabmButton);
        login.hesabmButton.click();
        ReusableMethods.waitForClickablility(siparisiTamamla.uyeliktenCikisYap, 5000);
        ReusableMethods.scrollToElement(Driver.getDriver(), siparisiTamamla.uyeliktenCikisYap);
        siparisiTamamla.uyeliktenCikisYap.click();
    }

    @And("Tarayiciyi kapat.")
    public void tarayiciyiKapat() {
        Driver.closeDriver();
    }


}
