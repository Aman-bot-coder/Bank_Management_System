import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup3 extends JFrame implements ActionListener {
    JRadioButton at1,at2;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton sub,clear;
    String fromno;
    signup3(String fromno){
        this.fromno = fromno;
        setLayout(null);
        JLabel l1 = new JLabel("Step 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,18));
        l1.setBounds(280,40,400,30);
        add(l1);
        JLabel at = new JLabel("Account Type:");
        at.setBounds(100,100,200,30);
        at.setFont(new Font("Raleway", Font.BOLD,18));
        add(at);
        at1 = new JRadioButton("Saving Account");
        at1.setBounds(300,100,200,30);
        at1.setFont(new Font("Raleway",Font.BOLD,12));
        at1.setBackground(Color.WHITE);
        add(at1);
        at2 = new JRadioButton("Current Account");
        at2.setBounds(500,100,200,30);
        at2.setFont(new Font("Raleway",Font.BOLD,12));
        at2.setBackground(Color.WHITE);
        add(at2);
        ButtonGroup bac = new ButtonGroup();
        bac.add(at1);
        bac.add(at2);
        JLabel card = new JLabel("CARD NO :");
        card.setBounds(100,200,200,30);
        card.setFont(new Font("Raleway", Font.BOLD,18));
        add(card);
        JLabel det = new JLabel("(Your 16 Digit Card no) ");
        det.setBounds(100,220,200,30);
        det.setFont(new Font("Raleway", Font.BOLD,10));
        add(det);
        JLabel cardno = new JLabel("XXXX-XXXX-XXXX-XXX6");
        cardno.setBounds(300,200,300,30);
        cardno.setFont(new Font("Raleway", Font.BOLD,20));
        add(cardno);
        JLabel pin = new JLabel("PIN:");
        pin.setBounds(100,300,300,30);
        pin.setFont(new Font("Raleway", Font.BOLD,20));
        add(pin);
        JLabel pino = new JLabel("XXXX");
        pino.setBounds(300,300,300,30);
        pino.setFont(new Font("Raleway", Font.BOLD,20));
        add(pino);
        JLabel ser = new JLabel("Services");
        ser.setBounds(280,400,300,30);
        ser.setFont(new Font("Raleway", Font.BOLD,20));
        add(ser);
        c1 = new JCheckBox("Internet Banking");
        c1.setFont(new Font("Raleway", Font.BOLD,12));
        c1.setBounds(100,450,150,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        c2 = new JCheckBox("ATM CARD");
        c2.setFont(new Font("Raleway", Font.BOLD,12));
        c2.setBounds(300,450,150,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        c3 = new JCheckBox("SMS ALERT");
        c3.setFont(new Font("Raleway", Font.BOLD,12));
        c3.setBounds(500,450,150,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        c4 = new JCheckBox("CHECQUE BOOK");
        c4.setFont(new Font("Raleway", Font.BOLD,12));
        c4.setBounds(100,500,150,30);
        c4.setBackground(Color.WHITE);
        add(c4);
        c5 = new JCheckBox("E-STATEMENT");
        c5.setFont(new Font("Raleway", Font.BOLD,12));
        c5.setBounds(300,500,300,30);
        c5.setBackground(Color.WHITE);
        add(c5);
        c6 = new JCheckBox("I hereby declare that the information provided is true and correct.");
        c6.setFont(new Font("Raleway", Font.BOLD,12));
        c6.setBounds(100,550,1000,30);
        c6.setBackground(Color.WHITE);
        add(c6);
        c7 = new JCheckBox("By clicking here, I state that I have read and understood the terms and conditions");
        c7.setFont(new Font("Raleway", Font.BOLD,12));
        c7.setBounds(100,600,1000,30);
        c7.setBackground(Color.WHITE);
        add(c7);
        clear = new JButton("CANCEL");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(200,700,150,30);
        clear.setFont(new Font("Raleway", Font.BOLD,20));
        clear.addActionListener(this::actionPerformed);
        add(clear);
        sub = new JButton("SUBMIT");
        sub.setBackground(Color.BLACK);
        sub.setForeground(Color.WHITE);
        sub.setBounds(400,700,150,30);
        sub.setFont(new Font("Raleway", Font.BOLD,20));
        sub.addActionListener(this::actionPerformed);
        add(sub);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);



    }
    public static void main(String[] args) {
        new signup3("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sub){
            String fromno = "" + Math.random();
            String accType = null;
            if(at1.isSelected()){
                accType = "Saving Account";
            }else if(at2.isSelected()){
                accType = "Current Account";
            }
            Random random = new Random();
            String cno = "" + Math.abs((random.nextLong() % 90000L)) +60709360674L;
            String pno = "" + Math.abs((random.nextLong() % 9000L) +1000L);
            String facility = "";
            if(c1.isSelected()){
                facility = facility + "Internet Banking";
            } else if(c2.isSelected()){
                facility = facility + "ATM CARD";
            } else if(c3.isSelected()){
                facility = facility + "SMS-Alert";
            } else if (c4.isSelected()) {
                facility = facility + "CHECQUE Book";

            } else if (c5.isSelected()) {
                facility = facility + "E-Statement";
            }
            try{
                if(accType.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please Choose Account Type");
                } else{
                    conn c = new conn();
                    String query = "insert into signupThree Values('"+fromno+"','"+accType+"','"+cno+"','"+pno+"','"+facility+"')";
                    String query2 = "insert into login Values('"+fromno+"','"+cno+"','"+pno+"')";
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query2);
                }
                JOptionPane.showMessageDialog(null,"Card Number: "+cno+"\n"+"PIN: "+pno);
                setVisible(false);
                new Login().setVisible(true);

            }catch (Exception e1){
                System.out.println(e1);
            }


        } else if (e.getSource()==clear) {
            setVisible(false);

        }


    }
}
