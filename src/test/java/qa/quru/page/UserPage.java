package qa.quru.page;

import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class UserPage {
 public static void userProfileCookies(String userId, String token, String expires){
     open("/favicon.ico");
     getWebDriver().manage().addCookie(new Cookie("userID", userId));
     getWebDriver().manage().addCookie(new Cookie("token", token));
     getWebDriver().manage().addCookie(new Cookie("expires", expires));

 }

 public static void checkDisappearBook(String bookId){
     open("/profile");
     $("[id='"+ bookId+"']").shouldBe(disappear);
 }
}
