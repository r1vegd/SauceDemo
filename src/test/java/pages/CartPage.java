package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage extends BasePage {

    public static final By CART_FIRST_ITEM_NAME = By.xpath("//a[@id='item_2_title_link']/div");
    public static final By CART_FIRST_ITEM_PRICE = By.xpath("//a[@id='item_2_title_link']/following-sibling::div[2]/div");
    public static final By CART_FIRST_ITEM_DESC = By.xpath("//a[@id='item_2_title_link']/following-sibling::div[1]");
    public static final By CART_SECOND_ITEM_NAME = By.xpath("//a[@id='item_3_title_link']/div");
    public static final By CART_SECOND_ITEM_PRICE = By.xpath("//a[@id='item_3_title_link']/following-sibling::div[2]/div");
    public static final By CART_ITEM_QTY = By.xpath("//div[@class='cart_quantity']");
    public static final By CART_REMOVE_ITEM_BUTTON = By.xpath("//button[contains(@id, 'remove')]");
    public static final By CART_CONTINUE_SHOPPING_BUTTON = By.xpath("//button[@data-test='continue-shopping']");
    public static final By CART_CHECKOUT_BUTTON = By.xpath("//button[@data-test='checkout']");
    public static final By REMOVED_CART_ITEM_LINE = By.xpath("//div[@class = 'removed_cart_item']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get first product name in cart")
    public String getCartFirstItemName() {
        return driver.findElement(CART_FIRST_ITEM_NAME).getText();
    }

    @Step("Get first product price in cart")
    public String getCartFirstItemPrice() {
        return driver.findElement(CART_FIRST_ITEM_PRICE).getText();
    }

    @Step("Get first product description in cart")
    public String getCartFirstItemDesc() {
        return driver.findElement(CART_FIRST_ITEM_DESC).getText();
    }

    @Step("Get second product name in cart")
    public String getCartSecondItemName() {
        return driver.findElement(CART_SECOND_ITEM_NAME).getText();
    }

    @Step("Get second product price in cart")
    public String getCartSecondItemPrice() {
        return driver.findElement(CART_SECOND_ITEM_PRICE).getText();
    }

    @Step("Get quantity of products in cart")
    public String getCartItemQty() {
        return driver.findElement(CART_ITEM_QTY).getText();
    }

    @Step("Remove product from the cart")
    public void removeCartItem() {
        driver.findElement(CART_REMOVE_ITEM_BUTTON).click();
    }

    @Step("Go into 'Continue shopping' section")
    public void continueCartShopping() {
        driver.findElement(CART_CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step("Proceed to checkout")
    public void checkoutCart() {
        driver.findElement(CART_CHECKOUT_BUTTON).click();
    }

    @Step("'Item line' element is displayed")
    public boolean removedCartItemLineDisplayed() {
        return driver.findElement(REMOVED_CART_ITEM_LINE).isEnabled();
    }


}
