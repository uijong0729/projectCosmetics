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
			
	
	//첫메뉴 UI
	public int firstMenu() {
	
		System.out.println("┌──────────────────────────────────────────────────┐");
		System.out.println("         	 화장품 추천 프로그램                              ");
		System.out.println("└──────────────────────────────────────────────────┘");
		System.out.println("┌──────────────────────────────────────────────────┐");
		System.out.println("  1.접속                         	    ");	
		System.out.println("  2.회원가입                   	    ");	
		System.out.println("  3.프로그램 소개                  	    ");	
		System.out.println("  9.종료                    	       ");	
		System.out.println("└──────────────────────────────────────────────────┘");
		int menu = this.getNextInt("메뉴번호 : ");
		if (menu == 9)
		{
			System.out.println("========== 종료합니다 ==========");
			//exitJpeg();
			System.exit(0);
		}
		return menu;
		}
	
	//2.회원가입
	public boolean register() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("        회원가입   			   ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("──────────────────────────────┐");
		
        //회원정보 등록
		System.out.print(" ID : ");
		loginId = input.next();
		input.nextLine();
		boolean result = false; 
		while(result == false) 
		{
			if(dao.getCustomerInfo(loginId) != null)
			{
				System.out.println("동일한 아이디가 존재합니다.");
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

		
		int cusAge = getNextInt(" 나이 : ");
		
		//남, 여만 입력받도록
		String cusGender;
		boolean ok;
		do{
			System.out.print(" 성별( M / F ) : ");
			cusGender = input.nextLine().toUpperCase();
						
			
			if(!(cusGender.equals("M") || cusGender.equals("F"))) 
			{
				System.out.println("성별( M / F )를 다시 입력해 주세요.");
				ok = false;
			}else 
			{
				System.out.println("회원가입이 완료되었습니다.");
				System.out.println("└──────────────────────────────");
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
	
	
	//접속 UI
	public int connection() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("          접속                              ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println("  1.로그인                                     ");	
		System.out.println("  9.나가기                                     ");	
		System.out.println("└──────────────────────────────┘");
		return this.getNextInt("메뉴번호 : ");
	}
	
	//로그인 UI //확인해보기
	public String login() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("        로그인                               ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.print(" ID : " );
		loginId = input.nextLine();
		
		System.out.print(" PW : ");
		String pw = input.nextLine();
		System.out.println("└──────────────────────────────┘");
		
		int check = 0;
		
		
		
		List<Customer> cusList = dao.getCustomerList();
			for (Customer customer : cusList) {
				//아이디 존재 확인
				if(customer.getId().equals(loginId)) {
					//아이디 존재 	
					check++;
				}
				//비밀번호 일치 확인
				try 
				{
					if(dao.getCustomerInfo(loginId).getPw().equals(pw)) {
						//비밀번호 일치
					check++;	
					}
				}
				catch(NullPointerException e)
				{}
				
				if(check == 2) {
					System.out.println("로그인 성공!");
					return loginId;
					
				}
		}//for문  
			if( check < 2) {
				System.out.println("로그인에 실패하셨습니다.");
				System.out.println("<계속하시려면 엔터를 눌러주세요>");
				input.nextLine();
				loginId = null;
			}
			
			return loginId;
	}
	
	//welcome UI
	public int welcome() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│           welcome!           │ ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		if(!(loginId.equals("manager"))) {System.out.println(" 1.피부 자가진단");} else {System.out.println(" 1.[관리자] 악성리뷰 및 스팸리뷰 삭제");}	
		if(!(loginId.equals("manager"))) {System.out.println(" 2.나에게 맞는 화장품 보기");} else {System.out.println(" 2.[관리자] 회원 강제탈퇴");}	
		if(!(loginId.equals("manager"))) {System.out.println(" 3.마이페이지");} else {System.out.println(" 3.[관리자] 상품 관리 시스템");}	
		System.out.println(" 9.로그아웃                       ");	
		System.out.println("└──────────────────────────────┘");
		return this.getNextInt("메뉴번호 : ");
	}
		
	
	//1.피부 자가진단
	public String skinTest() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("          피부 자가진단                   ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("* 1: 전혀 아니다 2: 아니다 3: 보통이다 4: 그렇다  5: 매우 그렇다" );
				      System.out.println("┌─────────────────────────────────────────────────────────────┐");
		int score1 = this.getNextIntMax5(" 1.하루라도 머리를 감지 않으면 금방 기름이진다. >> ");
		int score2 = this.getNextIntMax5(" 2.머리를 자주 감아도 간지럽고 비듬이 많다. >> ");
		int score3 = this.getNextIntMax5(" 3.코 주변에 블랙헤드, 화이트헤드가 많다. >> ");
		int score4 = this.getNextIntMax5(" 4.세안 후 아무것도 바르지 않아도 당기거나 건조한 느낌이 없다. >> ");
		int score5 = this.getNextIntMax5(" 5.얼굴에 기름이 쉽게 생기는 듯한 기분이 든다. >> ");
		int score6 = this.getNextIntMax5(" 6.춥고 건조한 날씨에도 피부가 가렵거나 따갑지 않다. >> ");
		int score7 = this.getNextIntMax5(" 7.끈적한 느낌보다 산뜻한 느낌의 화장품이 좋다. >> ");
		int score8 = this.getNextIntMax5(" 8.맨 얼굴일때 모공이 크게 보인다. >> ");
		int score9 = this.getNextIntMax5(" 9.기름종이나 티슈로 얼굴의 기름기를 자주 닦아낸다. >> ");
		int score10 = this.getNextIntMax5(" 10.세안 후 5시간 이상 지나면 얼굴에 유분기가 많이 도는 편이다. >> ");
		               System.out.println("└─────────────────────────────────────────────────────────────┘");
		
		//평균 점수 
		int sum = (score1 + score2 + score3 + score4 + score5
				+ score6 + score7 + score8 + score9 + score10) ; 
		double avg = sum;
		
		//0~15점 건성피부
		if(avg>0 && avg<=15) {
			String skin = "건성";
			System.out.println(skin + "피부 입니다.");
			return skin;
		}
		
		//16~30점 중성피부
		else if(avg>15 && avg<=30) {
			String skin = "중성";
			System.out.println(skin + "피부 입니다.");
			return skin;
		}
		
		//31~50점 지성피부
		else 
		{
			String skin = "지성";
			System.out.println(skin + "피부 입니다.");
			return skin;
		}	
		
	}
	
	//2.나에게 맞는 화장품보기
	public int recommendCos() {
		System.out.println("┌────────────────────────────────┐");
		System.out.println("      " + loginId +"님" + "을 위한 추천 화장품 ");
		System.out.println("└────────────────────────────────┘");
		System.out.println("┌────────────────────────────────────────┐");
		System.out.println(" 1.가성비 보기");
		System.out.println(" 2.가격별");	
		System.out.println(" 3.별점 순 추천");	
		System.out.println(" 4.상품정보 보기(리뷰)");
		System.out.println(" 5.찜하기");
		System.out.println(" 6.리뷰작성");
		System.out.println(" 7.모든 화장품 리스트");
		System.out.println(" 9.나가기                                                          ");	
		System.out.println("└────────────────────────────────────────┘");
		return this.getNextInt("메뉴번호 : ");
		
		
	}
	
	


	//2-1 가성비 보기
	public void basicType() {
		System.out.println("[추천 로션 TOP 3]");
		System.out.println("┌────────────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s  ", "[상품번호]");
		System.out.printf(" %-17s  ", "[상품명]");
		System.out.printf(" %-10s  ", "[가격]");
		System.out.printf(" %-10s  ", "[브랜드]");
		System.out.printf(" %-10s  ", "[별점]");
		System.out.println();
		Customer cu = dao.getCustomerInfo(loginId);
		CosDAO dao = new CosDAO();
		List<Cosmetic> list = dao.getCosmeticList();
		AssortPriceXGrade sorter = new AssortPriceXGrade();
		Collections.sort(list, sorter);
		int count = 0;
		for(int a = 0 ; a < list.size() ; a++)
		{
			boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("로션");
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
		System.out.println("└────────────────────────────────────────────────────────────────────────────┘");
		
		System.out.println("[추천 스킨 TOP 3]");
		System.out.println("┌────────────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s  ", "[상품번호]");
		System.out.printf(" %-17s  ", "[상품명]");
		System.out.printf(" %-10s  ", "[가격]");
		System.out.printf(" %-10s  ", "[브랜드]");
		System.out.printf(" %-10s  ", "[별점]");
		System.out.println();
		
		count = 0;
		for(int a = 0 ; a < list.size() ; a++)
		{
			boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("스킨");
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
		System.out.println("└────────────────────────────────────────────────────────────────────────────┘");
		System.out.print("<계속하려면 엔터치세요>");
		input.nextLine();
	}
	
	
	//2-2 가격별(가격 낮은 순서대로 출력 )
	public void priceType() {
		List<Cosmetic> list = dao.getCosmeticList();
		Customer cu = dao.getCustomerInfo(loginId);
		AssortInt sor = new AssortInt();
		Collections.sort(list, sor);
		System.out.println("[추천 로션 TOP 3]");
		System.out.println("┌────────────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s  ", "[상품번호]");
		System.out.printf(" %-17s  ", "[상품명]");
		System.out.printf(" %-10s  ", "[가격]");
		System.out.printf(" %-10s  ", "[브랜드]");
		System.out.printf(" %-10s  ", "[별점]");
		System.out.println();	
		int count = 0;
		//가격순 3개 뽑기
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("로션");
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
			System.out.println("└────────────────────────────────────────────────────────────────────────────┘");
		
		System.out.println("[추천 스킨 TOP 3]");
		System.out.println("┌────────────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s  ", "[상품번호]");
		System.out.printf(" %-17s  ", "[상품명]");
		System.out.printf(" %-10s  ", "[가격]");
		System.out.printf(" %-10s  ", "[브랜드]");
		System.out.printf(" %-10s  ", "[별점]");
		System.out.println();
		count = 0;
		//가격순 3개 뽑기
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("스킨");
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
			System.out.println("└────────────────────────────────────────────────────────────────────────────┘");
		
			System.out.print("<계속하려면 엔터치세요>");
			input.nextLine();
	}
	
	//2-3 별점추천 (별점 순 출력)
	public void gradeType() {
		List<Cosmetic> list = dao.getCosmeticList();
		Customer cu = dao.getCustomerInfo(loginId);
		AssortDouble sor2 = new AssortDouble();
		Collections.sort(list, sor2);
		System.out.println("[추천 로션 TOP 3]");
		System.out.println("┌────────────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s  ", "[상품번호]");
		System.out.printf(" %-17s  ", "[상품명]");
		System.out.printf(" %-10s  ", "[가격]");
		System.out.printf(" %-10s  ", "[브랜드]");
		System.out.printf(" %-10s  ", "[별점]");
		System.out.println();
		int count = 0;
		//별점 순 3개 뽑기
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("로션");
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
			System.out.println("└────────────────────────────────────────────────────────────────────────────┘");
		
		System.out.println("[추천 스킨 TOP 3]");
		System.out.println("┌────────────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s  ", "[상품번호]");
		System.out.printf(" %-17s  ", "[상품명]");
		System.out.printf(" %-10s  ", "[가격]");
		System.out.printf(" %-10s  ", "[브랜드]");
		System.out.printf(" %-10s  ", "[별점]");
		System.out.println();
		count = 0;
		//별점 순 3개 뽑기
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("스킨");
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
			System.out.println("└────────────────────────────────────────────────────────────────────────────┘");
			System.out.print("<계속하려면 엔터치세요>");
			input.nextLine();
	}
	//상품명 글자수 맞추기
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
	
	//2-4 상품정보 보기
	public void cosInformation() {
		Cosmetic cos = new Cosmetic();
			
		int cosNum = getNextInt("상품번호를 입력하세요 : ");
		
		System.out.println("┌─────────────────────────────┐");
		System.out.println("       상품정보 보기(리뷰) 	  ");	
		System.out.println("└─────────────────────────────┘");
		System.out.println("────────────────────────────────────────");
		cos = dao.getCosmetic(cosNum);
		try 
		{
			System.out.print("  [상품명]  ");
			System.out.println(cos.getCosName());
			
			System.out.print("  [상품정보]"  );
			System.out.println(cos.getCosContent());
	
			
			List<Review> cosReview = dao.getReview(cosNum);
		
			double total = 0;
			if(!(cosReview.isEmpty()))
			{	for (Review review : cosReview) 
				{
					System.out.printf("  [리뷰내용] %-20s [별점] %4f [작성일] %20s %n", review.getContent(),  review.getCosGrade(), review.getIndate());
					total += review.getCosGrade();			
				}
				System.out.println("  [평균 별점] " + total / cosReview.size());
			}
			else
			{
				System.out.println("  [리뷰] 리뷰가 없습니다");
			}
			System.out.println("────────────────────────────────────────");
		}//try
		catch(NullPointerException e)
		{
			System.out.println("상품 정보가 없습니다.");
		}//catch
		System.out.println("<계속하려면 엔터치세요> ");
		input.nextLine();
		
	}//상품정보보기
	
	//2-5 찜하기 UI2
	
	//2-6 리뷰작성
	public boolean insertReview() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("       리뷰작성      ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("──────────────────────────");
		int cosNum = this.getNextInt(" 상품번호 : ");
		System.out.print(" 리뷰내용 : ");	
		String content = input.nextLine();
		double cosGrade = this.getNextDouble(" 리뷰별점 : ");		
		System.out.println("──────────────────────────");
		
		Review review = new Review(cosNum, loginId ,content, cosGrade);
		try {
		Cosmetic replace = dao.getCosmetic(cosNum);
		replace.setCosGrade(cosGrade);
		dao.updateGrade(replace);
		}
		catch(NullPointerException e)
		{
			System.out.println("해당 상품이 없습니다.");
		}
	//	review.setCosNum(cosNum);
		if(dao.insertReview(review) == 0) {
			System.out.println("등록을 실패하였습니다.");
			return false;
		}
		else {
			System.out.println("리뷰등록이 완료되었습니다.");
			return true ;
		}
		
	}
	
	
	//3.마이페이지
	public int mypage() {
	cus = dao.getCustomerInfo(loginId);
		System.out.println("┌──────────────────────────────┐");
		System.out.println("        마이 페이지                  ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("────────────────────────────────────────");
		System.out.println(" ID : " + loginId);	
		System.out.println(" 나이 : " + cus.getCusAge());	
		System.out.println(" 성별 : " + cus.getCusGender());	
		System.out.println(" 피부타입 : " + ((cus.getCusSkinType() == null) ? "피부테스트를 실행해주세요" : cus.getCusSkinType()))  ;	
		System.out.println("────────────────────────────────────────");
		System.out.println("┌────────────────────────────────────────┐");
		System.out.println(" 1.비밀번호 변경  				 ");	
		System.out.println(" 2.회원 탈퇴 		 	         ");	
		System.out.println(" 3.찜메뉴 		 	         ");	//목록 만들기 
		System.out.println(" 9.상위메뉴  			         ");	
		System.out.println("└────────────────────────────────────────┘");
		return this.getNextInt("메뉴번호 : ");

		
	}
	
	
	//3-1 비밀번호 변경
	public String pwChange() {
		cus = dao.getCustomerInfo(loginId);
		
		System.out.println("┌──────────────────────────────┐");
		System.out.println("         비밀번호 변경      	       ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("────────────────────────────────");
		System.out.print(" 기존 비밀번호 입력 : ");	
		String pw = input.nextLine();
		if(cus.getPw().equals(pw)) {
			System.out.print(" 새로운 비밀번호 입력 : ");
			String NewPw = input.nextLine();
			System.out.print(" 새로운 비밀번호 확인 : ");
			String reNewPw = input.nextLine();
			if(NewPw.equals(reNewPw)) {
				Customer updateCus = new Customer(cus.getId(), NewPw, cus.getCusAge(), cus.getCusGender(), cus.getCusSkinType());
				
				int result = dao.updateCustomer(updateCus);
				//이 안에서 비밀번호가 변경성공했는지 안했는지 여부 확인 
				if(result == 0) {
					System.out.println("비밀번호 변경을 실패하였습니다.");
				}else {
					System.out.println("비밀번호가 변경되었습니다");
				}
			}
			System.out.println("──────────────────────────────── ");
			return NewPw;
		
		}else {
			System.out.println("비밀번호가 틀렸습니다.");
			System.out.println("<돌아가시려면 엔터를 입력하세요>");
			input.nextLine();
			return cus.getPw();
		}
		
		
		
	
	}
			        
	//3-2 회원 탈퇴
	public boolean deleteCustomer() {
		cus = dao.getCustomerInfo(loginId);
		if(loginId.equals("manager"))
		{
			System.out.println("[경고] 관리자는 탈퇴 할 수 없습니다");
			return false;
		}
		System.out.println("┌──────────────────────────────┐");
		System.out.println("│        회원 탈퇴      	       │");
		System.out.println("└──────────────────────────────┘");
		System.out.println("────────────────────────────────");
		System.out.print(" 비밀번호 입력 : ");	
		String pw = input.nextLine();
		//비밀번호가 같으면 탈퇴여부 띄우기
		if(cus.getPw().equals(pw)) 
		{
			System.out.println(" [알림] 회원을 탈퇴하시겠습니까? (Y/N) ");	
			String yn = input.nextLine();
			
			if(yn.equals("y") || yn.equals("Y")) {
				//
				Map<String, String> map = new HashMap<>();
				map.put("id", loginId);
				map.put("pw", pw);
				if(dao.deleteCustomer(map) == 0) {
					System.out.println(" [알림] 회원 탈퇴를 실패하였습니다.");
					System.out.println("──────────────────────────────── ");
					return false;
				}
				else {
					dao.deleteUserFavorite(loginId);
					System.out.println(" [알림] 탈퇴되었습니다.");
					System.out.println("──────────────────────────────── ");
					System.out.println("<계속하려면 엔터치세요>");
					input.nextLine();
					return true;
					}
				}
			else
				{
					System.out.println(" [알림] 탈퇴가 취소되었습니다.");
					System.out.println("└──────────────────────────────── ");
					return false;
				}
	
		
		}else {
			System.out.println(" [알림] 비밀번호가 틀렸습니다.");
			return false;
		}	
	}
	

	//3-3 찜목록
	public int zzim(){
		System.out.println("┌──────────────────────────────┐");
		System.out.println("        찜메뉴                               ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌──────────────────────────────┐");
		System.out.println(" 1. 찜 삭제                                     ");	
		System.out.println(" 2. 찜 목록                                     ");	
		System.out.println(" 9. 나가기                                      ");	
		System.out.println("└──────────────────────────────┘");
		return getNextInt("[메뉴번호입력] : ");
	}
	
	//8 관리자
	public int manager() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("        관리자       ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("┌────────────────────────────────────────┐");
		System.out.println(" 1.상품 등록 								 ");	
		System.out.println(" 2.상품 정보 수정 						  ");	
		System.out.println(" 3.상품 삭제     							  ");	
		System.out.println(" 4.상품 리스트                  				");	
		System.out.println(" 9.상위메뉴                				");	
		System.out.println("└────────────────────────────────────────┘");
		return this.getNextInt("메뉴번호 : ");	
	}
	
	//8-1 상품등록
	public boolean insertCos() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("            상품 등록       ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("───────────────────────────────");
		System.out.print(" 이름 : ");	
		String cosName = input.nextLine();
		
		int cosPrice = this.getNextInt("가격 : ");
		System.out.print(" 브랜드 : ");	
		String cosBrand = input.nextLine();
		System.out.print(" 상품소개 :	");	
		String cosContent = input.nextLine();
		System.out.print(" 피부타입 : ");
		String cosSkinType = input.nextLine();
		System.out.print(" 상품타입 : ");	
		String cosType = input.nextLine();
		
		System.out.println("───────────────────────────────");
		Cosmetic cos = null;
		cos = new Cosmetic(cosName, cosPrice, cosBrand, cosContent, cosSkinType, cosType);
		if(dao.insertCosmetic(cos) == 0)
		{
			System.out.println("등록을 실패하였습니다.");
			return false;
		}
		else
		{
			System.out.println("상품등록이 완료되었습니다.");
			return true ;
		}
		
	}
	
	//8-2 상품 정보 수정
	public boolean cosChange() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("       상품 정보 수정      ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("────────────────────────────────");
		int cosNumber = this.getNextInt(" 상품 번호 : ");
		//번호가 존재하면 1.가격 , 2.상품소개 수정화면 출력  //아니면 "존재하지 않는 상품입니다." 출력
		Cosmetic a = dao.getCosmetic(cosNumber);
		if ( a == null)
		{
			System.out.println("존재하지 않는 상품입니다.");
			return false;
		}
		else {
			int cosRePrice = this.getNextInt("1.가격 : ");
				System.out.print(" 2.상품 소개 : ");	
				String cosReIntroduction = input.nextLine();
				System.out.println("────────────────────────────────");
				Cosmetic updateCos = new Cosmetic();
				updateCos.setCosNumber(cosNumber);
				updateCos.setCosPrice(cosRePrice);
				updateCos.setCosContent(cosReIntroduction);
				
				if(dao.updateCosmetic(updateCos) != 0) {
					System.out.println("상품 정보 수정을 완료하였습니다.");
					return true;
				}
				else {
					System.out.println("상품 정보 수정을 실패하였습니다.");
					return false;
				}
		}
		
			}
	
	//8-3 상품 삭제
	public boolean cosDelete() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("           상품 삭제      ");
		System.out.println("└──────────────────────────────┘");
		System.out.println("────────────────────────────────────────");
		int cosNumber = this.getNextInt(" 삭제할 상품번호를 입력하세요 : ");
		if(dao.deleteCosmetic(cosNumber) == 0) {
			System.out.println("상품 삭제를 실패했습니다.");
			System.out.println("────────────────────────────────────────");
			return false;

		}
		else {
			System.out.println("상품을 삭제하였습니다.");
			System.out.println("────────────────────────────────────────");
			return true;
		}
	}
	
	//8-4 상품 리스트
	public void cosList() {
		System.out.println("┌──────────────────────────────┐");
		System.out.println("         상품 리스트                       ");
		System.out.println("└──────────────────────────────┘");
		/*
		System.out.println("┌───────────┬─────────────────┬───────────────┬───────────────────┐");
		System.out.println("│ 번호	    │ 이름                       │  가격	      │ 	브랜드          │");	
		System.out.println("└───────────┴─────────────────┴───────────────┴───────────────────┘");	
		*/
		System.out.println("┌────────────────────────────────────────────────────────────────────┐");
		System.out.printf(" %-5s", "[번호]");
		System.out.printf(" %-20s", "[이름]");
		System.out.printf("    %-10s ", "[가격]");
		System.out.printf("%-10s", "[브랜드]");
		System.out.printf("%-10s", "[평점]");
		System.out.printf("%-10s", "[종류]");
		System.out.println();
		System.out.println("└────────────────────────────────────────────────────────────────────┘");
		
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
		System.out.println("상위메뉴로 돌아가시려면 엔터를 입력해주세요.");
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
				System.out.println("[에러] 잘못 입력하였습니다");			
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
				System.out.println("[에러] 잘못 입력하였습니다");
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
						System.out.println("[알림] 0.0과 5.0사이의 값만 입력해주세요.");
					}

				} 
				catch (Exception e) 
				{
					System.out.println("[에러] 잘못 입력하였습니다");	
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
