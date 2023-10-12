public class Student extends User{
	public float height;
	public float weight;
	public double balance;
	Date membershipexpiry;
	
	Student(String name, String password,float height, float weight, double balance, Date membershipexpiry, String phonenumber){
		this.setStdata(this);
		this.name= name;
		this.phonenumber=phonenumber;
		this.password= password;
		this.height=height;
		this.weight=weight;
		this.balance=balance;
		this.membershipexpiry=membershipexpiry;
		
	}
}