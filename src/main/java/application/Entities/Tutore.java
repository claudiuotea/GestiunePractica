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

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_firma",referencedColumnName = "id")
    private Firma firma;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }
}
