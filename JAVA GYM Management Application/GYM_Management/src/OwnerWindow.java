import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class OwnerWindow extends JFrame {

	private JPanel contentPane;
	int b=0;


	public OwnerWindow(String name, String password,String phonenumber,double salary) {
		JFrame newPanel = new JFrame();
		
		newPanel.setBounds(380, 150, 900, 740);
		newPanel.setTitle("OWNER PAGE");      
        newPanel.setVisible(true);
		newPanel.getContentPane().setLayout(null);
		
		JLabel username = new JLabel();
        username.setBounds(277, 24, 494, 55);


        File image_file = new File("Owner.png");
        JLabel background = null;
        try {
            background = new JLabel(new ImageIcon(ImageIO.read(image_file)));
            newPanel.setContentPane(background);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }


        username.setFont(new Font("Tahoma", Font.BOLD, 30));
        username.setText("Welcome boss "+name); 
        username.setForeground(Color.RED);
        newPanel.getContentPane().add(username);
		
		
		JButton close = new JButton();
        close.setBounds(797, 505, 28, 28);
        newPanel.getContentPane().add(close);
        close.addActionListener(e -> System.exit(0));
        
        
        JLabel EXIT = new JLabel();
        EXIT.setText("EXIT");
        EXIT.setForeground(Color.RED);
        EXIT.setFont(new Font("Tahoma", Font.BOLD, 15));
        EXIT.setBounds(797, 471, 67, 42);
        newPanel.getContentPane().add(EXIT);
        
        
        JButton BACKMENU = new JButton();
        BACKMENU.setBounds(743, 505, 28, 28);
        newPanel.getContentPane().add(BACKMENU);
        
        
        JLabel lblMenu = new JLabel();
        lblMenu.setText("MENU");
        lblMenu.setForeground(Color.ORANGE);
        lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMenu.setBounds(730, 471, 67, 42);
        newPanel.getContentPane().add(lblMenu); 
        BACKMENU.addActionListener(e -> newPanel.setVisible(false));
        
        
        JButton Addstdnt = new JButton("ADD STUDENT");
		Addstdnt.setBounds(77, 290, 114, 60);
		newPanel.getContentPane().add(Addstdnt);
		
		JButton Addtrainer = new JButton("ADD TRAINER");
		Addtrainer.setBounds(235, 290, 114, 60);
		newPanel.getContentPane().add(Addtrainer);
		
		JButton DeleteStudent = new JButton("DELETE STUDENT");
		DeleteStudent.setBounds(77, 370, 114, 60);
		newPanel.getContentPane().add(DeleteStudent);
		
		JButton Deletetrainer = new JButton("DELETE TRAINER");
		Deletetrainer.setBounds(235, 370, 114, 60);
		newPanel.getContentPane().add(Deletetrainer);
		
		JTextField AddStdName = new JTextField();
		   JTextField AddStdPassword = new JTextField();
		   JTextField AddStdHeight = new JTextField();
		   JTextField AddStdWeight = new JTextField();
		   JTextField AddStdbalance = new JTextField();
		   JTextField AddStddate = new JTextField();
		   JTextField AddStdPhone = new JTextField();
		   
		   Object[] NewStudentInfo = {
		       "ENTER NAME:", AddStdName,
		       "ENTER PASSWORD:", AddStdPassword,
		       "ENTER HEIGHT: ",AddStdHeight,
		       "ENTER WEIGHT: ",AddStdWeight,
		       "ENTER BALANCE: ",AddStdbalance,
		       "ENTER DATE: ",AddStddate,
		       "ENTER PHONE NUMBER: ",AddStdPhone
		   };	   
		   	   
		   Addstdnt.addActionListener(new ActionListener() {
	          	  
               public void actionPerformed(ActionEvent e) {
             	  
            	   int option = JOptionPane.showConfirmDialog(null, NewStudentInfo, "SCREEN", JOptionPane.OK_CANCEL_OPTION);
             	  
            	   if (option == JOptionPane.OK_OPTION) {
            		   String[] parts = AddStddate.getText().split(",");
            		   		Student NewStd =new Student(AddStdName.getText(), AddStdPassword.getText(),Float.parseFloat(AddStdHeight.getText()),Float.parseFloat(AddStdWeight.getText()),Double.parseDouble(AddStdbalance.getText()),new Date(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]),Integer.parseInt(parts[2])),AddStdPhone.getText());
            		   
            		        try (BufferedWriter wwriter = new BufferedWriter(new FileWriter("records.txt", true))){
            			    wwriter.newLine();
            			    
            		    	  wwriter.write("student;"+AddStdName.getText()+";"+AddStdPassword.getText()+";"+AddStdHeight.getText()+";"+AddStdWeight.getText()+";"+AddStdbalance.getText()+";"+parts[0]+";"+parts[1]+";"+parts[2]+";"+AddStdPhone.getText());
            		    	  int i=0;
                   		      while(true) {
                   			   
                   			   if(UserData.getInstance().users[i]==null) {
                   				   UserData.getInstance().users[i] = NewStd;
                   				   break;
                   			   }
                   				  i++; 
                   		   }
            	    		  return;
            	    		}
            	    		catch(IOException ex){
            	    		  ex.printStackTrace();
            	    		}
            		    
			   }
             	  
               }
           });
		   
		   JTextField AddTraName = new JTextField();
		   JTextField AddTraPassword = new JTextField();
		   JTextField AddTraPhone = new JTextField();
		   JTextField AddTraSalary = new JTextField();	
		   
		   Object[] NewTrainerInfo = {
			       "ENTER NAME: ", AddTraName,
			       "ENTER PASSWORD", AddTraPassword,
			       "ENTER PHONE: ",AddTraPhone,
			       "ENTER SALARY: ",AddTraSalary
			   };
        		   
		   
		   
		   
		   Addtrainer.addActionListener(new ActionListener() {
	          	  
               public void actionPerformed(ActionEvent e) {
             	  
            	   int option = JOptionPane.showConfirmDialog(null, NewTrainerInfo, "SCREEN", JOptionPane.OK_CANCEL_OPTION);
             	  
            	   if (option == JOptionPane.OK_OPTION) {//ok basarsam demek
            		   Trainer NewTra =new Trainer(AddTraName.getText(), AddTraPassword.getText(),AddTraPhone.getText(), Double.parseDouble(AddTraSalary.getText()));
            		   
            		   try (BufferedWriter wwriter = new BufferedWriter(new FileWriter("records.txt", true))){
            			      wwriter.newLine();
            		    	  wwriter.write("trainer;"+AddTraName.getText()+";"+AddTraPassword.getText()+";"+AddTraPhone.getText()+";"+Double.parseDouble(AddTraSalary.getText()));
            		    	  int i=0;
                   		      while(true) {
                   			   
                   			   if(UserData.getInstance().users[i]==null) {
                   				   UserData.getInstance().users[i] = NewTra;
                   				   break;
                   			   }
                   				  i++; 
                   		   }
            	    		  return;
            	    		}
            	    		catch(IOException ex){
            	    		  ex.printStackTrace();
            	    		}
            		   
			   }
             	  
               }
           });
		   
		   
			   JTextField DltStdName = new JTextField();
			   JTextField DltStdPassword = new JTextField();
			   
			   Object[] DeleteStudentInfo = {
				       "ENTER NAME:", DltStdName,
				       "ENTER PASSWORD:", DltStdPassword
			   };
		   
		   DeleteStudent.addActionListener(new ActionListener() {
	          	  
               public void actionPerformed(ActionEvent e) {
            	   
            	   
            	   int option = JOptionPane.showConfirmDialog(null, DeleteStudentInfo, "SCREEN", JOptionPane.OK_CANCEL_OPTION);
            	   if(option == JOptionPane.OK_OPTION) {
                	   int i=0;
                	       	   
                	   
                	   
                	   while(true) {
                		   if(UserData.getInstance().users[i]!=null && UserData.getInstance().users[i].name.equals(DltStdName.getText()) && UserData.getInstance().users[i].password.equals(DltStdPassword.getText())) {
                			   		File inputFile = new File("records.txt");
                      	    		File tempFile = new File("myTempFile.txt");

                      	    	
                      	    		BufferedReader reader;
                      	    	try {
           							reader = new BufferedReader(new FileReader(inputFile));
           							BufferedWriter writerr = new BufferedWriter(new FileWriter(tempFile));

           							String[] parts = UserData.getInstance().users[i].studentData().membershipexpiry.DisplayDate().split(",");
           	           	    		String lineToRemove = "student;"+UserData.getInstance().users[i].studentData().name+";"+UserData.getInstance().users[i].studentData().password+";"+Math.round(UserData.getInstance().users[i].studentData().height)+";"+Math.round(UserData.getInstance().users[i].studentData().weight)+";"+Math.round(UserData.getInstance().users[i].studentData().balance)+";"+parts[0]+";"+parts[1]+";"+parts[2]+";"+UserData.getInstance().users[i].studentData().phonenumber;
           							//String lineToRemove ="student;Mehmet;123;196;99;1000;10;10;2022;+905312865030";
           							String currentLine;

           	           	    		while((currentLine = reader.readLine()) != null) {
           	           	    	    	String trimmedLine = currentLine.trim();
           	           	    	    	if(trimmedLine.equals(lineToRemove)) continue;
           	           	    	    	writerr.write(currentLine + System.getProperty("line.separator"));
           	           	    		} 
           	           	    		writerr.close(); 
           	           	    		reader.close();
           	           		    	inputFile.delete();
           	           		    
           	           	    		tempFile.renameTo(inputFile);
           						}
           	           	    		catch(IOException e1) {
           	           	    		e1.printStackTrace();
           	           		    	}
                			   	UserData.getInstance().users[i]=null;
                			   	break;
                		   }
                		   i++;
                		   if(i==UserData.getInstance().users.length) {
                	        	JFrame f= new JFrame("ERROR MESSAGE");
                	            JLabel wronglabel = new JLabel("Student not found!");  
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
                	            
                	            break;
                		   }
                	   }
            	   }
            	   
               }
           });
		   
		   JTextField DltTranrName = new JTextField();
		   JTextField DltTranrPassword = new JTextField();
		   
		   Object[] DeleteTrainerInfo = {
			       "ENTER NAME:", DltTranrName,
			       "ENTER PASSWORD:", DltTranrPassword
		   };
		   
		   Deletetrainer.addActionListener(new ActionListener() {
	          	  
               public void actionPerformed(ActionEvent e) {
            	   

            	   
            	   
            	   int optionn = JOptionPane.showConfirmDialog(null, DeleteTrainerInfo, "SCREEN", JOptionPane.OK_CANCEL_OPTION);
            	   if(optionn == JOptionPane.OK_OPTION) {
                	   int i=0;
                	   while(true) {
                		   if(UserData.getInstance().users[i]!=null && UserData.getInstance().users[i].name.equals(DltTranrName.getText()) && UserData.getInstance().users[i].password.equals(DltTranrPassword.getText())) {
           			   		    File inputFilee = new File("records.txt");
                 	    		File tempFilee = new File("myTempFile.txt");

                 	    	
                 	    		BufferedReader readerr;
                 	    	try {
      							readerr = new BufferedReader(new FileReader(inputFilee));
      							BufferedWriter writerrr = new BufferedWriter(new FileWriter(tempFilee));

      							
      	           	    		String lineToRemove = "trainer;"+UserData.getInstance().users[i].trainerData().name+";"+UserData.getInstance().users[i].trainerData().password+";"+UserData.getInstance().users[i].trainerData().phonenumber+";"+(int)UserData.getInstance().users[i].trainerData().salary;
      							String currentLinee;

      	           	    		while((currentLinee = readerr.readLine()) != null) {
      	           	    	    	String trimmedLine = currentLinee.trim();
      	           	    	    	if(trimmedLine.equals(lineToRemove)) continue;
      	           	    	    	writerrr.write(currentLinee + System.getProperty("line.separator"));
      	           	    		} 
      	           	    		writerrr.close(); 
      	           	    		readerr.close();
      	           		    	inputFilee.delete();
      	           		    
      	           	    		tempFilee.renameTo(inputFilee);
      						  }
      	           	    		catch(IOException e1) {
      	           	    		e1.printStackTrace();
      	           		    	}
           			   		UserData.getInstance().users[i]=null;
           			   		break;
                		   }
                		   i++;
                		   if(i==UserData.getInstance().users.length) {
                	        	JFrame f= new JFrame("ERROR MESSAGE");
                	            JLabel wronglabel = new JLabel("Trainer not found!");  
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
                	            
                	            break;
                		   }
                	   }
            	   }
            	   
               
            	   
               }
           });
		   
		   
		   
		   
	}
}