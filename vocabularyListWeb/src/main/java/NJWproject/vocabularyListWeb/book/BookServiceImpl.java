package NJWproject.vocabularyListWeb.book;

public class BookServiceImpl implements BookService{
    private BookRepository bookRepository = new MemoryBookRepositoryImpl();
    @Override
    public void join(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findBook(Long bookId) {
        return bookRepository.findById(bookId);
    }
}
