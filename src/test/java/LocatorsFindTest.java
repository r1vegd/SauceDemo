import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LocatorsFindTest extends BaseTest {

    String passwordInputLocatorId = "password";
    String loginButtonLocatorName = "login-button";
    String pictureBotLocatorClassname = "bot_column";
    String javaScriptTextLocatorTagName = "noscript";
    String linkedinLocatorLinkText = "LinkedIn";
    String facebookLocatorPartialLinkText = "Facebook";

    String xpathByAttribute = "//option[@value='za']";
    String xpathByText = "//span[text()='Products']";
    String xpathByContainsAttribute = "//option[contains(@value,'lo')]";
    String xpathByContainsText = "//span[contains(text(),'Pro')]";
    String xpathByAncestors = "//*[text()='Products']//ancestor::div[@class='header_secondary_container']";
    String xpathByDescendant = "//div[@class='header_secondary_container']//descendant::span";
    String xpathByFollowing = "//div[@class='header_secondary_container']//following-sibling::div";
    String xpathByPreceding = "//*[@class ='product_sort_container']//preceding::nav";
    String xpathAxes = "//select//child::option[1]";
    String xpathUsingAnd = "//span[@class='active_option' and text()='Name (A to Z)']";

    String css1class = ".social_linkedin";
    String css2classes = ".shopping_cart_container.shopping_cart_container";
    String cssId = "#contents_wrapper";
    String cssTagNameClass = "div.bm-burger-button";
    String cssAttributeValue1 = "a[href^=\"https://saucelabs.com/\"]";
    String cssAttributeValue2 = "a[href$=\".com/\"]";
    String getCssAttributeValue3 = "a[id*=inventory_sidebar_link]";

    @Test
    public void locatorsFindPractice() {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.id(passwordInputLocatorId));
        driver.findElement(By.name(loginButtonLocatorName));
        driver.findElement(By.className(pictureBotLocatorClassname));

        driver.get("https://www.saucedemo.com/inventory.html");
        driver.findElement(By.tagName(javaScriptTextLocatorTagName));
        driver.findElement(By.linkText(linkedinLocatorLinkText));
        driver.findElement(By.partialLinkText(facebookLocatorPartialLinkText));

        driver.findElement(By.xpath(xpathByAttribute));
        driver.findElement(By.xpath(xpathByText));
        driver.findElement(By.xpath(xpathByContainsAttribute));
        driver.findElement(By.xpath(xpathByContainsText));
        driver.findElement(By.xpath(xpathByAncestors));
        driver.findElement(By.xpath(xpathByDescendant));
        driver.findElement(By.xpath(xpathByFollowing));
        driver.findElement(By.xpath(xpathByPreceding));
        driver.findElement(By.xpath(xpathByPreceding));
        driver.findElement(By.xpath(xpathAxes));
        driver.findElement(By.xpath(xpathUsingAnd));

        driver.findElement(By.cssSelector(css1class));
        driver.findElement(By.cssSelector(css2classes));
        driver.findElement(By.cssSelector(cssId));
        driver.findElement(By.cssSelector(cssTagNameClass));
        driver.findElement(By.cssSelector(cssAttributeValue1));
        driver.findElement(By.cssSelector(cssAttributeValue2));
        driver.findElement(By.cssSelector(getCssAttributeValue3));


    }


}
