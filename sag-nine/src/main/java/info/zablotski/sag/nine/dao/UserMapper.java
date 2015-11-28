package info.zablotski.sag.nine.dao;

import info.zablotski.sag.nine.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
        return user;
    }
}