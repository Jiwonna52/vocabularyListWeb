package NJWproject.vocabularyListWeb.book;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BookServiceTest {
    private final BookRepository bookRepository = new MemoryBookRepositoryImpl();
    private final BookService bookService = new BookServiceImpl();

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
