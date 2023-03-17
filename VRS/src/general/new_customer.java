/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.BLUE;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author vrush
 */
public class new_customer extends JFrame implements ActionListener {

    JLabel  jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;
    JTextField t1, t2, t3, t4, t5, t6, t7, t;
    JButton b1, b2;

    public new_customer() {
        super("New Customer");
        setLayout(null);
        setSize(650, 600);
//        System.out.println("Inside");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("general/icons/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1500, 1000, Image.SCALE_DEFAULT);//(1200,700)

        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(-200, -10, 1600, 1000);
        // add(l3);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(9, 2, 10, 10));
        // add(l3);

        p.setBackground(Color.CYAN);
        
//        j1 = new JLabel("Id");
//        t = new JTextField();
//        j1.setBounds(480, 350, 200, 30);//(40,20,100,30)
//        j1.setFont(new Font("serif", Font.ITALIC, 25));
//        j1.setForeground(Color.BLACK);
//        p.add(j1);
//        p.add(t);

        jl1 = new JLabel("Name : ");
        // jl1.setHorizontalAlignment(SwingConstants.CENTER);
        jl1.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl1.setFont(new Font("serif", Font.ITALIC, 25));
        jl1.setForeground(Color.BLACK);
        t1 = new JTextField();
        p.add(jl1);
        p.add(t1);

        jl2 = new JLabel("Meter No : ");
        jl2.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl2.setFont(new Font("serif", Font.ITALIC, 25));
        jl2.setForeground(Color.BLACK);
        t2 = new JTextField();
        p.add(jl2);
        p.add(t2);

        jl3 = new JLabel("Address : ");
        jl3.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl3.setFont(new Font("serif", Font.ITALIC, 25));
        jl3.setForeground(Color.BLACK);
        t3 = new JTextField();
        p.add(jl3);
        p.add(t3);

        jl4 = new JLabel("State : ");
        jl4.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl4.setFont(new Font("serif", Font.ITALIC, 25));
        jl4.setForeground(Color.BLACK);
        t4 = new JTextField();
        p.add(jl4);
        p.add(t4);

        jl5 = new JLabel("City : ");
        jl5.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl5.setFont(new Font("serif", Font.ITALIC, 25));
        jl5.setForeground(Color.BLACK);
        t5 = new JTextField();
        p.add(jl5);
        p.add(t5);

        jl6 = new JLabel("E-mail : ");
        jl6.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl6.setFont(new Font("serif", Font.ITALIC, 25));
        jl6.setForeground(Color.BLACK);
        t6 = new JTextField();
        p.add(jl6);
        p.add(t6);

        jl7 = new JLabel("Phone Number : ");
        jl7.setBounds(480, 350, 200, 30);//(40,20,100,30)
        jl7.setFont(new Font("serif", Font.ITALIC, 25));
        jl7.setForeground(Color.BLACK);
        t7 = new JTextField();
        p.add(jl7);
        p.add(t7);

        b1 = new JButton("Submit");

        b2 = new JButton("Cancel");

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.YELLOW);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.YELLOW);

        p.add(b1);
        p.add(b2);
        //add(l3);
        setLayout(new BorderLayout());

        add(p, "Center");

        b1.addActionListener(this);
        b2.addActionListener(this);
        //add(l3);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent u) {
          try {
       // String z = t.getText();

        String a = t1.getText();
        String c = t2.getText();
        String d = t3.getText();
        String e = t4.getText();
        String f = t5.getText();
        String g = t6.getText();
        String h = t7.getText();

        String q1 = "insert into cus values('" + a + "','" + c + "','" + d + "','" + e + "','" + f + "','" + g + "','" + h + "')";

        
            conn c1 = new conn();

            c1.s.executeUpdate(q1);
            JOptionPane.showMessageDialog(null, "Customer Created");
            this.setVisible(rootPaneCheckingEnabled);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new_customer nc = new new_customer();
    }
}
