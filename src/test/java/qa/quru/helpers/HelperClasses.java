package qa.quru.helpers;

import qa.quru.api.BooksAPI;
import qa.quru.models.AddBookToListModel;
import qa.quru.models.DeleteBookModel;
import qa.quru.models.IsbnModel;
import qa.quru.models.LoginResponseModel;

import java.util.ArrayList;
import java.util.List;

public class HelperClasses {

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
