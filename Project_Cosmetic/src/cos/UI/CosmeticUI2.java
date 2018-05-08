package cos.UI;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import cos.service.CosDAO;
import cos.util.AssortPriceXGrade;

import cos.vo.*;



public class CosmeticUI2 extends CosmeticUI{

		public CosDAO dao = new CosDAO();
		public Scanner input = new Scanner(System.in);
		//public CosmeticUI ui = new CosmeticUI();
		
		public CosmeticUI2() {
			
		}
		
		
		public void StartUI() {
			clear();

			if (dao.getCustomerInfo("manager") == null)
			{
				Customer manager = new Customer("manager", "manager", 99, "99", "����");
				dao.insertCustomer(manager);
			}
		
		int menu = 0;
		out:
		do
		{
			maincosmetic();
			menu = firstMenu();
			int connection;
			
			switch(menu)
			{
			case 1: //����
				clear();
				connection = connection();	//���� �޴�â
				clear();
				while(connection != 9)
				{
					if(connection == 1)
					{
						String loginGo = login();	
						loginId = loginGo; //�α��� â
						
						if (loginId != null)
						{
							clear();
							startWelcome(); //����ȭ�� �����ִ� ������
							break;
						}
						else
						{
							break;
						}
					}
					else
					{
						System.out.println("[����] �޴���ȣ�� �����ϴ�.");
						break;
					}
				}//while
				break;
				
			case 2: //ȸ������ : ȸ������ �Ϸ�� ù�޴�
				clear();
				if(register())
				{
					System.out.println("[������ ȯ���մϴ�!]");
				}
				else
				{
					System.out.println("[���Կ� �����Ͽ����ϴ�]");
				}
				break;
			case 3: //����
				clear();
				maincosmetic();
				programInformation();
				System.out.print("<���ư��÷��� ����ġ����>");
				input.nextLine();
				break;
			case 9:
				//ù�޴��� ���ư���
				
				break out;
			default:
				System.out.println("[�߸��ȸ޴���ȣ]");
				
			}

		}
		while(menu != 9);
		
	}//startUI
		
		
		
		
		//���α׷� �Ұ�
		private void programInformation() {
			// TODO Auto-generated method stub
			
			System.out.println("��������������������������������������������������������������������������������������������������������");
			System.out.println("         	  ȭ��ǰ ��õ ���α׷� �Ұ�                    ");
			System.out.println("��������������������������������������������������������������������������������������������������������");
			System.out.println("��������������������������������������������������������������������������������������������������������");
			System.out.println("   �� ���α׷��� ��õ ������ ȭ��ǰ �߿��� �ڽ��� �Ǻ�Ÿ�Կ�");
			System.out.println("   �´� ȭ��ǰ ���� �� 3���� ��õ�� �帮�� ���α׷��Դϴ�. ");
			System.out.println("   ���� �� ����ڸ��� �׸��� ������ �������� �پ��ϰ� ��õ");
			System.out.println("   ������ �� ������ �� ���α׷��� ���� ������ָ� �غ��ϼ���!");
			System.out.println("��������������������������������������������������������������������������������������������������������");
		}


