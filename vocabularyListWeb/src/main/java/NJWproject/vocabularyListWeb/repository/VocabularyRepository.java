package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.entity.Vocabulary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

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

    public List<Vocabulary> findByChapter(Long bookId, String chapterName) {
        return em.createQuery("select v from Vocabulary v where (v.book.id = :id) and (v.chapter = :chapterName)")
                .setParameter("id", bookId).setParameter("chapterName", chapterName).getResultList();
    }

    public List<String> findChapterList(Long bookId) {
        return em.createQuery("SELECT DISTINCT v.chapter From Vocabulary v where v.book.id = :id").setParameter("id", bookId).getResultList();
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

    public List<Vocabulary> pagingVocabulary(Long bookId, int page) {
        List<Vocabulary> list = findAll(bookId);
        List<Vocabulary> pageList = new ArrayList<>();
        int num = 3;

        for (int i=(page-1)*num; i<list.size(); i++) {
            pageList.add(list.get(i));
            if (pageList.size() == num) {
                break;
            }
        }

        return pageList;
    }

    public List<Vocabulary> search(String keyword) {
        return em.createQuery("SELECT v From Vocabulary v WHERE v.korean Like CONCAT('%',:key,'%')").setParameter("key", keyword).getResultList();
    }
}
