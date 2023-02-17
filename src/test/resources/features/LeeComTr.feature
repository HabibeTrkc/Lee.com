
@Lee.com.EndToEnd
Feature: Lee.com.tr End to End test.


  Scenario:Sayfa da uyelik giris ile sepete urun eklenerek hatalı ödeme bilgileriyle siparis  durumu kontrol edilerek cıkış yapılır.
    When Kullanici url adresine gider.
    And Anasayfada pop up ve bildirim var ise tiklanir.
    And Daha onceden olusturlmus uyelik bilgileri ile giris yapilir.
    And Giris yapildi basarili console de bilgisi gosterilir.
    Then Sepete girilir
    And Sepete urun olup olmadigi kontrol edilir.Urun Urunler var ise sepet temizlenir.
    And Jeans kadin erkek kategorilerinden herhangi biri random secilir.
    And Urun listeleme sayfasindan siralama artan fiyat olarak secilir.
    Then Ilk urunun icerisine girilir.
    And Acilan urunun bedeni random olarak secilir.Tukenen beden secildi ise tekrar bir urun secilir.
    And Random secilen urun bedeni sepete eklenir.
    Then Sepete gidilir.
    And Hediye paketi istiyorum secilir.
    And Promosyon kodu rastgele girilir.
    Given Cikan hata mesaji console yazdirilir.
    And Satin al butonuna bas ve ilerle.
    And Teslimat adresi bilgilerine rastgele adres ekle.
    And Kredi karti bilgilerini hatali gir.
    And Siparisi tamamla.Cikan hata mesajini console yazdir.
    And Sepete don ve urun adedini bir artir.
    Then Uyelikten cikis yap.
    And Tarayiciyi kapat.



