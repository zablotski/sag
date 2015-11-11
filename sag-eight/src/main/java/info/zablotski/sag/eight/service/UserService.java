package info.zablotski.sag.eight.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserService {

    static HashMap<String, String> users = new HashMap<String, String>();
    {
        users.put("user1", "password1");
        users.put("user2", "password2");
        users.put("user3", "password3");
        users.put("user4", "password4");
        users.put("user5", "password5");
        users.put("user6", "password6");
        users.put("user7", "password7");
        users.put("user8", "password8");
        users.put("user9", "password9");
    }

    public Map<String, Object> getUserByUsername(String username) {

        if (users.get(username) != null){

            //logic here to get your user from the database
            Map<String, Object> userMap = new HashMap<String, Object>();
            userMap.put("username", username);
            userMap.put("password", users.get(username));
            userMap.put("role", "admin" );
            return userMap;
        }
        return null;
    }
}