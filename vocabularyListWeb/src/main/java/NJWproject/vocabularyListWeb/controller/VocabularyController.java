package NJWproject.vocabularyListWeb.controller;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.entity.Vocabulary;
import NJWproject.vocabularyListWeb.form.VocabularyForm;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import NJWproject.vocabularyListWeb.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Transactional
@Slf4j
public class VocabularyController {
    private final VocabularyRepository vocabularyRepository;
    private final BookRepository bookRepository;

    @GetMapping(value = "/{bookId}/vocabularies/new")
    public String createForm(Model model) {
        model.addAttribute("vocabularyForm", new VocabularyForm());
        return "vocabularies/createVocabularyForm";
    }

    @PostMapping(value = "/{bookId}/vocabularies/new")
    public String create(@PathVariable("bookId") Long bookId, VocabularyForm form) {
        Vocabulary vocabulary = new Vocabulary();
        Book book = (Book) bookRepository.find(bookId);
        System.out.println(bookId);
        vocabulary.setEnglish(form.getEnglish());
        vocabulary.setKorean(form.getKorean());
        vocabulary.setBook(book);
        vocabularyRepository.save(vocabulary);

        return "redirect:/{bookId}/vocabularyList";
    }

    @GetMapping(value = "/{bookId}/vocabularyList")
    public String vocabularyList(@PathVariable("bookId") Long bookId, Model model) {
        List<Vocabulary> vocabularyList = vocabularyRepository.findAll(bookId);
        model.addAttribute("vocabularies", vocabularyList);
        Book book = bookRepository.find(bookId);
        System.out.println(book.getId());
        model.addAttribute("book", book);
        return "vocabularies/vocabularyList";
    }
}
