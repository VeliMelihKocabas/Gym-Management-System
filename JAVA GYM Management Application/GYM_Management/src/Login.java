import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.event.*;

import java.io.File;
import java.io.IOException;
import java.lang.Exception;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
  
class Login extends JFrame implements ActionListener  
{
	 
      
 
	JButton b1;  
    JFrame newPanel;  
    JLabel userLabel, passLabel;  
    JTextField  textField1, textField2;
    
     

     
    public Login() throws IOException  
    {
    	newPanel = new JFrame();
    	
          
       
        userLabel = new JLabel();
        userLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        userLabel.setBounds(236, 380, 134, 50);
        userLabel.setText("        USER NAME: "); 
        userLabel.setForeground(Color.RED);
        
        
        textField1 = new JTextField(40); 
        textField1.setBounds(380, 380, 120, 45);
  
          
        passLabel = new JLabel();  
        passLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passLabel.setBounds(233, 450, 137, 50);
        passLabel.setText("           Password : ");
        passLabel.setForeground(Color.RED);
        textField2 = new JPasswordField(15);
        textField2.setBounds(380, 450, 120, 45);
        //textField2.setBounds(EXIT_ON_CLOSE, ABORT, WIDTH, HEIGHT);
          
      
        b1 = new JButton("LOG IN"); //set label to button  
        b1.setBounds(230, 500, 350, 50);
          
        

        
        File image_file = new File("background.jpg");
        JLabel background = new JLabel(new ImageIcon(ImageIO.read(image_file)));
        newPanel.setContentPane(background);
        
        
        
        
        newPanel.add(userLabel);    //set username label to panel  
        newPanel.add(textField1);   //set text field to panel  
        newPanel.add(passLabel);    //set password label to panel  
        newPanel.add(textField2);   //set text field to panel  
        newPanel.add(b1);
    
        
        newPanel.setBounds(380, 150, 900, 740);
        
        newPanel.getContentPane().setLayout(null);
        b1.addActionListener(this);       
        newPanel.setTitle("GYM MANAGEMENT SYSTEM");      
        newPanel.setVisible(true);
        
        
 
        
    }  
    
      
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter  
    {  
    	UserData.getInstance();
        String userValue = textField1.getText();        //get user entered username from the textField1  
        String passValue = textField2.getText();        //get user entered pasword from the textField2  
    	UserData.currentuser = UserData.getInstance().getUser(userValue, passValue);
		
    	
        if(UserData.currentuser==null) {    
        	JFrame f= new JFrame("ERROR MESSAGE");
            JLabel wronglabel = new JLabel("WRONG USERNAME OR PASSWORD");  
            wronglabel.setBounds(90,0, 275, 100);
            f.add(wronglabel);
            f.setBounds(650, 650, 400, 150);
            f.setLayout(null); 
            f.setVisible(true);
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
              	  f.setVisible(false);
                }
            };
            new javax.swing.Timer(delay, taskPerformer).start();
        }
    	
        else if (UserData.currentuser.studentData()!=null&&userValue.equals(UserData.currentuser.studentData().name)&&passValue.equals(UserData.currentuser.studentData().password)){      
            //STUDENT  
            StudentWindow a1 = new StudentWindow(UserData.currentuser.studentData().name, UserData.currentuser.studentData().password, UserData.currentuser.studentData().height, UserData.currentuser.studentData().weight,UserData.currentuser.studentData().balance, UserData.currentuser.studentData().membershipexpiry,UserData.currentuser.studentData().phonenumber);  
           
 
        }  
        else if(UserData.currentuser.trainerData()!=null&&userValue.equals(UserData.currentuser.trainerData().name)&&passValue.equals(UserData.currentuser.trainerData().password)){
        	//TRAINER
        	TrainerWindow a1 = new TrainerWindow(UserData.currentuser.trainerData().name, UserData.currentuser.trainerData().password , UserData.currentuser.trainerData().phonenumber , UserData.currentuser.trainerData().salary);
        	
        }
        else if(UserData.currentuser.ownerData()!=null&&userValue.equals(UserData.currentuser.ownerData().name)&&passValue.equals(UserData.currentuser.ownerData().password)){
        	//OWNER
        	OwnerWindow a1 = new OwnerWindow(UserData.currentuser.ownerData().name, UserData.currentuser.ownerData().password , UserData.currentuser.ownerData().phonenumber , UserData.currentuser.ownerData().salary);
        	
        }
          
    	
          


     
    }  
 	

     
    public static void main(String arg[])  
    {  
        try  
        {    
            Login gym = new Login();  
             
             
        }  
        catch(Exception e)  
        {     
            //handle exception   
            JOptionPane.showMessageDialog(null, e.getMessage());  
        }  
        
        

    }/*
    public static void main(String arg[])  
    {  
    
    	System.out.println(UserData.getInstance().getStudents());
        
        

    }*/




}  
//create the main class  