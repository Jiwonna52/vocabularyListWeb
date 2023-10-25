package NJWproject.vocabularyListWeb.form;

import NJWproject.vocabularyListWeb.entity.Book;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VocabularyForm {
    Long id;
    String english;
    String korean;
    Book book;
    String chapter;
}
