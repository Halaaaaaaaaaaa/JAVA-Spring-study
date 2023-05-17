package com.ezen.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.ezen.biz.dto.BoardVO;
import com.ezen.biz.service.BoardService;

//각 기능의 클래스마다 controller 해주기보다 하나의 컨트롤러를 만들어서 구현
@Controller
//"board"라는 속성 이름으로 model 객체에 데이터 저장 시 세션에도 동시에 저장된다.
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do") //요청에 대한 맵핑
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException { //스프링 프레임워크에서 객체를 자동적으로 생성
		
		System.out.println("[게시글 등록] 처리");
		
		//파일 업로드 처리
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("[파일 이름] " + fileName);
			uploadFile.transferTo(new File("D:/upload/" + fileName));
		}
		
		//2. DB 연동 처리
		//boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		
		// 3. 화면 네비개이션
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")	
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		//세션에 저장된 데이터를 사용하기 위해서 @ModelAttribute 사용하여 BoardVO에도 저장
		System.out.println("[게시글 수정] 처리");

		//boardDao.updateBoard(vo);
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String GetBoard(BoardVO vo, Model model) {
		
		System.out.println("[게시글 상세 조회] 처리");
		// 게시글 번호 입력값 추출
		///getBoard.do 호출 받으면 seq 받아서 전달
		BoardVO board = boardService.getBoard(vo);
	
		//응답화면 구성
		//@Sessionattribues가 설정 되어 있으면 세션에도 동시 저장된다.
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	//검색 조건 목록 설정
	@ModelAttribute("conditionMap") 
	public Map<String, String> searchConditionMap() { 
		
		Map<String, String> conditionMap = new HashMap<>(); 
		
		conditionMap.put("제목", "TITLE"); 
		conditionMap.put("내용", "CONTENT");
		//conditionMap.put("작성자", "WRITER");
		
		return  conditionMap; 
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,
			//검색 기능
			//@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			//@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			Model model) {
		
		System.out.println("[게시글 목록 조회] 처리");
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		//검색 조건, 검색어 출력
		System.out.println("[검색조건] " + vo.getSearchCondition());
		System.out.println("[검 색 어] " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		//화면 응답 처리
		//ModelAndView에 값을 저장해서 리턴해줄거기 때문에 세션이 필요가 없엉
		//DB에서 조회한 내용을 화면에 전달하기 위해 내장객체에 저장
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, Model model) {
		
		System.out.println("[게시글 삭제] 처리");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}

	//글 목록 데이터  형식 변환(JSON)
	@RequestMapping(value="/dataTransform.do")
	@ResponseBody 
	public List<BoardVO> dataTransform(BoardVO vo) { 
		System.out.println("[게시글 목록 조회(JSON)] 처리");
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		//검색 조건, 검색어 출력
		System.out.println("[검색조건] " + vo.getSearchCondition());
		System.out.println("[검 색 어] " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo); 
		
		return boardList; 
	}
	
	//글 목록 데이터 형식 변환(XML)
	@RequestMapping(value="/dataTransform_xml.do")
	@ResponseBody 
	public List<BoardVO> dataTransformXml(BoardVO vo) { 
		System.out.println("[게시글 목록 조회(XML)] 처리");
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		//검색 조건, 검색어 출력
		System.out.println("[검색조건] " + vo.getSearchCondition());
		System.out.println("[검 색 어] " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo); 
		
		return boardList; 
	}
}
