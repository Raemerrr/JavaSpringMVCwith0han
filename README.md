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
