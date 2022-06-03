package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BluerentalcarsPage {

    public BluerentalcarsPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//*[text()=' Login']")
    public WebElement ilkLogin;

    @FindBy(xpath = "//input[@id='formBasicEmail']")
    public WebElement emailKutusu;

   @FindBy(xpath = "//input[@id='formBasicPassword']")
   public WebElement passwordKutusu;

   @FindBy(xpath = "//button[@type='submit']")
    public WebElement ikinciLogin;

  @FindBy(id = "dropdown-basic-button")
    public WebElement profilIsmi;



}
