import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {
    JPanel panel;
    JLabel pressedKeyLabel;
    DefaultListModel<String> logKeyListModel = new DefaultListModel<>();
    Subject keySubject;
    static void main() {
        Frame frame = new Frame("Lab11_1");
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    Frame(String title) {
        super(title);
        setLayout(new GridLayout(1, 0));
        initLabel();
        initList();

        keySubject = new KeySubject();
        keySubject.attach(new KeyPressedObserver(pressedKeyLabel));
        keySubject.attach(new KeyLogObserver(logKeyListModel));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                keySubject.notifyObserver(e);
            }
        });
        setFocusable(true);
    }

    private void initLabel() {
        pressedKeyLabel = new JLabel();
        pressedKeyLabel.setPreferredSize(new Dimension(500, 500));
        pressedKeyLabel.setFont(new Font("Arial", Font.PLAIN, 200));
        pressedKeyLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(pressedKeyLabel);
    }

    private void initList() {
        JList<String> logKeyList = new JList<>(logKeyListModel);
        JScrollPane logKeyListScrollPane = new JScrollPane(logKeyList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(logKeyListScrollPane);
    }
}
