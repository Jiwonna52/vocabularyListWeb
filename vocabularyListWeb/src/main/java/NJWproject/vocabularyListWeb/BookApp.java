package NJWproject.vocabularyListWeb;

import NJWproject.vocabularyListWeb.book.Book;
import NJWproject.vocabularyListWeb.book.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BookApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //BookService bookService = appConfig.bookService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = applicationContext.getBean("bookService", BookService.class);

        Book book = new Book(1L, "RWRB");
        bookService.join(book);
        Book findBook1 = bookService.findBook(1L);

        System.out.println("findBook1.getId() = " + findBook1.getId());
        System.out.println("findBook1.getName() = " + findBook1.getName());
    }
}
