import java.sql.*;
import java.util.Queue;
import java.util.Scanner;

public class SoloModel {
    private static Queue<Integer> storyLinks;
    int currentRoom = 1;

    public static String getStory(int i) throws SQLException {

        try {

            String password = "password";
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "username", password);


            Statement stmt = conn.createStatement();
            Scanner tgb = new Scanner(System.in);

            String strSelect = "select body from story where id = " + i;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                String body = rset.getString("body");
                return body;
            }

            int rowCount = 1;
            while (rset.next()) {
                String description = rset.getString("description");
                int storyLink = rset.getInt("targetId");
                storyLinks.add(storyLink);
                System.out.println(++rowCount + " " + description);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
