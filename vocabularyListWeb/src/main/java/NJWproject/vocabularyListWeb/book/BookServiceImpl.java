package NJWproject.vocabularyListWeb.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void join(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
