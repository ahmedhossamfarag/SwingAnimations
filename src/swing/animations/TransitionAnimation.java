package swing.animations;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;

public class TransitionAnimation extends Animation {
    private final JComponent component;
    private final Point from;
    private final Point vector;
    private final int time;

    public TransitionAnimation(JComponent component, Point from, Point to, int time) throws InvalidParameterException {
        if(component == null) throw  new InvalidParameterException("from can't be null");
        if(from == null) throw  new InvalidParameterException("to can't be null");
        if(to == null) throw  new InvalidParameterException("component can't be null");
        if(time == 0) throw  new InvalidParameterException("time can't be 0");
        this.component = component;
        this.from = from;
        this.vector = new Point(to.x - from.x, to.y - from.y);
        this.time = time;
    }

    @Override
    public void update(int currentTime) {
        double pos = Math.min(1, (double) currentTime / time);
        component.setLocation((int) (from.x + (vector.x*pos)), (int) (from.y + (vector.y*pos)));
    }

    @Override
    public boolean hasFinished(int currentTime) {
        return currentTime >= time;
    }
}
