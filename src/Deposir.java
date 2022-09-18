import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Deposir extends JFrame implements ActionListener {
    JButton dep,back;
    JTextField dpa;
    String pnno;
    Deposir(String pno){
        this.pnno = pno;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel dp = new JLabel("Enter The Amount to Deposit");
        dp.setBounds(200,300,400,20);
        dp.setForeground(Color.WHITE);
        dp.setFont(new Font("System",Font.BOLD,18));
        image.add(dp);
        dpa = new JTextField();
        dpa.setBounds(200,340,270,20);
        dpa.setFont(new Font("System",Font.BOLD,16));
        image.add(dpa);
        dep = new JButton("Deposit");
        dep.setBounds(260,400,140, 40);
        dep.setFont(new Font("System",Font.BOLD,18));
        dep.addActionListener(this);
        image.add(dep);
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
        } else if (e.getSource()==dep) {
            String amount = dpa.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Amount to be deposit");
            }else{
                try{
                    conn conn = new conn();
                    String query = "Insert into trans values('"+pnno+"','"+date+"', 'Deposit' , '"+amount+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount Deposited Sucessfully");
                    setVisible(true);
                    new Transaction(pnno).setVisible(true);

                }catch(Exception e1){
                    System.out.println(e1);
                }

            }


        }

    }
}
