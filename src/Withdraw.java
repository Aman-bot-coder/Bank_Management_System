import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Withdraw extends JFrame implements ActionListener {
    JButton wth,back;
    JTextField with;
    String pnno;
    Withdraw(String pno){
        this.pnno = pno;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel dp = new JLabel("Enter The Amount to Withdraw");
        dp.setBounds(200,300,400,20);
        dp.setForeground(Color.WHITE);
        dp.setFont(new Font("System",Font.BOLD,18));
        image.add(dp);
        with = new JTextField();
        with.setBounds(200,340,270,20);
        with.setFont(new Font("System",Font.BOLD,16));
        image.add(with);
        wth = new JButton("Withdraw");
        wth.setBounds(260,400,140, 40);
        wth.setFont(new Font("System",Font.BOLD,18));
        wth.addActionListener(this);
        image.add(wth);
        back = new JButton("Back");
        back.setBounds(260,460,140,40);
        back.setFont(new Font("System",Font.BOLD,18));
        back.addActionListener(this);
        image.add(back);





        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }



    public static void main(String[] args){
        new Deposir("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
            new Transaction("").setVisible(true);
        } else if (e.getSource()==wth) {
            String amount = wth.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount to be Withdraw");
            }else{
                try{
                    conn conn = new conn();
                    String query = "Insert into trans values('"+pnno+"','"+date+"', 'Withdraw' , '"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount Withdraw Sucessfully");
                    setVisible(true);
                    new Transaction(pnno).setVisible(true);

                }catch(Exception e1){
                    System.out.println(e1);
                }

            }


        }

    }
}