		public void startWelcome() {
			
			while(true)
			{ 

				int welcome = welcome();		//����ȭ��
				switch (welcome)
				{
				case 1: //�Ǻ�Ÿ�� �����ϱ�
				if(loginId.equals("manager"))
				{
					System.out.println("[���] ���к��� ���� ������ ȸ������ �ݹ��� �� �� �ֽ��ϴ�.");
					int reviewNum = getNextInt("���� �� ���� ��ȣ : ");
					if(dao.deleteReview(reviewNum) != 0)
					{
						System.out.println("���� ����");
					}
					else
					{
						System.out.println("[�˸�] ������ ���䰡 �����ϴ�.");
					}
					break;
				}
				else 
				{
					clear();
					String skinType = skinTest();
					Customer cu = dao.getCustomerInfo(loginId);
					cu.setCusSkinType(skinType);
					int result = 0;
						try 
						{
							result = dao.updateSkin(cu);
						}
						catch(Exception e)
						{
							e.printStackTrace();
							//System.out.println();
						}
					
					if(result != 0)
					{
						System.out.println("==========�Ǻ�Ÿ�� �����Ϸ�============");
					}
					else
					{
						System.out.println("==========�Ǻ�Ÿ�� ��������============");
					}
					
						break;
				}
				//	Customer cus = dao.getCustomerInfo(�Է��Ѿ��̵�);
				//	cus.getPw().equals(�Է��� ��й�ȣ)
					
				case 2:	//��õȭ��ǰ ����
				if(loginId.equals("manager"))
				{
					System.out.println("[���] ������ ���� ���� ����� ���� �Ҽ��� �ٰŰ� �� �� �ֽ��ϴ�.");
					System.out.print("����Ż�� ��ų ȸ���� ���̵� : ");
					String id = input.next();
					input.nextLine();
						try 
						{
							Map<String, String> map = new HashMap<String, String>();
							map.put("id", id);
							map.put("pw", dao.getCustomerInfo(id).getPw());
							if(dao.deleteCustomer(map) != 0)
							{
								System.out.println("[�˸�] " + id + "���� �����Ǿ����ϴ�.");
							}
							else
							{
								System.out.println("[�˸�]���� ���� : ���� ���̵� �̰ų� �y�� ��ų �� ���� ȸ���Դϴ�.");
							}
						}
						catch(Exception e)
						{
							System.out.println("[�˸�]���� ���� : ���� ���̵� �̰ų� �y�� ��ų �� ���� ȸ���Դϴ�.");
						}
						finally
						{
							break;
						}
						
				}
					else
					{
						clear();
						Customer cus = dao.getCustomerInfo(loginId);
							if(cus.getCusSkinType() == null) {
								System.out.println("[�˸�] �Ǻ� �ڰ������� ���� ���ּ���.");
								break;
							}
						
						int recommend = 0;
						while(recommend != 9) 
						{
							recommend = recommendCos();
							recommendConsole(recommend);
						}
						
						break;
					}
				case 3: //���������� ���
					if(loginId.equals("manager"))
					{
						clear();
						int manager = 0; 
						if (loginId.equals("manager"))
						{	
							while(manager != 9)
							{
								manager = manager();
								managerSystem(manager);
							}
						}
						else
						{
							System.out.println("[���] ������ �����ϴ�.");
						}
						break;
					}
					else
					{
						int mypage = 0;
						while(mypage != 9)
						{
							clear();
							mypage = mypage();
							mypageMenu(mypage);
						}
						break;
					}
				case 9: //�α׾ƿ�
					clear();
					if(loginId != null) loginId = null;
					if(loginId != null) cus = null;
					return;
				default:
					System.out.println("[�߸��ȸ޴���ȣ]");
				}
			
			
			}
		}

		
		
		
		
		
		
		public void mypageMenu(int mypage) {
			switch(mypage)
			{
			case 1:				//��й�ȣ ����
				clear();
				pwChange();
				System.out.println("<����Ͻ÷��� ����ġ����>");
				input.nextLine();
				break;
			case 2:				//ȸ�� Ż��
				clear();

				if(deleteCustomer())
				{
					StartUI();
					return;
				}
				break;
			case 3://����
				clear();
				int zzim = 0;
				while(zzim != 9)
				{
					zzim = zzim();
					
					zzimMenu(zzim);

				}
				break;
				
			case 9:				//�����޴�
				clear();
				return;
				
			default:
				System.out.println("[�߸��ȸ޴���ȣ]");
			}
		}


		public void zzimMenu(int zzim) {
			switch(zzim)
			{
			
			case 1://1.�� ����
				int cosNumber = getNextInt("[�˸�] ������ ��ǰ��ȣ�� �Է����ּ��� : ");
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("id", loginId);
				map.put("cosNumber", cosNumber);
				
				if(dao.deleteFavorite(map) != 0)
				{
					System.out.println("[�˸�] ���� ����");
				}
				else
				{
					System.out.println("[�˸�] ���� ����");
				}
				System.out.println("<����Ͻ÷��� ����ġ����>");
				input.nextLine();
				break;
			case 2://2.�� ����Ʈ����
				List<Cosmetic> list = dao.printFavorite(loginId);
				
					if(list.isEmpty())
					{
						System.out.println("===== ����Ͻ� ���� �����ϴ� =====");
						System.out.println("<���ư��÷��� ����ġ����>");
						input.nextLine();
						break;
					}
					clear();
				System.out.println("[ �� ��� ]");
				System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
				for(int a = 0 ; a < list.size() ; a++)
				{
					System.out.printf(" %-5s  ", "[��ǰ��ȣ]");
					System.out.printf(" %-17s  ", "[��ǰ��]");
					System.out.printf(" %-10s  ", "[����]");
					System.out.printf(" %-10s  ", "[�귣��]");
					System.out.printf(" %-10s  ", "[����]");
					System.out.println();
					cosNumber = list.get(a).getCosNumber();
					StringBuffer sb = new StringBuffer();
					sb.append(list.get(a).getCosName());
					sb.append(abc(list.get(a)));
					System.out.printf("   %-5d  ", list.get(a).getCosNumber());
					System.out.print(sb.toString());
					System.out.printf("   %-10s  ", df.format(list.get(a).getCosPrice()));
					System.out.printf("   %-10s  ", list.get(a).getCosBrand());
					System.out.printf("   %-10f", dao.getGradeAvg(cosNumber));
					System.out.println();
				}
				System.out.println("������������������������������������������������������������������������������������������������������������������������������������������");
				System.out.println("<���ư��÷��� ����ġ����>");
				input.nextLine();
				break;
			default:
				
				break;
			}
			
		}
		



