package application.Entities;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Tutore")
public class Tutore {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "pass", nullable = false)
    private String pass;
    @NotNull
    @Column(name = "functie", nullable = false)
    private String functie;
    @NotNull
    @Column(name = "tel", nullable = false)
    private String tel;

    @Column(name = "fax", nullable = false)
    private String fax;
}
