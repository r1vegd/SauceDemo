package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

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
    public void checkInventoryItemPageProduct() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        inventoryPage.moveIntoInventoryItem();
//        Assert.assertEquals(inventoryItemPage.getInventoryDetailedItemName(),
//                inventoryPage.getInventoryFirstItemName(),
//                "Имя товара не совпадает" );
//        Assert.assertEquals(inventoryItemPage.getInventoryDetailedItemDesc(),
//                inventoryPage.getInventoryFirstItemDesc(),
//                "Описание товара не совпадает");
//        Assert.assertEquals(inventoryPage.getInventoryFirstItemPrice(),
//                inventoryItemPage.getInventoryDetailedItemPrice(),
//                "Цена товара не совпадает");
    }


}
