package swing.animations;

import java.util.Timer;
import java.util.TimerTask;

public abstract class Animation {

    private Action onFinish;

    private int currentTime;


    public void setOnFinish(Action onFinish) {
        this.onFinish = onFinish;
    }

    public abstract void update(int currentTime);

    public abstract boolean hasFinished(int currentTime);

    public void start(int delay, int framesInSecond){
        Timer timer = new Timer();
        int period = 1000/framesInSecond;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update(currentTime);
                if(hasFinished(currentTime)) {
                    timer.cancel();
                    if(onFinish != null){
                        onFinish.perform();
                    }
                }
                currentTime += period;
            }
        }, delay, period);
    }
}
