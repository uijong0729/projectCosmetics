package cos.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cos.service.*;
import cos.vo.*;

public class DaoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CosDAO dao = new CosDAO();
		
		//생성자 : dao, 스캐너
		/*
		pwChange();
		recommendCos();
		skinTest();
	
		firstMenu();
		
		getNextIntMax5()
		getNextInt()
		
		
			1. welcome();
			2. conncetion();
			3. login();
			
			
		*/
		/*
		login 
		id : 입력
		pw : 입력
		
		
		loginID = id;
		
		return loginId;
	*/
		//화장품삽입예제
	//	Cosmetic co = new Cosmetic("소망화장품", 7000, "브랜드", "상품소개", "건성", "로션");
	//	System.out.println(dao.insertCosmetic(co));

		//화장품수정예제
	//	Cosmetic co = new Cosmetic();
	//	co.setCosNumber(1);
	//	co.setCosPrice(9000);
	//	co.setCosContent("와이거쩐다");
	//	system.out.println(dao.updateCosmetic(co));//화장품 번호 입력
		
		//화장품삭제
	//	System.out.println(dao.deleteCosmetic(1));
		
		//화장품 출력
	//	List<Cosmetic> list = dao.getCosmeticList();
	//	for (Cosmetic cosmetic : list) {
	//		System.out.println(cosmetic);
	//	}
		
		//화장품 객체 불러오기
	//	System.out.println(dao.getCosmetic(4));
		
		//회원삽입예제
	//	Customer cu = new Customer("이의돋", "fjekwl", 30, "남", "건성");
	//	System.out.println(dao.insertCustomer(cu));
		
		
		
		/*회원 비번 변경 예제
		Customer cu = new Customer("이의조", "비번바꿨어", 30, "남", "건성");
		System.out.println(dao.updateCustomer(cu));
		*/
		
		
		//회원정보출력
	//	System.out.println(dao.getCustomerInfo("이의종"));
		
		
		//회원탈퇴
		//Customer cus = dao.getCustomerInfo("이의돋");
		//Map<String, String> map = new HashMap<>();
		//map.put("id", "이의돋");
		//map.put("pw", "fjekwl");
		
		//System.out.println(dao.deleteCustomer(map));
		
		//리뷰삽입예제
		//Review re = new Review(2 , "이의종", "이거별로", 1.5);
		//System.out.println(dao.insertReview(re));		
		
		//리뷰삭제예제
	//	System.out.println(dao.deleteReview(3));
		
		//리뷰 수정
	//	Review re = new Review(4, "내용 바꿀게", 4.2);
	//	System.out.println(dao.updateReview(re));
		
		//리뷰객체 불러오기
	//	System.out.println(dao.getReview(4));
		
		
		/*
		Favorite f = new Favorite();
		System.out.println(dao.insertFavorite(f));
		*/
		
	}

}
