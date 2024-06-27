package swing.animations;

import java.util.Objects;

public class Transition implements ChangeListener{
    private final Animator animator;
    private final ObservableVariable variable;
    private final Object changeValue;
    private final State nextState;

    protected Transition(Animator animator, ObservableVariable variable, Object changeValue, State nextState) {
        this.animator = animator;
        this.variable = variable;
        this.changeValue = changeValue;
        this.nextState = nextState;

        variable.addListener(this);
    }

    protected boolean isListenerTo(ObservableVariable variable, Object changeValue){
        if(!Objects.equals(this.variable, variable)) return false;
        return Objects.equals(this.changeValue, changeValue);
    }

    @Override
    public void onChange(Object oldValue, Object newValue) {
        if(Objects.equals(newValue, changeValue))
            animator.goToState(nextState);
    }

    protected void remove() {
        if(this.variable != null)
            this.variable.removeListener(this);
    }
}
