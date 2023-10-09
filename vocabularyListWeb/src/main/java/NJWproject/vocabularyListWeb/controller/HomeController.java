package NJWproject.vocabularyListWeb.controller;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookRepository bookRepository;
    @GetMapping("/")
    public String home(Model model) {
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("bookList", bookList);
        return "home";
    }
}
