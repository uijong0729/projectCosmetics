package cos.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cos.vo.Cosmetic;
import cos.vo.Customer;
import cos.vo.Favorite;
import cos.vo.Review;

public class CosDAO implements CosMapper {

	private  SqlSessionFactory factory = MyBatisConfig.getSqlSessionFactory();
	/*
	public static void main(String[] a) {
		CosDAO dao = new CosDAO();
		List<Cosmetic> cList = dao.printFavorite("이의종");
		for(Cosmetic c: cList) {
			System.out.println(c);
		}
		
		System.out.println(cList.size());
	}
	*/
	/*
	 * 
	 * 
	 * 
	 * 
	 *  				화장품
	 * 
	 */
	@Override
	public int insertCosmetic(Cosmetic c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.insertCosmetic(c);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("화장품 등록 오류");
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	@Override
	public int deleteCosmetic(int c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.deleteCosmetic(c);
			session.commit();
			
		}
		catch(Exception e)
		{
			System.out.println("화장품 삭제 오류");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}
	
	@Override
	public int updateCosmetic(Cosmetic c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.updateCosmetic(c);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("화장품 수정 오류");
		}
		finally
		{
			if(session != null) session.close();
		}
		return result;
	}

	@Override
	public List<Cosmetic> getCosmeticList() {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		List<Cosmetic> result = null;
		
		try
		{
			result = cm.getCosmeticList();
		}
		catch(Exception e)
		{
			System.out.println("출력오류");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	//특정 상품객체 가져오기
	@Override
	public Cosmetic getCosmetic(int cosNumber) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		Cosmetic result = null; 
		
		try
		{
			result = cm.getCosmetic(cosNumber);
		}
		catch(Exception e)
		{
			System.out.println("화장품 출력 오류");
			//	e.printStackTrace();
		}
		finally
		{
			session.close();
		}
		
		return result;
	}

	
	
	
	
	/*
	 * 
	 * 
	 * 				고객(회원)
	 * 
	 * 
	 * 
	 */
	@Override
	public int insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0; 
		try
		{
			result = cm.insertCustomer(c);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("회원 등록오류");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	@Override
	public int updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.updateCustomer(c);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("회원정보 변경 실패");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		
		return result;
	}
	
	
	
	@Override
	public Customer getCustomerInfo(String id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		Customer result = null;
		
		try
		{
			result = cm.getCustomerInfo(id);
		}
		catch(Exception e)
		{
			System.out.println("회원 출력 오류");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}
	
	

	@Override
	public int deleteCustomer(Map<String, String> map) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		
		try
		{
			result = cm.deleteCustomer(map);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("회원 탈퇴 오류");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		
		return result;
	}
	//회원 리스트 출력
	@Override
	public List<Customer> getCustomerList() {
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		 List<Customer> cusList = null;
		 try
			{
				cusList = cm.getCustomerList();
			}
			catch(Exception e)
			{
				System.out.println("[회원출력 에러]");
				//	e.printStackTrace();
			}
			finally
			{
				if(session != null) session.close();
			}
		return cusList;
	}
	
	//회원 피부타입 갱신
	@Override
	public int updateSkin(Customer c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.updateSkin(c);
			session.commit();
		}
		catch(Exception e)
		{
			//System.out.println("[피부타입 갱신 에러]");
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		return result;
	}
	
	/*
	 * 
	 * 		리뷰
	 * 
	 * 
	 * 
	 */
	
	
	

	@Override
	public int insertReview(Review r) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		 int result = 0;
		
		try
		{
			result = cm.insertReview(r);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("리뷰등록 에러");
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}



	@Override
	public int deleteReview(int reviewNum) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.deleteReview(reviewNum);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("리뷰 삭제 실패");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
			
		return result;
	}

	@Override
	public int updateReview(Review r) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.updateReview(r);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("리뷰 갱신에러");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		return result;
	}


	@Override
	public List<Review> getReview(int cosNum) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		List<Review> result = null;
		try {
			result = cm.getReview(cosNum);
		}
		catch(Exception e)
		{
			System.out.println("리뷰 출력 오류");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	//찜
	@Override
	public int insertFavorite(Favorite f) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.insertFavorite(f);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("[알림]상품이 없거나 이미 등록된 상품일 수 있습니다.");
			//e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	@Override
	public int deleteFavorite(Map<String, Object> map) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
		try
		{
			result = cm.deleteFavorite(map);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("삭제할 찜이 없습니다");
			e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
				
		
		return result;
	}

	@Override
	public List<Cosmetic> printFavorite(String id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		List<Cosmetic> result = null;
		try
		{
			result = cm.printFavorite(id);
		}
		catch(Exception e)
		{
			System.out.println("출력 할 찜목록이 없습니다.");
			//e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}
/*
	@Override
	public List<Cosmetic> getMyFavorite(String id) {
		SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		
		List<Cosmetic> cList = null;
		try {
			cList = cm.getMyFavorite(id);
		}
		finally {
			session.close();
		}
		
		return cList;
	}
*/

	@Override
	public int updateGrade(Cosmetic c) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		
		try
		{
			cm.updateGrade(c);
			session.commit();
		}
		catch(Exception e)
		{
			System.out.println("별점갱신오류");
			e.getMessage();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return 0;
	}

	@Override
	public double getGradeAvg(int cosNumber) {
		// TODO Auto-generated method stub
		SqlSession session =  factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		double result = 0.0;
		try
		{
			result = cm.getGradeAvg(cosNumber);
		}
		catch(Exception e)
		{
			//System.out.println("(리뷰가 없습니다)");
			//e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		return result;
	}

	@Override
	public int deleteUserFavorite(String id) {
		// TODO Auto-generated method stub
		SqlSession session = factory.openSession();
		CosMapper cm = session.getMapper(CosMapper.class);
		int result = 0;
			try
			{
				result = cm.deleteUserFavorite(id);
				session.commit();
			}
			catch(Exception e)
			{
				System.out.println("회원 정보 소거 실패");
				//e.printStackTrace();
			}
			finally
			{
				if(session != null) session.close();
			}
		
		return result;
	}


	
	
}




