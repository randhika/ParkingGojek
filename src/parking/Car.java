package parking;


public class Car  {
	private String regNo;
	private String color;
	
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String regNo, String color) {
		super();
		this.regNo = regNo;
		this.color = color;
	}
	public String getRegNo() {
		return regNo;
	}
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	
}
