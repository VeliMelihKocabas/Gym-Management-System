public class Owner extends User {
	public double salary;
	Owner(String name, String password,String phonenumber,double salary){
		this.setOwdata(this);
		this.salary=salary;
		this.name= name;
		this.phonenumber=phonenumber;
		this.password= password;
	}
}