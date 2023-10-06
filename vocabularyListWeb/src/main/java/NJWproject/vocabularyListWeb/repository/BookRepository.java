package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
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

    public List<Book> findAll() {
        return em.createQuery("select b from Book b", Book.class).getResultList();
    }

    public void delete(Long id) {
        Book book  = find(id);
        if (book != null) {
            em.remove(book);
        }
    }

    public void updateBook(Long id, String bookName) {
        Book book = find(id);
        book.setBookName(bookName);
    }
}
