
package Clases;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class conexion {
    public static Connection conectar() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bd_ds","root","");
            return con;
        }
        catch (SQLException e)  {System.out.println("Error de conexion" + e);
        }
        return (null);
    }
    
    
    
}
