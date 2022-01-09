package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import tests.base.Retry;

public class LoginPageTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"123", "123", "Epic sadface: Username and password do not match any user in this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(retryAnalyzer = Retry.class, description = "Login as standard users")
    public void positiveLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.inventoryItemNameDisplayed(),
                "Переход в каталог не осуществлён");
    }

    @Test(dataProvider = "loginData", description = "Negative login as all types of allowed users")
    public void usernameShouldBeRequired(String userName, String password, String errorMessage) {
        loginPage.open();
        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "Сообщение об ошибке не верно");
    }
}
