package swing.animations;

import javax.swing.*;
import java.awt.*;
import java.security.InvalidParameterException;

public class ResizeAnimation extends Animation{
    private final JComponent component;
    private final Dimension from;
    private final Dimension vector;
    private final int time;

    public ResizeAnimation(JComponent component, Dimension from, Dimension to, int time) throws InvalidParameterException {
        if(component == null) throw  new InvalidParameterException("from can't be null");
        if(from == null) throw  new InvalidParameterException("to can't be null");
        if(to == null) throw  new InvalidParameterException("component can't be null");
        if(time == 0) throw  new InvalidParameterException("time can't be 0");
        this.component = component;
        this.from = from;
        this.vector = new Dimension(to.width - from.width, to.height - from.height);
        this.time = time;
    }

    @Override
    public void update(int currentTime) {
        double pos = Math.min(1, (double) currentTime / time);
        Dimension newDim = new Dimension((int) (from.width + (vector.width*pos)), (int) (from.height + (vector.height*pos)));
        component.setSize(newDim);
        component.setPreferredSize(newDim);
    }

    @Override
    public boolean hasFinished(int currentTime) {
        return currentTime >= time;
    }
}
