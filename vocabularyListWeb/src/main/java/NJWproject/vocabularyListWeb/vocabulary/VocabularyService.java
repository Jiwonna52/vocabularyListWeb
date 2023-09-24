package NJWproject.vocabularyListWeb.vocabulary;

import java.util.List;

public interface VocabularyService {
    void join(Vocabulary vocabulary);
    Vocabulary findVocabulary(Long vocabularyId);
    List<Vocabulary> findVocabularyByChapterName(String chapterName);
    List<Vocabulary> findVocabularyByBookId(Long bookId);
}
