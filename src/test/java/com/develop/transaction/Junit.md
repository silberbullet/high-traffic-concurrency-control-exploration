# TDD 참고사항

### JUnit Jupiter
- TestEngine API 구현체로 JUnit 5를 구현
- 테스트이 실체 구현체는 별도 모듈 역할 수행 (Jupiter-Engine)
- 개발자가 테스트 코드를 작성할 때 사용

### JUnit Platform
- Test를 실행하기 위한 뼈대
- Test를 발견하고 테스트 계획을 생성하는 TestEngine 인터페이스 소유

### JUnit 5 기준 LifeCycle Annotation
- @Test :  테스트용 메소드를 표현하는 어노테인션
- @BeforeEach : 각 테스트 메소드가 시작되기 전에 실행되어야 하는 메소드 표현
- @AfterEach :  각 테스트 메소드가 시작된 후 실행되어야 하는 메소드 표현
- @BeforeAll : 테스트 시작 전에 실행되어야 하는 메소드 표현 (static 처리 필요)
- @AfterAll : 테스트 종료 후에 실행되어야 하는 메소드를 표현 (static 처리 필요)

### @SpringBootTest
- 통합 테스트 용도로 사용
- @SpringBootApplication을 차장가 하위 모든 Bean을 스캔
- 그 후 Test용 Application Context를 만들어 Bean을 추가하고, MockBean을 찾아 교체
    - Application Context는 애플리케이션의 **빈(Bean)**과 그들의 의존성을 관리하는 핵심 컨테이너
    - Spring은 기본적으로 Application Context를 캐시함

### @ExtendWith
- 메인으로 실행될 Class를 지저아
- @SpringBootTest는 기본적으로 @ExtendWith가 추가됨

### @WebMvcTest
- () 작성된 클래스만 실제로 로드하여 진행
- 매개변수 지정해주지 않을 시 컨트롤과 연관된 Bean 모두 로드
- 스프링의 모든 Bean을 로드 / @SpringBootTest 대신 컨트롤러 관련 코드만 테스트할 경우 사용

### @Autowired about MockBean
- Controller API를 테스트하는 용도인 MockMvc 객체를 주입
- perform() 메소드를 활용하여 컨트롤러의 동작을 확인 가능

### @MockBean
- 테스트할 클래스에서 주입 받고 있는 객체에 대해 가짜 객체 생성
- 해당 객체는 실제 행위 하지 않음
- given() 메소드를 활용하여 가짜 객체의 동작에 대해 정의하여 사용

### @AutoConfigureMockMvc
- spring.test.mockmvc의 설정을 로드하면서 McokMvc의 의존성을 자동으로 주입
- MockMvc 클래스는 REST API 테스틀 할 수 있는 클래스

### @Import
- 필요한 Class들을 Configuration으로 만들어 사용
- Configuration Component 클래스도 의존성 설정 가능
- Import된 클래스는 주입으로 사용 가능

### 통합 테스트
- @SpringBootTest를 사용하여 진행
- 대규모 프로젝트에서는 테스트를 실행할 때마다 모든 빈을 스캔하고 로드하는 작업이 반복되어 매번 무거운 작업을 수행

### 단위 테스트
- 프로젝트에 필요한 모든 기능에 대한 테스트를 각각 진행하는 것을 의미
- F.I.R.S.T 원칙
  - Fast : 테스트 코드의 실행은 빠르게 진행되어야 함
  - Independent : 독립적인 테스트가 가능해야함
  - Repeatable : 테스트는 매번 같은 결과를 만들어야 함
  - Self-Vaildating : 테스트는 그 자체로 실행하여 결과를 확인
  - Timely : 단위 테스트 비즈니스 코드가 완성되기 전에 구성하고 테스트가 가능해야 함 ( TDD 원칙을 가짐 )


### @Mock과 @MockBean 차이점

| **특징**         | **`@Mock`**                           | **`@MockBean`**                     |
|------------------|---------------------------------------|-------------------------------------|
| **사용 환경**    | 단위 테스트, 스프링 컨텍스트 불필요   | 통합 테스트, 스프링 컨텍스트 필요   |
| **애플리케이션 컨텍스트** | 스프링 컨텍스트와 무관               | 스프링 애플리케이션 컨텍스트 필요  |
| **Mockito 통합** | Mockito와 함께 사용                    | 스프링 부트 테스트에서 사용         |
| **적용 대상**    | 순수한 자바 클래스                    | 스프링 컨텍스트에 로드된 스프링 빈  |


### @InjectMocks
@InjectMocks는 Mockito에서 제공하는 어노테이션으로, 모킹된 의존성 객체들을 주입하여 테스트 대상 객체를 생성하는 데 사용됩니다. 쉽게 말해, @Mock으로 모킹된 객체들을 자동으로 주입하여 테스트할 클래스의 인스턴스를 생성해 줍니다.