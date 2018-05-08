package cos.util;

import java.util.Comparator;

import cos.vo.Cosmetic;

public class AssortInt implements Comparator<Cosmetic>{

	@Override
	public int compare(Cosmetic o1, Cosmetic o2) {
		// TODO Auto-generated method stub

		int val1 = o1.getCosPrice();
		int val2 = o2.getCosPrice();
		
		if(val1 > val2)
		{
			return 1;
		}
		else if(val1 < val2)
		{
			return -1;
		}
		else
		{
			return 0;
		}
		
	}
	
	
}
