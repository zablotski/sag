package info.zablotski.sag.eight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        userService = new UserService();

        Map<String, Object> userMap = userService.getUserByUsername(s);
        if (userMap == null) {
            throw new UsernameNotFoundException("User details not found with this username: " + s);
        }

        String username = (String) userMap.get("username");
        String password = (String) userMap.get("password");
        String role = (String) userMap.get("role");

        List authList = getAuthorities(role);

        User user = new User(username, password, authList);

        return user;
    }

    private List getAuthorities(String role) {
        List authList = new ArrayList();
        return authList;
    }
}
