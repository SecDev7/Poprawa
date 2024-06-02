import java.util.List;

public interface BookOperations {
    void addBook(Book book);
    void removeBook(String isbn);
    Book updateBook(String isbn, Book updatedBook);
    List<Book> getBooks();
}
