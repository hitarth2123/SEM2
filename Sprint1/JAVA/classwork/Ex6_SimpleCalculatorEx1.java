import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Ex6_SimpleCalculatorEx1 {
    public static void main(String[] args) {
      
        JFrame f = new JFrame("Simple Calculator");
        f.setLayout(new FlowLayout());

        JLabel label1 = new JLabel("Enter First Number ");
        JTextField tf1 = new JTextField(10);
        JLabel label2 = new JLabel("Enter Second Number");
        JTextField tf2 = new JTextField(10);
        JLabel resultLabel = new JLabel("");

        JButton b1 = new JButton("ADD");
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(tf1.getText());
                int num2 = Integer.parseInt(tf2.getText());
                int sum = num1 + num2;
                resultLabel.setText(String.valueOf(sum));
            }
        });

        JButton b2 = new JButton("Subtract");
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int num1 = Integer.parseInt(tf1.getText());
                int num2 = Integer.parseInt(tf2.getText());
                int diff = num1 - num2;
                resultLabel.setText(String.valueOf(diff));
            }
        });

        JButton b3 = new JButton("Reset");
        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf1.setText("");
                tf2.setText("");
                resultLabel.setText("");
            }
        });

        f.add(label1);
        f.add(tf1);
        f.add(label2);
        f.add(tf2);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(resultLabel);

        f.setSize(300, 200);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}