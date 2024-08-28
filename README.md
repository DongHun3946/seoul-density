# 서울시 장소별 인구혼잡도

## 👨‍🏫 프로젝트 소개
서울시 내 명소들의 인구 혼잡도를 사용자들이 쉽게 볼 수 있도록 하기 위한 웹사이트입니다.
## ⏲️ 개발 기간
- 2024/07/13 ~ 2024/08/25
## 🧑‍🤝‍🧑 개발자 소개
- 최동훈
## 💻 개발환경
- Version : Java 17
- IDE : IntelliJ
- Framework : SpringBoot 3.3.1
- ORM : JPA
## ⚙️ 기술 스택
- Server : AWS EC2
- DataBase : AWS RDS(MySQL)
- WS/WAS : Tomcat
## 📝 프로젝트 아키텍쳐
![image](https://github.com/user-attachments/assets/ee4cba42-a94f-4e98-a6ab-993712b66118)
## 📌 주요 기능
- 장소별 인구 혼잡도 정보 제공
  - 서울 열린데이터광장에서 제공하는 
- 장소 검색
- 장소별 댓글 등록
## 📌 배운점
- RestTemplate을 활용하여 API를 호출하는 방식
- RestTemplate 은 동기식으로 처리하여 API를 호출하는데 42ms나 걸리지만 각 스레드마다 비동기식으로 처리하는 CompletableFuture 를 사용하여 호출시간을 4~7ms로 줄일 수 있었다. 
## ✒️ API
- 사용한 API : <https://data.seoul.go.kr/dataList/OA-21778/A/1/datasetView.do>
