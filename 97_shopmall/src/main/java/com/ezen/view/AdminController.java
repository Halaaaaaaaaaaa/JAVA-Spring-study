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
	
	//������ �α���
	@PostMapping("/admin_login")
	public String admin_login(AdminVO vo, Model model) {
		System.out.println("=============[ admin_login �̵� ���� ]=============");
		
		int result = adminService.adminCheck(vo);
		
		if(result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "redirect:admin_product_list";
		} else if(result == 0) {
			model.addAttribute("message", "��й�ȣ�� Ȯ�����ּ���.");
		} else {
			model.addAttribute("message", "���̵� Ȯ�����ּ���.");
		}
		
		/* ��й�ȣ, ���̵� �ѹ���
		if(result == 1) {
			model.addAttribute("admin", adminService.getAdmin(vo.getId()));
			return "redirect:adminProduct";
		} else {
			if(result == 0 || result ==-1) {
				model.addAttribute("message", "���̵�� ��й�ȣ�� Ȯ�����ּ���.");
			}
		}
		*/
		
		return "admin/main";
	}
	
	//������ �α׾ƿ�
	@GetMapping("/admin_logout")
	public String admin_logout(SessionStatus status) {
		status.setComplete();
		
		return "admin/main";
		
	}
	
	//������ ��ǰ��ȸ ���
	//jsp���� name=key���  �ʵ�� �����͸� �޾ƾ��ϴµ� ProductVO�� key��� ������ ���� ������
	//@RequestParam ������̼� ��� - jsp���Ͽ��� �޴� key��� �ʵ带 value�� ����
	@RequestMapping("/admin_product_list")
	public String adminProductList(Model model,
			@RequestParam(value="key", defaultValue="") String name) {
		System.out.println("=============[ admin_product_list �̵� ���� ]=============");

		// 1) ��ü ��ǰ��� ��ȸ
		List<ProductVO> prodList = productService.getListProduct(name);
		//int productListSize = productService.countProductList(name);
		
		// 2) ���� ��ü�� ��ǰ ��� ����
		model.addAttribute("productList", prodList);
		model.addAttribute("productListSize", prodList.size());
		//model.addAttribute("productListSize", productListSize);
		
		// 3) ȭ�� ȣ��
		return "admin/product/productList";
	}
	
	//������ ��ǰ �� ���� ����
	@RequestMapping("/admin_product_detail")
	public String adminProductDetail(ProductVO vo, Model model) {
		System.out.println("=============[ admin_product_detail �̵� ���� ]=============");
		
		String[] kindList = {"", "��", "����", "����", "������", "����Ŀ��", "����"};
		
		ProductVO productDetail = productService.getProduct(vo);
			model.addAttribute("productVO", productDetail);
		int index = Integer.parseInt(productDetail.getKind());
			model.addAttribute("kind", kindList[index]);
		
		//ȭ�� ǥ��
		return "admin/product/productDetail";
	}
	
	/*//������ ��ǰ ��� ���
	@PostMapping("/admin_product_write_form ")
	public String adminProductWriteView() {
		
		
		
		return "admin/product/productWrite";
	}
	*/
	
}
