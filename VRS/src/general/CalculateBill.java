/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.awt.BorderLayout;
//import java.awt.Choice;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JTextField;

/**
 *
 * @author vrush
 */
public class CalculateBill extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4;
    JTextField t1;
    Choice cc, c2;
    JButton b1, b2;
    JPanel p;
    // String s1,x;

    static String[] ccItems;
    
    public CalculateBill() {
        //System.out.println("Calculate Bill called");
        // System.out.println("select meter_no from clz_pro");

        p = new JPanel();
        p.setLayout(new GridLayout(4, 2, 10, 30));
        p.setBackground(Color.orange);

        l1 = new JLabel("Calculate Electricity Bill");
        l2 = new JLabel("Meter No : ");
        l3 = new JLabel("Units Consumed : ");
        l4 = new JLabel("Month : ");

        t1 = new JTextField();

        cc = new Choice();
        
        try {
            conn c1 = new conn();
            String s1 = "select meter_no from cus";
            ResultSet rs = c1.s.executeQuery(s1);

            while (rs.next()) {

                cc.add(rs.getString("meter_no"));
                
            }
        } catch (Exception e) {
            e.getMessage();
        }
    
//        c1.add("1001");
//        c1.add("1002");
//        c1.add("1003");
//        c1.add("1004");
//        c1.add("1005");
//        c1.add("1006");
//        c1.add("1007");
//        c1.add("1008");
//        c1.add("1009");
      //  c1.add("1010");

        c2 = new Choice();
        c2.add("January");
        c2.add("February");
        c2.add("March");
        c2.add("April");
        c2.add("May");
        c2.add("June");
        c2.add("July");
        c2.add("August");
        c2.add("September");
        c2.add("October");
        c2.add("November");
        c2.add("December");

        b1 = new JButton("Submit");
        b2 = new JButton("Cancel");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        l1.setFont(new Font("serif", Font.BOLD, 26));
        //Move the to center
        l1.setHorizontalAlignment(JLabel.CENTER);
        l2.setFont(new Font("serif", Font.BOLD, 20));
        l3.setFont(new Font("serif", Font.BOLD, 20));
        l4.setFont(new Font("serif", Font.BOLD, 20));

        p.add(l2);
        p.add(cc);
        p.add(l4);
        p.add(c2);
        p.add(l3);
        p.add(t1);
        p.add(b1);
        p.add(b2);

        setLayout(new BorderLayout(30, 30));

        add(l1, "North");
        add(p, "Center");

        b1.addActionListener(this);
        b2.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);
        setSize(650, 500);
        setLocation(350, 220);
        setVisible(true);

    }

    
        
//    void static getMeterIds()
//    {
//        System.out.println(x);
//    }

    public static void main(String[] args) {
        CalculateBill cb = new CalculateBill();
        //getMeterIds();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
     if(ae.getSource()==b1)
     {
         String a = cc.getSelectedItem();//meter_no
         String b = t1.getText();//no of units consumed
         String c = c2.getSelectedItem();//month of year
         
         int p1 = Integer.parseInt(b);
         
         int p2 = p1*7;//cost per unit
         int p3 = p2+50;
         
         String q = "insert into bill (meter_no,month,no_of_units,bill_amount)values('"+a+"','"+c+"','"+b+"','"+p3+"')";
         
         try {
              conn c1 = new conn();
             c1.s.executeUpdate(q);
                      JOptionPane.showMessageDialog(null, "Bill Updated");

         } catch (Exception aee) {
              aee.printStackTrace();
         }
     }else{
         setVisible(false);
     }
    }

}
