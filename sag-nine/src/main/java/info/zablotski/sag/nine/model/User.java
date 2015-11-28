package info.zablotski.sag.nine.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="user")
public class User implements UserDetails{

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @Column(name="username")
    private String username;

    @Column(name = "password")
    private String password;

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