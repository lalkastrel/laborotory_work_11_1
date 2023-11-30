import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.EventObject;

public class KeyLogObserver implements Observer{
    private final DefaultListModel<String> keyState;
    @Override
    public void update(EventObject object) {
        keyState.addElement(KeyEvent.getKeyText(((KeyEvent) object).getKeyCode()));
    }
    KeyLogObserver(DefaultListModel<String> listModel) {
        keyState = listModel;
    }
}
