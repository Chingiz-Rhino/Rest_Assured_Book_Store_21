package qa.quru.models;

import lombok.Data;

@Data
public class DeleteBookModel {
    private String userId;
    private String isbn;
}
