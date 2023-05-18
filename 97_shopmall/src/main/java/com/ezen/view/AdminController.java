package com.ezen.view;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ezen.biz.dto.AdminVO;
import com.ezen.biz.dto.ProductVO;
import com.ezen.biz.service.AdminService;
import com.ezen.biz.service.ProductService;

@Controller
@SessionAttributes("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/admin_login_form")
	public String adminLoginView(HttpSession session, Model model) {

		return "admin/main";
	}
	
	//관리자 로그인
	@PostMapping("/admin_login")
	public String admin_login(AdminVO vo, Model model) {
		System.out.println("=============[ admin_login 이동 성공 ]=============");
		
		int result = adminService.adminCheck(vo);
		
		if(result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "redirect:admin_product_list";
		} else if(result == 0) {
			model.addAttribute("message", "비밀번호를 확인해주세요.");
		} else {
			model.addAttribute("message", "아이디를 확인해주세요.");
		}
		
		/* 비밀번호, 아이디 한번에
		if(result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "redirect:adminProduct";
		} else {
			if(result == 0 || result ==-1) {
				model.addAttribute("message", "아이디와 비밀번호를 확인해주세요.");
			}
		}
		*/
		
		return "admin/main";
	}
	
	//관리자 로그아웃
	@GetMapping("/admin_logout")
	public String admin_logout(SessionStatus status) {
		status.setComplete();
		
		return "admin/main";
		
	}
	
	//관리자 상품조회 기능
	//jsp에서 name=key라는  필드로 데이터를 받아야하는데 ProductVO에 key라는 변수가 없기 때문에
	//@RequestParam 어노테이션 사용 - jsp파일에서 받는 key라는 필드를 value로 선정
	@RequestMapping("/admin_product_list")
	public String adminProductList(Model model,
			@RequestParam(value="key", defaultValue="") String name) {
		System.out.println("=============[ admin_product_list 이동 성공 ]=============");

		// 1) 전체 상품목록 조회
		List<ProductVO> prodList = productService.getListProduct(name);
		//int productListSize = productService.countProductList(name);
		
		// 2) 내장 객체에 상품 목록 저장
		model.addAttribute("productList", prodList);
		model.addAttribute("productListSize", prodList.size());
		//model.addAttribute("productListSize", productListSize);
		
		// 3) 화면 호출
		return "admin/product/productList";
	}
	
	//관리자 상품 상세 정보 구현
	@RequestMapping("/admin_product_detail")
	public String adminProductDetail(ProductVO vo, Model model) {
		System.out.println("=============[ admin_product_detail 이동 성공 ]=============");
		
		String[] kindList = {"", "힐", "부츠", "샌달", "슬리퍼", "스니커즈", "세일"};
		
		ProductVO productDetail = productService.getProduct(vo);
			model.addAttribute("productVO", productDetail);
		int index = Integer.parseInt(productDetail.getKind());
			model.addAttribute("kind", kindList[index]);
		
		//화면 표출
		return "admin/product/productDetail";
	}
	
	/*//관리자 상품 등록 기능
	@PostMapping("/admin_product_write_form ")
	public String adminProductWriteView() {
		
		
		
		return "admin/product/productWrite";
	}
	*/
	
}
