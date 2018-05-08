package cos.vo;

public class Review {
	
	private int reviewNum;	//�����ȣ
	private int cosNum;		//��ǰ��ȣ
	private String id;		//�ۼ��� ID
	private String content;	//���䳻��
	private double cosGrade;	//���� ����
	private String indate;	//�����ۼ���

	public Review() {
		// TODO Auto-generated constructor stub
	}
	
//	public Review(int reviewNum, String content, double cosGrade) {
//		this.reviewNum = reviewNum;
//		this.content = content;
//		this.cosGrade = cosGrade;
//	}
	
	public Review(String content, double cosGrade) {
		this.content = content;
		this.cosGrade = cosGrade;
	}
	public Review(int cosNum, String id, String content, double cosGrade) {
		this.id = id;
		this.cosNum = cosNum;
		this.content = content;
		this.cosGrade = cosGrade;
	}


	
	
	public final double getCosGrade() {
		return cosGrade;
	}

	public final void setCosGrade(double cosGrade) {
		this.cosGrade = cosGrade;
	}

	public final int getCosNum() {
		return cosNum;
	}

	public final void setCosNum(int cosNum) {
		this.cosNum = cosNum;
	}


	public final int getReviewNum() {
		return reviewNum;
	}

	public final void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getContent() {
		return content;
	}

	public final void setContent(String content) {
		this.content = content;
	}

	public final String getIndate() {
		return indate;
	}

	public final void setIndate(String indate) {
		this.indate = indate;
	}

	
	
}
