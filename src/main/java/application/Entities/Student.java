package application.Entities;
import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name="user",nullable = false)
    private String user;
    @NotNull
    @Column(name="pass",nullable = false)
    private String pass;
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "CNP", nullable = false)
    private String CNP;
    @NotNull
    @Column(name = "CI", nullable = false)
    private String CI;
    @NotNull
    @Column(name = "cetatenie", nullable = false)
    private String cetatenie;
    @NotNull
    @Column(name = "domiciliu", nullable = false)
    private String domiciliu;
    @NotNull
    @Column(name = "tel", nullable = false)
    private String tel;
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "oras_n", nullable = false) //oras natal
    private String oras_n;
    @NotNull
    @Column(name = "linie", nullable = false) //linia de studiu
    private String linie;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_firma",referencedColumnName = "id")
    private Firma firma;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sectie",referencedColumnName = "id")
    private Sectie sectie;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUser() { return user; }
    public void setUser(String user) { this.user = user; }

    public String getPass() { return pass; }
    public void setPass(String pass) { this.pass = pass; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCNP() { return CNP; }
    public void setCNP(String CNP) { this.CNP = CNP; }

    public String getCI() { return CI; }
    public void setCI(String CI) { this.CI = CI; }

    public String getCetatenie() { return cetatenie; }
    public void setCetatenie(String cetatenie) { this.cetatenie = cetatenie; }

    public String getDomiciliu() { return domiciliu; }
    public void setDomiciliu(String domiciliu) { this.domiciliu = domiciliu; }

    public String getTel() { return tel; }
    public void setTel(String tel) { this.tel = tel; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getOras_n() { return oras_n; }
    public void setOras_n(String oras_n) { this.oras_n = oras_n; }

    public String getLinie() { return linie; }
    public void setLinie(String linie) { this.linie = linie; }
}
