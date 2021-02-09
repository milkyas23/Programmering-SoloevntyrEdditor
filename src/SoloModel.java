import java.sql.*;
import java.util.Scanner;

public class SoloModel {
    public static String getStory(int i) throws SQLException {

        try {

            String password = "password";
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/te18? " +
                            "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                    "username", password);


            Statement stmt = conn.createStatement();
            Scanner tgb = new Scanner(System.in);
            int currentRoom = 1;
            String strSelect = "select body from story where id = " + currentRoom;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                String body = rset.getString("body");
                return body;
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }


        return null;
    }
}
