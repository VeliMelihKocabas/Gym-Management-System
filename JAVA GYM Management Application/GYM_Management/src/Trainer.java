public class Trainer extends User{
	public double salary;
	Trainer(String name, String password,String phonenumber,double salary){
		this.setTrdata(this);
		this.salary=salary;
		this.name= name;
		this.phonenumber=phonenumber;
		this.password= password;
	}
	 

}