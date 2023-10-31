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
        vocabulary.setChapter("ch1");

        Long savedVoId = vocabularyRepository.save(vocabulary);
        Vocabulary findVo = vocabularyRepository.find(savedVoId);

        Assertions.assertThat(vocabulary).isEqualTo(findVo);
        Assertions.assertThat(savedId).isEqualTo(findVo.getBook().getId());
    }

    @Test
    @Transactional
    @Rollback
    void vocabularyChapterTest() {
        Book book = new Book();
        book.setBookName("hatingGame");
        Long savedId = bookRepository.save(book);

        String chap = "chp1";
        Vocabulary vocabulary1 = new Vocabulary();
        vocabulary1.setBook(book);
        vocabulary1.setEnglish("start");
        vocabulary1.setKorean("시작하다");
        vocabulary1.setChapter(chap);
        vocabularyRepository.save(vocabulary1);

        Vocabulary vocabulary2 = new Vocabulary();
        vocabulary2.setBook(book);
        vocabulary2.setEnglish("end");
        vocabulary2.setKorean("끝내다");
        vocabulary2.setChapter(chap);
        vocabularyRepository.save(vocabulary2);

        Assertions.assertThat(vocabularyRepository.findByChapter(savedId, chap).size()).isEqualTo(2);


    }

    @Test
    @Transactional
    @Rollback
    void vocabularyChapterListTest() {
        Book book = new Book();
        book.setBookName("hatingGame");
        Long savedId = bookRepository.save(book);

        String chap = "chp1";
        String chap2 = "chp2";

        Vocabulary vocabulary1 = new Vocabulary();
        vocabulary1.setBook(book);
        vocabulary1.setEnglish("start");
        vocabulary1.setKorean("시작하다");
        vocabulary1.setChapter(chap);
        vocabularyRepository.save(vocabulary1);

        Vocabulary vocabulary2 = new Vocabulary();
        vocabulary2.setBook(book);
        vocabulary2.setEnglish("end");
        vocabulary2.setKorean("끝내다");
        vocabulary2.setChapter(chap);
        vocabularyRepository.save(vocabulary2);

        Vocabulary vocabulary3 = new Vocabulary();
        vocabulary3.setBook(book);
        vocabulary3.setEnglish("smile");
        vocabulary3.setKorean("웃다");
        vocabulary3.setChapter(chap2);
        vocabularyRepository.save(vocabulary3);

        Assertions.assertThat(vocabularyRepository.findChapterList(savedId).size()).isEqualTo(2);
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

    @Test
    @Transactional
    @Rollback
    void 단어_검색_기능() {
        Book book = new Book();
        book.setBookName("RWRB");
        Long savedId = bookRepository.save(book);
        Book findBook = bookRepository.find(savedId);

        Vocabulary vocabulary1 = new Vocabulary();
        vocabulary1.setBook(book);
        vocabulary1.setEnglish("start");
        vocabulary1.setKorean("시작하다");
        vocabularyRepository.save(vocabulary1);

        Vocabulary vocabulary2 = new Vocabulary();
        vocabulary2.setBook(book);
        vocabulary2.setEnglish("end");
        vocabulary2.setKorean("끝내다");
        vocabularyRepository.save(vocabulary2);

        List<Vocabulary> searchResult = vocabularyRepository.search("끝내다");
        Assertions.assertThat(vocabulary2).isEqualTo(searchResult.get(0));
        System.out.println(searchResult.get(0).getKorean());
    }

    @Test
    @Transactional
    @Rollback
    void 단어_어러개_검색() {
        Book book = new Book();
        book.setBookName("RWRB");
        Long savedId = bookRepository.save(book);
        Book findBook = bookRepository.find(savedId);

        Vocabulary vocabulary1 = new Vocabulary();
        vocabulary1.setBook(book);
        vocabulary1.setEnglish("start");
        vocabulary1.setKorean("시작하다");
        vocabularyRepository.save(vocabulary1);

        Vocabulary vocabulary2 = new Vocabulary();
        vocabulary2.setBook(book);
        vocabulary2.setEnglish("end");
        vocabulary2.setKorean("끝내다");
        vocabularyRepository.save(vocabulary2);

        Vocabulary vocabulary3 = new Vocabulary();
        vocabulary3.setBook(book);
        vocabulary3.setEnglish("end!");
        vocabulary3.setKorean("끝!");
        vocabularyRepository.save(vocabulary3);

        List<Vocabulary> searchResult = vocabularyRepository.search("끝");
        Assertions.assertThat(vocabulary2).isEqualTo(searchResult.get(0));
        Assertions.assertThat(vocabulary3).isEqualTo(searchResult.get(1));
        System.out.println(searchResult.get(0).getKorean());
        System.out.println(searchResult.get(1).getKorean());
    }


}
