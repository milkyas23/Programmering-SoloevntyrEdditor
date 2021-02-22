import java.sql.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class SoloModel {
    private static Queue<Integer> storyLinks;
    int currentRoom = 1;
    private Statement stmt;

    public SoloModel() {
        String password = "password";
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "username", password);


            stmt = conn.createStatement();
        } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public String getStory(int i) throws SQLException {

        try {


            Scanner tgb = new Scanner(System.in);

            String strSelect = "select body from story where id = " + i;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                String body = rset.getString("body");
                return body;
            }
        }catch (SQLException e) {
                e.printStackTrace();
            }


            return null;

        }
    public  ArrayList<Link> getLinks(int i) throws SQLException {
        try {
            String strSelect = "select description, target_id from links where story_id = " + i;

            ResultSet rset = stmt.executeQuery(strSelect);
            ArrayList<Link> storyLinks = new ArrayList();

            int rowCount = 0;
                while (rset.next()) {
                String description = rset.getString("description");
                //int storyId = rset.getInt("story_id");
                int targetId = rset.getInt("target_id");

                    storyLinks.add(new Link(i,targetId,description));
                System.out.println(++rowCount + " " + description);
            }
            return storyLinks;


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
