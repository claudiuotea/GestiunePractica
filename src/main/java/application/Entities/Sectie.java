package application.Entities;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Sectie")
public class Sectie {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "secretara", nullable = false)
    private String secretara;

    @OneToMany//(optional = false)
    @JoinColumn(name = "id_sectie", referencedColumnName = "id")
    private List<Student> studenti;

    @ManyToOne(optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_sectie", referencedColumnName = "id")
    private Facultate facultate;

    @OneToOne(mappedBy = "sectie")
    private CadruDidactic cadruDidactic;

    public int getId() { return id; }
    public String getName() { return name; }
    public String getResp_pm() { return secretara; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setResp_pm(String resp_pm) { this.secretara = resp_pm; }

    public Sectie() { super(); }

    @Override
    public int hashCode() { return super.hashCode(); }
    @Override
    public boolean equals(Object obj) { return super.equals(obj); }
    @Override
    protected Object clone() throws CloneNotSupportedException { return super.clone(); }
    @Override
    public String toString() { return super.toString(); }

    public String getSecretara() {
        return secretara;
    }

    public void setSecretara(String secretara) {
        this.secretara = secretara;
    }

    public List<Student> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Student> studenti) {
        this.studenti = studenti;
    }

    public Facultate getFacultate() {
        return facultate;
    }

    public void setFacultate(Facultate facultate) {
        this.facultate = facultate;
    }

    public CadruDidactic getCadruDidactic() {
        return cadruDidactic;
    }

    public void setCadruDidactic(CadruDidactic cadruDidactic) {
        this.cadruDidactic = cadruDidactic;
    }

    public Sectie(int id, String name, String secretara, List<Student> studenti, Facultate facultate, CadruDidactic cadruDidactic) {
        this.id = id;
        this.name = name;
        this.secretara = secretara;
        this.studenti = studenti;
        this.facultate = facultate;
        this.cadruDidactic = cadruDidactic;
    }
}
