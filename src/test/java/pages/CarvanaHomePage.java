package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper']")
    public WebElement logo;

    @FindBy(css = "div[data-cv-test='headerWrapper']>div:nth-child(2)>div>a")
    public List<WebElement> mainItems;

    @FindBy(css = "div[data-qa='sign-in-wrapper']")
    public WebElement signInButtonHomePage;

    @FindBy(css = "#usernameField")
    public WebElement usernameInputBox;

    @FindBy(css = "#passwordField")
    public WebElement passwordInputBox;

    @FindBy(css = "#ae-signin-modal-label")
    public WebElement signInHeading;

    @FindBy(css = "button[data-cv='sign-in-submit']")
    public WebElement signInButtonLogin;

    @FindBy(css = "div[data-qa='error-message-container']")
    public WebElement signInErrorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsLink;

    @FindBy(css = "button[data-qa='drop-down-wrap']")
    public List<WebElement> filterOptionsList;

    @FindBy(css = "input[type='text']")
    public WebElement searchInputBox;

    @FindBy(css = "button[data-qa='go-button']")
    public WebElement goButton;

    @FindBy(css = "div[class='tk-frame top-frame']")
    public List<WebElement> imagesOfEachTile;

    @FindBy(css = "div[data-test='BaseFavoriteVehicle']")
    public List<WebElement> favoriteButton;

    @FindBy(css = "div[data-test='BaseInventoryType']")
    public List<WebElement> inventoryType;

    @FindBy(css = "div[data-qa='make-model']")
    public List<WebElement> yearMakeModel;

    @FindBy(css = "div[data-test='TrimMileage']")
    public List<WebElement> trimMileageInformation;

    @FindBy(css = "div[class='price ']")
    public List<WebElement> priceTileBody;

    @FindBy(css = "div[data-qa='monthly-payment']")
    public List<WebElement> monthlyPaymentInformation;

    @FindBy(css = "div[class='down-payment']")
    public List<WebElement> downPaymentInformation;

    @FindBy(css = "div[data-test='DeliveryChip']")
    public List<WebElement> deliveryChip;




}
