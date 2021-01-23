/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-23 01:46:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.challenge;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class challengeInsert_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>챌린지 등록 페이지</title>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/css/challenge/ch_insert.css\" type=\"text/css\">\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<!-- 해더 영역 -->\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<h2>챌린지 개설하기</h2>\r\n");
      out.write("\t\t<hr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/challenge/insert.do\" method=\"post\" \r\n");
      out.write("\t\t\tenctype=\"multipart/form-data\" role=\"form\" onsubmit=\"return noticeValidate();\">\r\n");
      out.write("\t\t\t<!-- 개설 정보 입력 -->\r\n");
      out.write("\t\t\t<div class=\"input\">\r\n");
      out.write("\t\t\t\t<label class=\"input-area\">제목</label>\r\n");
      out.write("\t\t\t\t<input type=\"text\" class=\"title-input\" id=\"chlngTitle\" name=\"chlngTitle\" placeholder=\"챌린지 제목을 입력해주세요.\"> <br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label class=\"input-area\">시작일</label>\r\n");
      out.write("\t\t\t\t<input type=\"date\" class=\"date str-date strDt\" id=\"strDt\" name=\"strDt\"> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label class=\"input-area\">종료일</label>\r\n");
      out.write("\t\t\t\t<input type=\"date\" class=\"date end-date endDt\" id=\"endDt\" name=\"endDt\"> \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<label class=\"input-area\">카테고리</label>\r\n");
      out.write("\t\t\t\t<select name=\"cate\" id=\"cate\" class=\"ch-cat\">\r\n");
      out.write("\t        \t\t\t<option value=\"10\">건강</option>\r\n");
      out.write("\t        \t\t\t<option value=\"20\">관계</option>\r\n");
      out.write("\t        \t\t\t<option value=\"30\">생활</option>\r\n");
      out.write("\t        \t\t\t<option value=\"40\">역량</option>\r\n");
      out.write("\t        \t\t\t<option value=\"50\">자산</option>\r\n");
      out.write("\t        \t\t\t<option value=\"60\">취미</option>\r\n");
      out.write("\t        \t\t\t<option value=\"70\">공부</option>\r\n");
      out.write("\t        \t\t\t<option value=\"80\">돈 관리</option>\r\n");
      out.write("\t        \t\t\t<option value=\"90\">그 외</option>\r\n");
      out.write("\t        \t</select>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<br><br>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<!-- 이미지 파일 업로드 -->\r\n");
      out.write("\t\t\t\t<div class=\"form-line\">\r\n");
      out.write("\t\t\t\t\t<label class=\"title-img\">대표 이미지 </label>\r\n");
      out.write("\t\t\t\t\t<div class=\"ch-board-Img chImg\" id=\"titleImgArea\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"titleImg\" width=\"200\" height=\"200\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div class=\"form-line-sb\">\r\n");
      out.write("\t\t\t\t\t<label class=\"t-img\">추가 설명<br>이미지</label>\r\n");
      out.write("\t\t\t\t\t<div class=\"ch-board-Img chImg\" id=\"contentImgArea1\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"contentImg1\" width=\"150\" height=\"150\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\t\t<div class=\"ch-board-Img chImg\" id=\"contentImgArea2\">\r\n");
      out.write("\t\t\t\t\t\t<img id=\"contentImg2\" width=\"150\" height=\"150\">\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div id=\"fileArea\">\r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img0\" name=\"img0\" onchange=\"LoadImg(this,0)\">     \r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img1\" name=\"img1\" onchange=\"LoadImg(this,1)\"> \r\n");
      out.write("\t\t\t\t\t<input type=\"file\" id=\"img2\" name=\"img2\" onchange=\"LoadImg(this,2)\">\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\t<!-- <div class=\"rule-area\">\r\n");
      out.write("\t\t\t\t\t<label class=\"input-area\">인증방법</label>\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" class=\"rule-input\">\r\n");
      out.write("\t\t\t\t</div> -->\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<br>\r\n");
      out.write("\t\t\t\t<div>소개하기</div>\r\n");
      out.write("\t\t\t\t<textarea class=\"form-control\" id=\"chlngContent\" name=\"chlngContent\" rows=\"15\" style=\"resize: none;\"\r\n");
      out.write("\t\t\t\t \t\t\tplaceholder=\"인증방법과 챌린지에 대해서 설명해주세요!\"></textarea>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<hr>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<!-- 완료, 목록 버튼 -->\r\n");
      out.write("\t\t\t<div class=\"text-center\">\r\n");
      out.write("\t\t\t\t<button type=\"submit\" class=\"btn\">완료</button>\r\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"btn\" onclick=\"location.href='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${header.referer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("'\">목록</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<!-- 푸터 영역 -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("    // 유효성 검사\r\n");
      out.write("    function noticeValidate() {\r\n");
      out.write("\t\tif ($(\"#challengeTitle\").val().trim().length == 0) {\r\n");
      out.write("\t\t\talert(\"제목을 입력해 주세요.\");\r\n");
      out.write("\t\t\t$(\"#challengeTitle\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif ($(\"#challengeContent\").val().trim().length == 0) {\r\n");
      out.write("\t\t\talert(\"내용을 입력해 주세요.\");\r\n");
      out.write("\t\t\t$(\"#challengeContent\").focus();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\t// 이미지 영역을 클릭할 때 파일 첨부 창이 뜨도록 설정하는 함수    //래디함수 : 페이지가 ㅎ로딩이 끝난후 실행\r\n");
      out.write("\t$(function(){\r\n");
      out.write("\t\t$(\"#fileArea\").hide(); // #fileArea 요소를 감춤\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\".chImg\").on(\"click\", function(){ //이미지 영역이 클릭이 되었을 때 \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t// 클릭한 이미지 영역 인덱스 얻어오기\r\n");
      out.write("\t\t\tvar index = $(\".chImg\").index(this);\r\n");
      out.write("\t\t\t\t\t// -> 클릭된 요소가 .noticeImg 중 몇번재 인덱스인지 반환\r\n");
      out.write("\t\t\tconsole.log(index);\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t// 클린된 영역 인덱스에 맞는 input file 태그 클릭\r\n");
      out.write("\t\t\t$(\"#img\" + index).click();\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\r\n");
      out.write(" \t// 각각의 영역에 파일을 첨부 했을 경우 미리 보기가 가능하도록 하는 함수\r\n");
      out.write("\tfunction LoadImg(value, num) {\r\n");
      out.write("\t\t// value.files : 파일이 선택되어 있으면 true\r\n");
      out.write("\t\t// value.files[0] : 여러 파일 중 첫번째 파일이 업로드 되어 있으면 true\r\n");
      out.write("\r\n");
      out.write("\t\tif (value.files && value.files[0]) { //해당 요소에 업로드된 파일이 있을 경우\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar reader = new FileReader();\r\n");
      out.write("\t\t\t// 자바스크립트 FileReader\r\n");
      out.write("\t\t\t// 웹 애플리케이션이 비동기적으로 데이터를 읽기 위하여 \r\n");
      out.write("\t\t\t// 읽을 파일을 가리키는 File 혹은 Blob객체를 이용해 \r\n");
      out.write("\t\t\t// 파일의 내용을 읽고 사용자의 컴퓨터에 저장하는 것을 가능하게 해주는 객체\r\n");
      out.write("\r\n");
      out.write("\t\t\treader.readAsDataURL(value.files[0]);\r\n");
      out.write("\t\t\t// FileReader.readAsDataURL()\r\n");
      out.write("\t\t\t// 지정된의 내용을 읽기 시작합니다. \r\n");
      out.write("\t\t\t// lob완료되면 result속성 data:에 파일 데이터를 나타내는 URL이 포함 됩니다.\r\n");
      out.write("\r\n");
      out.write("\t\t\treader.onload = function(e) {\r\n");
      out.write("\t\t\t\t// FileReader.onload\r\n");
      out.write("\t\t\t\t// load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료 되었을 때마다 발생합니다.\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t// 읽어들인 내용(이미지 파일)을 화면에 출력\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t$(\".chImg\").eq(num).children(\"img\").attr(\"src\",\r\n");
      out.write("\t\t\t\t\t\te.target.result); //num은 0,1,2,3 중 하나임\r\n");
      out.write("\t\t\t\t// e.target.result : 파일 읽기 동작을 성공한 요소가 읽어들인 파일 내용\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("    \t\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}