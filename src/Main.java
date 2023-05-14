import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3307/test";
        Connection conn= DriverManager.getConnection(url,"","");
        System.out.println("Connect hogaya!");

//        Statement statement=conn.createStatement();
//        ResultSet resultset=statement.executeQuery("SELECT * from mytable");
        //prepared statement
        PreparedStatement preparedStatement=conn.prepareStatement("SELECT * from mytable where id=? OR address=?");
        preparedStatement.setInt(1,1);
        preparedStatement.setString(2,"baluwatar");
        ResultSet resultset=preparedStatement.executeQuery();

//                statement.executeUpdate("INSERT INTO `mytable`(`name`, `address`) VALUES ('rohan','jhapa') ");
//                statement.executeUpdate("UPDATE `mytable` SET `name`='ram',`address`='baluwatar' WHERE id=1");
//                statement.executeUpdate("DELETE FROM `mytable` WHERE id=2");
        System.out.println(resultset);
        while(resultset.next()){
            System.out.print(resultset.getString("name"));
            System.out.print(" ");
            System.out.print(resultset.getString("address"));
            System.out.println("\n");
        }
    }
}