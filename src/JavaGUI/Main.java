package JavaGUI;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // JFrame = a GUI window
        JLabel label = new JLabel();//creates a label
        label.setText("Hey there fellas!");
//        ImageIcon image = new ImageIcon("src/JavaGUI/calculator.png");
 //       label.setIcon(image);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));

 //       label.setHorizontalAlignment(JLabel.CENTER);//set text LEFT, CENTER or RIGHT of image icon
 //       label.setVerticalAlignment(JLabel.BOTTOM);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(3);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label);
    }
}
