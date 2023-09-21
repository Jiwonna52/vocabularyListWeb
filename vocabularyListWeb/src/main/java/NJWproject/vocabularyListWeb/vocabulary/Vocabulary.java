package NJWproject.vocabularyListWeb.vocabulary;

public class Vocabulary {
    private Long id;
    private String english;
    private String korean;
    private Long bookId;

    public Vocabulary(Long id, String english, String korean, Long bookId) {
        this.id = id;
        this.english = english;
        this.korean = korean;
        this.bookId = bookId;
    }

    public Long getBookId() {
        return bookId;
    }

    public Long getId() {
        return id;
    }

    public String getKorean() {
        return korean;
    }

    public String getEnglish() {
        return english;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
