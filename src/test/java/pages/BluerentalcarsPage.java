package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BluerentalcarsPage {

    public BluerentalcarsPage() {

        PageFactory.initElements(Driver.getDriver(), this);

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

    @FindBy(xpath = "//div[text()='invalid credentials']")
    public WebElement basarisizGirisMsj;


    @FindBy(xpath = "//select[@name='car']")
    public WebElement ddm;

    @FindBy(xpath = "//input[@name='pickUpLocation']")
    public WebElement pickUp;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement contiuneButonu;

    @FindBy(xpath = "//div[text()='Complete Reservation']")
    public WebElement completeReservationYazsi;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement cardNo;

    @FindBy(xpath = "//div[text()='Reservation created successfully']")
    public WebElement aracKiralamaBasariliGirisMsj;

    @FindBy(xpath = "//input[@name='contract']")
    public WebElement rodioButon;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    public WebElement completeReservationButon;

    @FindBy(xpath = "//*[text()='Create new user']")
    public WebElement createNewUserElement;

    @FindBy(tagName = "h1")
    public WebElement registerYazisiElement;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstNameKutusuElement;

    @FindBy(xpath = "//*[text()='You are registered successfully. ']")
    public WebElement basariliGirisYazisiElement;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement registerButtonElement;



}
