package cos.service;

import java.util.List;
import java.util.Map;

import cos.vo.*;

public interface CosMapper {

	// [ȭ��ǰ]
	public int insertCosmetic(Cosmetic c);	//��ǰ��� (������)
	public int deleteCosmetic(int c);		//��ǰ���� (������)
	public int updateCosmetic(Cosmetic c);		//��ǰ���� (������) : ���ݹٲٱ�
	public List<Cosmetic> getCosmeticList();//��ü ��ǰ ����Ʈ ���
	public Cosmetic getCosmetic(int cosNumber); 			//Ư�� ��ǰ��ü ��������
	public int updateGrade(Cosmetic c);
	
	///////////////////////////////////////////////////////////////////////
	
	
	
	//	[ȸ��]
	public int insertCustomer(Customer c );		//ȸ�� ����
	public int updateCustomer(Customer c);		//ȸ�� �ڱ� ��й�ȣ ����
	public int updateSkin(Customer c);		//�Ǻ�Ÿ�԰���
	public Customer getCustomerInfo(String id);	//ȸ�� �ڱ��ڽ� ���� ���
	public int deleteCustomer(Map<String, String> map);		//Ż��
	public List<Customer> getCustomerList(); //��ü �� ����Ʈ
	
	////////////////////////////////////////////////////////////////////////
	
	
	
	//	[������]
	public int insertReview(Review r);			//������
	public int deleteReview(int reviewNum);			//�������
	public int updateReview(Review r);			//������� (����, ����, �ۼ��� ����)
	public List<Review> getReview(int reviewNum); 			//Ư������ ��ü ��������
	
	// [���ϱ�]
	public int insertFavorite(Favorite f);//���
	public int deleteFavorite(Map<String, Object> map);//����
	public List<Cosmetic> printFavorite(String id);//���
	public double getGradeAvg(int cosNumber);//����
	public int deleteUserFavorite(String id);//Ż��� ���� ����
	//public List<Cosmetic> getMyFavorite(String id);
	
	
}
