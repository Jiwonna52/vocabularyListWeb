package NJWproject.vocabularyListWeb.vocabulary;

import java.util.List;

public class VocabularyServiceImpl implements VocabularyService {
    private final VocabularyRepository vocabularyRepository = new MemoryVocabularyRepositoryImpl();
    @Override
    public void join(Vocabulary vocabulary) {
        vocabularyRepository.save(vocabulary);
    }

    @Override
    public Vocabulary findVocabulary(Long memberId) {
        return vocabularyRepository.findById(memberId);
    }

    @Override
    public List<Vocabulary> findVocabularyById(Long bookId) {
        return vocabularyRepository.findVocabularyListByBookId(bookId);
    }
}
