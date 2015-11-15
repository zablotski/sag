package info.zablotski.sag.eight.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class User implements UserDetails{

    private String username;
    private String password;
    private int id;

    public User(){}

    public User(int id, String userName, String password){
        this.id = id;
        this.username = userName;
        this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "userName=" + username + ", password=" + password + '}';
    }

    public int getUserId() {
        return id;
    }

    public void setId(int userId) {
        this.id = userId;
    }
}