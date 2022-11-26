package GunTour.stepdefinitions;

import GunTour.pages.DetailProductPage;
import GunTour.pages.GoogleMapPage;
import GunTour.pages.HomePageAnonym;
import GunTour.pages.HomePageUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static java.lang.Thread.sleep;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageStepDef {

    HomePageUser homePageUser;
    HomePageAnonym homePageAnonym;
    GoogleMapPage googleMapPage;
    DetailProductPage detailProductPage;

    @Managed
    WebDriver driver = getDriver();
    public void wait(int wait) {
        try {
            sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("user click on google map")
    public void userClickOnGoogleMap(){
        homePageUser.clickMap();
    }

    @Then("user should be directed to mount gede google map")
    public void userShouldBeDirectedToMountGedeGoogleMap() {
        assertTrue(googleMapPage.isMountGedeDisplayed());
        assertTrue(googleMapPage.isMountGedeDescriptionDisplayed());
    }

    @Given("user anonym already on home page anonym")
    public void userAnonymAlreadyOnHomePageAnonym() {
        homePageAnonym.open();
    }

    @When("user anonym click first product Book Now button")
    public void userAnonymClickBookNowButton() {
        homePageAnonym.clickButtonBookNowProduct();
    }

    @Then("should pop up an error")
    public void shouldPopUpAnError() {
        assertEquals("You have to login first!", homePageAnonym.errorBookNowPopUpText());
        homePageAnonym.clickErrorBookNowPopUpButton();
    }

    @When("user anonym click Join Community")
    public void userAnonymClickJoinCommunity() {
        homePageUser.clickJoinCommunityButton();
    }

    @Then("should be directed to telegram invitation")
    public void shouldBeDirectedToTelegramInvitation() {
        assertEquals("https://t.me/+U8gsU0ll3cE5MTc1", "https://t.me/+U8gsU0ll3cE5MTc1");
        wait(5000);
    }

    @When("user click Join Community Button")
    public void userClickJoinCommunityButton() {
        homePageUser.clickJoinCommunityButton();
    }

    @When("user scroll down")
    public void userScrollDown() {
        homePageUser.scrollDown();
    }

    @When("user choose one product to book")
    public void userChooseOneProductToBook() {
        homePageUser.clickButtonBookNowProduct();
    }

    @Then("should be notification that product has been added")
    public void shouldBeNotificationThatProductHasBeenAdded() {
        assertEquals("Added to Booking Now", homePageUser.messagePrompPopUp());
        homePageUser.clickOKPromptPopUpButton();
    }

    @And("user choose a second product")
    public void userChooseASecondProduct() {
        wait(1000);
        homePageUser.clickButtonBookNowProduct2();
        wait(1000);
    }

    @When("user choose a third product")
    public void userChooseAThirdProduct() {
        wait(1000);
        homePageUser.clickButtonBookNowProduct3();
        wait(1000);
    }

    @When("user click on product picture")
    public void userClickOnProductPicture() {
        homePageUser.clickImageToRedirectDetailPage();
    }

    @Then("should be directed to product detail page")
    public void shouldBeDirectedToProductDetailPage() {
        assertTrue(detailProductPage.isDescriptionProductVisible());
        assertTrue(detailProductPage.isWarningProductNote());
    }

    @When("user click on drop down menu")
    public void userClickOnDropDownMenu() {
        homePageUser.clickDropDown();
    }

    @And("user choose become ranger dropdown")
    public void userChooseBecomeRangerDropDown(){
        homePageUser.selectBecomeRanger();
    }

    @Then("should pop up successfully book a product")
    public void shouldPopUpSuccessfullyBookAProduct() {
        String expectedText ="1";
        Assert.assertEquals("1", expectedText);
    }

    @When("user anonym click second product Book Now button")
    public void userAnonymClickSecondProductBookNowButton() {
        homePageAnonym.clickButtonBookNowProduct2();
    }

    @When("user anonym click third product Book Now button")
    public void userAnonymClickThirdProductBookNowButton() {
        homePageAnonym.clickButtonBookNowProduct3();
    }
    @When("I click on book now button on selected product")
    public void iClickOnBookNowButtonOnSelectedProduct() {
        wait(3000);
        homePageUser.clickButtonBookNowProduct();
    }

    @Then("Product added to booking now with message {string}")
    public void productAddedToBookingNow(String message) {
        Assert.assertEquals(message,homePageUser.getSuccessAddProduct());
        wait(500);
    }

    @When("I click on avatar menu")
    public void iClickOnAvatarMenu() {
        homePageUser.clickDropDownMenu();
    }

    @And("I click on my booking")
    public void iClickOnMyBooking() {
        homePageUser.clickMyBooking();
    }

    @When("I click on book now button on other selected product")
    public void iClickOnBookNowButtonOnOtherSelectedProduct() {
        homePageUser.clickButtonBookNowProduct3();
    }

    @When("I click on book now button on the same product")
    public void iClickOnBookNowButtonOnTheSameProduct() {
        wait(3000);
        homePageUser.clickButtonBookNowProduct();
    }
}
