import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class SoloDesign {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SoloDesign");
        frame.setContentPane(new SoloDesign().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SoloDesign() {

    }

    public SoloDesign(JTextArea story) {
        Story = story;
    }

    public SoloDesign(JButton link1) {
        JA = link1;
        NEJ = NEJ;
    }

    public JTextArea Story;
    public JButton JA;
    public JButton NEJ;
    public JPanel Panel;
    public JButton startNext;

}
