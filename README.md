🗝️ Secret Diary API
개인 일기를 안전하게 기록하고 관리할 수 있는 RESTful API입니다.
Spring Boot 기반으로 제작되었으며, 비밀번호를 입력해야만 조회·수정·삭제할 수 있는 비공개 일기장 서비스입니다.

📌 프로젝트 개요
이 프로젝트는 Spring Boot를 활용하여 만든 비공개 다이어리 API입니다.
사용자는 비밀번호를 입력해 다이어리를 작성하고, 해당 비밀번호가 있어야만 해당 글을 조회, 수정, 삭제할 수 있도록 구현했습니다.

게시판 API 구조를 기반으로 기능을 확장하며 JPA, Controller, DTO, Service 간의 역할을 학습했습니다.

🛠 기술 스택
Java 17

Spring Boot 3.x

Spring Data JPA

H2 Database (인메모리 테스트 DB)

Lombok

Postman (API 테스트)

⚙️ 주요 기능
✍️ 일기 작성

제목, 내용, 작성자, 비밀번호 입력

🔐 일기 조회

id와 password를 함께 입력해야 조회 가능

🛠 일기 수정

비밀번호 일치 시에만 수정 가능

❌ 일기 삭제

비밀번호 일치 시에만 삭제 가능

❗ 전체 조회 기능은 제공하지 않음 (비공개 서비스 특성상)

🔍 학습 포인트
@RestController, @RequestMapping, @PostMapping, @GetMapping 등 RESTful 구조 이해

ResponseEntity를 사용해 HTTP 상태코드 기반 응답 처리

JPA는 기본 생성자가 반드시 필요하다는 사실과 이유 학습 (Reflection 기반 객체 생성)

DTO의 역할 구분:

RequestDto는 @Setter, @Getter

ResponseDto는 @Getter만 사용

H2 콘솔 연결 및 application.properties 구성법

📂 폴더 구조
bash
src/
├── controller/
├── domain/
├── dto/
├── repository/
└── service/
📑 상세 기록 (Notion)
학습 과정, 깨달은 점, 문제 해결 과정은 아래 노션 문서에 정리되어 있습니다.

👉 [Notion 링크 바로가기](https://peridot-chicken-4e7.notion.site/23f26275352480ab8cd1c93817a9eb39?source=copy_link)

🧪 실행 방법
프로젝트 클론

bash
git clone https://github.com/your-repo/secret-diary.git
IDE (IntelliJ 등)로 열기

main/resources/application.properties 확인
(H2 메모리 DB 사용 중)

실행 후 Postman으로 아래 API 요청

작성: POST /diary

조회: GET /diary/{id}?password=1234

수정: PUT /diary/{id}?password=1234

삭제: DELETE /diary/{id}?password=1234
