package com.ezen.biz.service;

import java.util.List;

import com.ezen.biz.dto.AddressVO;
import com.ezen.biz.dto.MemberVO;

public interface MemberService {

	// ȸ�� id�� �������� ����� ���� ��ȸ
	MemberVO getMember(String id);

	// ȸ�� ���� ���� ��ȸ
	int confirmID(String id);
	
	// ȸ�� �α��� ����
	int loginID(MemberVO vo);

	void insertMember(MemberVO vo);

	//�ּ� �۾�
	List<AddressVO> selectAddressByDong(String dong);
	
	
	
}