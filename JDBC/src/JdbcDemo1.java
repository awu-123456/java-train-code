import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo1 {
    public static void main(String[] args) throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java117?characterEncoding=utf8&useSSl=false");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("045511");

        Connection connection = dataSource.getConnection();

        String sql = "create table student(id int,name varchar(40))";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int n = preparedStatement.executeUpdate();
        System.out.println("n = " + n);
    }
}
