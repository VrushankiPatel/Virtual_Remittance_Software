/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author vrush
 */
public class CustomerDetails extends JFrame implements ActionListener {

    JTable t1;
    JButton b1;

    String x[] = {"Emp Name", "Meter No", "Address", "State", "City", "Email", "Phone"};
    String y[][] = new String[20][8];
    int i = 0, j = 0;

    public CustomerDetails() {
        //System.out.println("Customer Details called");
        super("Customer Details");
        setSize(1200, 650);
        setLocation(70, 70);
        try {

            conn c1 = new conn();
            String s1 = "select * from cus";
            ResultSet rs = c1.s.executeQuery(s1);

            while (rs.next()) {
                //y[i][j++] = rs.getInt("id") + "";
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("meter_no");
                y[i][j++] = rs.getString("address");
                y[i][j++] = rs.getString("state");
                y[i][j++] = rs.getString("city");
                y[i][j++] = rs.getString("email");
                y[i][j++] = rs.getString("phone_no");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        b1 = new JButton("Print");
        add(b1, "South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            t1.print();
        } catch (Exception e) {
        }
    }

    public static void main(String [] args) {
          new CustomerDetails().setVisible(true);
        //CustomerDetails cd = new CustomerDetails();
    }

}
