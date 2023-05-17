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
		//request:������� ��û ���� ��ü, response:������ ������ ������ �ϴ� ��ü
		//request�� response�� ó���Ұž�
		//private void�� �޼ҵ� ����
		process(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post������� ��û�� �����ʹ� ���ڵ� ó���� �ʿ��ϱ� ������
		//post ������� url ȣ��� �� �ѱ� �ν��ϱ� ���� encoding
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Client ��û ���� ����
		String uri = request.getRequestURI();
		//���� �������� �ִ� / ���Ŀ� �ִ� �ּҸ� ��Եȴ�
		String path = uri.substring(uri.lastIndexOf("/"));
		
		//System.out.println("URI = " + uri);
		System.out.println("[PATH] = " + path);
		
		if(path.equals("/login.do")) {
			System.out.println("[Log-In] ó��");
			
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
			System.out.println("[�Խñ� ��� ��ȸ] ó��");
			
			BoardVO vo = new BoardVO();
			BoardDAO boardDao = new BoardDAO();
			List<BoardVO> boardList = boardDao.getBoardList();
			
			//����ڰ� ��û �� ������ �������� �ִ� ������� session�� ���� ������ �ִ� ������ ��Ī�����ְ�
			HttpSession session = request.getSession();
			session.setAttribute("boardList", boardList);
			
			//jsp ȣ���Ѵ�.
			response.sendRedirect("getBoardList.jsp");
		
		} else if(path.equals("/getBoard.do")) {
			System.out.println("[�Խñ� �� ��ȸ] ó��");
			// �Խñ� ��ȣ �Է°� ����
			///getBoard.do ȣ�� ������ seq �޾Ƽ� ����
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			BoardVO board = boardDao.getBoard(vo);
			
			//���� ȭ�� ����
			HttpSession session = request.getSession();
			session.setAttribute("board", board);
			
			//getBoard.jsp ���ǿ� ����� ������ ����ڿ��� ����
			response.sendRedirect("getBoard.jsp");
		
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("[�Խñ� ���] ó��");
			
			// 1. ����� �Է� ���� ����
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");
			
			// 2. DB ���� ó��
			BoardVO vo = new BoardVO();
				vo.setTitle(title);
				vo.setWriter(writer);
				vo.setContent(content);
			
			BoardDAO boardDAO = new BoardDAO();
			boardDAO.insertBoard(vo);
			
			// 3. ȭ�� �׺���̼�
			//getBoardList.do�� ������ ������ �����͸� �����ͼ� ȭ���� ����ؾ� �ϱ� ����.
			//.jsp�� �ϰ� �Ǹ� ȭ�鸸 ǥ��ǰ� �����ʹ� �������� �ʱ� ������ .do�� �ҷ��;��Ѵ�.
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("[�Խñ� ����] ó��");

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
			System.out.println("[�Խñ� ����] ó��");
			
			String seq = request.getParameter("seq");

			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO boardDao = new BoardDAO();
			boardDao.deleteBoard(vo);
			
			response.sendRedirect("getBoardList.do");
		
		} else if(path.equals("/logout.do")) {
			System.out.println("[Log-Out] ó��");

			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("login.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
