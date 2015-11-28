package info.zablotski.sag.nine.service;

import info.zablotski.sag.nine.dao.UserDAO;
import info.zablotski.sag.nine.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
@Transactional
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    public Map<String, Object> getUserByUsername(String username) {
        User user = userDAO.getUserByUsername(username);
        if (user != null){
            Map<String, Object> userMap = new HashMap<String, Object>();
            userMap.put("username", user.getUsername());
            userMap.put("password", user.getPassword());
            userMap.put("role", "admin" );
             return userMap;
        }
        return null;
    }
}