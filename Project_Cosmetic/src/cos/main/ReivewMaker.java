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
		
		String ranc[] = {"�̰� ��� ��¥ ��ȸ��", "�̰� �� �����׿� �������� ��߰ھ��", "�׷����� �������ϴ�", "���� ���Ƽ� ����� �������ϴ�. ����������!", "�̰� ������ ���� �������� ȭ��ǰ�̿���", "���� ����", "�� �� ���γ׿�", "�׳� ���� �׷� ������ ȭ��ǰ", "�̰� ģ���� ��õ���༭ ��µ� �Ẹ�ϱ� �� �����׿�", "������ �����׿� �������� ��߰ھ��", "���� ���ٴµ� �� �̰� �� ������ �𸣰ھ�"};
		
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

