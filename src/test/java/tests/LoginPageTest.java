package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class LoginPageTest extends BaseTest {

    @Test
    public void positiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.inventoryItemNameDisplayed(),
                "Переход в каталог не осуществлён");
    }

    @Test
    public void usernameShouldBeRequired() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "Сообщение об ошибке не верно");
    }

    @Test
    public void passwordShouldBeRequired() {
        loginPage.open();
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Password is required",
                "Сообщение об ошибке не верно");
    }

    @Test
    public void credentialsNotMatchAnyUser() {
        loginPage.open();
        loginPage.login("123", "123");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Сообщение об ошибке не верно");
    }

    @Test
    public void lockedUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "Сообщение об ошибке не верно");
    }

}
