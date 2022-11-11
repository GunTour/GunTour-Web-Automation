package GunTour.stepdefinitions;

import GunTour.pages.AdminProductPage;
import GunTour.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;

public class LoginStepDef {

    AdminProductPage adminProductPage;
    LoginPage loginPage;
    public void wait(int wait) {
        try {
            sleep(wait);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Given("already on login page")
    public void AlreadyOnLoginPage(){
        loginPage.open();
    }
    @When("input email {string}")
    public void InputUsername(String username){
        loginPage.InputUsername(username);
    }
    @And("input password {string}")
    public void InputPassword(String password){
        loginPage.InputPassword(password);
    }
    @And("click login button")
    public void ClickLoginButton(){
        loginPage.ClickLoginButton();
    }
    @Then("directed to admin page")
    public void DirectedtoAdminPage(){
        adminProductPage.clickOk();
        assertEquals("https://guntour.vercel.app/admin", adminProductPage.getUrl());
    }
//    @When("click product menu")
//    public void clickProductMenu() {
//        adminProductPage.ClickProductButton();
//    }
//    @And("products table appear")
//    public void productsTableAppear() {
//        assertEquals("PRICE", adminProductPage.getTableTitle());
//    }

}
