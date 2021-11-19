# 계획

## 새로 알게된 기술이나 공부하고 있는거 추가해보즈아~~

1. flyway -- [적용완료] 
   1. `db 스키마의 정합성을 체크`
      1. 내에 변화를 버전으로 관리하면서 checksum을 비교 
      2. checksum 값이 맞지 않으면 체크섬을 맞춰야함
2. mongo DB + WebFlux
   1. 몽고 + Mysql transactional 묶으려면 클러스터 구성 필요
3. Redis
4. Docker
   1. Docker-compose 구성항목
      1. mySql - 완료
      2. mongoDB - 예정
      3. Rabbit MQ - 예정
      4. Redis - 예정 
5. k8s..... 이건 아마 오랜시간 공부할 예정...
6. vue.js -> Test 용도, Utils 용도의 메소드를 사용하기 위해 API로 만들기 보다 개발자용 모니터 만들자 ... 요것도 공부 시간이 많이 필요...
7. Rabbit MQ - ddl 발생에 대한 history 저장 비동기 처리 용도?
### 도메인은 뭘 하지? 흠....
- -> 우선 환경 세팅 먼저 쭉 하자..