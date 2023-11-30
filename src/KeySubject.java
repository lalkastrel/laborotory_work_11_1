import java.util.ArrayList;
import java.util.EventObject;
import java.util.List;

public class KeySubject implements Subject{
    private final List<Observer> keysState;
    KeySubject() {
        keysState = new ArrayList<>();
    }
    @Override
    public void attach(Observer o) {
        keysState.add(o);
    }

    @Override
    public void detach(Observer o) {
        keysState.remove(o);
    }

    @Override
    public void notifyObserver(EventObject object) {
        keysState.forEach(observer -> observer.update(object));
    }
}
