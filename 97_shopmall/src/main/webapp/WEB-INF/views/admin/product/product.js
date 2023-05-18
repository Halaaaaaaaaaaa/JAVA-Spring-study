/**
 * 상품 상세정보 구현
 */
function go_detail(pseq) {
	//productDetail.jsp 
	var theform = document.getElementById("prod_form");
	
	//url을 보내기 위한 action 속성
	//pseq를 조건으로 admin_product_detail이라는 url에 제품에 대한 정보를 보낼거야
	theform.action = "admin_product_detail?pseq=" + pseq;
	theform.submit();
}

//상품 목록 페이지 상품명 검색 기능 구현
function go_search() {
	//productDetail.jsp 
	var theform = document.getElementById("prod_form");
	
	theform.action = "admin_product_list";
	theform.submit;
}