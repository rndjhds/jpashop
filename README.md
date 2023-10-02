# jpashop
인프런 김영한 실전! 스프링부트와 JPA 활용1 웹 애플리케이션 개발과 실전! 스프링 부트와 JPA 활용2 - API 개발과 성능 최적화를 듣고 정리하는 레포지토리입니다. 


## 개발 환경
### 프레임워크 : Spring boot, JPA
### jdk 버전 : 1.8
### 데이터 베이스 : Oracle
### 빌드 관리 도구 : gradle
### templateEngine : Thymeleaf

JPA를 사용한 이유
JPA는 자바 표준 ORM 프레임 워크이다.
웹 애플리케이션 개발을 데이터 베이스 테이블에 의존하지 않고 더 객체스럽게 개발이 가능하고 객체와 테이블 매핑을 개발자가 직접 해주는것을 줄여주기 떄문에 사용하였습니다.

빌드관리 도구로 gradle을 사용한 이유
Maven은 각각의 라이브러리의 버전관리를 직접 해주어야 한다. 떄문에 하나라도 버전이 달라서 안되는 경우가 있기 발생할 수 있고, 버전 변경후 재빌드시 이미 존재하는 라이브러리도 다시 빌드를 한다.
하지만 gradle은 변경되지 라이브러리를 다시 빌드하지 않기 떄문에 시간이 더 단축되기 때문에 gradle을 사용하였습니다. gradle에서 현재 설정에 맞는 라이브러리 버전도 가져오기 때문에 관리도 쉽습니다.
