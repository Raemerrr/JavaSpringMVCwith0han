# 스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술
## 웹 애플리케이션 이해
### 웹 서버, 웹 애플리케이션 서버
- 웹 서버(Web Server)
    - HTTP 기반으로 동작
    - 정적 리소스 제공, 기타 부가기능
    - 정적(파일) HTML, CSS, JS, 이미지,영상
    - 예) NGINX, APACHE
    > 🔥정적인 파일을 들고 제공하기 때문에 HTML을 특정 사용자 마다 다르게 보여줄 수 없다.
- 웹 애플리케이션 서버(WAS - WebApplication Server)
    - HTTP 기반으로 동작
    - 웹 서버 기능 포함 + (정적 리소스제공 가능)
    - 프로그램 코드를 실행해서 애플리케이션로직 수행
        - 동적 HTML, HTTP API(JSON)
        - 서블릿, JSP, 스프링 MVC
    - 예) 톰캣(Tomcat) Jetty, Undertow
    > 🔥프로그램 코드를 실행해서 HTML을 특정 사용자 마다 다르게 보여줄 수 있다.
- 웹 서버(Web Server) vs 웹 애플리케이션 서버(WAS - WebApplication Server)
    - 여러 가지 플러그인 등 추가적인 기능으로 둘의 차이가 모호하다.
    - ⭐결론적으로 WAS는 애플리케이션 코드를 실행하는데 특화되어있다.

- 웹 구성 방식
    - WAS가 많은 기능을 포함할 경우 WAS가 이상이 생기면 오류 페이지를 띄어줄 수 없다.
        - WAS에서 정적인 리소스와 애플리케이션 로직을 모두 처리한다.
            <table>
              <tr>
                <th align="center" colspan="3">WAS</th>
              </tr>
              <tr>
                <td align="center">HTML</td>
                <td align="center">CSS</td>
                <td align="center">JS</td>
              </tr>
              <tr>
                <td align="center" colspan="3">리소스</td>
              </tr>
              <tr>
                <td align="center" colspan="3">애플리케이션로직</td>
              </tr>
            </table>
    - 일반적으론 WAS 앞에 Web Server를 두고 오류 페이지를 띄어 줄 수 있도록 한다.
        - Web Server에서 정적인 부분을 처리하고
            <table>
              <tr>
                <th align="center" colspan="3">Web Server</th>
              </tr>
              <tr>
                <td align="center">HTML</td>
                <td align="center">CSS</td>
                <td align="center">JS</td>
              </tr>
              <tr>
                <td align="center" colspan="3">리소스</td>
              </tr>
            </table>
        - WAS에서는 애플리케이션 로직에 집중할 수 있도록 한다.
            <table>
              <tr>
                <th align="center">WAS</th>
              </tr>
              <tr>
                <td align="center">애플리케이션 로직</td>
              </tr>
            </table>
        > ⭐WAS가 비정상이라면 Web Server에서 오류 페이지를 띄어주도록 한다.
### 서블릿
- 서버에서 처리해야 하는 업무
    <table>
      <tr>
        <td align="center">구분</td>
        <td align="center">업무</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">서버 TCP/IP 연결 대기, 소켓 연결</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">HTTP 요청 메세지를 파싱해서 읽기</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">POST 방식, /행위 URL 인지</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">Content-Type 확인</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">HTTP 메세지 바디 내용 파싱</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">행위 프로세스 실행</td>
      </tr>
      <tr>
        <td align="center" colspan="2"><strong>비즈니스 로직 실행</strong></td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">HTTP 응답 메세지 생성 시작</td>
      </tr>
      <tr>
        <td align="center">Servlet</td>
        <td align="center">TCP/IP에 응답 전달, 소켓 종료</td>
      </tr>
    </table>
    > ⭐개발자는 비즈니스 로직만 개발하고 나머지 부분은 서블릿을 이용하여 HTTP 스펙을 매우 편리하게 사용한다.
### HTML, HTTP API, CSR, SSR
- SSR - 서버 사이드 렌더링
  - HTML 결과를 서버에서 만들어서 웹 브라우저에 전달
  - 주로 정적인 화면에 사용
  - 관련 기술 : JSP, 타임리프 -> 백엔드 개발자
- CSR - 클라이언트 사이드 렌터링
  - HTML 결과를 자바스크립트를 사용해 웹 브라우저에서 동적으로 생성해서 적용
  - 주로 동적인 화면에 사용, 웹 환경을 마치 앱 처럼 필요한 부분부분 변경할 수 있음
  - 예) 구글 지도, Gmail, 구글 캘린더
  - 관련 기술 : React.js, Vue.js -> 웹 프론트엔드 개발자
- 참고
  - React.js, Vue.js를 CSR + SSR 동시에 지원하는 웹 프레임워크도 있음
  - SSR을 사용하더라도, 자바스크립트를 사용해서 화면 일부를 동적으로 변경 가능
