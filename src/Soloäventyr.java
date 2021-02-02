import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Here in this class SoloDesign from GUI form is introduced.
 */
public class Soloäventyr{
    SoloDesign view;
    SoloModel model;

    /**
     * In this constructor Soloäventyr is Designed with JFrame
     */
    public Soloäventyr() {
        JFrame frame = new JFrame("SoloDesign");
        view = new SoloDesign();
        model = new SoloModel();
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
        String password = "password";

        try {


            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "username", password);

            game.CharStreamExample();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void CharStreamExample() {

    }
    public void actionPerformed(ActionEvent actionEvent) {
        Story.setText(SoloModel.getStory(1));
    }
}


