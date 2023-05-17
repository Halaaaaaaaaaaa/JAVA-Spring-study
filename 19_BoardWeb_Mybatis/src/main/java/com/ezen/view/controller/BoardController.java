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

//�� ����� Ŭ�������� controller ���ֱ⺸�� �ϳ��� ��Ʈ�ѷ��� ���� ����
@Controller
//"board"��� �Ӽ� �̸����� model ��ü�� ������ ���� �� ���ǿ��� ���ÿ� ����ȴ�.
@SessionAttributes("board")
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value="/insertBoard.do") //��û�� ���� ����
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException { //������ �����ӿ�ũ���� ��ü�� �ڵ������� ����
		
		System.out.println("[�Խñ� ���] ó��");
		
		//���� ���ε� ó��
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			System.out.println("[���� �̸�] " + fileName);
			uploadFile.transferTo(new File("D:/upload/" + fileName));
		}
		
		//2. DB ���� ó��
		//boardDAO.insertBoard(vo);
		boardService.insertBoard(vo);
		
		// 3. ȭ�� �׺��̼�
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/updateBoard.do")	
	public String updateBoard(@ModelAttribute("board") BoardVO vo) {
		//���ǿ� ����� �����͸� ����ϱ� ���ؼ� @ModelAttribute ����Ͽ� BoardVO���� ����
		System.out.println("[�Խñ� ����] ó��");

		//boardDao.updateBoard(vo);
		boardService.updateBoard(vo);
		
		return "getBoardList.do";
	}
	
	@RequestMapping(value="/getBoard.do")
	public String GetBoard(BoardVO vo, Model model) {
		
		System.out.println("[�Խñ� �� ��ȸ] ó��");
		// �Խñ� ��ȣ �Է°� ����
		///getBoard.do ȣ�� ������ seq �޾Ƽ� ����
		BoardVO board = boardService.getBoard(vo);
	
		//����ȭ�� ����
		//@Sessionattribues�� ���� �Ǿ� ������ ���ǿ��� ���� ����ȴ�.
		model.addAttribute("board", board);
		
		return "getBoard.jsp";
	}
	
	//�˻� ���� ��� ����
	@ModelAttribute("conditionMap") 
	public Map<String, String> searchConditionMap() { 
		
		Map<String, String> conditionMap = new HashMap<>(); 
		
		conditionMap.put("����", "TITLE"); 
		conditionMap.put("����", "CONTENT");
		//conditionMap.put("�ۼ���", "WRITER");
		
		return  conditionMap; 
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,
			//�˻� ���
			//@RequestParam(value="searchCondition", defaultValue="TITLE", required=false) String condition,
			//@RequestParam(value="searchKeyword", defaultValue="", required=false) String keyword,
			Model model) {
		
		System.out.println("[�Խñ� ��� ��ȸ] ó��");
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		//�˻� ����, �˻��� ���
		System.out.println("[�˻�����] " + vo.getSearchCondition());
		System.out.println("[�� �� ��] " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo);
		
		//ȭ�� ���� ó��
		//ModelAndView�� ���� �����ؼ� �������ٰű� ������ ������ �ʿ䰡 ����
		//DB���� ��ȸ�� ������ ȭ�鿡 �����ϱ� ���� ���尴ü�� ����
		model.addAttribute("boardList", boardList);
		
		return "getBoardList.jsp";
	}
	
	@RequestMapping(value="/deleteBoard.do")
	public String deleteBoard(BoardVO vo, Model model) {
		
		System.out.println("[�Խñ� ����] ó��");
		
		boardService.deleteBoard(vo);
		
		return "getBoardList.do";
	}

	//�� ��� ������  ���� ��ȯ(JSON)
	@RequestMapping(value="/dataTransform.do")
	@ResponseBody 
	public List<BoardVO> dataTransform(BoardVO vo) { 
		System.out.println("[�Խñ� ��� ��ȸ(JSON)] ó��");
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		//�˻� ����, �˻��� ���
		System.out.println("[�˻�����] " + vo.getSearchCondition());
		System.out.println("[�� �� ��] " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo); 
		
		return boardList; 
	}
	
	//�� ��� ������ ���� ��ȯ(XML)
	@RequestMapping(value="/dataTransform_xml.do")
	@ResponseBody 
	public List<BoardVO> dataTransformXml(BoardVO vo) { 
		System.out.println("[�Խñ� ��� ��ȸ(XML)] ó��");
		
		if(vo.getSearchCondition() == null)
			vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null)
			vo.setSearchKeyword("");
		
		//�˻� ����, �˻��� ���
		System.out.println("[�˻�����] " + vo.getSearchCondition());
		System.out.println("[�� �� ��] " + vo.getSearchKeyword());
		
		List<BoardVO> boardList = boardService.getBoardList(vo); 
		
		return boardList; 
	}
}
