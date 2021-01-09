package application.Entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue
    private Long idUser;

    @NotNull//(message = "Username cannot be empty";)
    @Column(nullable = false)
    //@Pattern(regexp = ".+@stud.ubbcluj.ro", message = "Invalid email")
    private String username;
    @Column(nullable = false)
    @NotNull//(message = "Email cannot be empty";)
    @Pattern(regexp = ".+@.+")//, message = "Invalid email")
    private String email;
    @Column(nullable = false)
    @NotNull
    private String password;

    //poate mai usor daca bagam si

    //@Column(nullable = false)
    //@NotNull
    //@Pattern(regexp = "[1-8]\d{12}", message = "Invalid CNP")
    //private long CNP;
    //@.. private String serieBuletin;
    //@.. private long numarBuletin;
    //@.. private String cetatenie;
    //@.. private Adress(putem face clasa Andress cu mai multe stringuri) address;
    //@.. private long telephone;
    //@.. private String faculty;

    //role it's used to decide where the user can navigate (which paths)
    @Column(nullable = false)
    private String role;

    public User() {
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
