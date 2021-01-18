package application.Entities;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Firma")
public class Firma {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "pers", nullable = false) //persoana de contact
    private String pers;
    @NotNull
    @Column(name = "adresa", nullable = false)
    private String adresa;
    @NotNull
    @Column(name = "telefon")
    private String tel;
    @NotNull
    @Column(name = "fax")
    private String fax;
    @NotNull
    @Column(name = "cod_fiscal")
    private String cod;
    @NotNull
    @Column(name = "banca")
    private String banca;
    @NotNull
    @Column(name = "iban")
    private String iban;
    @NotNull
    @Column(name = "reprezentant") //reprezentant legal
    private String rep;
    @NotNull
    @Column(name = "email", nullable = false)
    private String email;
    @NotNull
    @Column(name = "pass", nullable = false)
    private String pass;

    @OneToMany//(optional = false)
    @JoinColumn(name = "id_firma", referencedColumnName = "id")
    private List<Student> studenti;

    @OneToMany//(optional = false)
    @JoinColumn(name = "id_firma", referencedColumnName = "id")
    private List<Tutore> tutori;

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getPers() { return pers; }

    public void setPers(String pers) { this.pers = pers; }

    public String getAdresa() { return adresa; }

    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getTel() { return tel; }

    public void setTel(String tel) { this.tel = tel; }

    public String getFax() { return fax; }

    public void setFax(String fax) { this.fax = fax; }

    public String getCod() { return cod; }

    public void setCod(String cod) { this.cod = cod; }

    public String getBanca() { return banca; }

    public void setBanca(String banca) { this.banca = banca; }

    public String getIban() { return iban; }

    public void setIban(String iban) { this.iban = iban; }

    public String getRep() { return rep; }

    public void setRep(String rep) { this.rep = rep; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPass() { return pass; }

    public void setPass(String pass) { this.pass = pass; }
}
