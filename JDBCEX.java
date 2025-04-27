
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DELL
 */
public class JDBCEX {

    public static void main(String[] args) {
        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            System.out.println("Connecting to a selected database...");

            // Establish connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE", "sys as sysdba", "root"
            );

            System.out.println("Connected database successfully...");

            Statement stmt = con.createStatement();
           //stmt.executeQuery("Select *from person");
           ResultSet rs=stmt.executeQuery("select * from person");
           // stmt.executeUpdate("update employees set email='abc@gmail.com' where employee_id=101");
           
           while(rs.next())
            {
                System.out.println(rs.getInt(1)+"  " + rs.getString(2)+rs.getDate(3));
             
         }
            // Example update query
            //stmt.executeUpdate("UPDATE person SET address='Pune' WHERE id=2");

            con.close();

        } catch (Exception e) {
            e.printStackTrace(); // Properly show the error
        }
    }
}