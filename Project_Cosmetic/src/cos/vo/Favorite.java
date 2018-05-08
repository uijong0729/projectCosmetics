package cos.vo;

public class Favorite {
	private int cosNumber;
	private String id;
	
	public Favorite() {
		// TODO Auto-generated constructor stub
	}
	
	public Favorite(int cosNumber, String id) {
		// TODO Auto-generated constructor stub
		this.cosNumber = cosNumber;
		this.id = id;
	}
	
	public final int getCosNumber() {
		return cosNumber;
	}
	public final void setCosNumber(int cosNumber) {
		this.cosNumber = cosNumber;
	}
	public final String getId() {
		return id;
	}
	public final void setId(String id) {
		this.id = id;
	}
	
	

}
