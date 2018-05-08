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
				Customer manager = new Customer("manager", "manager", 99, "99", "관성");
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
			case 1: //접속
				clear();
				connection = connection();	//접속 메뉴창
				clear();
				while(connection != 9)
				{
					if(connection == 1)
					{
						String loginGo = login();	
						loginId = loginGo; //로그인 창
						
						if (loginId != null)
						{
							clear();
							startWelcome(); //웰컴화면 보여주는 루프문
							break;
						}
						else
						{
							break;
						}
					}
					else
					{
						System.out.println("[에러] 메뉴번호가 없습니다.");
						break;
					}
				}//while
				break;
				
			case 2: //회원가입 : 회원가입 완료시 첫메뉴
				clear();
				if(register())
				{
					System.out.println("[가입을 환영합니다!]");
				}
				else
				{
					System.out.println("[가입에 실패하였습니다]");
				}
				break;
			case 3: //설명
				clear();
				maincosmetic();
				programInformation();
				System.out.print("<돌아가시려면 엔터치세요>");
				input.nextLine();
				break;
			case 9:
				//첫메뉴로 돌아가기
				
				break out;
			default:
				System.out.println("[잘못된메뉴번호]");
				
			}

		}
		while(menu != 9);
		
	}//startUI
		
		
		
		
		//프로그램 소개
		private void programInformation() {
			// TODO Auto-generated method stub
			
			System.out.println("┌──────────────────────────────────────────────────┐");
			System.out.println("         	  화장품 추천 프로그램 소개                    ");
			System.out.println("└──────────────────────────────────────────────────┘");
			System.out.println("┌──────────────────────────────────────────────────┐");
			System.out.println("   이 프로그램은 수천 수백의 화장품 중에서 자신의 피부타입에");
			System.out.println("   맞는 화장품 만을 딱 3개만 추천해 드리는 프로그램입니다. ");
			System.out.println("   가격 및 사용자리뷰 그리고 가성비를 기준으로 다양하게 추천");
			System.out.println("   받으실 수 있으니 이 프로그램을 통해 결정장애를 극복하세요!");
			System.out.println("└──────────────────────────────────────────────────┘");
		}


		public void startWelcome() {
			
			while(true)
			{ 

				int welcome = welcome();		//웰컴화면
				switch (welcome)
				{
				case 1: //피부타입 측정하기
				if(loginId.equals("manager"))
				{
					System.out.println("[경고] 무분별한 리뷰 삭제는 회원님의 반발을 살 수 있습니다.");
					int reviewNum = getNextInt("삭제 할 리뷰 번호 : ");
					if(dao.deleteReview(reviewNum) != 0)
					{
						System.out.println("삭제 성공");
					}
					else
					{
						System.out.println("[알림] 삭제할 리뷰가 없습니다.");
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
						System.out.println("==========피부타입 측정완료============");
					}
					else
					{
						System.out.println("==========피부타입 측정실패============");
					}
					
						break;
				}
				//	Customer cus = dao.getCustomerInfo(입력한아이디);
				//	cus.getPw().equals(입력한 비밀번호)
					
				case 2:	//추천화장품 보기
				if(loginId.equals("manager"))
				{
					System.out.println("[경고] 정당한 사유 없는 강퇴는 법적 소송의 근거가 될 수 있습니다.");
					System.out.print("강제탈퇴 시킬 회원의 아이디 : ");
					String id = input.next();
					input.nextLine();
						try 
						{
							Map<String, String> map = new HashMap<String, String>();
							map.put("id", id);
							map.put("pw", dao.getCustomerInfo(id).getPw());
							if(dao.deleteCustomer(map) != 0)
							{
								System.out.println("[알림] " + id + "님이 삭제되었습니다.");
							}
							else
							{
								System.out.println("[알림]삭제 실패 : 없는 아이디 이거나 탙퇴 시킬 수 없는 회원입니다.");
							}
						}
						catch(Exception e)
						{
							System.out.println("[알림]삭제 실패 : 없는 아이디 이거나 탙퇴 시킬 수 없는 회원입니다.");
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
								System.out.println("[알림] 피부 자가진단을 먼저 해주세요.");
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
				case 3: //마이페이지 출력
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
							System.out.println("[경고] 권한이 없습니다.");
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
				case 9: //로그아웃
					clear();
					if(loginId != null) loginId = null;
					if(loginId != null) cus = null;
					return;
				default:
					System.out.println("[잘못된메뉴번호]");
				}
			
			
			}
		}

		
		
		
		
		
		
		public void mypageMenu(int mypage) {
			switch(mypage)
			{
			case 1:				//비밀번호 변경
				clear();
				pwChange();
				System.out.println("<계속하시려면 엔터치세요>");
				input.nextLine();
				break;
			case 2:				//회원 탈퇴
				clear();

				if(deleteCustomer())
				{
					StartUI();
					return;
				}
				break;
			case 3://찜목록
				clear();
				int zzim = 0;
				while(zzim != 9)
				{
					zzim = zzim();
					
					zzimMenu(zzim);

				}
				break;
				
			case 9:				//상위메뉴
				clear();
				return;
				
			default:
				System.out.println("[잘못된메뉴번호]");
			}
		}


		public void zzimMenu(int zzim) {
			switch(zzim)
			{
			
			case 1://1.찜 삭제
				int cosNumber = getNextInt("[알림] 삭제할 상품번호를 입력해주세요 : ");
				
				Map<String, Object> map = new HashMap<>();
				
				map.put("id", loginId);
				map.put("cosNumber", cosNumber);
				
				if(dao.deleteFavorite(map) != 0)
				{
					System.out.println("[알림] 삭제 성공");
				}
				else
				{
					System.out.println("[알림] 삭제 실패");
				}
				System.out.println("<계속하시려면 엔터치세요>");
				input.nextLine();
				break;
			case 2://2.찜 리스트보기
				List<Cosmetic> list = dao.printFavorite(loginId);
				
					if(list.isEmpty())
					{
						System.out.println("===== 등록하신 찜이 없습니다 =====");
						System.out.println("<돌아가시려면 엔터치세요>");
						input.nextLine();
						break;
					}
					clear();
				System.out.println("[ 찜 목록 ]");
				System.out.println("┌───────────────────────────────────────────────────────────────────┐");
				for(int a = 0 ; a < list.size() ; a++)
				{
					System.out.printf(" %-5s  ", "[상품번호]");
					System.out.printf(" %-17s  ", "[상품명]");
					System.out.printf(" %-10s  ", "[가격]");
					System.out.printf(" %-10s  ", "[브랜드]");
					System.out.printf(" %-10s  ", "[별점]");
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
				System.out.println("└───────────────────────────────────────────────────────────────────┘");
				System.out.println("<돌아가시려면 엔터치세요>");
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
			case 1: //상품등록
				insertCos();
				break;
			case 2: //상품 정보수정
				cosChange();
				break;
			case 3: //상품 삭제
				cosDelete();
				break;
			case 4: //상품 리스트
				cosList();
				break;
			case 9: //상위메뉴
				clear();
				break;
			default:
				System.out.println("[잘못된메뉴번호]");
			}
		

		}
		

		public void recommendConsole(int recommend) {
			// TODO Auto-generated method stub
			switch(recommend)
			{
				case 1: //가성비 보기
					clear();
					basicType();
					clear();
					break;
					
				case 2: //가격순 보기
					clear();
					priceType();
					clear();
					break;
					
				case 3: //별점순 보기
					clear();
					gradeType();
					clear();
					break;
					
				case 4: //리뷰보기 + 상품보기
					cosInformation();
					clear();
					break;
					
				case 5: //찜하기
					int zzim = getNextInt("[안내] 찜 하실 상품의 번호를 입력하세요 : ");
					Favorite f = new Favorite(zzim, loginId);
					Cosmetic c = dao.getCosmetic(f.getCosNumber());
					if(dao.insertFavorite(f) == 0 || c == null)
					{
						System.out.println("[결과]찜 등록 실패");
					}
					else
					{
						System.out.println("[결과]찜 등록 성공");
					}
					break;
					
				case 6: //리뷰작성
					clear();
					insertReview();
					clear();
					break;
				case 7: //모든 상품보기
					cosList();
					break;
					
				case 9:  //상위메뉴
					clear();
					return;
				
				default:
					System.out.println("[잘못된 메뉴번호]");
					break;
					
			}
			
		}
		/*
		[리뷰]
		화장품 번호 : 1~ 150
		별점 : 0.0 ~ 5.0 random
		리뷰 내용 : 30 돌려쓰기
		리뷰 id : 몇자인지random(1~12) + char a~z 랜덤 + 1~9 stringbuffer 
		리뷰 날짜 : sysdate - 1~730
		*/

		//화면 밀어내기
		public void clear() {
			 for (int i = 0; i < 60; i++)
			  System.out.println("");
		}


		
		
		public void maincosmetic() {
			/*
			System.out.print("\t  ┌───┐		");
			System.out.println("\t\t  ┌───┐		");
			System.out.print("\t┌─┴───┴─┐		");
			System.out.println("\t┌─┴───┴─┐		");
			System.out.print("\t│\t│		");
			System.out.println("\t│\t│		");
			System.out.print("\t│\t│		");
			System.out.println("\t│\t│		");
			System.out.print("\t│\t│		");	
			System.out.println("\t│\t│		");	
			System.out.print("\t│\t│		");
			System.out.println("\t│\t│		");
			System.out.print("\t│\t│		");
			System.out.println("\t│\t│		");
			System.out.print("\t│\t│		");
			System.out.println("\t│\t│		");
			System.out.print("\t└───────┘		");	
			System.out.println("\t└───────┘		");	
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
