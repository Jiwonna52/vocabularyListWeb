package NJWproject.vocabularyListWeb.entity;

import javax.persistence.*;

@Entity
@Table
public class Vocabulary {
    @Id
    @Column(name = "vocabularyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String english;
    String korean;
}
