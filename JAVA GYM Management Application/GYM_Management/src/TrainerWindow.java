import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class TrainerWindow extends JFrame {
	
	

	private static void copyFileUsingStream(File source, File dest) throws IOException {
  	    InputStream is = null;
  	    OutputStream os = null;
  	    try {
  	        is = new FileInputStream(source);
  	        os = new FileOutputStream(dest);
  	        byte[] buffer = new byte[1024];
  	        int length;
  	        while ((length = is.read(buffer)) > 0) {
  	            os.write(buffer, 0, length);
  	        }
  	    } finally {
  	        is.close();
  	        os.close();
  	    }
  	}
	

	public TrainerWindow(String name, String password,String phonenumber,double salary) {
		
		JFrame newPanel = new JFrame();
		
		newPanel.setBounds(380, 150, 900, 740);
		newPanel.setTitle("TRAINER PAGE");      
        newPanel.setVisible(true);
		newPanel.getContentPane().setLayout(null);
		
		
		JLabel username = new JLabel();
		username.setBounds(277, 24, 494, 55);
		 
		File image_file = new File("trainer.jpg");
		
		
        JLabel background;
		try {
			background = new JLabel(new ImageIcon(ImageIO.read(image_file)));
			newPanel.setContentPane(background);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
		username.setFont(new Font("Tahoma", Font.BOLD, 30));
		username.setText("Welcome back "+name); 
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
        
        
        JButton BACKMENU = new JButton("");
        BACKMENU.setBounds(743, 505, 28, 28);
        newPanel.getContentPane().add(BACKMENU);
        
        JLabel lblMenu = new JLabel();
        lblMenu.setText("MENU");
        lblMenu.setForeground(Color.ORANGE);
        lblMenu.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblMenu.setBounds(730, 471, 67, 42);
        newPanel.getContentPane().add(lblMenu); 
        BACKMENU.addActionListener(e -> newPanel.setVisible(false));
		
		
        
        
         
        JMenuBar mb=new JMenuBar();  
        JMenu menu, submenu = null,submenu2,menu2,menu3,submenu3;
        menu=new JMenu("STUDENTS");  
       
        menu2=new JMenu("SET DIET PROGRAM");
        menu3=new JMenu("SET TRAINING PROGRAM");
        
        
        for(int i=0;i<UserData.getInstance().users.length;i++) {
        	if (UserData.getInstance().users[i]!=null && UserData.getInstance().users[i].studentData()!=null) {
        	  submenu=new JMenu(UserData.getInstance().users[i].name);
          	  submenu.add("Name: "+UserData.getInstance().users[i].name);
          	  submenu.add("Password: "+UserData.getInstance().users[i].password);
          	  submenu.add("Height: "+ String.valueOf(UserData.getInstance().users[i].studentData().height));
          	  submenu.add("Weight: "+String.valueOf(UserData.getInstance().users[i].studentData().weight));
          	  submenu.add("Balance: "+String.valueOf(UserData.getInstance().users[i].studentData().balance));
          	  submenu.add("Date: "+UserData.getInstance().users[i].studentData().membershipexpiry.DisplayDate());
          	  submenu.add("Phonenumber: "+UserData.getInstance().users[i].phonenumber);
      	  menu.add(submenu); 
			
        	}
        }
    
        
        
        for(int i=0;i<UserData.getInstance().users.length;i++) {
        	if (UserData.getInstance().users[i]!=null && UserData.getInstance().users[i].studentData()!=null) {
      	  submenu2=new JMenu(UserData.getInstance().users[i].name);
      	  submenu3=new JMenu(UserData.getInstance().users[i].name);
      	  JMenuItem diet1=new JMenuItem("diet1");
      	  JMenuItem diet2=new JMenuItem("diet2");
      	  JMenuItem diet3=new JMenuItem("diet3");
      	  JMenuItem diet4=new JMenuItem("diet4");
      	  JMenuItem diet5=new JMenuItem("diet5");
          JMenuItem training1=new JMenuItem("training1");
    	  JMenuItem training2=new JMenuItem("training2");
    	  JMenuItem training3=new JMenuItem("training3");
    	  JMenuItem training4=new JMenuItem("training4");
    	  JMenuItem training5=new JMenuItem("training5");
            submenu2.add(diet1);submenu2.add(diet2);submenu2.add(diet3);
            submenu2.add(diet4);submenu2.add(diet5);
            submenu3.add(training1);submenu3.add(training2);submenu3.add(training3);
            submenu3.add(training4);submenu3.add(training5);
            String dietismi="D-"+UserData.getInstance().users[i].name+"-"+UserData.getInstance().users[i].password+".png";
            String trainingismi="T-"+UserData.getInstance().users[i].name+"-"+UserData.getInstance().users[i].password+".png";
            File Dfile = new File(dietismi);
            File Tfile = new File(trainingismi);
            
            diet1.addActionListener(new ActionListener() {
          	  
                public void actionPerformed(ActionEvent e) {
              	  
              	  File myObj = new File(dietismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("diet 1.png");
              	  try {
            			copyFileUsingStream(file,Dfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  
                }
            });
            
            diet2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(dietismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("diet 2.png");
              	  try {
            			copyFileUsingStream(file,Dfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                }
            });
            
            diet3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(dietismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("diet 3.png");
              	  try {
            			copyFileUsingStream(file,Dfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		} 
                }
            });
            
            diet4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(dietismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("diet 4.png");
              	  try {
            			copyFileUsingStream(file,Dfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                }
            });
            
            diet5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(dietismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("diet 5.png");
              	  try {
            			copyFileUsingStream(file,Dfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                }
            });
            menu2.add(submenu2);
            
            
            training1.addActionListener(new ActionListener() {
            	  
                public void actionPerformed(ActionEvent e) {
              	  
              	  File myObj = new File(trainingismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("training 1.png");
              	  try {
            			copyFileUsingStream(file,Tfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  
                }
            });
            
            training2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(trainingismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("training 2.png");
              	  try {
            			copyFileUsingStream(file,Tfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                }
            });
            
            training3.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(trainingismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("training 3.png");
              	  try {
            			copyFileUsingStream(file,Tfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		} 
                }
            });
            
            training4.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(trainingismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("training 4.png");
              	  try {
            			copyFileUsingStream(file,Tfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                }
            });
            
            training5.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

              	  
              	  File myObj = new File(trainingismi);
              	  try {
            			myObj.createNewFile();
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
              	  
              	  File file = new File("training 5.png");
              	  try {
            			copyFileUsingStream(file,Tfile);
            		} catch (IOException e1) {
            			// TODO Auto-generated catch block
            			e1.printStackTrace();
            		}
                }
            });
            menu3.add(submenu3);
        }
 
		
        mb.add(menu);  
        newPanel.setJMenuBar(mb);
        mb.add(menu2);
        mb.add(menu3);
		
        }
	}

}