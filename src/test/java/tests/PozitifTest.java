package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class PozitifTest {

    BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();


    @Test
    public void pozitifLoginTest() {

       //1- https://www.bluerentalcars.com/ bu url ye git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));


        //2- anasayfadaki login butonuna basiniz

        bluerentalcarsPage.ilkLogin.click();


        //3- login aşaasında email adress kısmına doğru maili gir "customer@bluerentalcars.com"
       bluerentalcarsPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));

        //4- login aşamasında password kısmına doğru şifreyi gir "12345"
        bluerentalcarsPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));

        //5 -email ve şifreden sonra giriş yapabilmek için alt kısımdaki  login butonu ile giriş yap
        bluerentalcarsPage.ikinciLogin.click();


        //6- giriş yaptıktan sonra şifre için gelen pop'un  "kapat" bas
        //Driver.getDriver().switchTo().alert().dismiss();

        //7 -giriş yapıldıgını test etmek için  kullanınıcının isminin "Jordon Stark" oldugunu ontrol edelim
       String expectedUsername ="Jordon Stark";
       String actualUsername = bluerentalcarsPage.profilIsmi.getText();

       Assert.assertEquals(actualUsername ,expectedUsername);

    }
}
