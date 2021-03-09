import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabaseEditor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("DatabaseEditor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
    public DatabaseEditor(SoloModel editButton ) {
        editButton = editButton;
        continueButton = continueButton;
    }
    public JPanel DatabaseEditor;
    public JTextField Database;
    public JTextField NewDatabase;
    public JButton editButton;
    public JButton continueButton;


}

