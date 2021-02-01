import javax.swing.*;

/**
 * Here in this class SoloDesign from GUI form is introduced.
 */
public class Soloäventyr{
    SoloDesign view;

    /**
     * In this constructor Soloäventyr is Designed with JFrame
     */
    public Soloäventyr() {
        JFrame frame = new JFrame("SoloDesign");
        view = new SoloDesign();
        frame.add(view.Panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Here defines all methods in a public class
     * @param args
     */
    public static void main(String[] args) {
        Soloäventyr game = new Soloäventyr();
    }
}


