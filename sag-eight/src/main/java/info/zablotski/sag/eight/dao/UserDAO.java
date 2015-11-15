package info.zablotski.sag.eight.dao;

import info.zablotski.sag.eight.model.User;

import javax.sql.DataSource;
import java.util.List;

public interface UserDAO
{
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    public void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    public void create(String username, String password);
    /**
     * This is the method to be used to list down
     * a record from the Student table corresponding
     * to a passed student id.
     */
    public User getUser(Integer id);
    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    public List<User> listUsers();

}
