package NJWproject.vocabularyListWeb.vocabulary;

import java.util.List;

public interface VocabularyService {
    void join(Vocabulary vocabulary);
    Vocabulary findVocabulary(Long memberId);
    List<Vocabulary> findVocabularyById(Long bookId);
}
