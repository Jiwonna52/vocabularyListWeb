package NJWproject.vocabularyListWeb;

import NJWproject.vocabularyListWeb.entity.Book;
import NJWproject.vocabularyListWeb.entity.Vocabulary;
import NJWproject.vocabularyListWeb.repository.BookRepository;
import NJWproject.vocabularyListWeb.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class VocabularyListWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocabularyListWebApplication.class, args);
	}

	@Bean
	public HiddenHttpMethodFilter hiddenHttpMethodFilter(){
		return new HiddenHttpMethodFilter();
	}

}
