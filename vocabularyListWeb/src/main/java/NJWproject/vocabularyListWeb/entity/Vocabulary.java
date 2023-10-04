package NJWproject.vocabularyListWeb.entity;

import javax.persistence.*;

@Entity
public class Vocabulary {
    @Id
    @GeneratedValue
    @Column(name = "vocabulary_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private String english;
    private String korean;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }
}
