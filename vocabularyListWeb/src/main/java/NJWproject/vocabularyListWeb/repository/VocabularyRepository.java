package NJWproject.vocabularyListWeb.repository;

import NJWproject.vocabularyListWeb.entity.Vocabulary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class VocabularyRepository implements JpaRepository <Vocabulary, Long> {

}
