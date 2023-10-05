# 그냥, 영어 단어장(vocabularyListWeb)
## 3rd commit (09/24)
### AppConfig
객체 지향을 위해 추상과 구체 클래스를 분리해야 한다. 겉으로 보기에는 객체 지향이 지켜진 것 같으나 BookServiceImpl이나 VocabularyServiceImpl가 Memory~()라는 구체 클래스에 의존해고 있다. 그래서 관심사 분리를 위해 AppConfig라는 클래스를 추가로 생성해 주었다.

AppConfig 클래스는 객체를 생성하고 연결하는 기능을 가지고 있다. 즉, 클라이언트 클래스(Impl이 붙은)들의 생성자를 통해 AppConfig에서 개체를 생성하고 다른 클래스는 AppConfig에 작성된 메소드를 통해서 구현체에 접근하면 된다.

### Spring
스프링을 도입해 빈 컨테이너에서 관리하도록 했다. @Configuration을 AppConfig에 설정하여 설정 정보를 가지고 오도록 했고 @Bean을 이용해 메소드를 빈 컨테이너에 등록하도록 했다.
## 5th commit (09/30)
### AutoAppConfig
@Bean을 이용하여 스프링 컨테이너에 빈을 등록해야 했던 과거와 달리 @ComponentScan을 이용하여 @Component가 붙은 클래스를 자동으로 빈 등록 해줄 수 있게 했다. 이때 의존 관계 주입은 @AutoWired를 이용하여 명시해준다. @Autowired를 해줄 때는 개념이 같은 것을 찾아 주는데, 해당 개념이 충돌할 때 과거에는 수동을 우선시 했다. 하지만, 현재는 Spring Boot가 자동으로 오류를 내 준다. 

### Spring Boot
## 6th commit(10/4)
### Entity
DB의 테이블과 1대1 연결되는 Book과 Vocabulary 엔티티를 생성했다. 과거에 했던 작업을 남겨둘까 하다가 이름도 겹치고 복잡해져서 과감하게 지우기로 결정.
### Repository
주요 기능을 간단하게 구현했다. 나중에 Service로 나눌 예정.

## 7th commit
### book과 vocabulary 목록 반환 기능 구현(Repository)
엔티티 메니저 쿼리 이용
### controller
controller를 이용해서 model에 값을 넣어서 view로 값을 전달할 수 있게 함.
### 프론트 화면 구현
html을 이용해서 간단하게

