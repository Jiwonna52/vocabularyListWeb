package NJWproject.vocabularyListWeb.book;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @Test
    @Transactional
    @Rollback
    public void bookRepositoryTest() {
        Book book = new Book();
        book.setBookName("RWRB");
        Long savedId = bookRepository.save(book);
        Book findBook = bookRepository.find(savedId);

        Assertions.assertThat(book).isEqualTo(findBook);

    }
}
