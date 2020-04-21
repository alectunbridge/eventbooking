package org.mcrdig.bootcamp.eventbooking;

import java.sql.SQLException;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/users")
    public List<User> getUsers() throws SQLException {
        MySQLJdbcUtil mySQLJdbcUtil = new MySQLJdbcUtil();
        List<User> users = mySQLJdbcUtil.getUsers();
        return users;
    }
}
