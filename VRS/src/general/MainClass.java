/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author vrush
 */
public class MainClass extends JFrame implements ActionListener {

    public MainClass() {
        super("Login");//setting the name of frame
        System.out.println("Main class Found");

        setLayout(null);
        setSize(1360, 750);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/v3.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);//(1200,700)
        ImageIcon i3 = new ImageIcon(i2);

        JLabel l3 = new JLabel(i3);
        l3.setBounds(-200, -10, 1600, 1000);
        add(l3);

        //MenuBar
        JMenuBar mb = new JMenuBar();

        //First Column-->master
        JMenu master = new JMenu("Master");
        JMenuItem m1 = new JMenuItem("New Customer");
        JMenuItem m2 = new JMenuItem("Customer Details");
        JMenuItem m3 = new JMenuItem("Deposit Details");

        //---- New Customer ----
        m1.setFont(new Font("serif", Font.PLAIN, 12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/m3.jfif"));
        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setBackground(Color.white);
        m1.addActionListener(this);

        //---- Meter Details ----
        m2.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("general/icons/m1.jfif"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setBackground(Color.WHITE);
        m2.addActionListener(this);

        // ---- Deposit Details  ----- 
        m3.setFont(new Font("monospaced", Font.PLAIN, 12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("general/icons/m2.jfif"));
        Image image3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image3));
        m3.setBackground(Color.WHITE);
        m3.addActionListener(this);

        master.add(m1);
        master.add(m2);
        master.add(m3);
        
       // m1.addActionListener(this);
        //m2.addActionListener(this);
        //m3.addActionListener(this);

        mb.add(master);

        setJMenuBar(mb);

        //Customer Column--> Customer
        //    JMenuBar mb1 = new JMenuBar();
        JMenu customer = new JMenu("Customer");
       // JMenuItem m4 = new JMenuItem("Pay Bill");
        JMenuItem m5 = new JMenuItem("Calculate Bill");
        JMenuItem m6 = new JMenuItem("Last Bill");
       
       // m4.addActionListener(this);
        m5.addActionListener(this);
        m6.addActionListener(this);

        //customer.add(m4);
        customer.add(m5);
        customer.add(m6);

        mb.add(customer);

        //   setJMenuBar(mb1);
        //Report column--> Report
        //  JMenuBar mb2 = new JMenuBar();
        JMenu report = new JMenu("Report");
        JMenuItem m7 = new JMenuItem("Generate Bill");
        m7.addActionListener(this);

        report.add(m7);
         mb.add(report);

         //new column :EXIT
        JMenu exit = new JMenu("Exit");
        JMenuItem ex = new JMenuItem("Close");
        ex.addActionListener(this);
       
        exit.add(ex);
        mb.add(exit);

        setJMenuBar(mb);
        
        
        //setJMenuBar(mb1);
        //setJMenuBar(mb2);

        //---- New Customer ----
//        m.setFont(new Font("serif", Font.PLAIN, 12));
//        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/m3.jfif"));
//        Image image1 = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
//        m1.setIcon(new ImageIcon(image1));
//        m1.setBackground(Color.white);
//        
//         //---- Meter Details ----
//        m2.setFont(new Font("monospaced",Font.PLAIN,12));
//       ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("general/icons/m1.jfif"));
//        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
//        m2.setIcon(new ImageIcon(image2));
//        m2.setBackground(Color.WHITE);
        // ---- Deposit Details  ----- 
//        m3.setFont(new Font("monospaced",Font.PLAIN,12));
//        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("general/icons/m2.jfif"));
//        Image image3 = icon3.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
//        m3.setIcon(new ImageIcon(image3));
//        m3.setBackground(Color.WHITE);
        setVisible(true);

    }

//    void setVisible(boolean b) {
//                  
//    }
//     
    public static void main(String[] args) {
        MainClass m = new MainClass();

    }

//    void setVisible(boolean b) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("New Customer")) {
            new new_customer();//.setVisible(true);
            //setVisible(false);
        }
        
        else if(msg.equals("Customer Details")){
            new CustomerDetails().setVisible(true);

        }
        
         else if(msg.equals("Deposit Details")){
            new DepositDetails();
        }
        
//         else if(msg.equals("Pay Bill")){
//            new PayBill();
//        }
        
         else if(msg.equals("Calculate Bill")){
            new CalculateBill();
        }
        
         else if(msg.equals("Last Bill")){
            new LastBill();
        }
         
         else if(msg.equals("Generate Bill")){
            new GenerateBill();
        }
        
         else if(msg.equals("Close")){
         System.exit(0);
         }
    }
}
