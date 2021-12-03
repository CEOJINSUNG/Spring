# Spring

## Spring 공부 순서

1. [Spring MVC 개념 및 Hello World 출력하기](https://velog.io/@guri_coding/Spring-MVC-%EA%B8%B0%EC%B4%88-%EA%B3%B5%EB%B6%80%ED%95%98%EA%B8%B0) : spring-mvc-hello-world
2. [Spring MVC 와 Form을 활용한 간단한 회원가입 폼 만들기](https://velog.io/@guri_coding/Spring-MVC-%EC%99%80-Form%EC%9D%84-%ED%99%9C%EC%9A%A9%ED%95%9C-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85%ED%95%98%EA%B8%B0) : spring-mvc-form
3. [Spring MVC와 Form Tags 상세하게 공부해보기](https://velog.io/@guri_coding/Spring-MVC%EC%99%80-Form-Tags-%EC%83%81%EC%84%B8%ED%95%98%EA%B2%8C-%EA%B3%B5%EB%B6%80%ED%95%B4%EB%B3%B4%EA%B8%B0)

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
      
