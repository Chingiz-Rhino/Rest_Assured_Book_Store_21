package qa.quru.api;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.qameta.allure.Step;
import qa.quru.helpers.HelperClasses;
import qa.quru.models.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static qa.quru.spec.BooksSpec.*;

public class BooksAPI {


public HelperClasses helperClasses = new HelperClasses();

    @Step("Successful delete all books from list")
    public void deleteAllBooks(LoginResponseModel loginResponseModel) {
        given(booksRequestSpec)
                .header("Authorization", "Bearer" + loginResponseModel.getToken())
                .queryParam("UserId", loginResponseModel.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(bookSuccessDeleteResponseSpec);
    }

    @Step("Successful add book to list")
    public void addBook(LoginResponseModel loginResponseModel, AddBookToListModel addBookToListModel) {
        given(booksRequestSpec)
                .header("Authorization", "Bearer" + loginResponseModel.getToken())
                .body(addBookToListModel)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(bookSuccessAddResponseSpec);
    }

@NotNull
    @Step("Successful delete one book from list")
    public void deleteOneBook(LoginResponseModel loginResponseModel, DeleteBookModel deleteBookModel) {
        given(booksRequestSpec)
                .header("Authorization", "Bearer" + loginResponseModel.getToken())
                .queryParam("UserID", loginResponseModel.getUserId())
                .body(deleteBookModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(bookSuccessDeleteResponseSpec);
    }




}
