package qa.quru.tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import qa.quru.api.BooksAPI;
import qa.quru.api.LoginAuthAPI;

public class TestBase {

    LoginAuthAPI authorizationApi = new LoginAuthAPI();
    BooksAPI booksApi = new BooksAPI();
    @BeforeAll
   static void beforeAll(){
        Configuration.baseUrl = "https://demoqa.com";
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
    }
}
