package Selenium;

public class AccessModifer {
	private String city = "Ho chi minh city1";
	public String name = "9x9";
	private void setCity(String city) {
		this.city = city;
		}
	String getCity() {
		return city;
	}
		
	String getName() {
		return name;
	}
	public static void main(String[] args) {
		AccessModifer as = new AccessModifer();
		as.setCity("fdf");
		System.out.println(as.getCity());
	}

}
