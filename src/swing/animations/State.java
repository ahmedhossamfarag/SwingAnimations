package swing.animations;

import java.util.ArrayList;

public class State {
    private final String name;
    private final ArrayList<Animatable> animations;

    private final ArrayList<Transition> transitions;

    public State(String name) {
        this.name = name;
        this.animations = new ArrayList<>();
        this.transitions = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    protected void update(int currentFrame, int framesInSecond) {
        this.animations.forEach(a -> a.update(currentFrame, framesInSecond));
    }

    public void addAnimation(Animatable animation){
        if(animation != null)
            this.animations.add(animation);
    }

    public void removeAnimation(Animatable animation){
        if(animation != null)
            this.animations.remove(animation);
    }

    protected void addTransition(Transition transition) {
        if(transition != null)
            this.transitions.add(transition);
    }

    protected void removeTransition(ObservableVariable variable, Object changeValue){
        if(variable == null) return;
        for(Transition transition : new ArrayList<>(this.transitions)){
            if(transition.isListenerTo(variable, changeValue)){
                transition.remove();
                this.transitions.remove(transition);
            }
        }
    }

    protected boolean hasTransition(Transition transition){
        return this.transitions.contains(transition);
    }

    public void remove() {
        transitions.forEach(Transition::remove);
    }

}
