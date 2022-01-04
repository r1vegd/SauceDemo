package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage {

    public static final String ADD_TO_CART_FIRST_ITEM_BUTTON = "//button [@data-test='add-to-cart-sauce-labs-onesie']";
    public static final String ADD_TO_CART_SECOND_ITEM_BUTTON = "//button [@data-test='add-to-cart-test.allthethings()-t-shirt-(red)']";
    public static final By CART_BUTTON = By.xpath("//a[@class='shopping_cart_link']");
    public static final By INVENTORY_FIRST_ITEM_NAME = By.xpath("//a[@id='item_2_title_link']/div");
    public static final By INVENTORY_FIRST_ITEM_DESC = By.xpath("//a[@id='item_2_title_link']/following-sibling::div");
    public static final By INVENTORY_FIRST_ITEM_PRICE = By.xpath("//button[contains(@id, 'sauce-labs-onesie')]//../div");
    public static final By INVENTORY_SECOND_ITEM_NAME = By.xpath("//a[@id='item_3_title_link']/div");
    public static final By INVENTORY_SECOND_ITEM_PRICE = By.xpath("//button[contains(@id, 'test.allthethings()-t-shirt-(red)')]//../div");


    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Add to cart first product")
    public void addToCartFirstProduct(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_FIRST_ITEM_BUTTON, nameProduct))).click();
    }

    @Step("Add to cart second product")
    public void addToCartSecondProduct(String nameProduct) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_SECOND_ITEM_BUTTON, nameProduct))).click();
    }

    @Step("Get first product name from catalog")
    public String getInventoryFirstItemName() {
        return driver.findElement(INVENTORY_FIRST_ITEM_NAME).getText();
    }

    @Step("Get first product description from catalog")
    public String getInventoryFirstItemDesc() {
        return driver.findElement(INVENTORY_FIRST_ITEM_DESC).getText();
    }

    @Step("Get first product price from catalog")
    public String getInventoryFirstItemPrice() {
        return driver.findElement(INVENTORY_FIRST_ITEM_PRICE).getText();
    }

    @Step("Get second product name from catalog")
    public String getInventorySecondItemName() {
        return driver.findElement(INVENTORY_SECOND_ITEM_NAME).getText();
    }

    @Step("Get second product price from catalog")
    public String getInventorySecondItemPrice() {
        return driver.findElement(INVENTORY_SECOND_ITEM_PRICE).getText();
    }

    @Step("Go to the cart")
    public void moveToCartPage() {
        driver.findElement(CART_BUTTON).click();
    }

    @Step("Get into product detailed view")
    public void moveIntoInventoryItem() {
        driver.findElement(INVENTORY_FIRST_ITEM_NAME).click();
    }

    @Step("First product name is displayed in detailed view")
    public boolean inventoryItemNameDisplayed() {
       return driver.findElement(INVENTORY_FIRST_ITEM_NAME).isDisplayed();
    }


}
