package com.ezen.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
	
	@Test //test �����ϴ� �޼ҵ�
    public void testFindMax(){  
				  //����	//MathUtil ���ϴ� �� []�ȿ� �ִ��� ã�ƶ�
        assertEquals(4, MathUtil.findMax(new int[]{1,3,4,2}));  
        assertEquals(-1, MathUtil.findMax(new int[]{-12,-1,-3,-4,-2}));  
    } 
  
}
