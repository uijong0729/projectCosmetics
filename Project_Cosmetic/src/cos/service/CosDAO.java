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
		List<Cosmetic> cList = dao.printFavorite("������");
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
	 *  				ȭ��ǰ
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
			System.out.println("ȭ��ǰ ��� ����");
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
			System.out.println("ȭ��ǰ ���� ����");
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
			System.out.println("ȭ��ǰ ���� ����");
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
			System.out.println("��¿���");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	//Ư�� ��ǰ��ü ��������
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
			System.out.println("ȭ��ǰ ��� ����");
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
	 * 				��(ȸ��)
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
			System.out.println("ȸ�� ��Ͽ���");
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
			System.out.println("ȸ������ ���� ����");
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
			System.out.println("ȸ�� ��� ����");
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
			System.out.println("ȸ�� Ż�� ����");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		
		return result;
	}
	//ȸ�� ����Ʈ ���
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
				System.out.println("[ȸ����� ����]");
				//	e.printStackTrace();
			}
			finally
			{
				if(session != null) session.close();
			}
		return cusList;
	}
	
	//ȸ�� �Ǻ�Ÿ�� ����
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
			//System.out.println("[�Ǻ�Ÿ�� ���� ����]");
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
	 * 		����
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
			System.out.println("������ ����");
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
			System.out.println("���� ���� ����");
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
			System.out.println("���� ���ſ���");
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
			System.out.println("���� ��� ����");
			//	e.printStackTrace();
		}
		finally
		{
			if(session != null) session.close();
		}
		
		return result;
	}

	//��
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
			System.out.println("[�˸�]��ǰ�� ���ų� �̹� ��ϵ� ��ǰ�� �� �ֽ��ϴ�.");
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
			System.out.println("������ ���� �����ϴ�");
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
			System.out.println("��� �� ������ �����ϴ�.");
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
			System.out.println("�������ſ���");
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
			//System.out.println("(���䰡 �����ϴ�)");
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
				System.out.println("ȸ�� ���� �Ұ� ����");
				//e.printStackTrace();
			}
			finally
			{
				if(session != null) session.close();
			}
		
		return result;
	}


	
	
}




