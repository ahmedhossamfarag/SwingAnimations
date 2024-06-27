package tests;

import swing.animations.*;

import javax.swing.*;
import java.awt.*;

public class AnimationTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setSize(new Dimension(50, 50));

        JButton button1 = new JButton("Animation 1");
        button1.setSize(100,30);
        button1.addActionListener(e -> new TransitionAnimation(panel,panel.getLocation(), new Point(500,500), 5000).start(0, 50));
        button1.setLocation(400,0);

        JButton button2 = new JButton("Animation 2");
        button2.setSize(100,30);
        button2.addActionListener(e -> new ResizeAnimation(panel, panel.getSize(), new Dimension(300,300), 3000).start(0, 50));
        button2.setLocation(400,30);

        JButton button3 = new JButton("Animation 3");
        button3.setSize(100,30);
        button3.addActionListener(e -> new BackgroundAnimation(panel,panel.getBackground(), Color.magenta, 5000).start(0, 50));
        button3.setLocation(400,60);

        JButton button4 = new JButton("Animation 4");
        button4.setSize(100,30);
        button4.addActionListener(e -> {
            new TransitionAnimation(panel,panel.getLocation(), new Point(500,500), 5000).start(0, 50);
            new ResizeAnimation(panel, panel.getSize(), new Dimension(300, 300), 3000).start(0, 50);
        });
        button4.setLocation(400,90);

        frame.add(panel);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.setVisible(true);
    }
}
