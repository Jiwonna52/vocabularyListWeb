package NJWproject.vocabularyListWeb.book;

import NJWproject.vocabularyListWeb.AppConfig;
import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookServiceTest {
    AppConfig appConfig = new AppConfig();
    BookService bookService;

    @BeforeEach
    void config() {
        bookService = appConfig.bookService();
    }
    @Test
    void test() {
        // given
        Book book  = new Book(1L, "RWRB");

        // when
        bookService.join(book);
        Book findBook = bookService.findBook(book.getId());

        // then
        Assertions.assertThat(book).isEqualTo(findBook);
    }
}
