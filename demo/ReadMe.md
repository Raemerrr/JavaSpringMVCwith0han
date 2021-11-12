# 코로나19 예방접종 위탁의료기관 조회서비스
### [API 관련 문서](https://www.data.go.kr/iim/api/selectAPIAcountView.do#/API%20%EB%AA%A9%EB%A1%9D/GETlist)

#### 프로그램 정보
- URL : http://{ip}:port/api
  - Parameters
    - int page : default (1) - required false
    - int perPage : default (10) - required false
    - String returnType : default("JSON") - required false
    - String cond : default("") - required false
  
  - 예시 :  http://localhost:8080/api?page=2&perPage=5&cond=중구
  - page, perPage 파라미터에 대한 잘못된 입력에 대해 처리하는 로직이 들어있습니다.
    - 숫자 입력이 아닌 경우
    - int 범위를 벗어난 경우
    > 잘못된 입력이 있더라도 기본 값으로 검색이 가능하도록 하였습니다.

아주 간단한 프로젝트 진행하였습니다.
