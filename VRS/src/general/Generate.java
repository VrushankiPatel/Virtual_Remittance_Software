///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package general;
//
//import java.sql.*;
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
////import java.sql.SQLException;
////import java.util.logging.Level;
////import java.util.logging.Logger;
////import java.awt.BorderLayout;
////import java.awt.Choice;
////import java.awt.event.ActionEvent;
////import java.awt.event.ActionListener;
////import javax.swing.JButton;
////import javax.swing.JFrame;
////import javax.swing.JLabel;
////import javax.swing.JPanel;
////import javax.swing.JTextArea;
//
///**
// *
// * @author vrush
// */
//public class GenerateBill extends JFrame implements ActionListener {
//
//    JLabel l1;
//    JTextArea t1;
//    JButton b1,bMonth;
//    Choice c1, c2;
//    JPanel p1;
//
//    String url = "jdbc:mysql://localhost:3306/clz_pro";
//    String uname = "root";
//    String pass = "root";
//
//    public GenerateBill() {
//        //System.out.println("Generate Bill called");
//        setSize(500, 900);
//        setLayout(new BorderLayout());
//        p1 = new JPanel();
//
//        l1 = new JLabel("Generate Bill");
//   p1.setBackground(Color.PINK);
//
//        c1 = new Choice();
//
//        try {
//            conn c = new conn();
//            String s1 = "select meter_no from bill";
//            ResultSet rs = c.s.executeQuery(s1);
//            while (rs.next()) {
//                c1.add(rs.getString("meter_no"));
//            }
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//        c2 = new Choice();
//
//        c2.add("January");
//        c2.add("February");
//        c2.add("March");
//        c2.add("April");
//        c2.add("May");
//        c2.add("June");
//        c2.add("July");
//        c2.add("August");
//        c2.add("September");
//        c2.add("October");
//        c2.add("November");
//        c2.add("December");
//
//        p1.add(l1);
//        p1.add(c1);
//        p1.add(c2);
//        add(p1, "North");
//
//        t1 = new JTextArea(50, 15);
//        JScrollPane jsp = new JScrollPane(t1);
//        t1.setFont(new Font("serif", Font.ITALIC, 18));
//
//        b1 = new JButton("Generate Bill");
//
//        add(jsp, "Center");
//
//        add(b1, "South");
//
//        b1.addActionListener(this);
//
//        setLocation(350, 40);
//                t1.setBackground(Color.LIGHT_GRAY);
//
//        setVisible(true);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        t1.setText("");
//        
//       String  query = "select * from cus where meter_no=" + c1.getSelectedItem();
//       String query1="";
//        
//
//        if (c2.getSelectedItem().equals("January")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='January'";
//        } else if (c2.getSelectedItem().equals("February")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='February'";
//        } else if (c2.getSelectedItem().equals("March")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='March'";
//        } else if (c2.getSelectedItem().equals("April")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='April'";
//        } else if (c2.getSelectedItem().equals("May")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='May'";
//        } else if (c2.getSelectedItem().equals("June")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='June'";
//        } else if (c2.getSelectedItem().equals("July")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='July'";
//        } else if (c2.getSelectedItem().equals("August")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='August'";
//        } else if (c2.getSelectedItem().equals("September")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='September'";
//        } else if (c2.getSelectedItem().equals("October")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='October'";
//        } else if (c2.getSelectedItem().equals("November")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='November'";
//        } else if (c2.getSelectedItem().equals("December")) {
//            query1 = "select * from bill where meter_no=" + c1.getSelectedItem() + "and month='December'";
//        }
//
//        try {
//            //  String month = c2.getSelectedItem();
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, uname, pass);
//
//            Statement st = con.createStatement();
//
//            //t1.setText("ELECTRICITY BILL FOR THE MONTH OF  " + month + " ,2020\n\n\n");
//            // conn c = new conn();
//            ResultSet rs = st.executeQuery(query);
//
//            if (rs.next()) {
//                t1.append("\n   Customer Name : " + rs.getString("name"));
//                t1.append("\n   Meter Number   :  " + rs.getString("meter_no"));
//                t1.append("\n   Address                 : " + rs.getString("address"));
//                t1.append("\n   State                       :  " + rs.getString("state"));
//                t1.append("\n   City                          :  " + rs.getString("city"));
//                t1.append("\n   E-mail                     :  " + rs.getString("email"));
//                t1.append("\n   Phone Number    :  " + rs.getString("phone_no"));
//                t1.append("\n------------------------------------------------------------");
//                t1.append("\n");
//
//            }
//            st.close();
//            con.close();
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection(url, uname, pass);
//
//            Statement st = con.createStatement();
//            //conn c = new conn();
//            ResultSet rs = st.executeQuery(query1);
//            // ResultSet rs = c.s.executeQuery("select * from bill where meter_no=" +c1.getSelectedItem()+ "and month=" +c2.getSelectedItem());
//
//            while (rs.next()) {
//                t1.append("\n   Current Month :\t" + rs.getString("month"));
//                t1.append("\n   Units Consumed :\t" + rs.getString("no_of_units"));
//                t1.append("\n   Total Charges :\t" + rs.getString("bill_amount"));
//                t1.append("\n------------------------------------------------------------");
//                t1.append("\n   TOTAL PAYABLE :\t" + rs.getString("amount"));
//
//            }
//
//            st.close();
//            con.close();
//        } catch (Exception e) {
//            e.getMessage();
//        }
//
//    }
//
//    public static void main(String[] args) {
//        GenerateBill gb = new GenerateBill();
//    }
//
//}
