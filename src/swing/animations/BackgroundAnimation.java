package swing.animations;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;

public class BackgroundAnimation extends Animation{
    private final JComponent component;
    private final Color from;
    private final Color vector;
    private final int time;

    public BackgroundAnimation(JComponent component, Color from, Color to, int time) throws InvalidParameterException {
        if(component == null) throw  new InvalidParameterException("from can't be null");
        if(from == null) throw  new InvalidParameterException("to can't be null");
        if(to == null) throw  new InvalidParameterException("component can't be null");
        if(time == 0) throw  new InvalidParameterException("time can't be 0");
        this.component = component;
        this.from = from;
        this.vector = new Color(to.getRed() - from.getRed(), to.getGreen() - from.getGreen(), to.getBlue() - from.getBlue());
        this.time = time;
    }

    @Override
    public void update(int currentTime) {
        double pos = Math.min(1, (double) currentTime / time);
        component.setBackground(new Color(
                (int) (from.getRed() + (vector.getRed()*pos)),
                (int) (from.getGreen() + (vector.getGreen()*pos)),
                (int) (from.getBlue() + (vector.getBlue()*pos)))
        );
    }

    @Override
    public boolean hasFinished(int currentTime) {
        return currentTime >= time;
    }
}
