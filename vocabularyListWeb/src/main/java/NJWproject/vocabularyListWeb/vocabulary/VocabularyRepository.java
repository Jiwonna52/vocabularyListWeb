package NJWproject.vocabularyListWeb.vocabulary;

import java.util.List;

public interface VocabularyRepository {
    void save(Vocabulary vocabulary);
    Vocabulary findById(Long vocabularyId);
    List<Vocabulary> findVocabularyListByBookId(Long bookId);
}