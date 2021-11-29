package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By CART_FIRST_ITEM_NAME = By.xpath("//a[@id='item_2_title_link']/div");
    public static final By CART_FIRST_ITEM_PRICE = By.xpath("//a[@id='item_2_title_link']/following-sibling::div[2]/div");
    public static final By CART_FIRST_ITEM_DESC = By.xpath("//a[@id='item_2_title_link']/following-sibling::div[1]");
    public static final By CART_SECOND_ITEM_NAME = By.xpath("//a[@id='item_3_title_link']/div");
    public static final By CART_SECOND_ITEM_PRICE = By.xpath("//a[@id='item_3_title_link']/following-sibling::div[2]/div");
    public static final By CART_ITEM_QTY = By.xpath("//div[@class='cart_quantity']");
    public static final By CART_REMOVE_ITEM_BUTTON = By.xpath("//button[@data-test='remove-sauce-labs-bike-light']");
    public static final By CART_CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@data-test='continue-shopping']");
    public static final By CART_CHECKOUT_BUTTON = By.xpath("//button[@data-test='checkout']");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public String getCartFirstItemName() {
        return driver.findElement(CART_FIRST_ITEM_NAME).getText();
    }

    public String getCartFirstItemPrice() {
        return driver.findElement(CART_FIRST_ITEM_PRICE).getText();
    }

    public String getCartFirstItemDesc() {
        return driver.findElement(CART_FIRST_ITEM_DESC).getText();
    }

    public String getCartSecondItemName() {
        return driver.findElement(CART_SECOND_ITEM_NAME).getText();
    }

    public String getCartSecondItemPrice() {
        return driver.findElement(CART_SECOND_ITEM_PRICE).getText();
    }

    public String getCartItemQty() {
        return driver.findElement(CART_ITEM_QTY).getText();
    }

    public void removeCartItem() {
        driver.findElement(CART_REMOVE_ITEM_BUTTON).click();
    }

    public void continueCartShopping() {
        driver.findElement(CART_CONTINUE_SHOPPING_BUTTON).click();
    }

    public void checkoutCart() {
        driver.findElement(CART_CHECKOUT_BUTTON).click();
    }

}
