import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class signup2 extends JFrame implements ActionListener {
    JTextField  ptf,atf;
    JButton Next, Back;
    JComboBox reg,cat,Educa,Occupationn,inc,disabl;
    JRadioButton Yes, No,Y1,N1;
    String fromno;

    signup2(String fromno) {
        this.fromno = fromno;
        setLayout(null);
        JLabel s2 = new JLabel("Step 2:Personal Details ");
        s2.setFont(new Font("Railway", Font.BOLD, 20));
        s2.setBounds(290, 40, 400, 30);
        add(s2);
        JLabel religion = new JLabel("Religion:");
        religion.setFont(new Font("Railway", Font.BOLD, 15));
        religion.setBounds(150, 100, 100, 30);
        add(religion);
        String varreligion [] = {"Hindu","Muslim","Sikh","Christian","Others"};
        reg = new JComboBox(varreligion);
        reg.setBackground(Color.WHITE);
        reg.setBounds(300, 100, 400, 30);
        add(reg);
        JLabel ct = new JLabel("Category:");
        ct.setFont(new Font("Railway", Font.BOLD, 15));
        ct.setBounds(150, 150, 200, 30);
        add(ct);
        String catg [] = {"General","OBC","SC/ST","Others"};
        cat = new JComboBox(catg);
        cat.setBounds(300, 150, 400, 30);
        cat.setBackground(Color.WHITE);
        add(cat);
        JLabel eq = new JLabel("Educational");
        eq.setFont(new Font("Railway", Font.BOLD, 15));
        eq.setBounds(150, 200, 200, 30);
        add(eq);
        JLabel Qa = new JLabel("Qualification:");
        Qa.setFont(new Font("Railway", Font.BOLD, 15));
        Qa.setBounds(150, 220, 200, 30);
        add(Qa);
        String eudcationqul[] = {"SSC","HSC","DIPLOMA","Graduation","Post-Graduation","illiterate"};
        Educa = new JComboBox(eudcationqul);
        Educa.setBounds(300,200,400,30);
        Educa.setBackground(Color.WHITE);
        add(Educa);
        JLabel occu = new JLabel("Occupation:");
        occu.setFont(new Font("Railway", Font.BOLD, 15));
        occu.setBounds(150, 250, 200, 30);
        add(occu);
        String occupa [] = {"Employed","Self-Employed","Student","Other"};
        Occupationn =  new JComboBox(occupa);
        Occupationn.setBounds(300,250,400,30);
        Occupationn.setBackground(Color.WHITE);
        add(Occupationn);
        JLabel incom = new JLabel("Income:");
        incom.setBounds(150,300,200,30);
        incom.setFont(new Font("Reilway",Font.BOLD,15));
        add(incom);
        String incomee [] = {"Null","<1 Lac","<2.5 Lac","<5 Lac","<10 Lac","Upto 20 Lac"};
        inc = new JComboBox(incomee);
        inc.setBounds(300,300,400,30);
        inc.setBackground(Color.WHITE);
        add(inc);
        JLabel Dis = new JLabel("Disability:");
        Dis.setBounds(150,350,200,30);
        Dis.setFont(new Font("Railway",Font.BOLD,15));
        add(Dis);
        String diss[] = {"Yes","No"};
        disabl = new JComboBox(diss);
        disabl.setBounds(300,350,400,30);
        disabl.setBackground(Color.WHITE);
        add(disabl);
        JLabel pan = new JLabel("PAN NO:");
        pan.setFont(new Font("Railway", Font.BOLD, 15));
        pan.setBounds(150, 400, 200, 30);
        add(pan);
        ptf = new JTextField();
        ptf.setFont(new Font("Railway", Font.BOLD, 14));
        ptf.setBounds(300, 400, 400, 30);
        add(ptf);
        JLabel Uid = new JLabel("AADHAR:");
        Uid.setFont(new Font("Railway", Font.BOLD, 15));
        Uid.setBounds(150, 450, 200, 30);
        add(Uid);
        atf = new JTextField();
        atf.setFont(new Font("Railway", Font.BOLD, 14));
        atf.setBounds(300, 450, 400, 30);
        add(atf);
        JLabel Sc = new JLabel("Senior Citizen:");
        Sc.setFont(new Font("Railway", Font.BOLD, 15));
        Sc.setBounds(150, 500, 200, 30);
        add(Sc);
        Y1 = new JRadioButton("Yes");
        Y1.setBounds(380,500,100,30);
        Y1.setBackground(Color.WHITE);
        add(Y1);
        N1 = new JRadioButton("No");
        N1.setBounds(550,500,100,30);
        N1.setBackground(Color.WHITE);
        add(N1);
        ButtonGroup scg = new ButtonGroup();
        scg.add(Y1);
        scg.add(N1);
        JLabel Ec = new JLabel("Existing Customer:");
        Ec.setFont(new Font("Railway", Font.BOLD, 15));
        Ec.setBounds(150, 550, 200, 30);
        add(Ec);
        Yes = new JRadioButton("Yes");
        Yes.setBackground(Color.WHITE);
        Yes.setBounds(380,550,100,30);
        add(Yes);
        No = new JRadioButton("No");
        No.setBounds(550,550,100,30);
        No.setBackground(Color.WHITE);
        add(No);
        ButtonGroup ecb = new ButtonGroup();
        ecb.add(Yes);
        ecb.add(No);
        Back = new JButton("BACK");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBounds(350, 650, 100, 30);
        Back.addActionListener(this::actionPerformed);
        add(Back);
        Next = new JButton("NEXT");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(500, 650, 100, 30);
        Next.addActionListener(this);
        add(Next);


        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String fromno = "" + Math.random();
        String sreligion = (String)  reg.getSelectedItem();
        String scat = (String) cat.getSelectedItem();
        String sedu = (String) Educa.getSelectedItem();
        String socup = (String) Occupationn.getSelectedItem();
        String sinc = (String) inc.getSelectedItem();
        String sdis = (String) disabl.getSelectedItem();
        String pan = ptf.getText();
        String aadharr = atf.getText();
        String ExistCus = null;
        if (Yes.isSelected()) {
            ExistCus = "Yes";
        } else if (No.isSelected()) {
           ExistCus = "No";
        }
        String SenCit = null;
        if(Y1.isSelected()){
            SenCit = "Yes";
        }else if(N1.isSelected()){
            SenCit = "No";
        }
        if (e.getSource() == Back) {
            setVisible(false);
            new signup1().setVisible(true);
        }
        if (e.getSource() == Next) {
            try {
                if (pan.equals("")) {
                    JOptionPane.showMessageDialog(null, "PAN is Required");

                } else {
                    conn c = new conn();
                    String query = "insert into signupTwo values('" + fromno + "','" + sreligion + "','" + scat + "','" + sedu + "',+'" + socup + "','" + sinc + "','" + sdis + "','" + pan + "','" + aadharr + "','" + ExistCus + "','" + SenCit + "')";
                    c.s.executeUpdate(query);
//                    OBJECT SIGNUP3
                    setVisible(false);
                    new signup3(fromno).setVisible(true);
                }
            } catch (Exception e1) {
                System.out.println(e1);
            }
        }

    }
    public static void main(String[] args){
        new signup2("");

    }
}


