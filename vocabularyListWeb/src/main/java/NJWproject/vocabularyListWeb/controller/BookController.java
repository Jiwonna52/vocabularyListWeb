package NJWproject.vocabularyListWeb.controller;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.form.BookForm;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookRepository bookRepository;

    // 서버에게 데이터를 달라고 요청
    @GetMapping(value = "/books/new")
    public String createForm(Model model) {
        model.addAttribute("bookForm", new BookForm());
        return "books/createBookForm";
    }

    @PostMapping(value = "/books/new")
    public String create(BookForm form) {
        Book book = new Book();
        book.setBookName(form.getBookName());
        bookRepository.save(book);

        return "redirect:/home";
    }

    @GetMapping(value = "/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "books/bookList";
    }

    @DeleteMapping(value = "/bookList/{bookId}/delete")
    public String delete(@PathVariable("bookId") Long bookId) {
        bookRepository.delete(bookId);

        return "redirect:/home";
    }

    @GetMapping(value = "/bookList/{bookId}/update")
    public String bookUpdateForm(@PathVariable("bookId") Long bookId, Model model) {
        Book book = bookRepository.find(bookId);
        BookForm form = new BookForm();
        form.setId(book.getId());
        form.setBookName(book.getBookName());
        model.addAttribute("form", form);

        return "books/updateForm";

    }

    @PostMapping(value = "/bookList/{bookId}/update")
    public String bookUpdate(@PathVariable("bookId") Long bookId, @ModelAttribute("form") BookForm form) {
        bookRepository.updateBook(bookId, form.getBookName());
        return "redirect:/home";
    }
}