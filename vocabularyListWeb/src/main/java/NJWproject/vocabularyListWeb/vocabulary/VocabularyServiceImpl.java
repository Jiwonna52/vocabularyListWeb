package NJWproject.vocabularyListWeb.vocabulary;

import NJWproject.vocabularyListWeb.AppConfig;

import java.util.List;

public class VocabularyServiceImpl implements VocabularyService {
    private final VocabularyRepository vocabularyRepository;

    public VocabularyServiceImpl(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    @Override
    public void join(Vocabulary vocabulary) {
        vocabularyRepository.save(vocabulary);
    }

    @Override
    public Vocabulary findVocabulary(Long vocabularyId) {
        return vocabularyRepository.findById(vocabularyId);
    }

    @Override
    public List<Vocabulary> findVocabularyByChapterName(String chapterName) {
        return vocabularyRepository.findVocabularyListByChapter(chapterName);
    }

    @Override
    public List<Vocabulary> findVocabularyByBookId(Long bookId) {
        return vocabularyRepository.findVocabularyListByBookId(bookId);
    }
}
