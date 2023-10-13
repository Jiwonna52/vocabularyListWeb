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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.util.*;

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
    public String create(@PathVariable("bookId") Long bookId, VocabularyForm form, RedirectAttributes attribute) {
        Vocabulary vocabulary = new Vocabulary();
        Book book = (Book) bookRepository.find(bookId);
        vocabulary.setEnglish(form.getEnglish());
        vocabulary.setKorean(form.getKorean());
        vocabulary.setBook(book);
        vocabularyRepository.save(vocabulary);

        attribute.addAttribute("index", 1);
        return "redirect:/{bookId}/{index}/vocabularyList";
    }

    /*
    @GetMapping(value = "/{bookId}/vocabularyList")
    public String vocabularyList(@PathVariable("bookId") Long bookId, Model model) {
        List<Vocabulary> vocabularyList = vocabularyRepository.findAll(bookId);
        model.addAttribute("vocabularies", vocabularyList);
        Book book = bookRepository.find(bookId);
        System.out.println(book.getId());
        model.addAttribute("book", book);

        return "vocabularies/vocabularyList";
    }*/

    @GetMapping(value = "/{bookId}/{index}/vocabularyList")
    public String vocabularyListPaging(@PathVariable("bookId") Long bookId, @PathVariable("index") int index, Model model) {
        List<Vocabulary> list = vocabularyRepository.findAll(bookId);
        List<Vocabulary> pageList = vocabularyRepository.pagingVocabulary(bookId, index);

        List<Integer> pageIndex = new ArrayList<>();
        for (int i=1; i<=((list.size()-1)/3)+1; i++) {
            pageIndex.add(i);
        }

        model.addAttribute("list", pageList);
        model.addAttribute("book", bookRepository.find(bookId));
        model.addAttribute("pageIndex", pageIndex);

        return "vocabularies/vocabularyPagingList";
    }


    @DeleteMapping(value = "/{bookId}/vocabularyList/{vocabularyId}/delete")
    public String delete(@PathVariable("bookId") Long bookId, @PathVariable("vocabularyId") Long vocabularyId) {
        vocabularyRepository.delete(vocabularyId);
        return "redirect:/{bookId}/vocabularyList";
    }

    @GetMapping(value = "/{bookId}/vocabularyList/{vocabularyId}/update")
    public String vocabularyUpdateForm(@PathVariable("bookId") Long bookId, @PathVariable("vocabularyId") Long vocabularyId, Model model) {
        Book book = bookRepository.find(bookId);
        Vocabulary vocabulary = vocabularyRepository.find(vocabularyId);

        VocabularyForm form = new VocabularyForm();
        form.setId(vocabularyId);
        form.setKorean(vocabulary.getKorean());
        form.setEnglish(vocabulary.getEnglish());
        form.setBook(book);

        model.addAttribute("form", form);

        return "vocabularies/vocabularyUpdateForm";
    }

    @PostMapping(value = "/{bookId}/vocabularyList/{vocabularyId}/update")
    public String vocabularyForm(@PathVariable("bookId") Long bookId, @PathVariable("vocabularyId") Long vocabularyId, VocabularyForm form) {
        vocabularyRepository.updateVocabulary(vocabularyId, form.getKorean(), form.getEnglish());

        return "redirect:/{bookId}/vocabularyList";
    }
}
