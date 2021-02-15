import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
        view.startNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    view.Story.setText(SoloModel.getStory(model.currentRoom));
                    model.currentRoom++;
                    //System.out.println(model.currentRoom);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        view.JA.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent componentEvent) {
                try {
                    view.Story.setText(SoloModel.getStory(model.currentRoom));
                    model.currentRoom++;

                } catch (Exception e) {
                    e.printStackTrace();
                }

                super.componentResized(componentEvent);
            }
        });

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

    /**
     * Here button start/next is defined and functional.
     * @param actionEvent
     * @throws SQLException
     */
    public void actionPerformed(ActionEvent actionEvent) throws SQLException {
        view.Story.setText(model.getStory(1) + " " + model.getStory(2));

    }
}


