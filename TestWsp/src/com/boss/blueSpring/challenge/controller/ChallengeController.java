package com.boss.blueSpring.challenge.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.boss.blueSpring.challenge.model.service.ChallengeService;
import com.boss.blueSpring.challenge.model.vo.Attachment;
import com.boss.blueSpring.challenge.model.vo.Challenge;
import com.boss.blueSpring.challenge.model.vo.PageInfo;
import com.boss.blueSpring.common.MyFileRenamePolicy;
import com.boss.blueSpring.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/challenge/*")
public class ChallengeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 요청이 들어오는 주소 
		String contextPath = request.getContextPath();
		String command = uri.substring((contextPath + "/challenge").length()); 
		
		String path = null;
		RequestDispatcher view = null;
		
		String errorMsg = null;
		
		try {
			ChallengeService service = new ChallengeService();
			
			String cp = request.getParameter("cp");
			
	 
			//챌린지 목록 페이지 이동
			if(command.equals("/list.do")) {
				
				String sort = request.getParameter("sort");

				PageInfo pInfo = service.getPageInfo(cp);

//				if(request.getParameter("cn") != null) {
//				}
//				List<Challenge> list = service.selectList(pInfo, sort, cn);
				List<Challenge> list = service.selectList(pInfo, sort);
				
				
				path="/WEB-INF/views/challenge/challengeList.jsp";
				request.setAttribute("list", list);
				request.setAttribute("pInfo", pInfo);

				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			else if(command.equals("/view.do")) {
				HttpSession session = request.getSession(); 
				int challengeNo = Integer.parseInt(request.getParameter("no"));
				int memberNo = 0;
				
				
				//좋아요
//				Member member = (Member)session.getAttribute("loginMember");		
//				if(member != null) { //로그인한 멤버가 있으면
//					memberNo = member.getMemberNo(); 
//				}
//				Like likeInfo = service.selectLike(challengeNo, memberNo);
				Challenge challenge = service.selectChallenge(challengeNo);
				
				// 이미지 파일 조회 부분
				//List<Attachment> cList = service.selectChallengeFiles(challengeNo);
				
//				if(!cList.isEmpty()) {
//					request.setAttribute("cList", cList);
//				}
				
				path="/WEB-INF/views/challenge/challengeView.jsp";
				request.setAttribute("challenge", challenge);
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 챌린지 삽입 폼 컨트롤러 ********************************************ㄴ
			else if(command.equals("/insertForm.do")) {
				path="/WEB-INF/views/challenge/challengeInsert.jsp";
				view = request.getRequestDispatcher(path);
				view.forward(request, response);
			}
			
			// 챌린지 등록 컨트롤러***************************************************************************
			else if(command.equals("/insert.do")) {
				
				errorMsg = "챌린지 삽입 과정에서 오류 발생";
				
				int maxSize = 20 * 1024 * 1024; // 20MB == 20 * 1024KB == 20 * 1024 * 1024Byte
				
				String root = request.getSession().getServletContext().getRealPath("/");
				String filePath = root + "resources/uploadImages/challenge/";
				
				MultipartRequest multiRequest 
					= new MultipartRequest(request, filePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
				// 전달 받은 파일 정보를 저장
				List<Attachment> cList = new ArrayList<Attachment>();
				
				Enumeration<String> files = multiRequest.getFileNames();
				
				while(files.hasMoreElements()) { // 다음 요소가 있다면
					String name = files.nextElement(); //img0
					
					if(multiRequest.getFilesystemName(name) != null) {
						Attachment temp = new Attachment();
						
						temp.setFileName(multiRequest.getFilesystemName(name));
						temp.setFilePath(filePath);
						
						// name 속성에 따라 fileLevel 지정
						int fileLevel = 0;
						switch(name) {
						case "img0" : fileLevel = 0; break;
						case "img1" : fileLevel = 1; break;
						case "img2" : fileLevel = 2; break;
						}
						
						temp.setFileLevel(fileLevel);
						
						// fList에 추가
						cList.add(temp);
					}
				} // end while
				
				
				//insert.jsp에서 입력받은거를 얻어와!1!!!!!!!
				String chlngTitle = multiRequest.getParameter("chlngTitle");
				String chlngContent = multiRequest.getParameter("chlngContent");
				String chlngStartDt = multiRequest.getParameter("strDt");         
				String chlngEndDt = multiRequest.getParameter("endDt");          
				int chlngCateNo = Integer.parseInt(multiRequest.getParameter("cate"));

				System.out.println(chlngTitle);
				System.out.println(chlngContent);
				System.out.println(chlngStartDt);
				System.out.println(chlngEndDt);
				System.out.println(chlngCateNo);
				
				// 세션에서 로그인한 회원의 번호를 얻어옴
				//Member loginMember = (Member)request.getSession().getAttribute("loginMember"); 
				
				HttpSession session = request.getSession();
			    Member loginMember = (Member)session.getAttribute("loginMember");
			    int chlngeWriter = loginMember.getMemberNo();
			    System.out.println(loginMember);
				
				System.out.println(chlngeWriter);
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("cList", cList);
				map.put("chlngTitle", chlngTitle);
				map.put("chlngContent", chlngContent);
				map.put("chlngStartDt", chlngStartDt);
				map.put("chlngEndDt", chlngEndDt);
				map.put("chlngCateNo", chlngCateNo);
				map.put("chlngeWriter", chlngeWriter);
				
				System.out.println(map);
				
				int result = service.insertChallenge(map);
				System.out.println("result : " + result);
				
				if(result > 0) { // DB 삽입 성공 시 result에는 삽입한 글 번호가 저장되어있다.
					//swalIcon = "success";
					//swalTitle = "챌린지 등록 성공";
					path = "view.do?cp=1&no=" + result;
				}
					else {
//					swalIcon = "error";
//					swalTitle = "챌린지 등록 실패";
					path = "list.do";
				}
//				request.getSession().setAttribute("swalIcon", swalIcon);
//				request.getSession().setAttribute("swalTitle", swalTitle);
				System.out.println("path : " + path);
				
				response.sendRedirect(path);
			}
			
			
			// 챌린지 수정 폼
			
			// 챌린지 수정
			
			// 챌린지 삭제 ****************************************************
			else if(command.equals("/delete.do")) {
				
				errorMsg = "챌린지 미션 삭제 과정에서 오류 발생";
				
				int chlngNo = Integer.parseInt(request.getParameter("no"));
				
				int result = service.updateChFl(chlngNo);
				
				if(result > 0) {
					path = "list.do";
				}else {
					path = request.getHeader("referer");
				}
				response.sendRedirect(path);
			}
				
			
			// 챌린지 좋아요
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
			
		}
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
