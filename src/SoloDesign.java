import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SoloDesign {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SoloDesign");
        frame.setContentPane(new SoloDesign().Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SoloDesign() {
        startNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Story.setText(SoloModel.getStory(1));
            }
        });
    }
    public SoloDesign(JTextArea story) {
        Story = story;
    }

    public SoloDesign(JButton link1) {
        Link1 = link1;
        Link2 = Link2;
    }

    private JTextArea Story;
    private JButton Link1;
    private JButton Link2;
    public JPanel Panel;
    private JButton startNext;

}
