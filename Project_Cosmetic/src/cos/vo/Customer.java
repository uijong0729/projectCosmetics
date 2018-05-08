package cos.vo;
/*
 * 
 * �������� �����ϴ� vo
 */

import java.util.List;

public class Customer {
	private String id;			//ȸ���� ���̵�, ���̵�� �������̹Ƿ� �⺻Ű�� ���
	private String pw;			//ȸ���� ��й�ȣ
	private int cusAge;			//ȸ���� ����
	private String cusGender;		//ȸ���� ����
	private String cusSkinType;		//ȸ���� �Ǻ�Ÿ��
	
	
	//�⺻������
	public Customer() {	}
	
//	public int cosType()
	
	//�߰�������(����Ͻ�)
	public Customer(String id, String pw, int cusAge, String cusGender, String cusSkinType) {
		this.id = id;
		this.pw = pw;
		this.cusAge = cusAge;
		this.cusGender = cusGender;
		this.cusSkinType = cusSkinType;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getPw() {
		return pw;
	}

	public final void setPw(String pw) {
		this.pw = pw;
	}

	public final int getCusAge() {
		return cusAge;
	}

	public final void setCusAge(int cusAge) {
		this.cusAge = cusAge;
	}

	public final String getCusGender() {
		return cusGender;
	}

	public final void setCusGender(String cusGender) {
		this.cusGender = cusGender;
	}

	public final String getCusSkinType() {
		return cusSkinType;
	}

	public final void setCusSkinType(String cusSkinType) {
		this.cusSkinType = cusSkinType;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", pw=" + pw + ", cusAge=" + cusAge + ", cusGender=" + cusGender
				+ ", cusSkinType=" + cusSkinType + "]";
	}
	
	
	
	
}
