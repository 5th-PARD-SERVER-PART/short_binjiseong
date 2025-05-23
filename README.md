
## 📌 GitHub Repository
- [[5th PARD SERVER - GaehwaNane (GitHub)](https://github.com/5th-PARD-SERVER-PART/GaehwaNane.git)](https://github.com/5th-PARD-SERVER-PART/short_binjiseong.git)

## 🗂 ERD
- (ERD 이미지 또는 링크를 여기에 삽입해 주세요)

## 🔗 Swagger API 문서
- [Swagger UI 바로가기]([http://172.18.142.173:8080/swagger-ui/index.html#](http://172.18.137.90:8080/swagger-ui/index.html))

## 🔄 클백 연결표

| 순서 | 기능 설명 | API Endpoint | 메서드 | 비고 |
|------|-----------|---------------|--------|------|
| 1 | 사용자 이름 입력 및 초기화 | `/progress/init` | `POST` | 사용자 진행 상황 초기화 |
| 2 | 질문 전체 조회 | `/question` | `GET` | 모든 질문 불러오기 |
| 3 | 다음 질문 요청 | `/question/next?userName={userName}` | `GET` | 사용자 진행 기반 질문 반환 |
| 4 | 응답 제출 | `/response` | `POST` | 질문 응답 리스트 저장 |
| 5 | 결과 반환 | `/response/{userId}` | `GET` | 사용자 결과 분석 및 반환 |

---
