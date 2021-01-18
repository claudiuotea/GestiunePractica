package application.Entities;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Facultate")
public class Facultate {
    @Id@GeneratedValue
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    @NotNull
    @Column(name = "resp_pm", nullable = false) //responsabil protectia muncii
    private String resp_pm;
    @NotNull
    @Column(name = "resp_pr", nullable = false) //responsabil practica
    private String resp_pr;
    @NotNull
    @Column(name = "decan")
    private String decan;

    @OneToMany//(optional = false)
    @JoinColumn(name = "id_sectie", referencedColumnName = "id")
    private List<Sectie> sectii;

    public Facultate(int id, String name, String resp_pm, String resp_pr, String decan) {
        this.id = id;
        this.name = name;
        this.resp_pm = resp_pm;
        this.resp_pr = resp_pr;
        this.decan = decan;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getResp_pm() { return resp_pm; }
    public String getResp_pr() { return resp_pr; }
    public String getDecan() { return decan; }

    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setResp_pm(String resp_pm) { this.resp_pm = resp_pm; }
    public void setResp_pr(String resp_pr) { this.resp_pr = resp_pr; }
    public void setDecan(String decan) { this.decan = decan; }

    public Facultate() { super(); }

    @Override
    public int hashCode() { return super.hashCode(); }
    @Override
    public boolean equals(Object obj) { return super.equals(obj); }
    @Override
    protected Object clone() throws CloneNotSupportedException { return super.clone(); }
    @Override
    public String toString() { return super.toString(); }

}
