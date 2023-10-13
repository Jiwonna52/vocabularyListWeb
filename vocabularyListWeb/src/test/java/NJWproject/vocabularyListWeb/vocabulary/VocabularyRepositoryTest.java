package NJWproject.vocabularyListWeb.vocabulary;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.entity.Vocabulary;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import NJWproject.vocabularyListWeb.repository.VocabularyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class VocabularyRepositoryTest {

    @Autowired
    BookRepository bookRepository;


    @Autowired
    VocabularyRepository vocabularyRepository;

    @Test
    @Transactional
    @Rollback
    void vocabularyRepositoryTest() {
        Book book = new Book();
        book.setBookName("RWRB");
        Long savedId = bookRepository.save(book);
        Book findBook = bookRepository.find(savedId);

        Vocabulary vocabulary = new Vocabulary();
        vocabulary.setBook(book);
        vocabulary.setEnglish("start");
        vocabulary.setKorean("시작하다");

        Long savedVoId = vocabularyRepository.save(vocabulary);
        Vocabulary findVo = vocabularyRepository.find(savedVoId);

        Assertions.assertThat(vocabulary).isEqualTo(findVo);
        Assertions.assertThat(savedId).isEqualTo(findVo.getBook().getId());
    }


    @Test
    @Transactional
    @Rollback
    void vocabularyPageTest() {
        Book book = new Book();
        book.setBookName("RWRB");
        Long savedId = bookRepository.save(book);
        Book findBook = bookRepository.find(savedId);

        Vocabulary vocabulary1 = new Vocabulary();
        vocabulary1.setBook(book);
        vocabulary1.setEnglish("start");
        vocabulary1.setKorean("시작하다");
        vocabularyRepository.save(vocabulary1);


    }


}
