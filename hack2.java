//package hackwestern;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.*; 
import java.applet.*; 
// import an extra class for the ActionListener 
import java.awt.event.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class hack2 extends Applet implements ActionListener
	
{

	Button yes; 
	Button no; 
	TextField nameField; 
	
	StringBuffer strBuffer;
	Image backGround;
	

	public void init()  
	{ 


		setLayout(new FlowLayout()); 
		
		backGround=getImage(getCodeBase(),"C:\\Users\\neeraja\\Downloads\\light.jpg");
		
		yes = new Button("yes!"); 
		no = new Button("no!"); 
		nameField = new TextField("Is your muse headset on? If yes, wait two minutes then click on the Yes Button and enjoy the magic of Hollywood!",35);
		add(yes); 
		add(no); 
		
		yes.addActionListener(this); 
		no.addActionListener(this); 

	}
	public void paint(Graphics g) {

		g.drawString(nameField.getText(),20,100); 
		super.paint(g);

		//ImageIcon i = new ImageIcon("C:\\Users\\neeraja\\Downloads\\light.jpg");
        //g.drawImage(i.getImage(), 0, 0, this);
	   
	}
	
	@SuppressWarnings("resource")
	public void actionPerformed(ActionEvent evt)  
	{ 


		if (evt.getSource() == yes)  {
			//System.out.println("Hello");
			MuseOscServer.practice();
			//1. Create the frame.
			/*JFrame frame = new JFrame("Data");
			JLabel label1=new JLabel(MuseOscServer.practice());
			frame.getContentPane().add(label1, BorderLayout.CENTER);

			//4. Size the frame.
			frame.pack();

			//5. Show it.
			frame.setVisible(true);*/
		}
		

		else if (evt.getSource() == no)  
		{
			
			
			try{
			Desktop.getDesktop().browse(new URL("https://www.youtube.com/watch?v=YI5uXlTnNms").toURI());
			}
			catch(MalformedURLException mfe)
			{
				mfe.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			nameField.setText("This is my first time!"); 

			repaint(); 
		} 
			
	} 
	
