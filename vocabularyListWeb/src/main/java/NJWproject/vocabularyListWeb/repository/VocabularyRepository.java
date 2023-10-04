package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.entity.Vocabulary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
