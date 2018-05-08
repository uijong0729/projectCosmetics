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
			
	
	//羅詭景 UI
	public int firstMenu() {
	
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("         	 �倣暷� 蹺繭 Щ煎斜極                              ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("  1.蕾樓                         	    ");	
		System.out.println("  2.�蛾灠㊣�                   	    ");	
		System.out.println("  3.Щ煎斜極 模偃                  	    ");	
		System.out.println("  9.謙猿                    	       ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		int menu = this.getNextInt("詭景廓�� : ");
		if (menu == 9)
		{
			System.out.println("========== 謙猿м棲棻 ==========");
			//exitJpeg();
			System.exit(0);
		}
		return menu;
		}
	
	//2.�蛾灠㊣�
	public boolean register() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("        �蛾灠㊣�   			   ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		
        //�蛾讔內� 蛔煙
		System.out.print(" ID : ");
		loginId = input.next();
		input.nextLine();
		boolean result = false; 
		while(result == false) 
		{
			if(dao.getCustomerInfo(loginId) != null)
			{
				System.out.println("翕橾и 嬴檜蛤陛 襄營м棲棻.");
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

		
		int cusAge = getNextInt(" 釭檜 : ");
		
		//陴, 罹虜 殮溘嫡紫煙
		String cusGender;
		boolean ok;
		do{
			System.out.print(" 撩滌( M / F ) : ");
			cusGender = input.nextLine().toUpperCase();
						
			
			if(!(cusGender.equals("M") || cusGender.equals("F"))) 
			{
				System.out.println("撩滌( M / F )蒂 棻衛 殮溘п 輿撮蹂.");
				ok = false;
			}else 
			{
				System.out.println("�蛾灠㊣埬� 諫猿腎歷蝗棲棻.");
				System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
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
	
	
	//蕾樓 UI
	public int connection() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("          蕾樓                              ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("  1.煎斜檣                                     ");	
		System.out.println("  9.釭陛晦                                     ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return this.getNextInt("詭景廓�� : ");
	}
	
	//煎斜檣 UI //�挫恉媞萵�
	public String login() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("        煎斜檣                               ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.print(" ID : " );
		loginId = input.nextLine();
		
		System.out.print(" PW : ");
		String pw = input.nextLine();
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		int check = 0;
		
		
		
		List<Customer> cusList = dao.getCustomerList();
			for (Customer customer : cusList) {
				//嬴檜蛤 襄營 �挫�
				if(customer.getId().equals(loginId)) {
					//嬴檜蛤 襄營 	
					check++;
				}
				//綠塵廓�� 橾纂 �挫�
				try 
				{
					if(dao.getCustomerInfo(loginId).getPw().equals(pw)) {
						//綠塵廓�� 橾纂
					check++;	
					}
				}
				catch(NullPointerException e)
				{}
				
				if(check == 2) {
					System.out.println("煎斜檣 撩奢!");
					return loginId;
					
				}
		}//for僥  
			if( check < 2) {
				System.out.println("煎斜檣縑 褒ぬж樟蝗棲棻.");
				System.out.println("<啗樓ж衛溥賊 縛攪蒂 揚楝輿撮蹂>");
				input.nextLine();
				loginId = null;
			}
			
			return loginId;
	}
	
	//welcome UI
	public int welcome() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛           welcome!           弛 ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		if(!(loginId.equals("manager"))) {System.out.println(" 1.Я睡 濠陛霞欽");} else {System.out.println(" 1.[婦葬濠] 學撩葬箔 塽 蝶ば葬箔 餉薯");}	
		if(!(loginId.equals("manager"))) {System.out.println(" 2.釭縑啪 蜃朝 �倣暷� 爾晦");} else {System.out.println(" 2.[婦葬濠] �蛾� 鬼薯驍黴");}	
		if(!(loginId.equals("manager"))) {System.out.println(" 3.葆檜む檜雖");} else {System.out.println(" 3.[婦葬濠] 鼻ヶ 婦葬 衛蝶蠱");}	
		System.out.println(" 9.煎斜嬴醒                       ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return this.getNextInt("詭景廓�� : ");
	}
		
	
	//1.Я睡 濠陛霞欽
	public String skinTest() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("          Я睡 濠陛霞欽                   ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("* 1: 瞪⑵ 嬴棲棻 2: 嬴棲棻 3: 爾鱔檜棻 4: 斜溢棻  5: 衙辦 斜溢棻" );
				      System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		int score1 = this.getNextIntMax5(" 1.ж瑞塭紫 該葬蒂 馬雖 彊戲賊 旎寞 晦葷檜霞棻. >> ");
		int score2 = this.getNextIntMax5(" 2.該葬蒂 濠輿 馬嬴紫 除雖毀堅 綠蛟檜 號棻. >> ");
		int score3 = this.getNextIntMax5(" 3.囀 輿滲縑 綰楷④萄, �倣昄旁黖撠� 號棻. >> ");
		int score4 = this.getNextIntMax5(" 4.撮寰 �� 嬴鼠匙紫 夥腦雖 彊嬴紫 渡晦剪釭 勒褻и 替釵檜 橈棻. >> ");
		int score5 = this.getNextIntMax5(" 5.橡掉縑 晦葷檜 蔣啪 儅晦朝 蛭и 晦碟檜 萇棻. >> ");
		int score6 = this.getNextIntMax5(" 6.邊堅 勒褻и 陳噢縑紫 Я睡陛 陛滑剪釭 評骨雖 彊棻. >> ");
		int score7 = this.getNextIntMax5(" 7.莫瞳и 替釵爾棻 骯嗆и 替釵曖 �倣暷偯� 謠棻. >> ");
		int score8 = this.getNextIntMax5(" 8.裔 橡掉橾陽 賅奢檜 觼啪 爾檣棻. >> ");
		int score9 = this.getNextIntMax5(" 9.晦葷謙檜釭 じ蓬煎 橡掉曖 晦葷晦蒂 濠輿 欺嬴魚棻. >> ");
		int score10 = this.getNextIntMax5(" 10.撮寰 �� 5衛除 檜鼻 雖釭賊 橡掉縑 嶸碟晦陛 號檜 紫朝 ら檜棻. >> ");
		               System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		//ゎ敕 薄熱 
		int sum = (score1 + score2 + score3 + score4 + score5
				+ score6 + score7 + score8 + score9 + score10) ; 
		double avg = sum;
		
		//0~15薄 勒撩Я睡
		if(avg>0 && avg<=15) {
			String skin = "勒撩";
			System.out.println(skin + "Я睡 殮棲棻.");
			return skin;
		}
		
		//16~30薄 醞撩Я睡
		else if(avg>15 && avg<=30) {
			String skin = "醞撩";
			System.out.println(skin + "Я睡 殮棲棻.");
			return skin;
		}
		
		//31~50薄 雖撩Я睡
		else 
		{
			String skin = "雖撩";
			System.out.println(skin + "Я睡 殮棲棻.");
			return skin;
		}	
		
	}
	
	//2.釭縑啪 蜃朝 �倣暷偕萵�
	public int recommendCos() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("      " + loginId +"椒" + "擊 嬪и 蹺繭 �倣暷� ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println(" 1.陛撩綠 爾晦");
		System.out.println(" 2.陛問滌");	
		System.out.println(" 3.滌薄 牖 蹺繭");	
		System.out.println(" 4.鼻ヶ薑爾 爾晦(葬箔)");
		System.out.println(" 5.鎗ж晦");
		System.out.println(" 6.葬箔濛撩");
		System.out.println(" 7.賅萇 �倣暷� 葬蝶お");
		System.out.println(" 9.釭陛晦                                                          ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return this.getNextInt("詭景廓�� : ");
		
		
	}
	
	


	//2-1 陛撩綠 爾晦
	public void basicType() {
		System.out.println("[蹺繭 煎暮 TOP 3]");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s  ", "[鼻ヶ廓�β");
		System.out.printf(" %-17s  ", "[鼻ヶ貲]");
		System.out.printf(" %-10s  ", "[陛問]");
		System.out.printf(" %-10s  ", "[粽楠萄]");
		System.out.printf(" %-10s  ", "[滌薄]");
		System.out.println();
		Customer cu = dao.getCustomerInfo(loginId);
		CosDAO dao = new CosDAO();
		List<Cosmetic> list = dao.getCosmeticList();
		AssortPriceXGrade sorter = new AssortPriceXGrade();
		Collections.sort(list, sorter);
		int count = 0;
		for(int a = 0 ; a < list.size() ; a++)
		{
			boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("煎暮");
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
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		System.out.println("[蹺繭 蝶鑑 TOP 3]");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s  ", "[鼻ヶ廓�β");
		System.out.printf(" %-17s  ", "[鼻ヶ貲]");
		System.out.printf(" %-10s  ", "[陛問]");
		System.out.printf(" %-10s  ", "[粽楠萄]");
		System.out.printf(" %-10s  ", "[滌薄]");
		System.out.println();
		
		count = 0;
		for(int a = 0 ; a < list.size() ; a++)
		{
			boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("蝶鑑");
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
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.print("<啗樓ж溥賊 縛攪纂撮蹂>");
		input.nextLine();
	}
	
	
	//2-2 陛問滌(陛問 雪擎 牖憮渠煎 轎溘 )
	public void priceType() {
		List<Cosmetic> list = dao.getCosmeticList();
		Customer cu = dao.getCustomerInfo(loginId);
		AssortInt sor = new AssortInt();
		Collections.sort(list, sor);
		System.out.println("[蹺繭 煎暮 TOP 3]");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s  ", "[鼻ヶ廓�β");
		System.out.printf(" %-17s  ", "[鼻ヶ貲]");
		System.out.printf(" %-10s  ", "[陛問]");
		System.out.printf(" %-10s  ", "[粽楠萄]");
		System.out.printf(" %-10s  ", "[滌薄]");
		System.out.println();	
		int count = 0;
		//陛問牖 3偃 鉻晦
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("煎暮");
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
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		System.out.println("[蹺繭 蝶鑑 TOP 3]");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s  ", "[鼻ヶ廓�β");
		System.out.printf(" %-17s  ", "[鼻ヶ貲]");
		System.out.printf(" %-10s  ", "[陛問]");
		System.out.printf(" %-10s  ", "[粽楠萄]");
		System.out.printf(" %-10s  ", "[滌薄]");
		System.out.println();
		count = 0;
		//陛問牖 3偃 鉻晦
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("蝶鑑");
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
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
			System.out.print("<啗樓ж溥賊 縛攪纂撮蹂>");
			input.nextLine();
	}
	
	//2-3 滌薄蹺繭 (滌薄 牖 轎溘)
	public void gradeType() {
		List<Cosmetic> list = dao.getCosmeticList();
		Customer cu = dao.getCustomerInfo(loginId);
		AssortDouble sor2 = new AssortDouble();
		Collections.sort(list, sor2);
		System.out.println("[蹺繭 煎暮 TOP 3]");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s  ", "[鼻ヶ廓�β");
		System.out.printf(" %-17s  ", "[鼻ヶ貲]");
		System.out.printf(" %-10s  ", "[陛問]");
		System.out.printf(" %-10s  ", "[粽楠萄]");
		System.out.printf(" %-10s  ", "[滌薄]");
		System.out.println();
		int count = 0;
		//滌薄 牖 3偃 鉻晦
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("煎暮");
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
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
		System.out.println("[蹺繭 蝶鑑 TOP 3]");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s  ", "[鼻ヶ廓�β");
		System.out.printf(" %-17s  ", "[鼻ヶ貲]");
		System.out.printf(" %-10s  ", "[陛問]");
		System.out.printf(" %-10s  ", "[粽楠萄]");
		System.out.printf(" %-10s  ", "[滌薄]");
		System.out.println();
		count = 0;
		//滌薄 牖 3偃 鉻晦
			for(int a = 0 ; a < list.size() ; a++)
			{
				boolean check = (list.get(a).getCosSkinType().equals(cu.getCusSkinType())) && list.get(a).getCosType().equals("蝶鑑");
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
			System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
			System.out.print("<啗樓ж溥賊 縛攪纂撮蹂>");
			input.nextLine();
	}
	//鼻ヶ貲 旋濠熱 蜃蹺晦
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
	
	//2-4 鼻ヶ薑爾 爾晦
	public void cosInformation() {
		Cosmetic cos = new Cosmetic();
			
		int cosNum = getNextInt("鼻ヶ廓�ㄧ� 殮溘ж撮蹂 : ");
		
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("       鼻ヶ薑爾 爾晦(葬箔) 	  ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		cos = dao.getCosmetic(cosNum);
		try 
		{
			System.out.print("  [鼻ヶ貲]  ");
			System.out.println(cos.getCosName());
			
			System.out.print("  [鼻ヶ薑爾]"  );
			System.out.println(cos.getCosContent());
	
			
			List<Review> cosReview = dao.getReview(cosNum);
		
			double total = 0;
			if(!(cosReview.isEmpty()))
			{	for (Review review : cosReview) 
				{
					System.out.printf("  [葬箔頂辨] %-20s [滌薄] %4f [濛撩橾] %20s %n", review.getContent(),  review.getCosGrade(), review.getIndate());
					total += review.getCosGrade();			
				}
				System.out.println("  [ゎ敕 滌薄] " + total / cosReview.size());
			}
			else
			{
				System.out.println("  [葬箔] 葬箔陛 橈蝗棲棻");
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		}//try
		catch(NullPointerException e)
		{
			System.out.println("鼻ヶ 薑爾陛 橈蝗棲棻.");
		}//catch
		System.out.println("<啗樓ж溥賊 縛攪纂撮蹂> ");
		input.nextLine();
		
	}//鼻ヶ薑爾爾晦
	
	//2-5 鎗ж晦 UI2
	
	//2-6 葬箔濛撩
	public boolean insertReview() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("       葬箔濛撩      ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式");
		int cosNum = this.getNextInt(" 鼻ヶ廓�� : ");
		System.out.print(" 葬箔頂辨 : ");	
		String content = input.nextLine();
		double cosGrade = this.getNextDouble(" 葬箔滌薄 : ");		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式");
		
		Review review = new Review(cosNum, loginId ,content, cosGrade);
		try {
		Cosmetic replace = dao.getCosmetic(cosNum);
		replace.setCosGrade(cosGrade);
		dao.updateGrade(replace);
		}
		catch(NullPointerException e)
		{
			System.out.println("п渡 鼻ヶ檜 橈蝗棲棻.");
		}
	//	review.setCosNum(cosNum);
		if(dao.insertReview(review) == 0) {
			System.out.println("蛔煙擊 褒ぬж艘蝗棲棻.");
			return false;
		}
		else {
			System.out.println("葬箔蛔煙檜 諫猿腎歷蝗棲棻.");
			return true ;
		}
		
	}
	
	
	//3.葆檜む檜雖
	public int mypage() {
	cus = dao.getCustomerInfo(loginId);
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("        葆檜 む檜雖                  ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println(" ID : " + loginId);	
		System.out.println(" 釭檜 : " + cus.getCusAge());	
		System.out.println(" 撩滌 : " + cus.getCusGender());	
		System.out.println(" Я睡顫殮 : " + ((cus.getCusSkinType() == null) ? "Я睡纔蝶お蒂 褒чп輿撮蹂" : cus.getCusSkinType()))  ;	
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println(" 1.綠塵廓�� 滲唳  				 ");	
		System.out.println(" 2.�蛾� 驍黴 		 	         ");	
		System.out.println(" 3.鎗詭景 		 	         ");	//跡煙 虜菟晦 
		System.out.println(" 9.鼻嬪詭景  			         ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return this.getNextInt("詭景廓�� : ");

		
	}
	
	
	//3-1 綠塵廓�� 滲唳
	public String pwChange() {
		cus = dao.getCustomerInfo(loginId);
		
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("         綠塵廓�� 滲唳      	       ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print(" 晦襄 綠塵廓�� 殮溘 : ");	
		String pw = input.nextLine();
		if(cus.getPw().equals(pw)) {
			System.out.print(" 億煎遴 綠塵廓�� 殮溘 : ");
			String NewPw = input.nextLine();
			System.out.print(" 億煎遴 綠塵廓�� �挫� : ");
			String reNewPw = input.nextLine();
			if(NewPw.equals(reNewPw)) {
				Customer updateCus = new Customer(cus.getId(), NewPw, cus.getCusAge(), cus.getCusGender(), cus.getCusSkinType());
				
				int result = dao.updateCustomer(updateCus);
				//檜 寰縑憮 綠塵廓�ㄟ� 滲唳撩奢ц朝雖 寰ц朝雖 罹睡 �挫� 
				if(result == 0) {
					System.out.println("綠塵廓�� 滲唳擊 褒ぬж艘蝗棲棻.");
				}else {
					System.out.println("綠塵廓�ㄟ� 滲唳腎歷蝗棲棻");
				}
			}
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 ");
			return NewPw;
		
		}else {
			System.out.println("綠塵廓�ㄟ� ぎ溜蝗棲棻.");
			System.out.println("<給嬴陛衛溥賊 縛攪蒂 殮溘ж撮蹂>");
			input.nextLine();
			return cus.getPw();
		}
		
		
		
	
	}
			        
	//3-2 �蛾� 驍黴
	public boolean deleteCustomer() {
		cus = dao.getCustomerInfo(loginId);
		if(loginId.equals("manager"))
		{
			System.out.println("[唳堅] 婦葬濠朝 驍黴 й 熱 橈蝗棲棻");
			return false;
		}
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛        �蛾� 驍黴      	       弛");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print(" 綠塵廓�� 殮溘 : ");	
		String pw = input.nextLine();
		//綠塵廓�ㄟ� 偽戲賊 驍黴罹睡 嗥辦晦
		if(cus.getPw().equals(pw)) 
		{
			System.out.println(" [憲葡] �蛾衋� 驍黴ж衛啊蝗棲梱? (Y/N) ");	
			String yn = input.nextLine();
			
			if(yn.equals("y") || yn.equals("Y")) {
				//
				Map<String, String> map = new HashMap<>();
				map.put("id", loginId);
				map.put("pw", pw);
				if(dao.deleteCustomer(map) == 0) {
					System.out.println(" [憲葡] �蛾� 驍黴蒂 褒ぬж艘蝗棲棻.");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 ");
					return false;
				}
				else {
					dao.deleteUserFavorite(loginId);
					System.out.println(" [憲葡] 驍黴腎歷蝗棲棻.");
					System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 ");
					System.out.println("<啗樓ж溥賊 縛攪纂撮蹂>");
					input.nextLine();
					return true;
					}
				}
			else
				{
					System.out.println(" [憲葡] 驍黴陛 鏃模腎歷蝗棲棻.");
					System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式 ");
					return false;
				}
	
		
		}else {
			System.out.println(" [憲葡] 綠塵廓�ㄟ� ぎ溜蝗棲棻.");
			return false;
		}	
	}
	

	//3-3 鎗跡煙
	public int zzim(){
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("        鎗詭景                               ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println(" 1. 鎗 餉薯                                     ");	
		System.out.println(" 2. 鎗 跡煙                                     ");	
		System.out.println(" 9. 釭陛晦                                      ");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return getNextInt("[詭景廓��殮溘] : ");
	}
	
	//8 婦葬濠
	public int manager() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("        婦葬濠       ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println(" 1.鼻ヶ 蛔煙 								 ");	
		System.out.println(" 2.鼻ヶ 薑爾 熱薑 						  ");	
		System.out.println(" 3.鼻ヶ 餉薯     							  ");	
		System.out.println(" 4.鼻ヶ 葬蝶お                  				");	
		System.out.println(" 9.鼻嬪詭景                				");	
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		return this.getNextInt("詭景廓�� : ");	
	}
	
	//8-1 鼻ヶ蛔煙
	public boolean insertCos() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("            鼻ヶ 蛔煙       ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		System.out.print(" 檜葷 : ");	
		String cosName = input.nextLine();
		
		int cosPrice = this.getNextInt("陛問 : ");
		System.out.print(" 粽楠萄 : ");	
		String cosBrand = input.nextLine();
		System.out.print(" 鼻ヶ模偃 :	");	
		String cosContent = input.nextLine();
		System.out.print(" Я睡顫殮 : ");
		String cosSkinType = input.nextLine();
		System.out.print(" 鼻ヶ顫殮 : ");	
		String cosType = input.nextLine();
		
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		Cosmetic cos = null;
		cos = new Cosmetic(cosName, cosPrice, cosBrand, cosContent, cosSkinType, cosType);
		if(dao.insertCosmetic(cos) == 0)
		{
			System.out.println("蛔煙擊 褒ぬж艘蝗棲棻.");
			return false;
		}
		else
		{
			System.out.println("鼻ヶ蛔煙檜 諫猿腎歷蝗棲棻.");
			return true ;
		}
		
	}
	
	//8-2 鼻ヶ 薑爾 熱薑
	public boolean cosChange() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("       鼻ヶ 薑爾 熱薑      ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		int cosNumber = this.getNextInt(" 鼻ヶ 廓�� : ");
		//廓�ㄟ� 襄營ж賊 1.陛問 , 2.鼻ヶ模偃 熱薑�飛� 轎溘  //嬴棲賊 "襄營ж雖 彊朝 鼻ヶ殮棲棻." 轎溘
		Cosmetic a = dao.getCosmetic(cosNumber);
		if ( a == null)
		{
			System.out.println("襄營ж雖 彊朝 鼻ヶ殮棲棻.");
			return false;
		}
		else {
			int cosRePrice = this.getNextInt("1.陛問 : ");
				System.out.print(" 2.鼻ヶ 模偃 : ");	
				String cosReIntroduction = input.nextLine();
				System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
				Cosmetic updateCos = new Cosmetic();
				updateCos.setCosNumber(cosNumber);
				updateCos.setCosPrice(cosRePrice);
				updateCos.setCosContent(cosReIntroduction);
				
				if(dao.updateCosmetic(updateCos) != 0) {
					System.out.println("鼻ヶ 薑爾 熱薑擊 諫猿ж艘蝗棲棻.");
					return true;
				}
				else {
					System.out.println("鼻ヶ 薑爾 熱薑擊 褒ぬж艘蝗棲棻.");
					return false;
				}
		}
		
			}
	
	//8-3 鼻ヶ 餉薯
	public boolean cosDelete() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("           鼻ヶ 餉薯      ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
		int cosNumber = this.getNextInt(" 餉薯й 鼻ヶ廓�ㄧ� 殮溘ж撮蹂 : ");
		if(dao.deleteCosmetic(cosNumber) == 0) {
			System.out.println("鼻ヶ 餉薯蒂 褒ぬц蝗棲棻.");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			return false;

		}
		else {
			System.out.println("鼻ヶ擊 餉薯ж艘蝗棲棻.");
			System.out.println("式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式");
			return true;
		}
	}
	
	//8-4 鼻ヶ 葬蝶お
	public void cosList() {
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("         鼻ヶ 葬蝶お                       ");
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		/*
		System.out.println("忙式式式式式式式式式式式成式式式式式式式式式式式式式式式式式成式式式式式式式式式式式式式式式成式式式式式式式式式式式式式式式式式式式忖");
		System.out.println("弛 廓��	    弛 檜葷                       弛  陛問	      弛 	粽楠萄          弛");	
		System.out.println("戌式式式式式式式式式式式扛式式式式式式式式式式式式式式式式式扛式式式式式式式式式式式式式式式扛式式式式式式式式式式式式式式式式式式式戎");	
		*/
		System.out.println("忙式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式忖");
		System.out.printf(" %-5s", "[廓�β");
		System.out.printf(" %-20s", "[檜葷]");
		System.out.printf("    %-10s ", "[陛問]");
		System.out.printf("%-10s", "[粽楠萄]");
		System.out.printf("%-10s", "[ゎ薄]");
		System.out.printf("%-10s", "[謙盟]");
		System.out.println();
		System.out.println("戌式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式式戎");
		
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
		System.out.println("鼻嬪詭景煎 給嬴陛衛溥賊 縛攪蒂 殮溘п輿撮蹂.");
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
				System.out.println("[縑楝] 澀跤 殮溘ж艘蝗棲棻");			
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
				System.out.println("[縑楝] 澀跤 殮溘ж艘蝗棲棻");
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
						System.out.println("[憲葡] 0.0婁 5.0餌檜曖 高虜 殮溘п輿撮蹂.");
					}

				} 
				catch (Exception e) 
				{
					System.out.println("[縑楝] 澀跤 殮溘ж艘蝗棲棻");	
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
