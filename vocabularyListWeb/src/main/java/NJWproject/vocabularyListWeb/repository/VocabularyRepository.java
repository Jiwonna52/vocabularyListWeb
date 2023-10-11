package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.VocabularyListWebApplication;
import NJWproject.vocabularyListWeb.entity.Vocabulary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class VocabularyRepository {
    @PersistenceContext
    EntityManager em;

    public Long save(Vocabulary vocabulary) {
        em.persist(vocabulary);
        return vocabulary.getId();
    }

    public Vocabulary find(Long id) {
        return em.find(Vocabulary.class, id);
    }

    public List<Vocabulary> findAll(Long bookId) {
        return em.createQuery("select v from Vocabulary v where v.book.id = :id").setParameter("id", bookId).getResultList();
    }

    public void delete(Long vocabularyId) {
        Vocabulary vocabulary = find(vocabularyId);
        em.remove(vocabulary);
    }

    public void updateVocabulary(Long id, String korean, String english) {
        Vocabulary vocabulary = find(id);
        vocabulary.setEnglish(english);
        vocabulary.setKorean(korean);
    }

    public Map<Integer, List<Vocabulary>> pagingVocabulary(Long bookId) {
        List<Vocabulary> list = findAll(bookId);
        Map<Integer, List<Vocabulary>> map = new HashMap<>();
        int l = 3;
        int count = 0;
        int page = 1;
        List<Vocabulary> tmp = new ArrayList<>();

        for (int i=0; i<list.size(); i++) {
            tmp.add(list.get(i));
            if (tmp.size() == l) {
                map.put(page, tmp);
                page++;
                tmp = new ArrayList<>();
            }
        }

        if (tmp.size() != 0) {
            map.put(page, tmp);
        }

        return map;
    }
}
