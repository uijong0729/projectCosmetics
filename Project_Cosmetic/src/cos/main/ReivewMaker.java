package cos.main;



import java.util.List;

import cos.UI.*;
import cos.service.CosDAO;
import cos.vo.Cosmetic;
import cos.vo.Review;

public class ReivewMaker {

	public static void main(String[] args){
		// TODO Auto-generated method stub
	
		Review[] reviewMaker ;
		reviewMaker = new Review[10];
		
		StringBuffer sb = new StringBuffer(); 
		
		String ran[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
				"n", "o", "p","q","r","s","t","u","v","w","x","y","z"};
		
		String rani[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		
		String ranc[] = {"이거 사면 진짜 후회함", "이거 좀 괜찮네요 다음에도 사야겠어요", "그런저럭 괜찮습니다", "평점 좋아서 샀더니 낚였습니다. 사지마세요!", "이건 문명이 낳은 역사적인 화장품이에요", "좋네 좋아", "흠 좀 별로네요", "그냥 그저 그런 보통의 화장품", "이거 친구가 추천해줘서 샀는데 써보니까 꽤 괜찮네요", "가성비 괜찮네요 다음에도 사야겠어요", "남들 좋다는데 난 이게 왜 좋은지 모르겠어"};
		
		CosDAO dao = new CosDAO();
		
	for(int f = 0 ; f < 20 ; f++)
	{	
		for(int b = 0 ; b < 5 ; b++)
		{
			sb.append(ran[(int)((Math.random()*23))]);
		}
		for(int c = 0 ; c < 3 ; c++)
		{
			sb.append(rani[(int)((Math.random()*9))]);
		}
		
		List<Cosmetic> cos = dao.getCosmeticList();
		int fir = cos.get(0).getCosNumber();
		
		for (int a = 0 ; a < reviewMaker.length ; a++)
		{
			int random = (int) (fir + Math.random() *150);


			double cosGrade = Math.random()*5.0;
			reviewMaker[a] = new Review(random, sb.toString(), (ranc[(int)(Math.random()*10)]), cosGrade);
			dao.insertReview(reviewMaker[a]);
			
			try
			{
				Cosmetic replace = dao.getCosmetic(random);
				replace.setCosGrade(cosGrade);
				dao.updateGrade(replace);
			}
			catch(NullPointerException e)
			{
			 
			}
			
		}
		sb.setLength(0); 
	}
}
	}

