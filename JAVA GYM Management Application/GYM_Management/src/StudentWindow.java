import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ListModel;

public class StudentWindow extends JFrame {

	
	int a=0;
	JFrame newPanel;
	JLabel username;
	static String name;
	static float height;
	static float weight;
	private JButton b;

	public StudentWindow(String name, String password,float height, float weight, double balance, Date membershipexpiry, String phonenumber){
		newPanel = new JFrame();
		
		newPanel.setBounds(380, 150, 900, 740);
		newPanel.setTitle("STUDENT PAGE");      
        newPanel.setVisible(true);
		newPanel.getContentPane().setLayout(null);
		
		
		
    	
        
	       
		username = new JLabel();
		username.setBounds(277, 24, 494, 55);
		 
		File image_file = new File("student.jpg");
		
		
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
		

		JLabel username_1 = new JLabel();
		username_1.setBackground(new Color(240, 240, 240));
        username_1.setText("USER INFO");
        username_1.setBackground(getForeground());        
        username_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        username_1.setBounds(66, 114, 194, 55);
        newPanel.getContentPane().add(username_1);
		
		
		 
		DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("NAME: "+name);  
        l1.addElement("PASSWORD: "+password);
        l1.addElement("HEIGHT: "+height);  
        l1.addElement("WEIGHT: "+weight);  
        l1.addElement("BALANCE: "+balance);
        l1.addElement("MEMBERSHIPEXPIRY : "+membershipexpiry.DisplayDate());
        l1.addElement("PHONE NUMBER : "+phonenumber);
        JList<String> list = new JList<>(l1);  
        list.setBounds(29,177, 218,196);
        list.setBackground(Color.ORANGE);
        newPanel.getContentPane().add(list);
        
       
        
        
        
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
        
        
        
        

        JFrame dietwindow = new JFrame();
        dietwindow.setBounds(380, 150, 900, 740);
        dietwindow.setTitle("DIET LIST");
        String Dprogram="D-"+name+"-"+password+".png"; 
		File dietfile = new File(Dprogram);
		      
		boolean dietexists = dietfile.exists();
		JButton btnShowDietrogram = new JButton("SHOW DIET PROGRAM");
		
		btnShowDietrogram.addActionListener((event) -> a++);
        
        JButton closediet = new JButton("EXIT");        
        
        closediet.setBounds(350, 50, 194, 55);
        dietwindow.getContentPane().add(closediet);
        closediet.addActionListener((event) -> dietwindow.setVisible(false));
        
        
        
        btnShowDietrogram.setForeground(Color.RED);
        btnShowDietrogram.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnShowDietrogram.setBounds(39, 456, 239, 76);
        newPanel.getContentPane().add(btnShowDietrogram);
        
        
		if(dietexists==false /*&& a!=0*/) {
        	JFrame f= new JFrame("ERROR MESSAGE");
            JLabel wronglabel = new JLabel("There is no diet program!");  
            wronglabel.setBounds(90,0, 275, 100);
            f.add(wronglabel);
            f.setBounds(650, 650, 400, 150);
            f.setLayout(null); 
            //f.setVisible(true);
            btnShowDietrogram.addActionListener((event) -> f.setVisible(true));
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
              	  f.setVisible(false);
                }
            };
            new javax.swing.Timer(delay, taskPerformer).start();
        }
		else {
			JLabel dietlist;
			try {
				
				dietlist = new JLabel(new ImageIcon(ImageIO.read(dietfile)));
				dietwindow.setContentPane(dietlist);
				btnShowDietrogram.addActionListener((event) -> dietwindow.setVisible(true));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}
        
        
        
        
		
		
        
        
        
        JFrame trainingwindow = new JFrame();
		trainingwindow.setBounds(380, 150, 900, 740);
		trainingwindow.setTitle("TRAINING LIST");
		String Tprogram="T-"+name+"-"+password+".png"; 
		File trainingfile = new File(Tprogram);
		
		boolean Trainingexists = trainingfile.exists();
		JButton btnShowTRAProgram = new JButton("SHOW TRAINING PROGRAM");
		
		btnShowTRAProgram.addActionListener((event) -> a++);
        
        JButton closetraining = new JButton("EXIT");        
        
        closetraining.setBounds(350, 50, 194, 55);
        trainingwindow.getContentPane().add(closetraining);
        closetraining.addActionListener((event) -> trainingwindow.setVisible(false));
        
        
        
        btnShowTRAProgram.setForeground(Color.RED);
        btnShowTRAProgram.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnShowTRAProgram.setBounds(39, 550, 239, 76);
        newPanel.getContentPane().add(btnShowTRAProgram);
        
        
		if(Trainingexists==false) {
        	JFrame f= new JFrame("ERROR MESSAGE");
            JLabel wronglabel = new JLabel("There is no training program!");  
            wronglabel.setBounds(90,0, 275, 100);
            f.add(wronglabel);
            f.setBounds(650, 650, 400, 150);
            f.setLayout(null); 
            //f.setVisible(true);
            btnShowTRAProgram.addActionListener((event) -> f.setVisible(true));
            int delay = 2000; //milliseconds
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
              	  f.setVisible(false);
                }
            };
            new javax.swing.Timer(delay, taskPerformer).start();
        }
		else {
			JLabel traininglist;
			try {
				
				traininglist = new JLabel(new ImageIcon(ImageIO.read(trainingfile)));
				trainingwindow.setContentPane(traininglist);
				btnShowTRAProgram.addActionListener((event) -> trainingwindow.setVisible(true));
			} catch (IOException e1) {
				
				e1.printStackTrace();
				
			}
		}
	
	}
}