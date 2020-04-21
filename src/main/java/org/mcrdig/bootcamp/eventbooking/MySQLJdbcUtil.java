package org.mcrdig.bootcamp.eventbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.Statement;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLJdbcUtil {

    public static void main(String[] args) throws SQLException {

        MySQLJdbcUtil mySQLJdbcUtil = new MySQLJdbcUtil();
        mySQLJdbcUtil.createUser("Julie");
    }

    public void createUser(String userName) throws SQLException {

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://db-workshop.public-dev.zuto.cloud:3306/bootcamp3?user=bootcamp3&password=TelephoneWeek"))
        {
            conn.setAutoCommit(false);

            String query = "insert into user(name) value(?);";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, userName);
            statement.execute();
            conn.commit();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}
