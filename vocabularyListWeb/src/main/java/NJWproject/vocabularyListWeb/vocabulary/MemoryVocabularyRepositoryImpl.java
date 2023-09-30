package NJWproject.vocabularyListWeb.vocabulary;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class MemoryVocabularyRepositoryImpl implements VocabularyRepository{
    private static Map<Long, Vocabulary> vocabularyStore = new HashMap<>();
    @Override
    public void save(Vocabulary vocabulary) {
        vocabularyStore.put(vocabulary.getId(), vocabulary);
    }

    @Override
    public Vocabulary findById(Long vocabularyId) {
        return vocabularyStore.get(vocabularyId);
    }

    @Override
    public List<Vocabulary> findVocabularyListByChapter(String chapterName) {
        return vocabularyStore.values().stream().filter(vocabulary -> vocabulary.getChapterName().equals(chapterName)).collect(Collectors.toList());
    }

    @Override
    public List<Vocabulary> findVocabularyListByBookId(Long bookId) {
        /*
        List<Vocabulary> vocabularyList = new ArrayList<>();
        for (Vocabulary vocabulary : vocabularyStore.values()) {
            if(vocabulary.getBookId() == bookId) {
                vocabularyList.add(vocabulary);
            }
        }*/

        return vocabularyStore.values().stream().filter(vocabulary -> vocabulary.getBookId().equals(bookId)).collect(Collectors.toList());
    }
}
