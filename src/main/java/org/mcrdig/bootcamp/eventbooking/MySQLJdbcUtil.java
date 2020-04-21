package org.mcrdig.bootcamp.eventbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLJdbcUtil {

    public static void main(String[] args) throws SQLException {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://db-workshop.public-dev.zuto.cloud:3306?user=bootcamp3&password=TelephoneWeek");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally {
            conn.close();
        }
    }
}
