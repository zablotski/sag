package info.zablotski.sag.nine.dao.impl;

import info.zablotski.sag.nine.dao.UserDAO;
import info.zablotski.sag.nine.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }


    public List<User> listUsers() {

        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = sessionFactory.getCurrentSession().createQuery("from User user where user.username = :username");
        query.setParameter("username", username);
        return (User) query.uniqueResult();
    }


//    public User getUserByUsername(String username) {
//        jdbcTemplateObject = new JdbcTemplate(dataSource);
//
//        String SQL = "select * from user where username = ?";
//        User User = jdbcTemplateObject.queryForObject(SQL,  new Object[]{username}, new UserMapper());
//        return User;
//    }




}