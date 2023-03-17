/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.KeyEventDispatcher;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author vrush
 */
public class login1 implements ActionListener {

    JFrame f;
    JTextField t1;
    JPasswordField t2;
    JButton b1, b2;

    public login1() {

        f = new JFrame("Customer Login");//setting the name of frame
        //   f.setBackground(Color.WHITE);
        f.setLayout(null);
        f.setSize(1360, 750);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/g4.gif"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);//(1200,700)
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(-200, -10, 1600, 1000);//(0,150,1360,530);// default
        //  f.add(l3);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(480, 350, 200, 30);//(40,20,100,30)
        l1.setFont(new Font("serif", Font.ITALIC, 30));
        l1.setForeground(Color.ORANGE);
        f.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(480, 400, 200, 30);//(40,70,100,30)
        l2.setFont(new Font("serif", Font.ITALIC, 30));
        l2.setForeground(Color.ORANGE);
        f.add(l2);

        t1 = new JTextField();
        t1.setBounds(630, 350, 250, 30);//(150,20,150,30)
        f.add(t1);

        t2 = new JPasswordField();
        t2.setBounds(630, 400, 250, 30);//(150,70,150,30)
        f.add(t2);

        b1 = new JButton("Login");
        b1.setBounds(550, 475, 120, 30);//(40,140,120,30)
        b1.setFont(new Font("serif", Font.BOLD, 25));
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        // t2.addKeyListener(new KeyAdapter() {} )

        b2 = new JButton("Cancel");
        b2.setBounds(720, 475, 120, 30);//(180,140,120,30)
        b2.setFont(new Font("serif", Font.BOLD, 25));
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        f.add(b2);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("general/icons/w1.jfif"));
        Image i5 = i4.getImage().getScaledInstance(204, 204, Image.SCALE_DEFAULT);//(1200,700)
        ImageIcon i6 = new ImageIcon(i5);

        JLabel l4 = new JLabel(i6);
        l4.setBounds(600, 100, 175, 175);
        f.add(l4);

        f.add(l3);
        // f.add(l4);

        t2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    b1.doClick();
                }
            }
        });

        b2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e1) {
                if (e1.getKeyCode() == KeyEvent.VK_ENTER) {
                    b2.doClick();
                }
            }
        });

        f.setVisible(true);
        //System.out.println("Welcome");
    }

    public static void main(String[] args) {
        login1 l = new login1();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (ae.getSource() == b1) {
            try {
                conn c1 = new conn();
                String u = t1.getText().toString();
                String v = t2.getText().toString();

                String q = "select * from login1 where user_name='" + u + "' and password='" + v + "'";
                //  try {
                ResultSet rs = c1.s.executeQuery(q);//for retrieving for updating executrUpdate
                if (rs.next()) {
                    //System.out.println("login success....");
                    JOptionPane.showMessageDialog(null, "Login Successful");
                    new Mainclass1();
                    f.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "InValid Login");
                    f.setVisible(false);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //System.out.println("Invalid login");
            f.setVisible(false);
        }

    }

    private void setIcon(ImageIcon imageIcon) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
