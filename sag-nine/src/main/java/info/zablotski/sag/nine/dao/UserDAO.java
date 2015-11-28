package info.zablotski.sag.nine.dao;

import info.zablotski.sag.nine.model.User;

import java.util.List;

public interface UserDAO
{
    /**
     * This is the method to be used to list down
     * all the records from the Student table.
     */
    public List<User> listUsers();
    public User getUserByUsername(String username);

}
