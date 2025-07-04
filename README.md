# 방탈출 예약

## 기능 목록 정리

### 회원 관련

- 로그인
    - 이메일과 비밀번호로 로그인
    - 로그인 시 JWT 발급
    - 로그인 시 JWT를 쿠키에 저장
        - JWT는 만료시간이 존재

- 회원가입
    - 이메일은 중복 불가
    - 비밀번호 암호화

- 로그인 상태 확인
    - JWT를 통해 로그인 상태 확인

- 로그아웃 (회원)
    - JWT는 쿠키에 저장되어 있으므로 쿠키 삭제

### 예약 관련

- 예약 생성 (회원)
    - 동일한 날짜, 시간, 테마 예약 불가
    - 예약 시 테마와 예약 시간을 선택
    - 결제 정보를 통해 결제 요청을 보내고, 승인될 경우 예약 확정

- 예약 대기 생성 (회원)
    - 예약이 존재하는 날짜, 시간, 테마에 예약을 시도할 경우 대기 예약 생성
    - 대기 예약은 예약이 취소되면 자동으로 예약으로 전환
    - 대기 예약은 동일한 날짜, 시간, 테마로 중복 불가
    - 이미 해당 날짜, 시간, 테마에 대한 예약이 존재하는 회원일 경우 대기 생성 불가

- 예약 삭제 (회원)
    - 만약 예약 대기가 존재한다면 가장 빠른 예약 대기를 예약으로 전환

- 내 예약 목록 조회 (회원)
    - 회원이 예약한 모든 예약과 대기 목록을 조회

- 예약 시간 목록 조회 (회원)

- 예약 시간 생성 (관리자)
    - 예약 시간은 중복 불가

- 예약 시간 삭제 (관리자)
    - 예약에서 참조 중인 시간은 삭제 불가능

- 예약 가능 시간 조회 (회원)

- 예약 대기 목록 조회 (관리자)

- 예약 대기 삭제 (관리자)

- 테마 목록 조회 (회원)

- 테마 생성 (관리자)

- 테마 삭제 (관리자)
    - 예약에서 참조 중인 테마는 삭제 불가능

- 인기 테마 조회
    - 최근 7일간 예약 수가 많은 상위 10개의 테마 목록 조회

- 테마 예약 가능 여부 조회 (회원)

### 관리자 관련

- 전체 회원 목록 조회 (관리자)
- 전체 예약 조회 (관리자)
- 전체 예약 검색 (관리자)
    - 회원, 테마, 시작일, 종료일을 통해 예약 목록 조회

## 엔드포인트 정리

### 회원 관련

- [x] `POST /login`  
  로그인


- [x] `GET /signup`  
  회원가입


- [x] `GET /login/check`
  로그인 상태 확인


- [x] `POST /logout`  
  로그아웃

---

### 예약 관련

- [x] `GET /reservations`  
  모든 예약 목록 조회

- [x] `GET /waitings`  
  모든 예약 대기 목록 조회

- [x] `GET /reservations/times`  
  날짜와 테마에 따른 예약 가능 여부를 포함한 시간 목록 조회


- [x] `POST /reservations`  
  예약 또는 대기 생성


- [x] `DELETE /reservations/{id}`  
  예약 삭제
    - 예약에서 참조 중인 시간은 삭제 불가능
    - 만약 예약 대기가 존재한다면 가장 빠른 예약 대기를 예약으로 전환


- [x] `GET /reservations/mine`  
  나의 예약 및 대기 목록 조회


- [x] `DELETE /waitings/{id}`  
  예약 대기 삭제

---

### 예약 시간 관련

- [x] `GET /times`  
  모든 예약 시간 목록 조회


- [x] `POST /times`  
  예약 시간 생성


- [x] `DELETE /times/{id}`  
  예약 시간 삭제

---

### 테마 관련

- [x] `GET /themes`  
  모든 테마 목록 조회


- [x] `POST /themes`  
  테마 생성


- [x] `DELETE /themes/{id}`  
  테마 삭제


- [x] `GET /themes/ranking`
  인기 테마 조회

  
---

### 사용자 페이지

- [x] `GET /login`  
  로그인 페이지


- [x] `GET /signup`  
  회원가입 페이지

---

### 관리자 페이지

- [x] `GET /admin`  
  어드민 메인 페이지


- [x] `GET /admin/reservation`  
  예약 관리용 페이지


- [x] `GET /admin/time`  
  예약 시간 관리 페이지


- [x] `GET /admin/theme`  
  테마 관리 페이지


- [x] `GET /admin/waiting`
  예약 대기 관리 페이지

---

### 회원 페이지

- [x] `GET /`  
  인기 테마 페이지


- [x] `GET /reservation`  
  회원 예약 페이지


- [x] `GET /reservation-mine`
  나의 예약 페이지
