import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPriceNameCartTest extends BaseTest {

    String loginField = "[placeholder=Username]";
    String loginCredential = "//div[@id='login_credentials']";
    String passwordField = "[placeholder=Password]";
    String passwordCredential = "//div[@class='login_password']";
    String loginButton = "//input[@id='login-button']";

    String addToCartButton = "//button[@id='add-to-cart-sauce-labs-backpack']";
    String shoppingCartButton = ".shopping_cart_link";

    String catalogProductName = "//a[@id='item_4_title_link']/div";
    String catalogProductPrice = "//button[@id='remove-sauce-labs-backpack']/../div";

    String cartProductName = ".inventory_item_name";
    String cartProductPrice = ".inventory_item_price";

    @Test
    public void locatorsFind() {
        driver.get("https://www.saucedemo.com/");
        WebElement loginInput = driver.findElement(By.cssSelector(loginField));
        loginInput.sendKeys(driver.findElement(By.xpath(loginCredential)).getText().split("\\r?\\n")[1]);

        WebElement passwordInput = driver.findElement(By.cssSelector(passwordField));
        passwordInput.sendKeys(driver.findElement(By.xpath(passwordCredential)).getText().split("\\r?\\n")[1]);
        driver.findElement(By.xpath(loginButton)).click();

        driver.findElement(By.xpath(addToCartButton)).click();

        String savedCatalogProductName = driver.findElement(By.xpath(catalogProductName)).getText();
        String savedPriceProductName = driver.findElement(By.xpath(catalogProductPrice)).getText();

        driver.findElement(By.cssSelector(shoppingCartButton)).click();

        String savedCartProductName = driver.findElement(By.cssSelector(cartProductName)).getText();
        String savedCartProductPrice = driver.findElement(By.cssSelector(cartProductPrice)).getText();

        Assert.assertEquals(savedCartProductName, savedCatalogProductName, "Названия добавленного продукта не совпадают");
        Assert.assertEquals(savedPriceProductName, savedCartProductPrice, "Цены добавленного продукта не совпадают");

    }

}
