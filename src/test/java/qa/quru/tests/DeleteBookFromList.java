package qa.quru.tests;

import org.junit.jupiter.api.Test;
import qa.quru.helpers.HelperClasses;
import qa.quru.models.AddBookToListModel;
import qa.quru.models.DeleteBookModel;
import qa.quru.models.IsbnModel;
import qa.quru.models.LoginResponseModel;
import qa.quru.page.ProfilePage;
import qa.quru.page.UserPage;

import static qa.quru.tests.TestData.*;

public class DeleteBookFromList extends TestBase{
UserPage userPage = new UserPage();
ProfilePage profilePage = new ProfilePage();
    @Test
    public void deleteBookFromProfileTest(){
        LoginResponseModel loginResponse = authorizationApi.login(credModel);

        IsbnModel isbnModel = booksApi.helperClasses.createIsbnModel(getISBN());
        AddBookToListModel bookList = booksApi.helperClasses.createAddBookToListModel(loginResponse, isbnModel);
        DeleteBookModel deleteBook = booksApi.helperClasses.createDeleteBookModel(loginResponse, isbnModel);

        booksApi.deleteAllBooks(loginResponse);
        booksApi.addBook(loginResponse,bookList);
        booksApi.deleteOneBook(loginResponse, deleteBook);


        userPage.userProfileCookies(loginResponse.getUserId(), loginResponse.getToken(), loginResponse.getExpires());
        profilePage.openProfilePage();
        profilePage.checkDisappearBook("see-book-Understanding ECMAScript 6");
    }


}



