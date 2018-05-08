package cos.UI;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import cos.service.CosDAO;
import cos.util.AssortDouble;
import cos.util.AssortInt;
import cos.util.AssortPriceXGrade;
import cos.vo.*;
import cos.UI.*;



public class CosmeticUI {
	
		private CosDAO dao;
		private Scanner input;
		public String loginId = null;
		public static Customer cus;
//		public Cosmetic cos;
//		public CosmeticUI2 ui2 = new CosmeticUI2() ;
		static DecimalFormat df;
		
		public CosmeticUI() {
			dao = new CosDAO();
			input = new Scanner(System.in);
			cus = new Customer();
	//		cos = new Cosmetic();
			df  = new DecimalFormat("#,###");
		}
			
	
	//ù�޴� UI
	public int firstMenu() {
	
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("         	 ȭ��ǰ ��õ ���α׷�                              ");
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������������������������������");
		System.out.println("  1.����                         	    ");	
		System.out.println("  2.ȸ������                   	    ");	
		System.out.println("  3.���α׷� �Ұ�                  	    ");	
		System.out.println("  9.����                    	       ");	
		System.out.println("��������������������������������������������������������������������������������������������������������");
		int menu = this.getNextInt("�޴���ȣ : ");
		if (menu == 9)
		{
			System.out.println("========== �����մϴ� ==========");
			//exitJpeg();
			System.exit(0);
		}
		return menu;
		}
	
	//2.ȸ������
	public boolean register() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("        ȸ������   			   ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������");
		
        //ȸ������ ���
		System.out.print(" ID : ");
		loginId = input.next();
		input.nextLine();
		boolean result = false; 
		while(result == false) 
		{
			if(dao.getCustomerInfo(loginId) != null)
			{
				System.out.println("������ ���̵� �����մϴ�.");
				System.out.print(" ID : ");
				loginId = input.nextLine();
				
				result = false;
			}
			else
			{
				result = true;
			}
		}
		
			
		System.out.print(" PW : ");	
		String pw = input.nextLine();

		
		int cusAge = getNextInt(" ���� : ");
		
		//��, ���� �Է¹޵���
		String cusGender;
		boolean ok;
		do{
			System.out.print(" ����( M / F ) : ");
			cusGender = input.nextLine().toUpperCase();
						
			
			if(!(cusGender.equals("M") || cusGender.equals("F"))) 
			{
				System.out.println("����( M / F )�� �ٽ� �Է��� �ּ���.");
				ok = false;
			}else 
			{
				System.out.println("ȸ�������� �Ϸ�Ǿ����ϴ�.");
				System.out.println("��������������������������������������������������������������");
				ok = true;
			}
		  }
		while(ok == false);
	
