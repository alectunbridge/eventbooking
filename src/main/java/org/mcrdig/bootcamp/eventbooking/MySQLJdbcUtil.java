package org.mcrdig.bootcamp.eventbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySQLJdbcUtil {

    public static void main(String[] args) throws SQLException {

        MySQLJdbcUtil mySQLJdbcUtil = new MySQLJdbcUtil();
        // mySQLJdbcUtil.createUser("Julie");
        System.out.println( mySQLJdbcUtil.getUsers());
        System.out.println(mySQLJdbcUtil.getUser(1));
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

    public List<User> getUsers() throws SQLException {

        List<User> users = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://db-workshop.public-dev.zuto.cloud:3306/bootcamp3?user=bootcamp3&password=TelephoneWeek"))
        {
            conn.setAutoCommit(false);

            String query = "select * from user ";
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                User user = new User(resultSet.getInt("id"), resultSet.getString("name"));
                users.add(user);
            }

            conn.commit();



        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        return users;
    }

    public User getUser(int id) throws SQLException {

        User user = null;
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://db-workshop.public-dev.zuto.cloud:3306/bootcamp3?user=bootcamp3&password=TelephoneWeek"))
        {
            conn.setAutoCommit(false);

            String query = "select * from user where id=?;";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"), resultSet.getString("name"));
            }
            conn.commit();
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        return user;
    }
}
