package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.entity.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BookRepository {
    // 영속성 컨텍스트
    @PersistenceContext
    EntityManager em;

    public Long save(Book book) {
        em.persist(book);
        return book.getId();
    }

    public Book find(Long id) {
        return em.find(Book.class, id);
    }
}
