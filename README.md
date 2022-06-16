# Spring

## Spring 공부 순서

1. [Spring MVC 개념 및 Hello World 출력하기](https://velog.io/@guri_coding/Spring-MVC-%EA%B8%B0%EC%B4%88-%EA%B3%B5%EB%B6%80%ED%95%98%EA%B8%B0) : spring-mvc-hello-world
2. [Spring MVC 와 Form을 활용한 간단한 회원가입 폼 만들기](https://velog.io/@guri_coding/Spring-MVC-%EC%99%80-Form%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%ED%95%98%EA%B8%B0) : spring-mvc-form
3. [Spring MVC와 Form Tags 상세하게 공부해보기](https://velog.io/@guri_coding/Spring-MVC%EC%99%80-Form-Tags-%EC%83%81%EC%84%B8%ED%95%98%EA%B2%8C-%EA%B3%B5%EB%B6%80%ED%95%B4%EB%B3%B4%EA%B8%B0)
4. [Spring JPA와 AWS 연동하기](https://velog.io/@guri_coding/Spring-JPA-%EC%99%80-AWS-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0) : spring-jpa-tutorial
5. [Spring JPA Auditing 기능 추가해 createdDate, lastModifiedDate 자동 생성하기](https://velog.io/@guri_coding/Spring-JPA-Auditing-%EA%B8%B0%EB%8A%A5-%EC%B6%94%EA%B0%80%ED%95%B4-createdDate-lastModifiedDate-%EC%9E%90%EB%8F%99-%EC%83%9D%EC%84%B1%ED%95%98%EA%B8%B0) : spring-jpa-auditing
6. [Spring 기본 데이터 접근과 @Component에 대하여](https://velog.io/@guri_coding/Spring-%EA%B8%B0%EB%B3%B8-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%A0%91%EA%B7%BC%EA%B3%BC-Component%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC)

### Spring 환경 설정
    1. Java 11 이상
    2. Intellij or eclips 사용하기
    3. https://start.spring.io/ 로 Spring 시작하기
    4. 여기서 받아서 Intellij로 시작하기
    5. ./gradlew clean build && cd build/libs
    6. ls -arlth 한다음 파일을 복사해서 실행함
    7. java -jar hello-spring-0.0.1-SNAPSHOT.jar 이름은 예시임 

### Spring
    - https://www.thymeleaf.org/ 참고
    - MVC: Model, View, Controller

### JPA & Spring boot 연동

    0. Back-End 개발 워크플로우
       1) ERD 설계 - 기능 명세서, API 명세서
       2) Table 생성 - MySQL Workbench Table
       3) Entity 생성 - JPA Table 생성
       4) Repository 생성
       5) Repository 테스트
       6) 연관관계 설정
       7) 필요한 Query Method 생성
    
    1. JPA 폴더 구조
       > main
         > component
         > config
         > controller
           > api : UserApiController - 여기서 @RequestMapping을 통해 API 생성
         > ifs - 여기서 CRUDInterface를 생성하고 ApiController/ApiLogicService에 @Override하는 방식으로 운영됨
         > model
           > entity : User.java로 @Entity class 생성
           > network
             > request : UserApiRequest.java - Request 구조 
             > response : UserApiResponse.java - Response 구조
             Header.java - Response 중 공통적으로 쓰이는 것들이 있기 때문에 여기서 구현 ex) api 통신시간, api 응답 코드, api 부가 설명, data가 있는데 data에 Generic Class를 써서 다양한 클래스의 데이터들이 들어올 수 있게 만들어줌
         > repository : UserRepository - 여기서는 실제 DB에 연결해 Interface를 만드는데 이때 JpaRepository를 불러와 사용
         > service : UserApiLogicService
      