		Customer cus = new Customer(loginId, pw, cusAge, cusGender,null);
		if(dao.insertCustomer(cus) == 0) 
		{
			return false;
		}else {
			return true;
		}
	}
	
	
	//���� UI
	public int connection() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("          ����                              ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println("  1.�α���                                     ");	
		System.out.println("  9.������                                     ");	
		System.out.println("����������������������������������������������������������������");
		return this.getNextInt("�޴���ȣ : ");
	}
	
	//�α��� UI //Ȯ���غ���
	public String login() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("        �α���                               ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" ID : " );
		loginId = input.nextLine();
		
		System.out.print(" PW : ");
		String pw = input.nextLine();
		System.out.println("����������������������������������������������������������������");
		
		int check = 0;
		
		
		
		List<Customer> cusList = dao.getCustomerList();
			for (Customer customer : cusList) {
				//���̵� ���� Ȯ��
				if(customer.getId().equals(loginId)) {
					//���̵� ���� 	
					check++;
				}
				//��й�ȣ ��ġ Ȯ��
				try 
				{
					if(dao.getCustomerInfo(loginId).getPw().equals(pw)) {
						//��й�ȣ ��ġ
					check++;	
					}
				}
				catch(NullPointerException e)
				{}
				
				if(check == 2) {
					System.out.println("�α��� ����!");
					return loginId;
					
				}
		}//for��  
			if( check < 2) {
				System.out.println("�α��ο� �����ϼ̽��ϴ�.");
				System.out.println("<����Ͻ÷��� ���͸� �����ּ���>");
				input.nextLine();
				loginId = null;
			}
			
			return loginId;
	}
	
	//welcome UI
	public int welcome() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("��           welcome!           �� ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		if(!(loginId.equals("manager"))) {System.out.println(" 1.�Ǻ� �ڰ�����");} else {System.out.println(" 1.[������] �Ǽ����� �� ���Ը��� ����");}	
		if(!(loginId.equals("manager"))) {System.out.println(" 2.������ �´� ȭ��ǰ ����");} else {System.out.println(" 2.[������] ȸ�� ����Ż��");}	
		if(!(loginId.equals("manager"))) {System.out.println(" 3.����������");} else {System.out.println(" 3.[������] ��ǰ ���� �ý���");}	
		System.out.println(" 9.�α׾ƿ�                       ");	
		System.out.println("����������������������������������������������������������������");
		return this.getNextInt("�޴���ȣ : ");
	}
		
	
	//1.�Ǻ� �ڰ�����
	public String skinTest() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("          �Ǻ� �ڰ�����                   ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("* 1: ���� �ƴϴ� 2: �ƴϴ� 3: �����̴� 4: �׷���  5: �ſ� �׷���" );
				      System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		int score1 = this.getNextIntMax5(" 1.�Ϸ�� �Ӹ��� ���� ������ �ݹ� �⸧������. >> ");
		int score2 = this.getNextIntMax5(" 2.�Ӹ��� ���� ���Ƶ� �������� ����� ����. >> ");
		int score3 = this.getNextIntMax5(" 3.�� �ֺ��� �����, ȭ��Ʈ��尡 ����. >> ");
		int score4 = this.getNextIntMax5(" 4.���� �� �ƹ��͵� �ٸ��� �ʾƵ� ���ų� ������ ������ ����. >> ");
		int score5 = this.getNextIntMax5(" 5.�󱼿� �⸧�� ���� ����� ���� ����� ���. >> ");
		int score6 = this.getNextIntMax5(" 6.��� ������ �������� �Ǻΰ� ���ưų� ������ �ʴ�. >> ");
		int score7 = this.getNextIntMax5(" 7.������ �������� ����� ������ ȭ��ǰ�� ����. >> ");
		int score8 = this.getNextIntMax5(" 8.�� ���϶� ����� ũ�� ���δ�. >> ");
		int score9 = this.getNextIntMax5(" 9.�⸧���̳� Ƽ���� ���� �⸧�⸦ ���� �۾Ƴ���. >> ");
		int score10 = this.getNextIntMax5(" 10.���� �� 5�ð� �̻� ������ �󱼿� ���бⰡ ���� ���� ���̴�. >> ");
		               System.out.println("������������������������������������������������������������������������������������������������������������������������������");
		
		//��� ���� 
		int sum = (score1 + score2 + score3 + score4 + score5
				+ score6 + score7 + score8 + score9 + score10) ; 
		double avg = sum;
		
		//0~15�� �Ǽ��Ǻ�
		if(avg>0 && avg<=15) {
			String skin = "�Ǽ�";
			System.out.println(skin + "�Ǻ� �Դϴ�.");
			return skin;
		}
		
		//16~30�� �߼��Ǻ�
		else if(avg>15 && avg<=30) {
			String skin = "�߼�";
			System.out.println(skin + "�Ǻ� �Դϴ�.");
			return skin;
		}
		
		//31~50�� �����Ǻ�
		else 
		{
			String skin = "����";
			System.out.println(skin + "�Ǻ� �Դϴ�.");
			return skin;
		}	
		
	}
	
	//2.������ �´� ȭ��ǰ����
	public int recommendCos() {
		System.out.println("��������������������������������������������������������������������");
		System.out.println("      " + loginId +"��" + "�� ���� ��õ ȭ��ǰ ");
		System.out.println("��������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������������");
		System.out.println(" 1.������ ����");
		System.out.println(" 2.���ݺ�");	
		System.out.println(" 3.���� �� ��õ");	
		System.out.println(" 4.��ǰ���� ����(����)");
		System.out.println(" 5.���ϱ�");
		System.out.println(" 6.�����ۼ�");
		System.out.println(" 7.��� ȭ��ǰ ����Ʈ");
		System.out.println(" 9.������                                                          ");	
		System.out.println("������������������������������������������������������������������������������������");
		return this.getNextInt("�޴���ȣ : ");
		
		
	}
	
	


	//2-1 ������ ����
	public void basicType() {
		System.out.println("[��õ �μ� TOP 3]");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
		System.out.printf(" %-17s  ", "[��ǰ��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.printf(" %-10s  ", "[�귣��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.println();
		Customer cu = dao.getCustomerInfo(loginId);
		CosDAO dao = new CosDAO();
		List<Cosmetic> list = dao.getCosmeticList();
		AssortPriceXGrade sorter = new AssortPriceXGrade();
		Collections.sort(list, sorter);
		int count = 0;
		for(int a = 0 ; a < list.size() ; a++)
		{
			boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("�μ�");
			if(check)
			{
				StringBuffer sb = new StringBuffer();
				sb.append(list.get(a).getCosName());
				sb.append(abc(list.get(a)));
				int cosNumber = list.get(a).getCosNumber();
				System.out.printf("   %-5d  ", cosNumber);
				System.out.print(sb.toString());
				System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
				System.out.printf("   %-10s  ", list.get(a).getCosBrand());
				System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
			System.out.println();
			count++;
			list.remove(list.get(a));
			}
			
			if (count >= 3) {break;}
		}
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
		System.out.println("[��õ ��Ų TOP 3]");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
		System.out.printf(" %-17s  ", "[��ǰ��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.printf(" %-10s  ", "[�귣��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.println();
		
		count = 0;
		for(int a = 0 ; a < list.size() ; a++)
		{
			boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("��Ų");
			if(check)
			{
				StringBuffer sb = new StringBuffer();
				sb.append(list.get(a).getCosName());
				sb.append(abc(list.get(a)));
				int cosNumber = list.get(a).getCosNumber();
				System.out.printf("   %-5d  ", cosNumber);
				System.out.print(sb.toString());
				System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
				System.out.printf("   %-10s  ", list.get(a).getCosBrand());
				System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
			System.out.println();
			count++;
			}
		 if (count >= 3) {break;}
		}
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.print("<����Ϸ��� ����ġ����>");
		input.nextLine();
	}
	
	
	//2-2 ���ݺ�(���� ���� ������� ��� )
	public void priceType() {
		List<Cosmetic> list = dao.getCosmeticList();
		Customer cu = dao.getCustomerInfo(loginId);
		AssortInt sor = new AssortInt();
		Collections.sort(list, sor);
		System.out.println("[��õ �μ� TOP 3]");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
		System.out.printf(" %-17s  ", "[��ǰ��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.printf(" %-10s  ", "[�귣��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.println();	
		int count = 0;
		//���ݼ� 3�� �̱�
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("�μ�");
				if(check)
				{
					StringBuffer sb = new StringBuffer();
					sb.append(list.get(a).getCosName());
					sb.append(abc(list.get(a)));
					int cosNumber = list.get(a).getCosNumber();
					System.out.printf("   %-5d  ", cosNumber);
					System.out.print(sb.toString());
					System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
					System.out.printf("   %-10s  ", list.get(a).getCosBrand());
					System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
				System.out.println();
				count++;
				}
				if (count >= 3) {break;}
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
		System.out.println("[��õ ��Ų TOP 3]");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
		System.out.printf(" %-17s  ", "[��ǰ��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.printf(" %-10s  ", "[�귣��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.println();
		count = 0;
		//���ݼ� 3�� �̱�
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("��Ų");
				if(check)
				{
					StringBuffer sb = new StringBuffer();
					sb.append(list.get(a).getCosName());
					sb.append(abc(list.get(a)));
					int cosNumber = list.get(a).getCosNumber();
					System.out.printf("   %-5d  ", cosNumber);
					System.out.print(sb.toString());
					System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
					System.out.printf("   %-10s  ", list.get(a).getCosBrand());
					System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
				System.out.println();
				count++;
				}
				if (count >= 3) {break;}
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
			System.out.print("<����Ϸ��� ����ġ����>");
			input.nextLine();
	}
	
	//2-3 ������õ (���� �� ���)
	public void gradeType() {
		List<Cosmetic> list = dao.getCosmeticList();
		Customer cu = dao.getCustomerInfo(loginId);
		AssortDouble sor2 = new AssortDouble();
		Collections.sort(list, sor2);
		System.out.println("[��õ �μ� TOP 3]");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
		System.out.printf(" %-17s  ", "[��ǰ��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.printf(" %-10s  ", "[�귣��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.println();
		int count = 0;
		//���� �� 3�� �̱�
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("�μ�");
				if(check)
				{
					StringBuffer sb = new StringBuffer();
					sb.append(list.get(a).getCosName());
					sb.append(abc(list.get(a)));
					int cosNumber = list.get(a).getCosNumber();
					System.out.printf("   %-5d  ", cosNumber);
					System.out.print(sb.toString());
					System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
					System.out.printf("   %-10s  ", list.get(a).getCosBrand());
					System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
				System.out.println();
				count++;
				}
				if (count >= 3) {break;}
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		
		System.out.println("[��õ ��Ų TOP 3]");
		System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
		System.out.printf(" %-17s  ", "[��ǰ��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.printf(" %-10s  ", "[�귣��]");
		System.out.printf(" %-10s  ", "[����]");
		System.out.println();
		count = 0;
		//���� �� 3�� �̱�
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("��Ų");
				if(check)
				{
					StringBuffer sb = new StringBuffer();
					sb.append(list.get(a).getCosName());
					sb.append(abc(list.get(a)));
					int cosNumber = list.get(a).getCosNumber();
					System.out.printf("   %-5d  ", cosNumber);
					System.out.print(sb.toString());
					System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
					System.out.printf("   %-10s  ", list.get(a).getCosBrand());
					System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
				System.out.println();
				count++;
				}
				if (count >= 3) {break;}
			}
			System.out.println("������������������������������������������������������������������������������������������������������������������������������������������������������������");
			System.out.print("<����Ϸ��� ����ġ����>");
			input.nextLine();
	}
	//��ǰ�� ���ڼ� ���߱�
	public String abc(Cosmetic cos) {
	int a = 20- cos.getCosName().length();
	StringBuffer sb = new StringBuffer();
	for(int i=0 ; i <a ; i++) {
		if (i == a-1) {
			sb.append("\t");
		}
		else {
			sb.append(" ");		
			
		}
	}
	return sb.toString();
	
	 
	}
	
	//2-4 ��ǰ���� ����
	public void cosInformation() {
		Cosmetic cos = new Cosmetic();
			
		int cosNum = getNextInt("��ǰ��ȣ�� �Է��ϼ��� : ");
		
		System.out.println("��������������������������������������������������������������");
		System.out.println("       ��ǰ���� ����(����) 	  ");	
		System.out.println("��������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������");
		cos = dao.getCosmetic(cosNum);
		try 
		{
			System.out.print("  [��ǰ��]  ");
			System.out.println(cos.getCosName());
			
			System.out.print("  [��ǰ����]"  );
			System.out.println(cos.getCosContent());
	
			
			List<Review> cosReview = dao.getReview(cosNum);
		
			double total = 0;
			if(!(cosReview.isEmpty()))
			{	for (Review review : cosReview) 
				{
					System.out.printf("  [���䳻��] %-20s [����] %4f [�ۼ���] %20s %n", review.getContent(),  review.getCosGrade(), review.getIndate());
					total += review.getCosGrade();			
				}
				System.out.println("  [��� ����] " + total / cosReview.size());
			}
			else
			{
				System.out.println("  [����] ���䰡 �����ϴ�");
			}
			System.out.println("��������������������������������������������������������������������������������");
		}//try
		catch(NullPointerException e)
		{
			System.out.println("��ǰ ������ �����ϴ�.");
		}//catch
		System.out.println("<����Ϸ��� ����ġ����> ");
		input.nextLine();
		
	}//��ǰ��������
	
	//2-5 ���ϱ� UI2
	
	//2-6 �����ۼ�
	public boolean insertReview() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("       �����ۼ�      ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������");
		int cosNum = this.getNextInt(" ��ǰ��ȣ : ");
		System.out.print(" ���䳻�� : ");	
		String content = input.nextLine();
		double cosGrade = this.getNextDouble(" ���亰�� : ");		
		System.out.println("����������������������������������������������������");
		
		Review review = new Review(cosNum, loginId ,content, cosGrade);
		try {
		Cosmetic replace = dao.getCosmetic(cosNum);
		replace.setCosGrade(cosGrade);
		dao.updateGrade(replace);
		}
		catch(NullPointerException e)
		{
			System.out.println("�ش� ��ǰ�� �����ϴ�.");
		}
	//	review.setCosNum(cosNum);
		if(dao.insertReview(review) == 0) {
			System.out.println("����� �����Ͽ����ϴ�.");
			return false;
		}
		else {
			System.out.println("�������� �Ϸ�Ǿ����ϴ�.");
			return true ;
		}
		
	}
	
	
	//3.����������
	public int mypage() {
	cus = dao.getCustomerInfo(loginId);
		System.out.println("����������������������������������������������������������������");
		System.out.println("        ���� ������                  ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println(" ID : " + loginId);	
		System.out.println(" ���� : " + cus.getCusAge());	
		System.out.println(" ���� : " + cus.getCusGender());	
		System.out.println(" �Ǻ�Ÿ�� : " + ((cus.getCusSkinType() == null) ? "�Ǻ��׽�Ʈ�� �������ּ���" : cus.getCusSkinType()))  ;	
		System.out.println("��������������������������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������������");
		System.out.println(" 1.��й�ȣ ����  				 ");	
		System.out.println(" 2.ȸ�� Ż�� 		 	         ");	
		System.out.println(" 3.��޴� 		 	         ");	//��� ����� 
		System.out.println(" 9.�����޴�  			         ");	
		System.out.println("������������������������������������������������������������������������������������");
		return this.getNextInt("�޴���ȣ : ");

		
	}
	
	
	//3-1 ��й�ȣ ����
	public String pwChange() {
		cus = dao.getCustomerInfo(loginId);
		
		System.out.println("����������������������������������������������������������������");
		System.out.println("         ��й�ȣ ����      	       ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" ���� ��й�ȣ �Է� : ");	
		String pw = input.nextLine();
		if(cus.getPw().equals(pw)) {
			System.out.print(" ���ο� ��й�ȣ �Է� : ");
			String NewPw = input.nextLine();
			System.out.print(" ���ο� ��й�ȣ Ȯ�� : ");
			String reNewPw = input.nextLine();
			if(NewPw.equals(reNewPw)) {
				Customer updateCus = new Customer(cus.getId(), NewPw, cus.getCusAge(), cus.getCusGender(), cus.getCusSkinType());
				
				int result = dao.updateCustomer(updateCus);
				//�� �ȿ��� ��й�ȣ�� ���漺���ߴ��� ���ߴ��� ���� Ȯ�� 
				if(result == 0) {
					System.out.println("��й�ȣ ������ �����Ͽ����ϴ�.");
				}else {
					System.out.println("��й�ȣ�� ����Ǿ����ϴ�");
				}
			}
			System.out.println("���������������������������������������������������������������� ");
			return NewPw;
		
		}else {
			System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			System.out.println("<���ư��÷��� ���͸� �Է��ϼ���>");
			input.nextLine();
			return cus.getPw();
		}
		
		
		
	
	}
			        
	//3-2 ȸ�� Ż��
	public boolean deleteCustomer() {
		cus = dao.getCustomerInfo(loginId);
		if(loginId.equals("manager"))
		{
			System.out.println("[���] �����ڴ� Ż�� �� �� �����ϴ�");
			return false;
		}
		System.out.println("����������������������������������������������������������������");
		System.out.println("��        ȸ�� Ż��      	       ��");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.print(" ��й�ȣ �Է� : ");	
		String pw = input.nextLine();
		//��й�ȣ�� ������ Ż�𿩺� ����
		if(cus.getPw().equals(pw)) 
		{
			System.out.println(" [�˸�] ȸ���� Ż���Ͻðڽ��ϱ�? (Y/N) ");	
			String yn = input.nextLine();
			
			if(yn.equals("y") || yn.equals("Y")) {
				//
				Map<String, String> map = new HashMap<>();
				map.put("id", loginId);
				map.put("pw", pw);
				if(dao.deleteCustomer(map) == 0) {
					System.out.println(" [�˸�] ȸ�� Ż�� �����Ͽ����ϴ�.");
					System.out.println("���������������������������������������������������������������� ");
					return false;
				}
				else {
					dao.deleteUserFavorite(loginId);
					System.out.println(" [�˸�] Ż��Ǿ����ϴ�.");
					System.out.println("���������������������������������������������������������������� ");
					System.out.println("<����Ϸ��� ����ġ����>");
					input.nextLine();
					return true;
					}
				}
			else
				{
					System.out.println(" [�˸�] Ż�� ��ҵǾ����ϴ�.");
					System.out.println("������������������������������������������������������������������ ");
					return false;
				}
	
		
		}else {
			System.out.println(" [�˸�] ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
			return false;
		}	
	}
	

	//3-3 ����
	public int zzim(){
		System.out.println("����������������������������������������������������������������");
		System.out.println("        ��޴�                               ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		System.out.println(" 1. �� ����                                     ");	
		System.out.println(" 2. �� ���                                     ");	
		System.out.println(" 9. ������                                      ");	
		System.out.println("����������������������������������������������������������������");
		return getNextInt("[�޴���ȣ�Է�] : ");
	}
	
	//8 ������
	public int manager() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("        ������       ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("������������������������������������������������������������������������������������");
		System.out.println(" 1.��ǰ ��� 								 ");	
		System.out.println(" 2.��ǰ ���� ���� 						  ");	
		System.out.println(" 3.��ǰ ����     							  ");	
		System.out.println(" 4.��ǰ ����Ʈ                  				");	
		System.out.println(" 9.�����޴�                				");	
		System.out.println("������������������������������������������������������������������������������������");
		return this.getNextInt("�޴���ȣ : ");	
	}
	
	//8-1 ��ǰ���
	public boolean insertCos() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("            ��ǰ ���       ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������");
		System.out.print(" �̸� : ");	
		String cosName = input.nextLine();
		
		int cosPrice = this.getNextInt("���� : ");
		System.out.print(" �귣�� : ");	
		String cosBrand = input.nextLine();
		System.out.print(" ��ǰ�Ұ� :	");	
		String cosContent = input.nextLine();
		System.out.print(" �Ǻ�Ÿ�� : ");
		String cosSkinType = input.nextLine();
		System.out.print(" ��ǰŸ�� : ");	
		String cosType = input.nextLine();
		
		System.out.println("��������������������������������������������������������������");
		Cosmetic cos = null;
		cos = new Cosmetic(cosName, cosPrice, cosBrand, cosContent, cosSkinType, cosType);
		if(dao.insertCosmetic(cos) == 0)
		{
			System.out.println("����� �����Ͽ����ϴ�.");
			return false;
		}
		else
		{
			System.out.println("��ǰ����� �Ϸ�Ǿ����ϴ�.");
			return true ;
		}
		
	}
	
	//8-2 ��ǰ ���� ����
	public boolean cosChange() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("       ��ǰ ���� ����      ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("����������������������������������������������������������������");
		int cosNumber = this.getNextInt(" ��ǰ ��ȣ : ");
		//��ȣ�� �����ϸ� 1.���� , 2.��ǰ�Ұ� ����ȭ�� ���  //�ƴϸ� "�������� �ʴ� ��ǰ�Դϴ�." ���
		Cosmetic a = dao.getCosmetic(cosNumber);
		if ( a == null)
		{
			System.out.println("�������� �ʴ� ��ǰ�Դϴ�.");
			return false;
		}
		else {
			int cosRePrice = this.getNextInt("1.���� : ");
				System.out.print(" 2.��ǰ �Ұ� : ");	
				String cosReIntroduction = input.nextLine();
				System.out.println("����������������������������������������������������������������");
				Cosmetic updateCos = new Cosmetic();
				updateCos.setCosNumber(cosNumber);
				updateCos.setCosPrice(cosRePrice);
				updateCos.setCosContent(cosReIntroduction);
				
				if(dao.updateCosmetic(updateCos) != 0) {
					System.out.println("��ǰ ���� ������ �Ϸ��Ͽ����ϴ�.");
					return true;
				}
				else {
					System.out.println("��ǰ ���� ������ �����Ͽ����ϴ�.");
					return false;
				}
		}
		
			}
	
	//8-3 ��ǰ ����
	public boolean cosDelete() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("           ��ǰ ����      ");
		System.out.println("����������������������������������������������������������������");
		System.out.println("��������������������������������������������������������������������������������");
		int cosNumber = this.getNextInt(" ������ ��ǰ��ȣ�� �Է��ϼ��� : ");
		if(dao.deleteCosmetic(cosNumber) == 0) {
			System.out.println("��ǰ ������ �����߽��ϴ�.");
			System.out.println("��������������������������������������������������������������������������������");
			return false;

		}
		else {
			System.out.println("��ǰ�� �����Ͽ����ϴ�.");
			System.out.println("��������������������������������������������������������������������������������");
			return true;
		}
	}
	
	//8-4 ��ǰ ����Ʈ
	public void cosList() {
		System.out.println("����������������������������������������������������������������");
		System.out.println("         ��ǰ ����Ʈ                       ");
		System.out.println("����������������������������������������������������������������");
		/*
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("�� ��ȣ	    �� �̸�                       ��  ����	      �� 	�귣��          ��");	
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");	
		*/
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		System.out.printf(" %-5s", "[��ȣ]");
		System.out.printf(" %-20s", "[�̸�]");
		System.out.printf("    %-10s ", "[����]");
		System.out.printf("%-10s", "[�귣��]");
		System.out.printf("%-10s", "[����]");
		System.out.printf("%-10s", "[����]");
		System.out.println();
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������������");
		
		List<Cosmetic> list = dao.getCosmeticList();
		if (!(list.isEmpty()))
		{

		for(int a = 0 ; a < list.size() ; a++)
		{
			int cosNumber = list.get(a).getCosNumber();
			StringBuffer sb = new StringBuffer();
			sb.append(list.get(a).getCosName());
			sb.append(abc(list.get(a)));
			System.out.printf("   %-5d", list.get(a).getCosNumber());
			System.out.print(sb.toString());
			System.out.printf("   %-10s", df.format(list.get(a).getCosPrice()));
			System.out.printf("   %-10s", list.get(a).getCosBrand());
			System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
			System.out.printf("   %-10s", list.get(a).getCosType());
			System.out.println();
		}
		
		}
		System.out.println("�����޴��� ���ư��÷��� ���͸� �Է����ּ���.");
		input.nextLine();
	}
	
	
	int getNextIntMax5(String message) {
		int option = 0;
		   
		do {
			try 
			{
				System.out.print(message);
				option = input.nextInt();
			} 
			catch (Exception e) 
			{
				System.out.println("[����] �߸� �Է��Ͽ����ϴ�");			
			}
			finally
			{
				input.nextLine();
			}

		} while(option <= 0 || option > 5);
		
		return option;
	}
	
	int getNextInt(String message) {
		int option = 0;
	
		do {
			try {
				System.out.print(message);
				option = input.nextInt();
			} 
			catch (Exception e) 
			{
				System.out.println("[����] �߸� �Է��Ͽ����ϴ�");
				//e.printStackTrace();
			}
			finally
			{
				input.nextLine();
			}

		} while(option == 0);
		
		return option;
	}
	
	double getNextDouble(String message) {
		double option = 0.0;
	
		do {
				try 
				{
				System.out.print(message);
			
				option = input.nextDouble();
					if(option < 0.0 || option > 5.0) 
					{
						System.out.println("[�˸�] 0.0�� 5.0������ ���� �Է����ּ���.");
					}

				} 
				catch (Exception e) 
				{
					System.out.println("[����] �߸� �Է��Ͽ����ϴ�");	
				}
				finally
				{			
					input.nextLine();
				}

		} while(option < 0.0 || option > 5.0);
		
		return option;
	}
	
	
	/*
	public void exitJpeg() {
		System.out.println(":          +#%##%#+.                         ##########\r\n" + 
				":         #########%=                        ##########\r\n" + 
				":        +###########                        ##########\r\n" + 
				":        .%#########+                        ##########\r\n" + 
				":         .*#######:                         ##########\r\n" + 
				":            .::=:..:::::::::::::..          ##########\r\n" + 
				":            :*###################%#*.       ##########\r\n" + 
				":          .*########################%:      ##########\r\n" + 
				":         +################*+*****#####=     ##########\r\n" + 
				":       :###################      =#####+    ##########\r\n" + 
				".     .*#######*#############      =#####+   ##########\r\n" + 
				"#%###%#######=  #############*      :#####=  ##########\r\n" + 
				"###########+    .#############=      :*##*.  ##########\r\n" + 
				"########*+.      .#############:             ##########\r\n" + 
				":                 =############%.            ##########\r\n" + 
				":                  +############=            ##########\r\n" + 
				":                 .#############+            ##########\r\n" + 
				":                .#######**#####*            ##########\r\n" + 
				":               .#######* =######            ##########\r\n" + 
				":              .#######*  :######.           ##########\r\n" + 
				":             .#######*   .######:           %#########\r\n" + 
				":             #######*     ######+            ..:*#####\r\n" + 
				":           .#######*      *###############%####+ .####\r\n" + 
				":          .#######*       =#####################%. ###\r\n" + 
				":         .#######*         +###################### :##\r\n" + 
				":         #######*                           ........*#\r\n" + 
				":        #######*                            %#########\r\n" + 
				":      .#######*                             ##########");
	}
	*/
	
	
}
