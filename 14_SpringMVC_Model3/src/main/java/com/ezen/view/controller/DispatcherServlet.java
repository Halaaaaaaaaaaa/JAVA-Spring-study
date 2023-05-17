package com.ezen.view.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet("/DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // DispatcherServlet 최초 호출시 초기화 수행
    // HandlerMapping, ViewResolver 객체 초기화
	@Override
	public void init() throws ServletException {
		super.init();
		
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}




	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST방식으로 요청한 데이터는 인코딩 처리 필요
		request.setCharacterEncoding("UTF-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// (1) Client 요청 정보를 추출
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		
		System.out.println("[PATH] = "+path);

		// (2) HandlerMapping에서 path에 해당하는 Controller 조회
		Controller controller = handlerMapping.getController(path);
		
		// (3) 위에서 조회한 Controller 실행
		String viewName = controller.handleRequest(request, response);
		
		// (4) ViewResolver를 통해 view 조립
		//webapp 하위에 있는 파일들이 접두사 ./ 접미사 .jsp로 되어 있는 파일들이니
		//.jsp 는 조립하지 않고 그 외의 파일만 조립을 하여 view 에 들어간다.
		String view = "";
		if(viewName.contains(".do")) {
			view = viewName;
		} else {
			view = viewResolver.getView(viewName);
		}
		response.sendRedirect(view);
	}

}





