import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayCountries{
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/nation";
        String user = "moss2am";
        String password = "lucysslippers23";
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection to MariaDB established Successfully!");
            System.out.println("Nations Database");
            System.out.println("--------------");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a lanaguage:\n");
            String userLanguage = input.nextLine();
            System.out.println("Language to query is: " + userLanguage + "\n");
            //String query = "Select c.name as Countries, l.language as Language " + "from countries as c join country_languages as cl on c.country_id = cl.country_id join languages as l on cl.language_id = l.language_id where Language=‘English’";
            String query = "SELECT c.name AS Countries, l.language AS Language " +
               "FROM countries AS c " +
               "JOIN country_languages AS cl ON c.country_id = cl.country_id " +
               "JOIN languages AS l ON cl.language_id = l.language_id " +
               "WHERE l.language = " + "'" + userLanguage + "';";

            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                //System.out.println(rs.getString("Database"));
                System.out.println(rs.getString("Countries") + "-->" + rs.getString("Language") + "\n");
            }
        }
        catch (SQLException e){
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
    }
}


