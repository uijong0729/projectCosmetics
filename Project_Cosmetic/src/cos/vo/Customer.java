package cos.vo;
/*
 * 
 * 고객정보를 저장하는 vo
 */

import java.util.List;

public class Customer {
	private String id;			//회원의 아이디, 아이디는 고유값이므로 기본키로 사용
	private String pw;			//회원의 비밀번호
	private int cusAge;			//회원의 나이
	private String cusGender;		//회원의 성별
	private String cusSkinType;		//회원의 피부타입
	
	
	//기본생성자
	public Customer() {	}
	
//	public int cosType()
	
	//추가생성자(고객등록시)
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
