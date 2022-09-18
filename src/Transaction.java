import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transaction  extends  JFrame implements ActionListener {
    JButton withdraw,pc,fc,ms,be,de,ex;
    String pno;
    Transaction(String pnno){
        this.pno = pnno;

        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        JLabel text = new JLabel("Please Select Your Transaction");
        text.setBounds(170,300,400,25);
        text.setFont(new Font("System",Font.BOLD,22));
        text.setForeground(Color.white);
        image.add(text);
         withdraw = new JButton("Withdraw");
        withdraw.setBounds(150,415,150,25);
        withdraw.setForeground(Color.BLACK);
        withdraw.setFont(new Font("System",Font.BOLD,22));
        withdraw.addActionListener(this);
        image.add(withdraw);
         fc = new JButton("Fast Cash");
        fc.setBounds(370,415,150,25);
        fc.setForeground(Color.BLACK);
        fc.setFont(new Font("System",Font.BOLD,22));
        fc.addActionListener(this);
        image.add(fc);
        be = new JButton("Balance");
        be.setBounds(150,445,150,25);
        be.setForeground(Color.BLACK);
        be.setFont(new Font("System",Font.BOLD,22));
        be.addActionListener(this);
        image.add(be);
         ms = new JButton("Mini Statement");
        ms.setBounds(370,445,150,25);
        ms.setForeground(Color.BLACK);
        ms.setFont(new Font("System",Font.BOLD,15));
        ms.addActionListener(this);
        image.add(ms);
         de = new JButton("Deposit");
        de.setBounds(150,475,150,25);
        de.setForeground(Color.BLACK);
        de.setFont(new Font("System",Font.BOLD,22));
        de.addActionListener(this);
        image.add(de);
        pc = new JButton("Pin Change");
        pc.setBounds(370,475,150,25);
        pc.setForeground(Color.BLACK);
        pc.setFont(new Font("System",Font.BOLD,15));
        pc.addActionListener(this);
        image.add(pc);
        ex = new JButton("Exit");
        ex.setBounds(150,505,150,25);
        ex.setForeground(Color.BLACK);
        ex.setFont(new Font("System",Font.BOLD,22));
        ex.addActionListener(this);
        image.add(ex);





        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }
    public static void main(String[] args){
        new Transaction("");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== ex){
            System.exit(0);
        }else if(ae.getSource()==de){
            setVisible(false);
            new Deposir(pno).setVisible(true);
        } else if (ae.getSource()==withdraw) {
            setVisible(false);
            new Withdraw("").setVisible(true);

        }
    }
}

