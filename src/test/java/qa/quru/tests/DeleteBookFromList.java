package qa.quru.tests;

import org.junit.jupiter.api.Test;
import qa.quru.models.AddBookToListModel;
import qa.quru.models.DeleteBookModel;
import qa.quru.models.IsbnModel;
import qa.quru.models.LoginResponseModel;
import qa.quru.page.UserPage;

import static qa.quru.tests.TestData.*;

public class DeleteBookFromList extends TestBase{

    @Test
    public void deleteBookFromProfileTest(){
        LoginResponseModel loginResponse = authorizationApi.login(credModel);

        IsbnModel isbnModel = booksApi.createIsbnModel(getISBN());
        AddBookToListModel bookList = booksApi.createAddBookToListModel(loginResponse, isbnModel);
        DeleteBookModel deleteBook = booksApi.createDeleteBookModel(loginResponse, isbnModel);

        booksApi.deleteAllBooks(loginResponse);
        booksApi.addBook(loginResponse,bookList);
        booksApi.deleteOneBook(loginResponse, deleteBook);

        UserPage.userProfileCookies(loginResponse.getUserId(), loginResponse.getToken(), loginResponse.getExpires());
    }

}



