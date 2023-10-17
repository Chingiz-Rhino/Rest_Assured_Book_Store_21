package qa.quru.models;

import lombok.Data;

import java.util.List;

@Data
public class AddBookToListModel {
    String userId;
    List<IsbnModel> collectionsOfIsbn;
}
