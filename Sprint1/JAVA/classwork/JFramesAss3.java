import javax.swing.*;
public class JFramesAss3 extends JFrame {
    JFrame f;
    JFramesAss3(){
        JButton b= new JButton("click");
        b.setBounds(130,100,100,40);

        add(b);
        setSize(400,500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new JFramesAss3();
    }
}
