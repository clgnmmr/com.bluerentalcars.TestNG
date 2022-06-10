package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class AracKiralamE2E extends TestBaseRapor {
    BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();

    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("Pozitif Login Test", "Kullanici dogru maili ve sifre ile giris yapabilmeli");
        //1- https://www.bluerentalcars.com/ bu url ye git

        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));
        extentTest.info("Siteye giris yapildi");


        //2- anasayfadaki login butonuna basiniz

        bluerentalcarsPage.ilkLogin.click();
        extentTest.info("anasayfadaki logine tiklandi");

        //3- login aşaasında email adress kısmına doğru maili gir "customer@bluerentalcars.com"
        bluerentalcarsPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        extentTest.info("dogru mail girisi yapildi");
        //4- login aşamasında password kısmına doğru şifreyi gir "12345"
        bluerentalcarsPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        extentTest.info("dogru sifre girisi yapildi");
        //5 -email ve şifreden sonra giriş yapabilmek için alt kısımdaki  login butonu ile giriş yap
        bluerentalcarsPage.ikinciLogin.click();
        extentTest.info("ikinc login tiklandi");

        //6- giriş yaptıktan sonra şifre için gelen pop'un  "kapat" bas
        //Driver.getDriver().switchTo().alert().dismiss();

        //7 -giriş yapıldıgını test etmek için  kullanınıcının isminin "Jordon Stark" oldugunu ontrol edelim
        String expectedUsername = "Jordon Stark";
        String actualUsername = bluerentalcarsPage.profilIsmi.getText();
        Assert.assertEquals(actualUsername, expectedUsername);
        extentTest.pass("Kullanici adi anasayfda goruldu");
        //8- kullanici herhangi bir arac secip devamindaki gerekli bilgileri doldursun
        Select select=new Select(bluerentalcarsPage.ddm);
        select.selectByVisibleText("Ford Kuga");
        Actions actions=new Actions(Driver.getDriver());
        actions.click(bluerentalcarsPage.pickUp)
                .sendKeys("Kansas Arkansas City"+ Keys.TAB)
                .sendKeys("Kansas Arkansas City"+ Keys.TAB)
                .sendKeys("17092022"+ Keys.TAB)
                .sendKeys("1200"+ Keys.TAB)
                .sendKeys("28092022"+ Keys.TAB)
                .sendKeys("1200").perform();
        extentTest.info("Gerekli araç kiralama bilgileri girildi");
        //9- kullanici continue rezervation butonuna tiklasin
        bluerentalcarsPage.contiuneButonu.click();
        extentTest.info("devam butaonuna tiklandi");
        //10- Complete Reservation basliginin gorundugunu test eder
        Assert.assertTrue(bluerentalcarsPage.completeReservationYazsi.isDisplayed());
        extentTest.pass("Baslik Complete Reservation yazisi görüldü ");
        //11- Complete Reservation istenilen bilgiler doldurulur
        actions.click(bluerentalcarsPage.cardNo)
                .sendKeys("1234123412341234"+Keys.TAB)
                .sendKeys("Jordon Stark"+Keys.TAB)
                .sendKeys("1224"+Keys.TAB)
                .sendKeys("122").perform();
        extentTest.info("gerekli fatura bilgiler dolduruldu");
        bluerentalcarsPage.rodioButon.click();
        extentTest.info("kullanici doldurdugu bilgilerin dogrulugunu onayladi");
        bluerentalcarsPage.completeReservationButon.click();
        extentTest.info("Kullanici rezervasyonu basarili bir sekilde tamamladi");
        //12- Reservasyon tamamlanir
        //13. Rezervasyonun tamamlandigini "Reservation created successfully" ggrundugunu test eder
        ReusableMethods.waitForVisibility(bluerentalcarsPage.aracKiralamaBasariliGirisMsj,10);
        Assert.assertTrue(bluerentalcarsPage.aracKiralamaBasariliGirisMsj.isDisplayed());
        extentTest.pass("kullanici basarili bir sekilde arac kiraladı");
    }
}
