package application.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "USER")
public class User {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name="username",nullable = false)
    private String username;
    @NotNull
    @Column(name="password",nullable = false)
    private String password;
    @NotNull
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="verified")
    private boolean verified;

    public User() {
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
