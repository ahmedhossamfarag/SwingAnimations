package tests;

import swing.animations.Animator;
import swing.animations.ObservableVariable;
import swing.animations.State;

import javax.swing.*;
import java.awt.*;

public class AnimatorTest {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Animator Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(600,600));
        frame.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBackground(Color.BLUE);
        panel.setSize(new Dimension(50, 50));
        ObservableVariable variable1 = new ObservableVariable(false);
        ObservableVariable variable2 = new ObservableVariable(false);
        JButton button1 = new JButton("Right");
        button1.setSize(100,30);
        button1.addActionListener(e -> variable1.setValue(true));
        button1.setLocation(400,0);
        JButton button2 = new JButton("Down");
        button2.setSize(100,30);
        button2.addActionListener(e -> variable2.setValue(true));
        button2.setLocation(400,30);
        frame.add(panel);
        frame.add(button1);
        frame.add(button2);

        Animator animator = createAnimator(panel, variable1, variable2);
        frame.setVisible(true);
        animator.start();
    }

    public static Animator createAnimator(JComponent component, ObservableVariable variable1, ObservableVariable variable2){
        State state1 = new State("State 1");
        State state2 = new State("State 2");
        State state3 = new State("State 3");

        state1.addAnimation((cf, fps) -> {
            Point p = component.getLocation();
            component.setLocation(p.x + 10, p.y);
        });


        state2.addAnimation((cf, fps) -> {
            Point p = component.getLocation();
            component.setLocation(p.x - 10, p.y);
        });


        state3.addAnimation((cf, fps) -> {
            Point p = component.getLocation();
            component.setLocation(p.x, p.y + 10);
        });


        Animator animator = new Animator(10, state1);

        animator.addTransition(state1, state2, variable1, true);
        animator.addTransition(state2, state3, variable2, true);

        return animator;
    }

}
