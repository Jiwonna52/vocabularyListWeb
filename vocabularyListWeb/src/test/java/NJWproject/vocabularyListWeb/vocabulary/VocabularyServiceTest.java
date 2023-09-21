package NJWproject.vocabularyListWeb.vocabulary;

import NJWproject.vocabularyListWeb.book.Book;
import NJWproject.vocabularyListWeb.book.BookService;
import NJWproject.vocabularyListWeb.book.BookServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class VocabularyServiceTest {
    private final VocabularyRepository vocabularyRepository = new MemoryVocabularyRepositoryImpl();
    private final VocabularyService vocabularyService = new VocabularyServiceImpl();
    private final BookService bookService = new BookServiceImpl();

    @Test
    void join() {
        //given
        Vocabulary vocabulary = new Vocabulary(1L, "start", "시작하다", 1L);

        //when
        vocabularyService.join(vocabulary);
        Vocabulary findVocabulary = vocabularyService.findVocabulary(vocabulary.getId());

        //then
        Assertions.assertThat(vocabulary).isEqualTo(findVocabulary);
    }

    @Test
    void joinWithBook() {
        // given
        Book book = new Book(1L, "RWRB");
        Vocabulary vocabulary = new Vocabulary(1L, "start", "시작하다", 1L);

        // when
        bookService.join(book);
        vocabularyService.join(vocabulary);
        Vocabulary findVocabulary = vocabularyService.findVocabulary(vocabulary.getId());

        // then
        Assertions.assertThat(bookService.findBook(findVocabulary.getBookId())).isEqualTo(book);
    }

    @Test
    void findVocabularyListByBookId() {
        // given
        Book book = new Book(1L, "RWRB");
        Vocabulary vocabulary1 = new Vocabulary(1L, "start", "시작하다", 1L);
        Vocabulary vocabulary2 = new Vocabulary(2L, "end", "끝내다.", 1L);

        // when
        bookService.join(book);
        vocabularyService.join(vocabulary1);
        vocabularyService.join(vocabulary2);

        // then
        vocabularyService.findVocabularyById(book.getId()).stream().forEach(vocabulary -> System.out.println(vocabulary.getEnglish() + " " + vocabulary.getKorean()));

    }
}
