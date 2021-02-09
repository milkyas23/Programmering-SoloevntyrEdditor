import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

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



            game.CharStreamExample();




    }

    private void CharStreamExample() {

    }
    public void actionPerformed(ActionEvent actionEvent) throws SQLException {
        view.Story.setText(model.getStory(1));
    }
}


