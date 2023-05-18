package com.ezen.biz.service;

import java.util.List;

import com.ezen.biz.dto.ProductVO;

public interface ProductService {

	List<ProductVO> getNewProductList();

	List<ProductVO> getBestProductList();

	ProductVO getProduct(ProductVO vo);

	List<ProductVO> getProductListByKind(String kind);
	
	////////////////////////////////////////////////////////////////////////
	
	//�� ��ǰ ��� ���� ��ȸ
	int countProductList(String name);
		
	//��ǰ ��� ��ȸ
	List<ProductVO> getListProduct(String name);
	
	//��ǰ �߰�
	void insertProduct(ProductVO vo);
	
	//��ǰ ����
	void updateProduct(ProductVO vo);

}