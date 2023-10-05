package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.entity.Vocabulary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
}
