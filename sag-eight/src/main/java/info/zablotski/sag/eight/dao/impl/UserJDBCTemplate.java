package info.zablotski.sag.eight.dao.impl;

import info.zablotski.sag.eight.dao.UserDAO;
import info.zablotski.sag.eight.dao.UserMapper;
import info.zablotski.sag.eight.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class UserJDBCTemplate implements UserDAO {
    @Autowired
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplateObject;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    public void create(String username, String password) {
        String SQL = "insert into user (username, age) values (?, ?)";

        jdbcTemplateObject.update( SQL, username, password);
        System.out.println("Created Record username = " + username);
        return;
    }

    public User getUser(Integer id) {
        String SQL = "select * from user where id = ?";
        User User = jdbcTemplateObject.queryForObject(SQL,
                new Object[]{id}, new UserMapper());
        return User;
    }

    public User getUserByUsername(String username) {
        jdbcTemplateObject = new JdbcTemplate(dataSource);

        String SQL = "select * from user where username = ?";
        User User = jdbcTemplateObject.queryForObject(SQL,  new Object[]{username}, new UserMapper());
        return User;
    }

    @Override
    public List<User> listUsers() {
        String SQL = "select * from user";
        List <User> Users = jdbcTemplateObject.query(SQL,
                new UserMapper());
        return Users;
    }

    public void delete(Integer id){
        String SQL = "delete from user where id = ?";
        jdbcTemplateObject.update(SQL, id);
        System.out.println("Deleted Record with ID = " + id );
        return;
    }

}