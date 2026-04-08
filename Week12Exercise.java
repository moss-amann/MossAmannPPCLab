import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;

public class Week12Exercise {
    public static void main(String [] args){
        String url = "jdbc:mariadb://localhost:3306/labwork";
        String user = "moss2am";
        String password = "lucysslippers23";
    

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection to MariaDB established successfully");

            ArrayList<SalesPerson> salesPersonList = new ArrayList<SalesPerson>();

            String query = "select s.name, s.city, s.commission, sum(o.purchase_amt) as totalSales " 
            + "from salesman s join orders o on s.salesman_id = o.salesman_id " 
            + "group by s.name;";
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()) {
                SalesPerson newObject = new SalesPerson(rs.getString("name"), 
                rs.getString("city"), rs.getDouble("commission"),
                rs.getDouble("totalSales"));
                salesPersonList.add(newObject);
            }

            //error checking
            /*for(SalesPerson salesPerson : salesPersonList) {
                System.out.println(salesPerson);
            }*/

            //Question 1
            Map<String, Double> nameAndEarnings = salesPersonList.stream()
                .collect(Collectors.groupingBy(SalesPerson::getName,
                Collectors.summingDouble(SalesPerson::getEarnings)
                ));

            System.out.printf("%-20s %10s\n", "Name", "Total Earnings");
            System.out.println("----------------------------------------");

            nameAndEarnings.forEach((name, earnings) -> System.out.printf("%-20s %10.2f\n", name, earnings));
            
            //Question 2
            Map<String, Double> nameAndCommission = salesPersonList.stream().collect(Collectors.groupingBy(SalesPerson::getName, Collectors.summingDouble(e -> e.getEarnings() * e.getCommission())));
            
            System.out.printf("%-20s %10s\n", "Name", "Total Commission");
            System.out.println("----------------------------------------");

            nameAndCommission.forEach((name, commission) -> System.out.printf("%-20s %10.2f\n", name, commission));
        }
        catch (SQLException e) {
            System.out.println("Database connection failed");
            e.printStackTrace();
        }
        //conn.close();
    }

}

class SalesPerson {
    String name;
    String city;
    double commission;
    double totalSales;

    public SalesPerson(String name, String city, double commission, double totalSales){
        this.name = name;
        this.city = city;
        this.commission = commission;
        this.totalSales = totalSales;
    }

    @Override
    public String toString(){
        return "Sales Person name: " + name 
        + ", City: " + city 
        + "Commission: " + commission 
        + ", Total Sales: " + totalSales 
        + ". ";
    }

    public String getName() {
        return name;
    }
    public Double getEarnings(){
        return totalSales;
    }
    public Double getCommission(){
        return commission;
    }

}