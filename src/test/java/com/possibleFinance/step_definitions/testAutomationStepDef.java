package com.possibleFinance.step_definitions;

import com.possibleFinance.pages.ShopPage;
import com.possibleFinance.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class testAutomationStepDef {
    WebDriver driver = Driver.getDriver();
    ShopPage page = new ShopPage();


    @Given("User navigate to landing page")
    public void user_navigate_to_landing_page() {
     driver.get("http://automationpractice.com/");
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue(page.header.isDisplayed());

    }
    @When("User hover over popular item")
    public void user_hover_over_popular_item() {

        Actions action = new Actions(driver);
        action.moveToElement(page.firstPopularItem).perform();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(page.addToCart));
        Assert.assertTrue(page.addToCart.isDisplayed());


    }
    @Then("{string} button is displayed")
    public void button_is_displayed(String string) {
    page.addToCart.click();
    new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(page.successMessage));

    Assert.assertTrue(page.successMessage.getText().contains("Product successfully added to your shopping cart"));

    driver.quit();


    }
}
