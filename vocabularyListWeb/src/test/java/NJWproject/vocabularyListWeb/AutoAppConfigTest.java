package NJWproject.vocabularyListWeb;

import NJWproject.vocabularyListWeb.book.BookService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {
    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        BookService bookService = ac.getBean(BookService.class);
        Assertions.assertThat(bookService).isInstanceOf(BookService.class);
    }
}