### Junit5 정리

    0. Junit5 기본 설정
        testRuntime("org.junit.jupiter:junit-jupiter-engine:5.1.0")

    1. 기본 Annotaion
        1) @Test : 테스트 Method 임을 선언함
        2) @ParameterizedTest : 매개 변수를 받는 테스트를 작성할 수 있음
        3) @RepeatedTest : 반복되는 테스트를 작성할 수 있음
        4) @TestFactory : @Test로 선언된 정적 테스트가 아닌 동적으로 테스트를 사용함
        5) @TestInstance : 테스트 클래스의 생명주기를 설정함
        6) @TestTemplate : 공급자에 의해 여러 번 호출될 수 있도록 설계된 테스트 케이스 템플릿임을 나타냄
        7) @TestMethodOrder : 테스트 메소드 실행 순서를 구성하는데 사용함
        8) @DisplayName : 테스트 클래스 또는 메소드의 사용자 정의 이름을 선언할 때 사용함
        9) @DisplayNameGeneration : 이름 생성기를 선언함. 예를 들어 '_'를 공백 문자로 치환해주는 생성기가 있음. ex) new_test -> new test
        10) @BeforeEach : 모든 테스트 실행 전에 실행할 테스트에 사용함
        11) @AfterEach : 모든 테스트 실행 후에 실행한 테스트에 사용함
        12) @BeforeAll : 현재 클래스를 실행하기 전 제일 먼저 실행할 테스트 작성하는데, static으로 선언함
        13) @AfterAll : 현재 클래스 종류 후 해당 테스트를 실행하는데, static으로 선언함
        14) @Nested : 클래스를 정적이 아닌 중첩 테스트 클래스임을 나타냄
        15) @Tag : 클래스 또는 메소드 레벨에서 태그를 선언할 때 사용함. 이를 메이븐을 사용할 경우 설정에서 테스트를 태그로 인식해 포함하거나 제외시킬 수 있음
        16) @Disabled : 이 클래스나 테스트를 사용하지 않음을 표시함
        17) @Timeout : 테스트 실행 시간을 선언 후 초과되면 실패하도록 설정함
        18) @ExtendWith : 확장을 선언적으로 등록할 때 사용함
        19) @RegisterExtension : 필드를 통해 프로그래밍 방식으로 확장을 등록할 때 사용함
        20) @TempDir : 필드 주입 또는 매개변수 주입을 통해 임시 디렉토리를 제공하는데 사용함
    
    2. JUnit4 Assertions
        1) assertEquals : 두 값을 비교하여 일치 여부 판단
        2) assertArrayEquals : 두 배열을 비교하여 일치 여부 판단/두 배열이 모두 Null이어도 동일한 것으로 간주함
        3) assertNotNull & assertNull : 객체의 Null 여부 판단
        4) assertNotSame & assertSame : 두 변수가 동일한 객체를 참조하는지 확인
        5) assertTrue & assertFalse : 특정 조건이 true인지 false인지 판단
        6) fail : AssertionFailedError를 발생시키는 테스트에 실패/실제 예외가 발생했는지 확인하거나, 개발 중에 테스트를 실패하게 만들고 싶을 때 사용
        7) assertThat : 첫번째 파라미터에 비교대상 값, 두번째 파라미터에 비교 로직이 담긴 Matcher를 받음
    
    3. JUnit5 Assertions
        1) assertArrayEquals : 예상 배열과 실제 배열이 동일한지 확인/배열이 같지 않으면 마지막 인자로 들어간 메시지가 출력됨
        2) assertEquals : 두 값을 비교하여 일치 여부 판단
        3) assertTrue & assertFalse : JUnit4와 동일하며 BooleanSupplier도 사용 가능
        4) assertNull & assertNotNull : JUnit4와 동일하며 객체의 null 여부 확인
        5) assertSame & assertNotSame : JUnit4와 동일하며 예상되는 값과 실제 값이 동일한 객체를 참조하는지 확인
        6) fail : 제공된 실패 메시지와 기본 원인으로 테스트에 실패/개발이 완료되지 않은 테스트를 표시하는데 유용
        7) assertAll : 모든 Assertion이 실행되고 실패가 함께 보고되는 그룹화된 Assertion/MultipleFailureError에 대한 메시지 문자열에 포함될 제목과 실행 가능한 스트림을 허용/실행 파일 중 하나에서 OutOfMemoryError가 발생한 경우에만 중단됨/메소드 내에서 인자로 람다식을 사용(여러 개의 람다식이 동시에 실행됨)
        8) assertIterableEquals : 예상 반복 가능 항목과 실제 반복 가능 항목이 동일한지 확인/두 Iterable은 동일한 순서로 동일한 요소를 반환해야 함/두 Iterable이 동일한 유형일 필요는 없음/아래에서 서로 다른 유형의 두 목록이 동일한지 확인
        9) assertLinesMatch : 예상 목록이 실제 목록과 일치하는지 확인/assertEquals, assertIterableEquals와 다름
        10) assertNotEquals : 예상 값과 실제 값이 다름을 확인
        11) assertThrows : 특정 예외가 발생하였는지 확인/첫 번째 인자는 확인할 예외 클래스/두 번째 인자는 테스트하려는 코드
        12) assertTimeout & assertTimeoutPreemptively : 특정 시간 안에 실행이 끝나는지 확인/시간 내 실행이 끝나는지 여부 확인 시 - assertTimeout/지정한 시간 내 끝나지 않으면 바로 종료 - assertTimeoutPreemptively
        

