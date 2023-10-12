public class User {
	public String name;
	public String phonenumber;
	public String password;
	private Student st;
	private Trainer tr;
	private Owner ow;
	
	public User() {};
	
	
	public Student studentData() 
	{
		return st;
	}
	public Trainer trainerData() 
	{
		return tr;
	}
	public Owner ownerData() 
	{
		return ow;
	}
	public void setStdata(Student a)
	{
		st=a;
	}
	public void setTrdata(Trainer a)
	{
		tr=a;
	}
	public void setOwdata(Owner a)
	{
		ow=a;
	}
}