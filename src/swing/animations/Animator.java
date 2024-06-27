package swing.animations;

import java.util.Timer;
import java.util.TimerTask;

public class Animator {
    private final int framesInSecond;

    private State currentState;

    private int currentFrame;

    private Timer timer;

    public Animator(int framesInSecond, State initialState){
        this.framesInSecond = framesInSecond;
        this.currentState = initialState;
    }

    public void addTransition(State fromState, State toState, ObservableVariable variable, Object value){
        if(fromState != null){
            fromState.addTransition(new Transition(this, variable, value, toState));
        }
    }

    public void removeTransition(State fromState, ObservableVariable variable, Object value){
        if(fromState != null){
            fromState.removeTransition(variable, value);
        }
    }

    protected void goToState(State nextState) {
        currentState = nextState;
        currentFrame = 0;
    }

    private void update(){
        if(currentState != null){
            currentState.update(currentFrame, framesInSecond);
        }
        currentFrame++;
    }

    public void start(){
        timer = new Timer();
        int period = 1000/framesInSecond;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                update();
            }
        }, 0, period);
    }

    public void stop(){
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }
}
