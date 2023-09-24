package NJWproject.vocabularyListWeb;

import NJWproject.vocabularyListWeb.book.BookRepository;
import NJWproject.vocabularyListWeb.book.BookService;
import NJWproject.vocabularyListWeb.book.BookServiceImpl;
import NJWproject.vocabularyListWeb.book.MemoryBookRepositoryImpl;
import NJWproject.vocabularyListWeb.vocabulary.MemoryVocabularyRepositoryImpl;
import NJWproject.vocabularyListWeb.vocabulary.VocabularyRepository;
import NJWproject.vocabularyListWeb.vocabulary.VocabularyService;
import NJWproject.vocabularyListWeb.vocabulary.VocabularyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public static BookRepository bookRepository() {
        return new MemoryBookRepositoryImpl();
    }
    @Bean
    public static BookService bookService() {
        return new BookServiceImpl(bookRepository());
    }

    @Bean
    public static VocabularyRepository vocabularyRepository() {
        return new MemoryVocabularyRepositoryImpl();
    }

    @Bean
    public static VocabularyService vocabularyService() {
        return new VocabularyServiceImpl(vocabularyRepository());
    }


}
