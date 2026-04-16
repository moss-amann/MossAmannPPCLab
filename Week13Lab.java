import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
import java.util.function.Function;
import java.util.stream.*;
import java.util.function.*;

public class Week13Lab {
    public static void main(String [] args) {
        String url = "jdbc:mariadb://localhost:3306/employee";
        String user = "moss2am";
        String password = "lucysslippers23";

        try {
            //1. 
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();
            System.out.println("Connection to MariaDB established successfully");
            
            List<Employee> employeeList = new ArrayList<Employee>();

            String query = "Select id, name, salary" + " from employees;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                Employee newEmployee = new Employee(rs.getInt("id"), rs.getString("name"), rs.getDouble("salary"));
                employeeList.add(newEmployee);
            }

            //Error handeling
            /*for(Employee e : employeeList) {
                System.out.println(e);
            }*/

            //2. 
            //List<Employee> employeelist2 = employeeList.stream().collect(Collectors.toList());
            List<String> employeeNameList = employeeList.stream().map(e -> e.getName()).collect(Collectors.toList());
            System.out.println("High Earners List");
            employeeNameList.forEach(name -> System.out.printf("%-20s \n", name));

            //3.
            Predicate<Employee> salPredicate = e -> e.getSalary() > 50000;
            List<Employee> highEarners = employeeList.stream().filter(salPredicate).collect(Collectors.toList());
            //4. 
            highEarners.forEach(e -> System.out.printf("%3d %12s %10.2f\n", e.getId(), e.getName(), e.getSalary()));

            //5. 
            //Function<Employee, Employee> applyTax = e.getSalary() -> (e.getSalary() * (1-0.15));
            Function<Employee, Employee> applyTax = e -> new Employee(e.getId(), e.getName(), e.getSalary()*0.75);
                //testing 
                //System.out.println(applyTax.apply(highEarners.get(0)));

            //6.    
            Function<Employee, String> formatSalary = e -> String.format("$%-10.2f", e.getSalary());
                //testing
                Employee emp6test = employeeList.get(0);
                System.out.println(formatSalary.apply(emp6test));

            //7.
            List<Employee> highEarnUpdate = employeeList.stream().filter(salPredicate).map(applyTax).collect(Collectors.toList());
            System.out.println("High Earners Updated Salary");
            highEarnUpdate.forEach(e -> System.out.printf("%3d %10s %10s\n", e.getId(), e.getName(), formatSalary.apply(e)));

        }   
        catch(SQLException e ) {
            System.out.println("error");
            e.printStackTrace();
        }
    }
}

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString(){
        return String.format("Employee{id=%d, name = %s, salary= %2f}%n", id, name, salary);
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getSalary(){
        return salary;
    }
}