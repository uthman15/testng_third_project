package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base {

    @Test(priority = 1, description = "TC1: Validate Carvana home page title and url")
    public void testCarvanaHomePageAndTitle(){
        driver.get("https://www.carvana.com/");

        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
    }

    @Test(priority = 2, description = "TC2: Validate the Carvana logo")
    public void testCarvanaLogoDisplayed(){
        driver.get("https://www.carvana.com/");

        Assert.assertTrue(carvanaHomePage.logo.isDisplayed());
    }

    @Test(priority = 3, description = "TC3: Validate the main navigation section items")
    public void testMainNavigationItems(){
        driver.get("https://www.carvana.com/");

        String[] mainNavigationItems = {"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for (int i = 0; i < mainNavigationItems.length; i++) {
            Assert.assertEquals(carvanaHomePage.mainItems.get(i).getText(), mainNavigationItems[i]);
        }
    }

    @Test(priority = 4, description = "TC4: Validate the sign in error message")
    public void testSignInErrorMessage(){
        driver.get("https://www.carvana.com/");
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.signInButtonHomePage, 15);
        carvanaHomePage.signInButtonHomePage.click();
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.signInHeading, 15);
        Assert.assertTrue(carvanaHomePage.signInHeading.isDisplayed());
        Assert.assertEquals(carvanaHomePage.signInHeading.getText(), "Sign in");
        carvanaHomePage.usernameInputBox.sendKeys("johndoe@gmail.com");
        carvanaHomePage.passwordInputBox.sendKeys("abcd1234");
        carvanaHomePage.signInButtonLogin.click();
        Waiter.waitForVisibilityOfElement(driver, carvanaHomePage.signInErrorMessage, 15);
        Assert.assertEquals(carvanaHomePage.signInErrorMessage.getText(), "Email address and/or password combination is incorrect\nPlease try again or reset your password.");
    }

    @Test(priority = 5, description = "TC5: Validate the search filter options and search button")
    public void testSearchFilterSearchButton(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");

        String[] expectedFilterOptions = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};

        for (int i = 0; i < 6; i++) {
            Assert.assertEquals(carvanaHomePage.filterOptionsList.get(i).getText(), expectedFilterOptions[i]);
        }
    }

    @Test(priority = 6, description = "TC6: Validate the search result tiles")
    public void testSearchResultTiles(){
        driver.get("https://www.carvana.com/");
        carvanaHomePage.searchCarsLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        carvanaHomePage.searchInputBox.sendKeys("mercedes-benz");
        carvanaHomePage.goButton.click();
        Waiter.pause(3);
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));
        for (WebElement element : carvanaHomePage.imagesOfEachTile) {
            Assert.assertTrue(element.isDisplayed());
        }
        for (WebElement element : carvanaHomePage.favoriteButton) {
            Assert.assertTrue(element.isDisplayed());
        }
        for (WebElement element : carvanaHomePage.inventoryType) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText()!=null);
        }
        for (WebElement element : carvanaHomePage.yearMakeModel) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText()!=null);
        }
        for (WebElement element : carvanaHomePage.trimMileageInformation) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText()!=null);
        }
        for (WebElement element : carvanaHomePage.priceTileBody) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(Integer.parseInt(element.getText().replaceAll("[^0-9]", ""))>0);
        }
        for (WebElement element : carvanaHomePage.monthlyPaymentInformation) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText()!=null);
        }
        for (WebElement element : carvanaHomePage.downPaymentInformation) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText()!=null);
        }
        for (WebElement element : carvanaHomePage.deliveryChip) {
            Assert.assertTrue(element.isDisplayed());
            Assert.assertTrue(element.getText()!=null);
        }
    }
}
