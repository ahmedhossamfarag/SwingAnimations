package swing.animations;

import javax.swing.*;
import java.awt.*;

public class ResizeAnimation extends Animation{
    private final JComponent component;
    private final Dimension from;
    private final Dimension vector;
    private final int time;

    public ResizeAnimation(JComponent component, Dimension from, Dimension to, int time) {
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
