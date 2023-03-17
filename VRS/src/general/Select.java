/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author vrush
 */
public class Select extends JFrame implements ActionListener {

    //JFrame f;
    JButton b1, b2;

    public Select() {

        new JFrame("Selection");//setting the name of frame
        setLayout(null);
        setSize(1360, 750);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/s.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);//(1200,700)
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l1 = new JLabel(i3);
        l1.setBounds(-200, -10, 1600, 1000);//(0,150,1360,530);// default
        //f.add(l1);

        b1 = new JButton("Admin");
        b1.setBackground(Color.ORANGE);
        b1.setForeground(Color.BLACK);
        b1.setBounds(570, 250, 200, 70);//(500,600,300,70)
        b1.addActionListener(this);

        b2 = new JButton("Client");
        b2.setBackground(Color.ORANGE);
        b2.setForeground(Color.BLACK);
        b2.setBounds(570, 400, 200, 70);//(500,600,300,70)
        b2.addActionListener(this);

        JLabel lid = new JLabel("Login");
        lid.setBounds(580, 40, 1200, 100);
        lid.setFont(new Font("TIMES NEW ROMAN", Font.PLAIN, 80));
        lid.setForeground(Color.GREEN);

        add(lid);

        //add(l1);
        add(b1);
        add(b2);
        add(l1);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        setVisible(true);
        
        String msg = ae.getActionCommand();
        if (msg.equals("Admin")) {
            new login();//setVisible(true);

        } else if (msg.equals("Client")) {
            new login1();
            //setVisible(true);
        }
    }

    public static void main(String[] args) {
        Select s = new Select();
    }
}
