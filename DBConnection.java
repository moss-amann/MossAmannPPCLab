import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.io.*;

public class DBConnection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Declare strings and recieve command line arguments
        //scanner input
        System.out.println("Enter username:  ");
        String user = scanner.next();
        System.out.println("Enter password: ");
        String password = scanner.next();
        System.out.println("Enter database name: ");
        String database = scanner.next();
        String url = "jdbc:mariadb://localhost:3306/" + database;

        try {

            //Connection to MariaDB + output using DriverManager

            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection to MariaDB established Successfully!");
            
            //SQL Query to retrieve data set from each table
            String query = "Select o.order_no as orderNumber, c.customer_name as customerName, c.city as customerCity, s.name as salesmanName, o.purchase_amt as amount, (s.commission * o.purchase_amt) as commissionAmount " + 
            "from orders as o " + 
            "join customer as c on o.customer_id = c.customer_id " + 
            "join salesman as s on o.salesman_id = s.salesman_id" + ";";

            //Declare ArrayList<Sales>
            ArrayList<Sales> salesList = new ArrayList<Sales>();
            //Declare result set and connect to statement to create and excecute query string
            ResultSet rs = stmt.executeQuery(query);
            //while new row, create a new sales object and add to saleslist
            while(rs.next()) {
                Sales newObject = new Sales(rs.getInt("orderNumber"), rs.getString("customerName"), rs.getString("customerCity"), rs.getString("salesmanName"), rs.getInt("amount"), rs.getDouble("commissionAmount"));
                salesList.add(newObject);
            }

            //Loop to print arrayList for error checking
            for(Sales sale : salesList) {
                System.out.println(sale);
            }
            conn.close();
        }
        //SQL error handeling 
        catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        scanner.close();
        
    }
}

class Sales {
    int orderNumber;
    String customerName;
    String customerCity;
    String salesmanName;
    double amount;
    double commissionAmount;

    //Sales object constructor
    public Sales(int orderNumber, String customerName, String customerCity, String salesmanName, int amount, double commissionAmount) {
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.customerCity = customerCity;
        this.salesmanName = salesmanName;
        this.amount = amount;
        this.commissionAmount = commissionAmount;
    }

    //toString method for arrayList
    @Override
    public String toString() {
        return "Sales{" +
            "orderNumber=" + orderNumber +
            ", customerName='" + customerName + '\'' +
            ", customerCity='" + customerCity + '\'' +
            ", salesmanName='" + salesmanName + '\'' +
            ", amount=" + amount +
            ", commissionAmount=" + commissionAmount +
            '}';
    }
    
}
