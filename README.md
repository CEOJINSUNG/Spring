# Spring

### Spring 환경 설정
    1. Java 11 이상
    2. Intellij or eclips 사용하기
    3. https://start.spring.io/ 로 Spring 시작하기
    4. 여기서 받아서 Intellij로 시작하기

### Spring-web
    - https://www.thymeleaf.org/ 참고

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
      
