package info.zablotski.sag.eight.service;

import info.zablotski.sag.eight.dao.impl.UserJDBCTemplate;
import info.zablotski.sag.eight.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserService {

    @Autowired
    UserJDBCTemplate userJDBCTemplate;

    public Map<String, Object> getUserByUsername(String username) {
        Object o = userJDBCTemplate;

        User user = userJDBCTemplate.getUserByUsername(username);
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