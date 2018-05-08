package cos.vo;


/*
 * [화장품의 상품 정보를 담는 value object]
 * 
 */
public class Cosmetic {

	private int cosNumber;	//상품 번호 : 상품번호는 시퀀스를 이용하여 자동부여한다.
	private String cosName; //상품 이름
	private int cosPrice;	//상품 가격
	private double cosGrade;//상품의 점수(별점)	: 별점은 리뷰 테이블에서 통계내서 입력받는다. (상품을 등록하자마자 별점을 줄 순 없으므로)
	private String cosBrand;//상품의 브랜드
	private String cosContent; //상품소개 (상세보기 했을 때만 출력)
	private String cosSkinType;//상품의 피부타입
	private String cosType;	   //상품의 타입 (스킨/토너 or 로션)
	
	//기본생성자
	public Cosmetic() {}
	
	//신규 화장품등록시 사용되는 생성자 
	public Cosmetic(String cosName, int cosPrice, String cosBrand, String cosContent, String cosSkinType, String cosType) {
		this.cosName = cosName;
		this.cosPrice = cosPrice;
		this.cosBrand = cosBrand;
		this.cosContent = cosContent;
		this.cosSkinType = cosSkinType;
		this.cosType = cosType;
	}
	


	public final int getCosNumber() {
		return cosNumber;
	}

	public final void setCosNumber(int cosNumber) {
		this.cosNumber = cosNumber;
	}

	public final String getCosName() {
		return cosName;
	}

	public final void setCosName(String cosName) {
		this.cosName = cosName;
	}

	public final int getCosPrice() {
		return cosPrice;
	}

	public final void setCosPrice(int cosPrice) {
		this.cosPrice = cosPrice;
	}

	public final double getCosGrade() {
		return cosGrade;
	}

	public final void setCosGrade(double cosGrade) {
		this.cosGrade = cosGrade;
	}

	public final String getCosBrand() {
		return cosBrand;
	}

	public final void setCosBrand(String cosBrand) {
		this.cosBrand = cosBrand;
	}

	public final String getCosSkinType() {
		return cosSkinType;
	}

	public final void setCosSkinType(String cosSkinType) {
		this.cosSkinType = cosSkinType;
	}

	public final String getCosType() {
		return cosType;
	}

	public final void setCosType(String cosType) {
		this.cosType = cosType;
	}

	public final String getCosContent() {
		return cosContent;
	}

	public final void setCosContent(String cosContent) {
		this.cosContent = cosContent;
	}

	@Override
	public String toString() {
		return "Cosmetic [cosNumber=" + cosNumber + ", cosName=" + cosName + ", cosPrice=" + cosPrice + ", cosGrade="
				+ cosGrade + ", cosBrand=" + cosBrand + ", cosContent=" + cosContent + ", cosSkinType=" + cosSkinType
				+ ", cosType=" + cosType + "]";
	}

	
	
}
