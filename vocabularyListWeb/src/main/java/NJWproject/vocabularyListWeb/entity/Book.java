package NJWproject.vocabularyListWeb.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue
    @Column(name = "book_id")
    private Long id;
    private String bookName;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Vocabulary> vocabularyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
