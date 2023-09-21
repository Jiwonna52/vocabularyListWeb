package NJWproject.vocabularyListWeb.book;

public interface BookService {
    void join(Book book);
    Book findBook(Long bookId);
}
