
import javax.swing.*;
import java.awt.event.*;

class Ex12_RBEvent2 {
    JRadioButton rb1, rb2;
    JButton b;
    JFrame f;
    JLabel l;

    Ex12_RBEvent2() {
        f = new JFrame("RadioButton Ex");
        rb1 = new JRadioButton("Male");
        rb1.setBounds(100, 50, 100, 30);
        rb2 = new JRadioButton("Female");
        rb2.setBounds(100, 100, 100, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        b = new JButton("click");
        b.setBounds(100, 150, 80, 30);
        l = new JLabel();
        l.setBounds(70, 200, 180, 30);
        f.add(rb1);
        f.add(rb2);
        f.add(b);
        f.add(l);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rb1.isSelected()) {
                    l.setText("You have selected Male.");
                }
                if (rb2.isSelected()) {
                    l.setText("You have selected Female.");
                }
        f.setSize(300,300);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);}

        });

    }
    public static void main(String[] args) {
        new Ex12_RBEvent2();
    }
}

