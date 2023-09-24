# vocabularyListWeb
## 3th commit
### AppConfig
객체 지향을 위해 추상과 구체 클래스를 분리해야 한다. 겉으로 보기에는 객체 지향이 지켜진 것 같으나 BookServiceImpl이나 VocabularyServiceImpl가 Memory~()라는 구체 클래스에 의존해고 있다. 그래서 관심사 분리를 위해 AppConfig라는 클래스를 추가로 생성해 주었다.

AppConfig 클래스는 객체를 생성하고 연결하는 기능을 가지고 있다. 즉, 클라이언트 클래스(Impl이 붙은)들의 생성자를 통해 AppConfig에서 개체를 생성하고 다른 클래스는 AppConfig에 작성된 메소드를 통해서 구현체에 접근하면 된다.

### Spring
스프링을 도입해 빈 컨테이너에서 관리하도록 했다. @Configuration을 AppConfig에 설정하여 설정 정보를 가지고 오도록 했고 @Bean을 이용해 메소드를 빈 컨테이너에 등록하도록 했다.
