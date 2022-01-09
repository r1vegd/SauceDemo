package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage extends BasePage {

    public static final By FIRST_NAME_CHECKOUT = By.xpath("//input[@placeholder='First Name']");
    public static final By LAST_NAME_CHECKOUT = By.xpath("//input[@placeholder='Last Name']");
    public static final By ZIP_POSTAL_CODE_CHECKOUT = By.xpath("//input[@placeholder='Zip/Postal Code']");

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("'First Name' input is displayed")
    public boolean firstNameCheckoutDisplayed() {
        return driver.findElement(FIRST_NAME_CHECKOUT).isDisplayed();
    }

    @Step("'Last Name' input is displayed")
    public boolean lastNameCheckoutDisplayed() {
        return driver.findElement(LAST_NAME_CHECKOUT).isDisplayed();
    }

    @Step("'Zip/Postal Code' input is displayed")
    public boolean zipPostalCodeCheckoutDisplayed() {
        return driver.findElement(ZIP_POSTAL_CODE_CHECKOUT).isDisplayed();
    }


}
