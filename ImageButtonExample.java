/*
4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or
“Hour Glass is pressed” depending upon the JButton with image either Digital Clock
or Hour Glass is pressed by implementing the event handling mechanism with
addActionListener( ).
*/
package oneA;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ImageButtonExample {

    JLabel l1;

    ImageButtonExample() {

        JFrame f = new JFrame("Image Button Example");

        l1 = new JLabel();
        l1.setBounds(50, 50, 800, 100);
        l1.setFont(new Font("Arial", Font.BOLD, 30));

        // Load images (ensure these files exist in your project directory)
        ImageIcon digitalIcon = new ImageIcon("digital_clock.png");
        ImageIcon hourGlassIcon = new ImageIcon("hour_glass.png");

        JButton b1 = new JButton(digitalIcon);
        JButton b2 = new JButton(hourGlassIcon);

        b1.setBounds(100, 200, 150, 150);
        b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Digital Clock is pressed");
            }
        });

        b2.setBounds(350, 200, 150, 150);
        b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                l1.setText("Hour Glass is pressed");
            }
        });

        f.add(b1);
        f.add(b2);
        f.add(l1);

        f.setSize(600, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}