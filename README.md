# Study-SpringBoot

## 09/17

### [스프링부트](https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#getting-started-introducing-spring-boot)


## 10/21

### 의존성 관리 응용
 - 버전 관리 해주는 의존성 추가
 - 버전 관리 안해주는 의존성 추가
 - 기존 의존성 버전 변경하기

### `ModelMapper`
 - Dto 대신 사용 가능

### `@SpringBootApplication`
 - 안에는 3가지 Annotation이 있음
   1) `@SpringBootConfiguration` (`@Configuration` 과 거의 유사)
   2) `@ComponentScan`
   3) `@EnableAutoConfiguration`

 - `Bean`은 두 단계에 나뉘어 읽힘
   1단계) `@Component`으로 등록
   2단계) 이후 `@EnableAutoConfiguration` 으로 등록

 - `@ComponentScan`
   - `@Component`를 가진 class 들을 scan 해서 `bean` 으로 등록
   - `@ComponentScan`을 가진 class 부터 하위 패키지 까지 전부다 훑어서 `@Component`, `@Configuration`, `@Repository`, `@Service`, `@Controller`, `@RestController` 어노테이션을 찾아서 `bean`으로 등록

 - `@EnableAutoConfiguration`
   - `resource` -> `META-INF` -> `spring.factories` 에 기본 설정들이 포함되어 있음
   - `@ConditionalOnXXX`는 조건에 따라 bean을 등록 or 미등록


## 10/22

### `@ConditionalOnMissingBean`
  - 해당 타입의 `bean`이 없을시 `@ConditionalOnMissingBean`을 추가한 bean을 등록하도록 함
  - 덮어쓰기 방지

### `Bean` 재정의 수고 덜기
  - `@ConfigurationProperties(“holoman”)`
  - `@EnableConfigurationProperties(HolomanProperties)`
  - 프로퍼티 키값 자동 완성

### '스프링부트는 웹서버가 아니다!'
  - 내장 servlet container를 쉽게 사용할 수 있게끔 해주는 툴
  - springframework를 쉽게 사용하게 해주는 툴
  - 자동 설정으로 내장 servlet container가 만들어짐
  - 톰캣 객체 생성
  - 포트 설정
  - 톰캣에 컨텍스트 추가
  - 서블릿 만들기
  - 톰캣에 서블릿 추가
  - 컨텍스트에 서블릿 맵핑
  - 톰캣 실행 및 대기
  -> 이 모든 과정을 보다 상세히 또 유연하고 설정하고 실행해주는게 바로 스프링 부트의 자동 설정.
    - ServletWebServerFactoryAutoConfiguration (서블릿 웹 서버 생성)
      - TomcatServletWebServerFactoryCustomizer (서버 커스터마이징)
      - Servlet Container를 만드는 일
    - DispatcherServletAutoConfiguration
      - 서블릿 만들고 등록

### `DispatcherServlet`
  - `HttpServlet`과 동일
  - `HttpServlet`을 상속해서 만든 스프링 MVC의 핵심 클래스

### Web Server Servlet Container Customizing
  -  `spring.main.web-application-type=none`
    - 웹 서블릿 컨테이너 의존성들이 classpath에 있다 하더라도 무시하고 none-webapplication 으로 실행하고 끝남
  - `server.port=7070`
    - 포트 변경
    - 랜덤 포트 사용(7070 -> 0)
