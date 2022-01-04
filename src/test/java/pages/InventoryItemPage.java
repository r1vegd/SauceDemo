package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryItemPage extends BasePage {

    public static final By INVENTORY_DETAILED_ITEM_NAME = By.xpath("//div[@class='inventory_details_name large_size']");
    public static final By INVENTORY_DETAILED_ITEM_DESC = By.xpath("//div[@class='inventory_details_desc large_size']");
    public static final By INVENTORY_DETAILED_ITEM_PRICE = By.xpath("//div[@class='inventory_details_price']");
    public static final String ADD_TO_CART_DETAILED_ITEM_BUTTON = "//button[@class='btn btn_primary btn_small btn_inventory']";
    public static final String BACK_TO_PRODUCTS_BUTTON = "//button[@class='btn btn_secondary back btn_large inventory_details_back_button']";

    public InventoryItemPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get product name from detailed view")
    public String getInventoryDetailedItemName() {
        return driver.findElement(INVENTORY_DETAILED_ITEM_NAME).getText();
    }

    @Step("Get product description from detailed view")
    public String getInventoryDetailedItemDesc() {
        return driver.findElement(INVENTORY_DETAILED_ITEM_DESC).getText();
    }

    @Step("Get product price from detailed view")
    public String getInventoryDetailedItemPrice() {
        return driver.findElement(INVENTORY_DETAILED_ITEM_PRICE).getText();
    }

    @Step("Add product into cart from detailed view")
    public void addToCartDetailedItemButton() {
        driver.findElement(By.xpath(ADD_TO_CART_DETAILED_ITEM_BUTTON)).click();
    }

    @Step("Back to catalog")
    public void backToProductsButton() {
        driver.findElement(By.xpath(BACK_TO_PRODUCTS_BUTTON)).click();
    }


}
