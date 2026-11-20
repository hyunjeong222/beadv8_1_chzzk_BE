# beadv8_1_chzzk_BE

실시간 라이브 방송 플랫폼의 백엔드다. PC 화면 공유와 휴대폰 카메라로 방송을 송출하고, 다른 기기에서 시청한다.

- 프론트엔드: [beadv8_1_chzzk_FE](https://github.com/hyunjeong222/beadv8_1_chzzk_FE)
- 기술: Java 25, Spring Boot 4.2, MySQL, Flyway, MediaMTX

## 실행 방법

```bash
cp .env.example .env   # 값 채우기
docker compose up -d   # 로컬 MySQL
./gradlew bootRun
```
