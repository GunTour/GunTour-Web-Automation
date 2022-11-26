package GunTour.stepdefinitions;

import GunTour.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static java.lang.Thread.sleep;

public class OrderHistoryStepDef {

    MidtransPage midtransPage;
    BookingPage bookingPage;
    HomePageUser homePage;
    ConfirmationPage confirmationPage;
    BookingHistoryPage bookingHistory;
    BCAKlikPayPage bcaKlikPayPage;
    BRImoPage brimoPage;
    public void wait(int wait) {
        try {
            sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @When("I click on Pay Now button")
    public void iClickOnPayNowButton() {
        bookingHistory.clickPayNowButton();
    }

    @Then("I redirected to midtrans")
    public void iRedirectedToMidtrans() {
        Assert.assertTrue(midtransPage.isMerchantNameVisible());
        Assert.assertTrue(midtransPage.isSelectMethodVisible());
    }

    @When("I click on delete button")
    public void iClickOnDeleteButton() {
        bookingHistory.clickDeleteButton();
    }

    @When("I click yes delete it on alert pop up")
    public void iClickYesDeleteItOnAlertPopUp() {
        wait(1000);
        bookingHistory.clickYesDeleteIt();
        wait(500);
    }

    @And("I already create a booking plan")
    public void iAlreadyCreateABookingPlan() {
        homePage.clickBookedNowNavabr();
        bookingPage.inputFromDate("11172022");
        wait(500);
        bookingPage.inputToDate("11192022");
        bookingPage.clickDropDownEntrance();
        bookingPage.selectDropDownEntrance("Entrance Cibodas");
        bookingPage.clickDropDownPerson();
        bookingPage.selectDropDownPerson("5");
//        bookingPage.clickDropDownRangers();
//        bookingPage.selectDropDownRangers("Fajar Nugraha");
        bookingPage.scrollSmooth();
        bookingPage.clickBookedNowButton();
        Assert.assertEquals("Are you sure the data is correct?",bookingPage.sweetAlertAppear());
        bookingPage.clickYesSureAlert();
        Assert.assertEquals("https://guntour.vercel.app/confirm",confirmationPage.getUrl());
        confirmationPage.isPaymentDescriptionVisible();
        confirmationPage.clickConfirmButton();
        Assert.assertEquals("Confirmation Successful",confirmationPage.getConfirmationSuccessfulMessage());
        wait(4000);
        Assert.assertEquals("https://guntour.vercel.app/history",bookingHistory.getUrl());
    }

    @And("I see status booking is {string}")
    public void iSeeStatusBookingIs(String status) {
        Assert.assertEquals(status,bookingHistory.statusBookingProduct());
    }


    @When("I select BCA Payment Method")
    public void iSelectBCAPaymentMethod() {
        wait(3000);
        midtransPage.clickBCAKlikPay();
    }

    @And("I click pay now button with BCA Klik Pay")
    public void iClickPayNowButtonWithBCAKlikPay() {
        bcaKlikPayPage.clickPayNowBCA();
        wait(3000);
    }

    @And("I click Bayar button with BCA Klik Pay")
    public void iClickBayarButtonWithBCAKlikPay() {
        bcaKlikPayPage.clickBayarButton();
        wait(2000);
    }

    @Then("I see transaction is success")
    public void iSeeTransactionIsSuccess() {
        Assert.assertTrue(bcaKlikPayPage.isTransactionSuccessVisible());
    }

    @When("I click back to merchant website button")
    public void iClickBackToMerchantWebsiteButton() {
        bcaKlikPayPage.clickBackToMerchantButton();
        wait(4000);
    }

    @Then("I redirected to booking history with status booking is {string}")
    public void iRedirectedToBookingHistoryWithStatusBookingIs(String status) {
        Assert.assertEquals(status,bookingHistory.statusBookingProduct());
    }

    @And("I select payment method with bank transfer")
    public void iSelectPaymentMethodWithBankTransfer() {
        midtransPage.selectBankTransfer();
    }

    @And("I select permata bank")
    public void iSelectPermataBank() {
        midtransPage.clickPermataBank();
    }

    @And("I click back to merchant")
    public void iClickBackToMerchant() {
        midtransPage.clickBackToMerchant();
    }

    @Then("I see virtual account Permata")
    public void iSeeVirtualAccountPermata() {
        wait(3000);
        Assert.assertTrue(midtransPage.isVirtualAccountVisible());
    }

    @And("I select payment method with BRImo")
    public void iSelectPaymentMethodWithBRImo() {
        midtransPage.clickBRImo();
    }

    @And("I click pay now button with BRImo")
    public void iClickPayNowButtonWithBRImo() {
        brimoPage.clickPayNowBRImo();
    }

    @And("I input user BRImo as {string}")
    public void iInputUserBRImoAs(String username) {
        brimoPage.inputUserBRImo(username);
    }

    @When("I click back to website merchant")
    public void iClickBackToWebsiteMerchant() {
        brimoPage.clickBackToWebsiteMerchant();
        wait(5000);
    }

    @And("I click Bayar button with BRImo")
    public void iClickBayarButtonWithBRImo() {
        brimoPage.clickBayarButton();
    }

    @Then("I see transaction with brimo is success")
    public void iSeeTransactionWithBrimoIsSuccess() {
        Assert.assertTrue(brimoPage.isSuccessMessageVisible());
    }
}
