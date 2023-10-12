import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;

public class UserData {
	private static UserData userdata;
	public User [] users;
	public static User currentuser;
	
	private UserData() 
	{
		users= new User[500];

		
		int row=0;
		String line = "";
		String splitBy = ";";
		
		
			
	      try {
	    	  BufferedReader newreader = new BufferedReader(new FileReader("records.txt"));
			while ((line = newreader.readLine()) != null)//File reading	        
			  {
			    String[] parts = line.split(splitBy);	
			    if(parts[0].equals("student")) {
			    	users[row]=new Student(parts[1],parts[2],Float.parseFloat(parts[3]),Float.parseFloat(parts[4]),Double.parseDouble(parts[5]),new Date(Integer.parseInt(parts[6]),Integer.parseInt(parts[7]),Integer.parseInt(parts[8])),parts[9]);
			    	row++;
			    }
			    else if(parts[0].equals("trainer")) {
			    	users[row]=new Trainer(parts[1],parts[2],parts[3],Double.parseDouble(parts[4]));
			    	row++;
			    }
			    else if(parts[0].equals("owner")) {
			    	users[row]=new Owner(parts[1],parts[2],parts[3],Double.parseDouble(parts[4]));
			    	row++;
			    }
			  }
			newreader.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static UserData getInstance()
	{
	    if (userdata == null)
	        userdata = new UserData();
	  
	    return userdata;
	}
	
	public User getUser(String username,String password) 
	{
		for (int i = 0; i < users.length; i++) 
		{
			
			if (users[i]!=null && users[i].name.equals(username) && users[i].password.equals(password)) 
			{
				return users[i];
			}
			
		}
		return null;
		
	}
	

}