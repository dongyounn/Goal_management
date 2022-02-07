# 계획

## 목표 달성을 도와주는 API

시나리오

ㄴ 회원으로 가입한다

ㄴ 방장으로서 방을 만들어서 목표를 만든다 ex 1일 1커밋, 기상시간 약속, 운동 등등

ㄴ 목표 달성시 리워드 지급 - 추첨권

ㄴ 매주 추첨 배치

인증 -> 승인 으로 처리

승인 3일 안에 안하면 자동 승인

이미지 저장 그냥 mysql 에 하자 (귀찮)

다 만들면 k8s (kustomize 로 빌드 배포 가지가 목표) - argo



1. flyway -- [적용완료] 
   1. `db 스키마의 정합성을 체크`
      1. 내에 변화를 버전으로 관리하면서 checksum을 비교 
      2. checksum 값이 맞지 않으면 체크섬을 맞춰야함
2. mongo DB + WebFlux

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
