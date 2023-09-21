package NJWproject.vocabularyListWeb.book;

public class Book {
    private Long Id;
    private String name;

    public Book(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
