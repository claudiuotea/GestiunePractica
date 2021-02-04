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

    @NotNull
    @Column(name = "grupa", nullable = false)
    private String grupa;

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

    public String getDataNastere()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.CNP.substring(5, 7));
        sb.append(".");
        sb.append(this.CNP.substring(3, 5));
        sb.append(".");
        if(this.CNP.charAt(0) == 6 || this.CNP.charAt(0) == 5)
        {
            sb.append("20");
            sb.append(this.CNP.substring(1, 3));
        }
        if(this.CNP.charAt(0) == 2 || this.CNP.charAt(0) == 1)
        {
            sb.append("19");
            sb.append(this.CNP.substring(1, 3));
        }
        return sb.toString();
    }

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

    public String getGrupa() { return grupa;}
    public void setGrupa(String grupa) { this.grupa = grupa; }

    public String getAnStudiu()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.grupa.charAt(1));
        return sb.toString();
    }

    public Firma getFirma() {
        return firma;
    }

    public void setFirma(Firma firma) {
        this.firma = firma;
    }

    public Sectie getSectie() {
        return sectie;
    }

    public void setSectie(Sectie sectie) {
        this.sectie = sectie;
    }
}
