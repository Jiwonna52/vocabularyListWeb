package NJWproject.vocabularyListWeb.book;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MemoryBookRepositoryImpl implements BookRepository {

    private final Map<Long, Book> bookStore = new HashMap<>();
    @Override
    public void save(Book book) {
        bookStore.put(book.getId(), book);
    }

    @Override
    public Book findById(Long bookId) {
        return bookStore.get(bookId);
    }
}
