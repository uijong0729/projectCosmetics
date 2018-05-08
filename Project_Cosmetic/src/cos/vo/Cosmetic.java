package cos.vo;


/*
 * [ȭ��ǰ�� ��ǰ ������ ��� value object]
 * 
 */
public class Cosmetic {

	private int cosNumber;	//��ǰ ��ȣ : ��ǰ��ȣ�� �������� �̿��Ͽ� �ڵ��ο��Ѵ�.
	private String cosName; //��ǰ �̸�
	private int cosPrice;	//��ǰ ����
	private double cosGrade;//��ǰ�� ����(����)	: ������ ���� ���̺��� ��賻�� �Է¹޴´�. (��ǰ�� ������ڸ��� ������ �� �� �����Ƿ�)
	private String cosBrand;//��ǰ�� �귣��
	private String cosContent; //��ǰ�Ұ� (�󼼺��� ���� ���� ���)
	private String cosSkinType;//��ǰ�� �Ǻ�Ÿ��
	private String cosType;	   //��ǰ�� Ÿ�� (��Ų/��� or �μ�)
	
	//�⺻������
	public Cosmetic() {}
	
	//�ű� ȭ��ǰ��Ͻ� ���Ǵ� ������ 
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
