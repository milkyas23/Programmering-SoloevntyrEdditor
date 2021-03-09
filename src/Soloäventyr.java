import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Here in this class SoloDesign from GUI form is introduced.
 */
public class Soloäventyr{
    SoloDesign view;
    SoloModel model;
    DatabaseEditor editor;

    /**
     * In this constructor Soloäventyr is Designed with JFrame also view and model are introduced to recognise each other.
     * @param editButton
     * @param Database
     * @param continueButton
     */
    public Soloäventyr(AbstractButton editButton, AbstractButton Database, AbstractButton continueButton) {
        JFrame frame = new JFrame("SoloDesign");
        frame = new JFrame("DatabaseEditor");
        view = new SoloDesign();
        model = new SoloModel();
        editor = new DatabaseEditor(model);
        frame.add(view.Panel);
        view.startNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    ArrayList<Link>links = model.getLinks(model.currentRoom);

                    Link linl1=links.get(0);
                    view.JA.setText(linl1.getDescription());
                    view.JA.setName(String.valueOf(linl1.getTarget_id()));

                    Link linl2 = null;
                    if (links.size() > 1) {
                        linl2 = links.get(1);
                        view.NEJ.setText(linl2.getDescription());
                        view.NEJ.setName(String.valueOf(linl2.getTarget_id()));
                    } else{
                        view.NEJ.setText("-");
                    }

                    view.Story.setText(model.getStory(model.currentRoom));


                    model.currentRoom++;
                    //System.out.println(model.currentRoom);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        view.JA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.currentRoom = Integer.parseInt(view.JA.getName());
                ArrayList<Link>links = null;
                try {
                    links = model.getLinks(model.currentRoom);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (links.size() == 0) {
                        System.out.println("end");

                    return;
                }

                Link linl1=links.get(0);
                view.JA.setText(linl1.getDescription());
                view.JA.setName(String.valueOf(linl1.getTarget_id()));

                Link linl2 = null;
                if (links.size() > 1) {
                    linl2 = links.get(1);
                    view.NEJ.setText(linl2.getDescription());
                    view.NEJ.setName(String.valueOf(linl2.getTarget_id()));
                } else{
                    view.NEJ.setText("-");
                }

                try {
                    view.Story.setText(model.getStory(model.currentRoom));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
        view.NEJ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                model.currentRoom = Integer.parseInt(view.NEJ.getName());
                ArrayList<Link>links = null;
                try {
                    links = model.getLinks(model.currentRoom);
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                Link linl1=links.get(0);
                view.JA.setText(linl1.getDescription());
                view.JA.setName(String.valueOf(linl1.getTarget_id()));

                Link linl2 = null;
                if (links.size() > 1) {
                    linl2 = links.get(1);
                    view.NEJ.setText(linl2.getDescription());
                    view.NEJ.setName(String.valueOf(linl2.getTarget_id()));
                } else{
                    view.NEJ.setText("-");
                }

                try {
                    view.Story.setText(model.getStory(model.currentRoom));
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });


            editButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                }
            });
            Database.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        ArrayList<Link> links = model.getLinks(model.currentRoom);

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        Database.setText(model.getStory(model.currentRoom));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            });
            continueButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    try {
                        ArrayList<Link>links = model.getLinks(model.currentRoom);

                        Link linl1=links.get(0);
                        Database.setText(linl1.getDescription());

                        Link linl2 = null;
                        if (links.size() > 1) {
                            linl2 = links.get(1);
                            Database.setText(linl2.getDescription());
                        }

                        Database.setText(model.getStory(model.currentRoom));


                        model.currentRoom++;
                        System.out.println(model.currentRoom);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });



        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    /**
     * Here defines all methods in a public class
     * @param args
     * @param editButton
     * @param Database
     * @param continueButton
     */
    public static void main(String[] args, AbstractButton editButton, AbstractButton Database, AbstractButton continueButton) {
        Soloäventyr game = new Soloäventyr(editButton, Database, continueButton);

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


