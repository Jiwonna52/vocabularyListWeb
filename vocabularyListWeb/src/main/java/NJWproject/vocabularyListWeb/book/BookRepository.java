package NJWproject.vocabularyListWeb.book;

public interface BookRepository {
    void save(Book book);
    Book findById(Long bookId);
}
