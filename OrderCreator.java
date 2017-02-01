/**
 * Assignment #3 - COMP249 U - Due Date: April 11th 2016 
 * Wan Lan He - 29469419
 */

package assignment3;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class OrderCreator {
  
	public static void main (String[] args) {
		
	   JPanel panel = new JPanel();
	   JFrame myFrame = new JFrame("Order Generator");
	    // Optional: specify what happens when the frame closes
	   myFrame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	   myFrame.setSize(450,200);
	
	   JTextField text1 = new JTextField ("Enter price here.", 30);
	   panel.add(text1);
	   text1.setBounds(100, 20, 165, 25);
	  
	   JTextField text2 = new JTextField ("Enter volume here.", 30);
	   panel.add(text2);
	   text2.setBounds(100, 60, 165, 25);
	   
	   JTextField text3 = new JTextField ("Enter name here.", 30);
	   panel.add(text3);
	   text3.setBounds(100, 100, 165, 25);
	  	   
	   //create widgets
	  JButton submit = new JButton ("Submit");
      panel.add(submit);
      submit.setBounds(160, 160, 80, 25);
      submit.setPreferredSize(new Dimension(189, 26));
      submit.addActionListener(new ActionListener() {
    	  public void actionPerformed(ActionEvent e){
    		  String text = text1.getText() + text2.getText() + text3.getText();
    		 
    		  if(e.getActionCommand().equals("Submit")){
    			  text1.setText("");
            	  text2.setText("");
            	  text3.setText("");
    		  }
    		  
    		  
          }
      });
      
      JButton reset = new JButton ("Reset");
      panel.add(reset);
      reset.setBounds(160, 160, 80, 25);
      reset.setPreferredSize(new Dimension(189, 26));
      reset.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
        	  text1.setText("");
        	  text2.setText("");
        	  text3.setText("");
          }
      });
      
 
      JLabel last = new JLabel("Last order: none" );
      last.setForeground(Color.GRAY);
      panel.add(last);
      
      
      //add the panel to the frame
      myFrame.add(panel);
      myFrame.setVisible(true);
	  } 
	
	public void handle(ActionEvent e){

	}
}