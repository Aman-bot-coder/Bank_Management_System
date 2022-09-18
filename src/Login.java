//package Bank.Management.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signin,signup,clear;
    long random;
    JTextField cTf;
    JPasswordField cPf;
    Login(){
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        add(l1);
        JLabel text = new JLabel("Welcome to ATM Machine");
        text.setFont(new Font("Osward",Font.BOLD,35));
        text.setBounds(200,40,480,40);
        add(text);
        JLabel cardno = new JLabel("Card Number:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(100,150,200,30);
        add(cardno);
         cTf = new JTextField();
        cTf.setBounds(300,150,230,30);
        add(cTf);
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(100,230,480,30);
        add(pin);
         cPf = new JPasswordField();
        cPf.setBounds(300,230,230,30);
        add(cPf);
         signin = new JButton("SIGN IN");
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.setBounds(300,300,100,30);
        signin.addActionListener(this);
        add(signin);
         clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(420,300,100,30);
        clear.addActionListener(this);
        add(clear);
        signup = new JButton("SIGN UP");
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.setBounds(300,350,230,50);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.WHITE);
    }
    public static void main(String[] args){
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==clear){
            cTf.setText("");
            cPf.setText("");
        }else if(e.getSource()==signin){
            conn c = new conn();
            String cardnoo = cTf.getText();
            String pnno = cPf.getText();

            String query = "select * from login where cardno = '"+cardnoo+"'and pno = '"+pnno+"'";
//            conn cc = new conn();
            try{
                conn cc = new conn();
                ResultSet rs =  cc.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pnno).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid cardnumber or PIN");

                }
            }catch (Exception er){
                System.out.println(er);

            }


        }else if(e.getSource()==signup){
            setVisible(false);
            new signup1().setVisible(true);
        }

    }
}
