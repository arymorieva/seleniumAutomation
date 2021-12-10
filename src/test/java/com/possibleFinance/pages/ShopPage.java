package com.possibleFinance.pages;

import com.possibleFinance.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {

    WebDriver driver = Driver.getDriver();

    public ShopPage(){
        PageFactory.initElements(driver,this);
    }

        @FindBy(id = "header_logo")
        public WebElement header;


        @FindBy(css = "ul[id='homefeatured'] .product-container:nth-child(1)")
        public WebElement firstPopularItem;

        @FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']/span[text()='Add to cart'][1]")
        public WebElement addToCart;

    @FindBy(css = "div h2:nth-child(2)")
    public WebElement successMessage;
    }


