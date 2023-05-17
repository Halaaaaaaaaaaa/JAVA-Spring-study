package com.ezen.biz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MathUtilTest {
	
	@Test //test 수행하는 메소드
    public void testFindMax(){  
				  //예상값	//MathUtil 행하는 식 []안에 최댓값을 찾아라
        assertEquals(4, MathUtil.findMax(new int[]{1,3,4,2}));  
        assertEquals(-1, MathUtil.findMax(new int[]{-12,-1,-3,-4,-2}));  
    } 
  
}
