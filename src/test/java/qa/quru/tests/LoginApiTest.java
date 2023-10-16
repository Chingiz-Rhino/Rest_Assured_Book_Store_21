package qa.quru.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import qa.quru.models.LoginResponseModel;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static qa.quru.spec.LoginSpec.successLoginRequestSpec;
import static qa.quru.spec.LoginSpec.successLoginResponseSpec;
import static qa.quru.tests.TestData.login;
import static qa.quru.tests.TestData.password;

public class LoginApiTest extends TestBase{

    @Test
    public void loginSuccessUITest(){

        open("/login");
        $("#userName").setValue(login);
        $("#password").setValue(password).pressEnter();
        $("#userName-value").shouldHave(text(login));

    }

}



