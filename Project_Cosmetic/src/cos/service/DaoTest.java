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
		
		//������ : dao, ��ĳ��
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
		id : �Է�
		pw : �Է�
		
		
		loginID = id;
		
		return loginId;
	*/
		//ȭ��ǰ���Կ���
	//	Cosmetic co = new Cosmetic("�Ҹ�ȭ��ǰ", 7000, "�귣��", "��ǰ�Ұ�", "�Ǽ�", "�μ�");
	//	System.out.println(dao.insertCosmetic(co));

		//ȭ��ǰ��������
	//	Cosmetic co = new Cosmetic();
	//	co.setCosNumber(1);
	//	co.setCosPrice(9000);
	//	co.setCosContent("���̰�¾��");
	//	system.out.println(dao.updateCosmetic(co));//ȭ��ǰ ��ȣ �Է�
		
		//ȭ��ǰ����
	//	System.out.println(dao.deleteCosmetic(1));
		
		//ȭ��ǰ ���
	//	List<Cosmetic> list = dao.getCosmeticList();
	//	for (Cosmetic cosmetic : list) {
	//		System.out.println(cosmetic);
	//	}
		
		//ȭ��ǰ ��ü �ҷ�����
	//	System.out.println(dao.getCosmetic(4));
		
		//ȸ�����Կ���
	//	Customer cu = new Customer("���ǵ�", "fjekwl", 30, "��", "�Ǽ�");
	//	System.out.println(dao.insertCustomer(cu));
		
		
		
		/*ȸ�� ��� ���� ����
		Customer cu = new Customer("������", "����ٲ��", 30, "��", "�Ǽ�");
		System.out.println(dao.updateCustomer(cu));
		*/
		
		
		//ȸ���������
	//	System.out.println(dao.getCustomerInfo("������"));
		
		
		//ȸ��Ż��
		//Customer cus = dao.getCustomerInfo("���ǵ�");
		//Map<String, String> map = new HashMap<>();
		//map.put("id", "���ǵ�");
		//map.put("pw", "fjekwl");
		
		//System.out.println(dao.deleteCustomer(map));
		
		//������Կ���
		//Review re = new Review(2 , "������", "�̰ź���", 1.5);
		//System.out.println(dao.insertReview(re));		
		
		//�����������
	//	System.out.println(dao.deleteReview(3));
		
		//���� ����
	//	Review re = new Review(4, "���� �ٲܰ�", 4.2);
	//	System.out.println(dao.updateReview(re));
		
		//���䰴ü �ҷ�����
	//	System.out.println(dao.getReview(4));
		
		
		/*
		Favorite f = new Favorite();
		System.out.println(dao.insertFavorite(f));
		*/
		
	}

}
