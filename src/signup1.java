import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class signup1 extends JFrame implements ActionListener {
    JTextField ntf, ftf, ctf, ptf, atf, etf, phtf, dob;
    long random;
    JButton Next, clear;
    JDateChooser dateChooser;
    JRadioButton Male, Female;

    signup1() {
        setLayout(null);
        Random ran = new Random();
        long random = Math.abs((ran.nextLong() % 9000L) + 1000L);
        JLabel fromno = new JLabel("Application From No " + random);
        fromno.setFont(new Font("Railway", Font.BOLD, 38));
        fromno.setBounds(140, 20, 600, 40);
        add(fromno);
        JLabel pd = new JLabel("Step 1:Personal Details ");
        pd.setFont(new Font("Railway", Font.BOLD, 20));
        pd.setBounds(290, 80, 400, 30);
        add(pd);
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Railway", Font.BOLD, 15));
        name.setBounds(150, 150, 100, 30);
        add(name);
        ntf = new JTextField();
        ntf.setFont(new Font("Railway", Font.BOLD, 14));
        ntf.setBounds(300, 150, 400, 30);
        add(ntf);
        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Railway", Font.BOLD, 15));
        fname.setBounds(150, 200, 200, 30);
        add(fname);
        ftf = new JTextField();
        ftf.setFont(new Font("Railway", Font.BOLD, 14));
        ftf.setBounds(300, 200, 400, 30);
        add(ftf);
        JLabel Dob = new JLabel("Date of Birth:");
        Dob.setFont(new Font("Railway", Font.BOLD, 15));
        Dob.setBounds(150, 250, 200, 30);
        add(Dob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 250, 400, 30);
        add(dateChooser);
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Railway", Font.BOLD, 15));
        gender.setBounds(150, 300, 200, 30);
        add(gender);
        Male = new JRadioButton("Male");
        Male.setBounds(300, 300, 60, 30);
        Male.setBackground(Color.WHITE);
        add(Male);
        Female = new JRadioButton("Female");
        Female.setBounds(450, 300, 80, 30);
        Female.setBackground(Color.WHITE);
        add(Female);
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(Male);
        genderGroup.add(Female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Railway", Font.BOLD, 15));
        email.setBounds(150, 350, 200, 30);
        add(email);
        etf = new JTextField();
        etf.setFont(new Font("Railway", Font.BOLD, 14));
        etf.setBounds(300, 350, 400, 30);
        add(etf);
        JLabel ph = new JLabel("Phone:");
        ph.setFont(new Font("Railway", Font.BOLD, 15));
        ph.setBounds(150, 400, 200, 30);
        add(ph);
        phtf = new JTextField();
        phtf.setFont(new Font("Railway", Font.BOLD, 14));
        phtf.setBounds(300, 400, 400, 30);
        add(phtf);
        JLabel add = new JLabel("Address:");
        add.setFont(new Font("Railway", Font.BOLD, 15));
        add.setBounds(150, 450, 200, 30);
        add(add);
        atf = new JTextField();
        atf.setFont(new Font("Railway", Font.BOLD, 14));
        atf.setBounds(300, 450, 400, 30);
        add(atf);
        JLabel pin = new JLabel("Zip Code:");
        pin.setFont(new Font("Railway", Font.BOLD, 15));
        pin.setBounds(150, 500, 200, 30);
        add(pin);
        ptf = new JTextField();
        ptf.setFont(new Font("Railway", Font.BOLD, 14));
        ptf.setBounds(300, 500, 400, 30);
        add(ptf);
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Railway", Font.BOLD, 15));
        city.setBounds(150, 550, 200, 30);
        add(city);
        ctf = new JTextField();
        ctf.setFont(new Font("Railway", Font.BOLD, 14));
        ctf.setBounds(300, 550, 400, 30);
        add(ctf);
        Next = new JButton("NEXT");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(350, 600, 100, 30);
        Next.addActionListener(this::actionPerformed);
        add(Next);
        clear = new JButton("CLEAR");
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(500, 600, 100, 30);
        clear.addActionListener(this);
        add(clear);


        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String fromno = "" + random;
        String name = ntf.getText();
        String fname = ftf.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (Male.isSelected()) {
            gender = "Male";
        } else if (Female.isSelected()) {
            gender = "Female";
        }
        String email = etf.getText();
        String phone = phtf.getText();
        String address = atf.getText();
        String pin = ptf.getText();
        String city = ctf.getText();
        if (e.getSource() == clear) {
            ntf.setText("");
            ftf.setText("");
            etf.setText("");
            atf.setText("");
            phtf.setText("");
            ctf.setText("");
            ptf.setText("");
        }
        if (e.getSource() == Next) {
            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");

                } else {
                    conn c = new conn();
                    String query = "insert into signup values('" + fromno + "','" + name + "','" + fname + "','" + dob + "','"+gender+"','" + email + "',+'" + phone + "','" + address + "','" + pin + "','" + city + "')";
                    c.s.executeUpdate(query);
                    setVisible(false);
                    new signup2(fromno).setVisible(true);
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }
    }




    public static void main(String[] args){
        new signup1();

    }
}





