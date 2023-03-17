/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import java.awt.Image;
//import javax.swing.ImageIcon;
//import javax.swing.JFrame;
//import javax.swing.JLabel;

/**
 *
 * @author vrush
 */
public class SplashScreen implements ActionListener {
  
    JFrame f;
    JButton b;
    
    public SplashScreen() {
        
        f = new JFrame("Virtual Remittance Software");//setting the name of frame
        f.setLayout(null);
        f.setSize(1360,750);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/SplashScreen.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500,1000, Image.SCALE_DEFAULT);//(1200,700)
        ImageIcon i3 = new ImageIcon(i2);
        
        JLabel l1 = new JLabel(i3);
        l1.setBounds(-200,-10,1600,1000);//(0,150,1360,530);// default
        //f.add(l1);
        
       b = new JButton("Click Here To Continue");
       b.setBackground(Color.ORANGE);
       b.setForeground(Color.BLACK);
       b.setBounds(520,550,300,70);//(500,600,300,70)
       b.addActionListener(this);
       
       JLabel lid = new JLabel("Virtual Remittance Software");
       lid.setBounds(350, 30, 1200, 100);
       lid.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,50));
       lid.setForeground(Color.MAGENTA);
       
       f.add(lid);
       
       f.add(l1);
       
       f.add(b);
       
       f.setVisible(true);
       
    }
    public static void main(String[] args) {
        SplashScreen s=new SplashScreen();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.setVisible(false); 
        new Select().setVisible(true);
    }
    
}



