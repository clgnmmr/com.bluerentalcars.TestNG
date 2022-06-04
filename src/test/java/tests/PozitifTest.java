package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class PozitifTest extends TestBaseRapor {

    BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();


    @Test
    public void pozitifLoginTest(){
        extentTest=extentReports.createTest("Pozitif Login Test", "Kullanici dogru maili ve sifre ile giris yapabilmeli");
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
       String expectedUsername ="Jordon Stark";
       String actualUsername = bluerentalcarsPage.profilIsmi.getText();

       Assert.assertEquals(actualUsername ,expectedUsername);

       extentTest.pass("kullanici basarili sekilde giris yapti");

       Driver.closeDriver();

    }
}
