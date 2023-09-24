package NJWproject.vocabularyListWeb;

import NJWproject.vocabularyListWeb.book.Book;
import NJWproject.vocabularyListWeb.book.BookService;
import NJWproject.vocabularyListWeb.vocabulary.Vocabulary;
import NJWproject.vocabularyListWeb.vocabulary.VocabularyService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class VocabularyApp {
    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        //BookService bookService = appConfig.bookService();
        //VocabularyService vocabularyService = appConfig.vocabularyService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        BookService bookService = applicationContext.getBean("bookService", BookService.class);
        VocabularyService vocabularyService = applicationContext.getBean("vocabularyService", VocabularyService.class);

        Book book = new Book(1L, "RWRB");
        bookService.join(book);
        Book findBook1 = bookService.findBook(1L);

        Vocabulary vocabulary = new Vocabulary(1L, "start", "시작하다", "chapter1", 1L);
        vocabularyService.join(vocabulary);
        List<Vocabulary> vocabularyListByBookId = vocabularyService.findVocabularyByBookId(1L);
        vocabularyListByBookId.stream().forEach(vocabulary1 -> System.out.println(vocabulary1.getEnglish() + " " + vocabulary1.getKorean()));
    }
}
