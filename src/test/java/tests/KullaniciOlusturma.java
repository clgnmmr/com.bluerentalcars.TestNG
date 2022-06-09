package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

public class KullaniciOlusturma {

    @Test
    public void test01() throws InterruptedException {
        //1-Anasayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsUrl"));

        // 2-Anasayfadaki login tuşuna bas
        BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();
        bluerentalcarsPage.ilkLogin.click();

        // 3-Create new user butonuna bas
        bluerentalcarsPage.createNewUserElement.click();

        // 4-"Register" yazısının çıktığını test ediniz
        Assert.assertTrue(bluerentalcarsPage.registerYazisiElement.isDisplayed());

        // 5-Gerekli bilgileri doldurduktan sonra Register butonuna basınız.
        Actions actions = new Actions(Driver.getDriver());
        Faker faker = new Faker();
        String password = faker.internet().password();
        String emailAddress = faker.internet().emailAddress();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String expectedName = firstName + " " + lastName;
        System.out.println("sifre: " + password);
        System.out.println("email adress: " + emailAddress);

        actions.click(bluerentalcarsPage.firstNameKutusuElement).
                sendKeys(firstName + Keys.TAB).
                sendKeys(lastName + Keys.TAB).
                sendKeys(faker.phoneNumber().phoneNumber() + Keys.TAB).
                sendKeys(faker.address().fullAddress() + Keys.TAB).
                sendKeys(faker.address().zipCode() + Keys.TAB).
                sendKeys(emailAddress + Keys.TAB).
                sendKeys(password + Keys.TAB).
                sendKeys(password + Keys.TAB).
                sendKeys(Keys.PAGE_DOWN).
                perform();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(bluerentalcarsPage.registerButtonElement));
        bluerentalcarsPage.registerButtonElement.click();
        Thread.sleep(3000);

        // 6-"You are registered successfully" yazısını gördüğünüzü test ediniz

        wait.until(ExpectedConditions.visibilityOf(bluerentalcarsPage.basariliGirisYazisiElement));
        Assert.assertTrue(bluerentalcarsPage.basariliGirisYazisiElement.isDisplayed());

        // 7-Login sayfasındakı Login tuşuna basınız
        bluerentalcarsPage.emailKutusu.sendKeys(emailAddress);
        bluerentalcarsPage.passwordKutusu.sendKeys(password);
        bluerentalcarsPage.ikinciLogin.click();

        // 8-Doğru şekilde siteye giriş yaptığınızı test ediniz.
        String actualName = bluerentalcarsPage.profilIsmi.getText();
        System.out.println(actualName);
        Assert.assertEquals(actualName,expectedName);

        // 9-Sayfayı kapatınız.
        Driver.closeDriver();
    }

}