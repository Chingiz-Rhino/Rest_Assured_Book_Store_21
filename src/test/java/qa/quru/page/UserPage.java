package qa.quru.page;

import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UserPage {
 public static void userProfileCookies(String userID, String expires, String token){
     open("/favicon.ico");
     getWebDriver().manage().addCookie(new Cookie("userID", userID));
     getWebDriver().manage().addCookie(new Cookie("expires", expires));
     getWebDriver().manage().addCookie(new Cookie("token", token));
 }
}
