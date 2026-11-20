# beadv8_1_chzzk_BE

Spring Boot 4.2 / Java 25 / Gradle(Kotlin 문법) 백엔드 개인 프로젝트다.

## 기술 스택

- 웹: Spring Web MVC, Validation
- DB: MySQL, Spring Data JPA, Flyway(`src/main/resources/db/migration`)
- 기타: Lombok, DevTools
- 시험: JUnit 5, Testcontainers(MySQL)
- 기본 패키지: `com.chzzk`
- 설정 파일: `src/main/resources/application.yaml`

## 규칙

- 주석, 커밋 메시지, 문서는 한국어로 쓴다. 클래스·변수·메서드 이름은 영어로 짓는다.
- 브랜치, 커밋 메시지, PR은 `docs/CONVENTION.md`를 따른다. 파일을 고치기 전에 이슈를 만들고 `dev`에서 `<유형>/<이슈번호>` 브랜치부터 딴다.
- 커밋과 PR에는 AI 표기(`Co-Authored-By`, `Generated with`)를 넣지 않는다.
- 엔티티를 추가하거나 고치면 Flyway 마이그레이션을 함께 추가한다. 이미 적용된 마이그레이션은 고치지 않는다.
- `.env`, 비밀번호, 토큰은 커밋하지 않는다.
