package cos.service;

import java.util.List;
import java.util.Map;

import cos.vo.*;

public interface CosMapper {

	// [화장품]
	public int insertCosmetic(Cosmetic c);	//상품등록 (관리자)
	public int deleteCosmetic(int c);		//상품삭제 (관리자)
	public int updateCosmetic(Cosmetic c);		//상품수정 (관리자) : 가격바꾸기
	public List<Cosmetic> getCosmeticList();//전체 상품 리스트 출력
	public Cosmetic getCosmetic(int cosNumber); 			//특정 상품객체 가져오기
	public int updateGrade(Cosmetic c);
	
	///////////////////////////////////////////////////////////////////////
	
	
	
	//	[회원]
	public int insertCustomer(Customer c );		//회원 가입
	public int updateCustomer(Customer c);		//회원 자기 비밀번호 갱신
	public int updateSkin(Customer c);		//피부타입갱신
	public Customer getCustomerInfo(String id);	//회원 자기자신 정보 출력
	public int deleteCustomer(Map<String, String> map);		//탈퇴
	public List<Customer> getCustomerList(); //전체 고객 리스트
	
	////////////////////////////////////////////////////////////////////////
	
	
	
	//	[리뷰등록]
	public int insertReview(Review r);			//리뷰등록
	public int deleteReview(int reviewNum);			//리뷰삭제
	public int updateReview(Review r);			//리뷰수정 (별점, 내용, 작성일 갱신)
	public List<Review> getReview(int reviewNum); 			//특정리뷰 객체 가져오기
	
	// [찜하기]
	public int insertFavorite(Favorite f);//등록
	public int deleteFavorite(Map<String, Object> map);//삭제
	public List<Cosmetic> printFavorite(String id);//출력
	public double getGradeAvg(int cosNumber);//수정
	public int deleteUserFavorite(String id);//탈퇴시 같이 삭제
	//public List<Cosmetic> getMyFavorite(String id);
	
	
}
