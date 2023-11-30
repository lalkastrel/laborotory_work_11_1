import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class KeyPressedObserver implements Observer{
    private final JLabel keyState;
    @Override
    public void update(EventObject object) {
        keyState.setText(KeyEvent.getKeyText(((KeyEvent) object).getKeyCode()));
    }

    KeyPressedObserver(JLabel keyState) {
        this.keyState = keyState;
    }

}
