package qa.quru.api;

import io.qameta.allure.Step;
import qa.quru.models.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static qa.quru.spec.BooksSpec.*;

public class BooksAPI {


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


    @Step("Successful delete one book from list")
    public void deleteOneBook(LoginResponseModel loginResponseModel, DeleteBookModel deleteBookModel) {
        given(booksRequestSpec)
                .header("Authorization", "Bearer" + loginResponseModel.getToken())
                .queryParam("UserId", loginResponseModel.getUserId())
                .body(deleteBookModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(bookSuccessDeleteResponseSpec)
                .statusCode(204);
    }

    public IsbnModel createIsbnModel(String isbn) {
        IsbnModel isbnModel = new IsbnModel();
        isbnModel.setIsbn(isbn);
        return isbnModel;

    }

    public AddBookToListModel createAddBookToListModel(LoginResponseModel loginResponse, IsbnModel isbnModel) {
        AddBookToListModel bookList = new AddBookToListModel();
        bookList.setUserId(loginResponse.getUserId());
        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbnModel);
        bookList.setCollectionsOfIsbn(isbnList);
        return bookList;
    }

    public DeleteBookModel createDeleteBookModel(LoginResponseModel loginResponse, IsbnModel isbnModel) {
        DeleteBookModel deleteBook = new DeleteBookModel();
        deleteBook.setUserId(loginResponse.getUserId());
        deleteBook.setIsbn(isbnModel.getIsbn());
        return deleteBook;
    }


}