		public void managerSystem(int manager) {
			// TODO Auto-generated method stub
			switch(manager)
			{
			case 1: //��ǰ���
				insertCos();
				break;
			case 2: //��ǰ ��������
				cosChange();
				break;
			case 3: //��ǰ ����
				cosDelete();
				break;
			case 4: //��ǰ ����Ʈ
				cosList();
				break;
			case 9: //�����޴�
				clear();
				break;
			default:
				System.out.println("[�߸��ȸ޴���ȣ]");
			}
		

		}
		

		public void recommendConsole(int recommend) {
			// TODO Auto-generated method stub
			switch(recommend)
			{
				case 1: //������ ����
					clear();
					basicType();
					clear();
					break;
					
				case 2: //���ݼ� ����
					clear();
					priceType();
					clear();
					break;
					
				case 3: //������ ����
					clear();
					gradeType();
					clear();
					break;
					
				case 4: //���亸�� + ��ǰ����
					cosInformation();
					clear();
					break;
					
				case 5: //���ϱ�
					int zzim = getNextInt("[�ȳ�] �� �Ͻ� ��ǰ�� ��ȣ�� �Է��ϼ��� : ");
					Favorite f = new Favorite(zzim, loginId);
					Cosmetic c = dao.getCosmetic(f.getCosNumber());
					if(dao.insertFavorite(f) == 0 || c == null)
					{
						System.out.println("[���]�� ��� ����");
					}
					else
					{
						System.out.println("[���]�� ��� ����");
					}
					break;
					
				case 6: //�����ۼ�
					clear();
					insertReview();
					clear();
					break;
				case 7: //��� ��ǰ����
					cosList();
					break;
					
				case 9:  //�����޴�
					clear();
					return;
				
				default:
					System.out.println("[�߸��� �޴���ȣ]");
					break;
					
			}
			
		}
		/*
		[����]
		ȭ��ǰ ��ȣ : 1~ 150
		���� : 0.0 ~ 5.0 random
		���� ���� : 30 ��������
		���� id : ��������random(1~12) + char a~z ���� + 1~9 stringbuffer 
		���� ��¥ : sysdate - 1~730
		*/

		//ȭ�� �о��
		public void clear() {
			 for (int i = 0; i < 60; i++)
			  System.out.println("");
		}


		
		
		public void maincosmetic() {
			/*
			System.out.print("\t  ����������		");
			System.out.println("\t\t  ����������		");
			System.out.print("\t������������������		");
			System.out.println("\t������������������		");
			System.out.print("\t��\t��		");
			System.out.println("\t��\t��		");
			System.out.print("\t��\t��		");
			System.out.println("\t��\t��		");
			System.out.print("\t��\t��		");	
			System.out.println("\t��\t��		");	
			System.out.print("\t��\t��		");
			System.out.println("\t��\t��		");
			System.out.print("\t��\t��		");
			System.out.println("\t��\t��		");
			System.out.print("\t��\t��		");
			System.out.println("\t��\t��		");
			System.out.print("\t������������������		");	
			System.out.println("\t������������������		");	
			*/
			System.out.println("                                        .+=++=+=+ \r\n" + 
					"        ++             ++             +=#*##*##%==:  \r\n" + 
					"     ==##==          ==%#==        :==#*==**+**##%+=: \r\n" + 
					"      @%  %@          @#  @@        =@#==*+****#%*%**= \r\n" + 
					"      #*  *#        :=#*  ##::      =@*==@%    **+*: \r\n" + 
					"   :@#.   .#@=:  :+@#.:   %%      =@*==#*::   \r\n" + 
					"   :@#.    *##%#@##*       #%      :#+==..%%.: \r\n" + 
					"  .:%*.      .+#*#+         %...     %*:=..%@ \r\n" + 
					" =@#  ==:=    +#*#+    ==++  #@:       @%.:%@ \r\n" + 
					" =@*  @%%@             @#%@  #@:       %#..%@ \r\n" + 
					" =@*  @#%%             @#%%  #%#@#@#@#@%.:::%@ \r\n" + 
					" =@*                      =#@*#*#*#*@#.:@@   \r\n" + 
					"   :@%                    @=%@:.*#=.=#*.:@%   \r\n" + 
					"     @%@@%@#@#@#@#@#@#@%@@..::*%=:=%*::@%   \r\n" + 
					"            #@:.:.:.:.:.:..:::::.:::.:::@%   \r\n" + 
					"            #@=:======================::@%   \r\n" + 
					"            #@=:*@#@#@#@%@@%@%@#@#@#@#.:@%   \r\n" + 
					"           #@:.+@*:=@#        *@+:+@*.:@%   \r\n" + 
					"           %@%@#@#@%@%        *@#@#@#@%@%  \r\n" + 
					"");
			
		}
		
		
		
}
