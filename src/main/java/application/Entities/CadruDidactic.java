package application.Entities;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "CadruDidactic")
public class CadruDidactic {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "functie", nullable = false)
    private String functie;
    @NotNull
    @Column(name = "tel", nullable = false)
    private String tel;

    @Column(name = "fax", nullable = false)
    private String fax;
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "pass", nullable = false)
    private String pass;

    public CadruDidactic(int id, String name, String functie, String tel, String fax, String email, String pass) {
        this.id = id;
        this.name = name;
        this.functie = functie;
        this.tel = tel;
        this.fax = fax;
        this.email = email;
        this.pass = pass;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getFunctie() { return functie; }
    public void setFunctie(String functie) { this.functie = functie; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getFax() { return fax; }
    public void setFax(String fax) { this.fax = fax; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public CadruDidactic() { super(); }

    @Override
    public int hashCode() { return super.hashCode(); }
    @Override
    public boolean equals(Object obj) { return super.equals(obj); }
    @Override
    protected Object clone() throws CloneNotSupportedException { return super.clone(); }
    @Override
    public String toString() { return super.toString(); }
}
