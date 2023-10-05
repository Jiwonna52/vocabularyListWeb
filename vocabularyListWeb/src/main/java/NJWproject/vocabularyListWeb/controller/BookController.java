package NJWproject.vocabularyListWeb.controller;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.form.BookForm;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

        return "redirect:/bookList";
    }

    @GetMapping(value = "/bookList")
    public String bookList(Model model) {
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("books", bookList);
        return "books/bookList";
    }
}
