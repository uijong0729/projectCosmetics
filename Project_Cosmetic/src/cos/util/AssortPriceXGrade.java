package cos.util;

import java.util.Comparator;

import cos.service.CosDAO;
import cos.vo.Cosmetic;

public class AssortPriceXGrade implements Comparator<Cosmetic>{

	@Override
	public int compare(Cosmetic o1, Cosmetic o2) {
		// TODO Auto-generated method stub
		CosDAO dao = new CosDAO();
		double val1 =  dao.getGradeAvg(o1.getCosNumber()) / o1.getCosPrice();
		double val2 =  dao.getGradeAvg(o2.getCosNumber()) / o2.getCosPrice();
		
		
		
		
		if(val1 > val2)
		{
			return -1;
		}
		else if(val1 < val2)
		{
			return 11;
		}
		else
		{
			return 0;
		}
		
	}
	
	
}
