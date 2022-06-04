package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class NagatifTest {
    BluerentalcarsPage bluerentalcarsPage;

    @Test
    public void YanlisMailyanlisSifre() {
        //1- https://www.bluerentalcars.com/ bu url ye git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));
        //2- anasayfadaki login butonuna bas
        bluerentalcarsPage = new BluerentalcarsPage();
        bluerentalcarsPage.ilkLogin.click();
        //3- login aşaasında email adress kısmına yanlış maili gir "client@bluerentalcars.com"
        bluerentalcarsPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //4- login aşamasında password kısmına yanlış şifreyi gir "54321"
        bluerentalcarsPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        //5- giris butonuna tiklayiniz
        bluerentalcarsPage.ikinciLogin.click();
        //6- giremediğini kontrol etmek için sağ ustte gelen yazının "invalid credentials" oldugunu kontrol edelim.
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(bluerentalcarsPage.basarisizGirisMsj));
        Assert.assertTrue(bluerentalcarsPage.basarisizGirisMsj.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void DogruMailyanlisSifre() {
        // 1- https://www.bluerentalcars.com/ bu url ye git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));
        //2- anasayfadaki login butonuna bas
        bluerentalcarsPage = new BluerentalcarsPage();
        bluerentalcarsPage.ilkLogin.click();
        //3- login aşaasında email adress kısmına dogru maili gir "customer@bluerentalcars.com"
        bluerentalcarsPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcValidEmail"));
        //4- login aşamasında password kısmına yanlış şifreyi gir "54321"
        bluerentalcarsPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcWrongPassword"));
        // 5- giris butonuna tiklayiniz
        bluerentalcarsPage.ikinciLogin.click();
        //6- giremediğini kontrol etmek için sağ ustte gelen yazının "invalid credentials" oldugunu kontrol edelim.
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(bluerentalcarsPage.basarisizGirisMsj));
        Assert.assertTrue(bluerentalcarsPage.basarisizGirisMsj.isDisplayed());
        Driver.closeDriver();
    }

    @Test
    public void yanlisMaildogruSifre() {
        //1- https://www.bluerentalcars.com/ bu url ye git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));
        //2- anasayfadaki login butonuna bas
        bluerentalcarsPage = new BluerentalcarsPage();
        bluerentalcarsPage.ilkLogin.click();
        //3- login aşaasında email adress kısmına yanlış maili gir "client@bluerentalcars.com"
        bluerentalcarsPage.emailKutusu.sendKeys(ConfigReader.getProperty("brcWrongEmail"));
        //4- login aşamasında password kısmına doğru şifreyi gir "12345"
        bluerentalcarsPage.passwordKutusu.sendKeys(ConfigReader.getProperty("brcValidPassword"));
        // 5- giris butonuna tiklayiniz
        bluerentalcarsPage.ikinciLogin.click();
        //6- giremediğini kontrol etmek için sağ ustte gelen yazının "invalid credentials" oldugunu kontrol edelim.
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(bluerentalcarsPage.basarisizGirisMsj));
        Assert.assertTrue(bluerentalcarsPage.basarisizGirisMsj.isDisplayed());
        Driver.closeDriver();
    }
}
