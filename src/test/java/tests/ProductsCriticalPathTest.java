package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProductsCriticalPathTest extends BaseTest {

    @Test
    public void oneProductShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addToCartFirstProduct("Sauce Labs Onesie");
        inventoryPage.moveToCartPage();
        Assert.assertEquals(cartPage.getCartFirstItemName(),
                inventoryPage.getInventoryFirstItemName(),
                "Имена товара в корзине и каталоге не совпадают");
        Assert.assertEquals(cartPage.getCartFirstItemPrice(),
                inventoryPage.getInventoryFirstItemPrice(),
                "Цена товара в корзине и каталоге не совпадают");
    }

    @Test
    public void fewProductsShouldBeAddedIntoCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addToCartFirstProduct("Sauce Labs Onesie");
        inventoryPage.addToCartSecondProduct("Test.allTheThings() T-Shirt (Red)");
        inventoryPage.moveToCartPage();
        Assert.assertEquals(cartPage.getCartFirstItemName(),
                inventoryPage.getInventoryFirstItemName(),
                "Имена первого товара в корзине и каталоге не совпадают");
        Assert.assertEquals(cartPage.getCartSecondItemName(),
                inventoryPage.getInventorySecondItemName(),
                "Имена второго товара в корзине и каталоге не совпадают");
        Assert.assertEquals(cartPage.getCartFirstItemPrice(),
                inventoryPage.getInventoryFirstItemPrice(),
                "Цена первого товара в корзине и каталоге не совпадают");
        Assert.assertEquals(cartPage.getCartSecondItemPrice(),
                inventoryPage.getInventorySecondItemPrice(),
                "Цена второго товара в корзине и каталоге не совпадают");

    }

    @Test
    public void proceedToCheckOutYourInformation() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addToCartFirstProduct("Sauce Labs Onesie");
        inventoryPage.moveToCartPage();
        cartPage.checkoutCart();
        Assert.assertTrue(checkoutYourInformationPage.firstNameCheckoutDisplayed(),
                "Поле ввода имени не отображается");
        Assert.assertTrue(checkoutYourInformationPage.lastNameCheckoutDisplayed(),
                "Поле ввода фамилии не отображается");
        Assert.assertTrue(checkoutYourInformationPage.zipPostalCodeCheckoutDisplayed(),
                "Поле ввода ZIP не отображается");
    }

    @Test
    public void checkInventoryItemPageProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        String expectedInventoryItemName = inventoryPage.getInventoryFirstItemName();
        String expectedInventoryItemDesc = inventoryPage.getInventoryFirstItemDesc();
        String expectedInventoryItemPrice = inventoryPage.getInventoryFirstItemPrice();

        inventoryPage.moveIntoInventoryItem();
        String actualInventoryDetailedItemName = inventoryItemPage.getInventoryDetailedItemName();
        String actualInventoryDetailedItemDesc = inventoryItemPage.getInventoryDetailedItemDesc();
        String actualInventoryDetailedItemPrice = inventoryItemPage.getInventoryDetailedItemPrice();

        Assert.assertEquals(actualInventoryDetailedItemName,
                expectedInventoryItemName,
                "Имя товара не совпадает");
        Assert.assertEquals(actualInventoryDetailedItemDesc,
                expectedInventoryItemDesc,
                "Описание товара не совпадает");
        Assert.assertEquals(actualInventoryDetailedItemPrice,
                expectedInventoryItemPrice,
                "Цена товара не совпадает");
    }

    @Test
    public void productCanBeDeletedFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.addToCartFirstProduct("Sauce Labs Onesie");
        inventoryPage.moveToCartPage();

        cartPage.removeCartItem();
        Assert.assertTrue(cartPage.removedCartItemLineDisplayed(),
                "Корзина не очищена");
    }


}
