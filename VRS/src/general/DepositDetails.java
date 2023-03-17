/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author vrush
 */
public class DepositDetails extends JFrame implements ActionListener {

    JLabel l1;
    JTextArea t1;
    JButton b1;
    Choice c1;
    JPanel p1;

    String url = "jdbc:mysql://localhost:3306/clz_pro";
    String uname = "root";
    String pass = "root";
    //String query;

    public DepositDetails() {
        //System.out.println("Last Bill called");

        setSize(1370, 730);
        setLayout(new BorderLayout());
        p1 = new JPanel();

        l1 = new JLabel("Meter No");
        p1.setBackground(Color.YELLOW);

        c1 = new Choice();
        try {
            conn c = new conn();
            String s1 = "select meter_no from cus";
            ResultSet rs = c.s.executeQuery(s1);

            while (rs.next()) {
                c1.add(rs.getString("meter_no"));

            }
        } catch (Exception e) {
            e.getMessage();
        }

        t1 = new JTextArea(50, 15);
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("serif", Font.ITALIC, 18));
        t1.setForeground(Color.GREEN);

        b1 = new JButton("Deposit Details");

        add(jsp, "Center");

        add(b1, "South");

        b1.addActionListener(this);

        setLocation(0, 0);
        t1.setBackground(Color.BLACK);

        p1.add(l1);
        p1.add(c1);

        add(p1, "North");
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // t1.setText("");

        try {
            String q = "select * from bill where meter_no=" + c1.getSelectedItem();

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, uname, pass);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(q);
            while (rs.next()) {
                
                t1.append("\n    Last Billed Month :\t" + rs.getString("month"));
                t1.append("\n    Units Consumed:\t" + rs.getString("no_of_units"));
                t1.append("\n    Last Billed Amount :\t" + rs.getString("bill_amount"));
                t1.append("\n---------------------------------------------------------------");
              //  t1.append("\n    TOTAL PAYABLE :\t" + rs.getString("amount"));
            }

            st.close();
            con.close();
        } catch (Exception ee) {
            ee.getMessage();
        }

    }

    public static void main(String[] args) {
        DepositDetails dd = new DepositDetails();
    }

}
