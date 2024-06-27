package swing.animations;

import java.util.ArrayList;
import java.util.Objects;


public class ObservableVariable {



    private Object value;
    private final ArrayList<ChangeListener> listeners;

    public ObservableVariable(Object initialValue){
        value = initialValue;
        listeners = new ArrayList<>();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        if(Objects.equals(this.value, value)) return;
        listeners.forEach(l -> l.onChange(this.value, value));
        this.value = value;
    }

    public void addListener(ChangeListener listener){
        if(listener != null)
            listeners.add(listener);
    }

    public void removeListener(ChangeListener listener){
        if(listener != null)
            listeners.remove(listener);
    }
}
