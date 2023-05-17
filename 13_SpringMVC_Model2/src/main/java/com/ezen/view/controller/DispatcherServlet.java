package com.ezen.view.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ezen.biz.dao.BoardDAO;
import com.ezen.biz.dao.UserDAO;
import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.dto.UserVO;

/**
 * Servlet implementation class DispatcherServlet
 */
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request:사용자의 요청 정보 객체, response:내용을 가지고 응답을 하는 객체
		//request와 response를 처리할거얌
		//private void로 메소드 생성
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식으로 요청한 데이터는 인코딩 처리가 필요하기 때문에
		//post 방식으로 url 호출될 시 한글 인식하기 위한 encoding
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Client 요청 정보 추출
		String uri = request.getRequestURI();
		//제일 마지막에 있는 / 이후에 있는 주소를 찍게된다
		String path = uri.substring(uri.lastIndexOf("/"));
		
		//System.out.println("URI = " + uri);
		System.out.println("[PATH] = " + path);
		
		if(path.equals("/login.do")) {
			System.out.println("[Log-In] 처리");
			
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			
			UserVO vo = new UserVO();
			vo.setId(id);
			vo.setPassword(password);
			
			UserDAO userDao = new UserDAO(); 
			UserVO user = userDao.getUser(vo);
			
			if (user != null) {
				response.sendRedirect("getBoardList.do");
			} else {
				response.sendRedirect("login.jsp");
			}
		
		} else if(path.equals("/getBoardList.do")) {
			System.out.println("[게시글 목록 조회] 처리");
			
			BoardVO vo = new BoardVO();
			BoardDAO boardDao = new BoardDAO();
			List<BoardVO> boardList = boardDao.getBoardList();
			
			//사용자가 요청 시 서버와 브라우저에 있는 사용자의 session을 통해 서버에 있는 정보를 매칭시켜주고
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			//jsp 호출한다.
			response.sendRedirect("getBoardList.jsp");
		
		} else if(path.equals("/getBoard.do")) {
			System.out.println("[게시글 상세 조회] 처리");
			// 게시글 번호 입력값 추출
			///getBoard.do 호출 받으면 seq 받아서 전달
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			BoardVO board = boardDao.getBoard(vo);
			
			//응답 화면 구성
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//getBoard.jsp 세션에 저장된 내용을 사용자에게 전달
			response.sendRedirect("getBoard.jsp");
		
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("[게시글 등록] 처리");
			
			// 1. 사용자 입력 정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. 화면 네비게이션
			//getBoardList.do로 보내는 이유는 데이터를 가져와서 화면을 출력해야 하기 때문.
			//.jsp로 하게 되면 화면만 표출되고 데이터는 가져오지 않기 때문에 .do로 불러와야한다.
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("[게시글 수정] 처리");

			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			String seq = request.getParameter("seq");
			
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			boardDao.updateBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("[게시글 삭제] 처리");
			
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			boardDao.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/logout.do")) {
			System.out.println("[Log-Out] 처리");

			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
