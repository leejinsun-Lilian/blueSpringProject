/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-01-16 19:43:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1610674708861L));
    _jspx_dependants.put("jar:file:/C:/Users/user/Desktop/dev/workspace/Semi/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/BlueSpring/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

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
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"ko\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>푸른봄에 오신 것을 환영합니다.</title>\r\n");
      out.write("    <script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"resources/css/main.css\" type=\"text/css\">\r\n");
      out.write("    \r\n");
      out.write("    <!-- Bootstrap core CSS -->\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\">\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- Bootstrap core JS -->\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.5.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"wrapper\">\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/views/common/header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"title\">\r\n");
      out.write("\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/admin/adminMain.do\"><img id=\"mainImg\" src=\"resources/img/mainImg.png\"></a>\r\n");
      out.write("\t\t\t<form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/main/mainSearchPage.do\" method=\"get\" name=\"search_input\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"search_input\" class=\"input\" placeholder=\"관심있는 내용을 검색해 보세요!\">\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"content\">\r\n");
      out.write("\t\t\t<div class=\"board\">\r\n");
      out.write("\t\t\t\t<div class=\"board_item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"board_title\">정부정책</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_content\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-sm table-borderless\">\r\n");
      out.write("\t\t\t\t\t\t  <tbody>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">1</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">코로나블루 토닥토닥...광명시 ‘마음카페’ 개소</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">2</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">정부, 3971억 규모 근로장려금 지급</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">3</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">서울시 상담 센터 블루터치 사이트 안내</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">4</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">서울시, '코로나 블루' 검진·상담비용 8만원 지원</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\t\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">5</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">코로나19 확진자 대상 비대면 정신 상담 서비스 운영</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">6</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">\"코로나 우울 극복해요\" 앱·전화상담으로 '마음건강' 회복 지원</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">7</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">세종시 울적한 마음 카카오톡 상담 위로</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t  </tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_more\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/notice/list.do\">더보기</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"board_item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"board_title\">자유게시판</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_content\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-sm table-borderless\">\r\n");
      out.write("\t\t\t\t\t\t  <tbody>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[자유]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">동네 상담 센터에 상담 다녀온 후기</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[고민]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">코로나에 걸릴까봐 너무 무서워요 ㅠㅠ</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[취미]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">요즘 할게 없어서 이것 저것 한 것 올려봅니다</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[자유]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">작년부터 코딩 배우는 중입니다.</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[일상]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">수세미 뜨개질 해서 친구들 선물해줬어요!</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[자유]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">새해 기념 음악방송 합니다. 들어오세요.</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\t\t\t\t\t    \t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t  </tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_more\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/board/list.do\">더보기</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"board_item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"board_title\">챌린지목록</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_content\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-sm table-borderless\">\r\n");
      out.write("\t\t\t\t\t\t  <tbody>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[취미]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">미니멀 리스트 도전하기 (하루에 1개씩 물건 버리기)</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[역량]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">일주일에 정해진 책 1권 읽기</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[취미]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">원격 방송으로 주말에 함께 노래 듣기</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[건강]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">매일 30분씩 런데이/산책 하기</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[돈관리]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">하루에 10000원 이하로 지출 하기</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[공부]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">매일 2시간 공부 하기 (공부 주제: 자유)</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[취미]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">뜨개질 만들기 (이번주: 곱창밴드)</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\r\n");
      out.write("\t\t\t\t\t\t    \t\t\t    \r\n");
      out.write("\t\t\t\t\t\t  </tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_more\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/challenge/list.do\">더보기</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div class=\"board_item\">\r\n");
      out.write("\t\t\t\t\t<div class=\"board_title\">인증게시판</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_content\">\r\n");
      out.write("\t\t\t\t\t\t<table class=\"table table-sm table-borderless\">\r\n");
      out.write("\t\t\t\t\t\t  <tbody>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[취미]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">미니멀 리스트 도전 (문제집 버렸어요.)</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[건강]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">01/12 조깅 30분 (런데이어플) 사진 인증합니다.</a></td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[역량]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">01/12 '시선으로부터' 완독 후기</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[취미]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">미니멀 리스트 도전 (옷 버리기)</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[건강]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">01/12 산책 30분 인증합니다.</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[공부]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">하루에 공부 2시간 (영어 공부 인증)</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\r\n");
      out.write("\t\t\t\t\t\t    <tr>\r\n");
      out.write("\t\t\t\t\t\t      <th scope=\"row\">[돈관리]</th>\r\n");
      out.write("\t\t\t\t\t\t      <td colspan=\"3\"><a href=\"#\">하루 지출 10000원 이하 하기 인증합니다.</a><td>\r\n");
      out.write("\t\t\t\t\t\t    </tr>\t\t\t\t\t    \r\n");
      out.write("\t\t\t\t\t\t  </tbody>\r\n");
      out.write("\t\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\t<div class=\"board_more\">\r\n");
      out.write("\t\t\t\t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/challengeCrtfd/list.do\">더보기</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div style=\"clear: both;\"></div>\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "WEB-INF/views/common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
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
