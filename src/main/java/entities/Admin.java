package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "admin", schema = "miniprojetsoa", catalog = "")
public class Admin {
    private int cin;
    private String dept;
    private Personne personneByCin;
    private Collection<Resultat> resultatsByCin;

    @Id
    @Column(name = "cin")
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "dept")
    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Admin that = (Admin) o;

        if (cin != that.cin) return false;
        if (dept != null ? !dept.equals(that.dept) : that.dept != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cin;
        result = 31 * result + (dept != null ? dept.hashCode() : 0);
        return result;
    }

    @OneToOne
    @PrimaryKeyJoinColumn(name = "cin", referencedColumnName = "cin")
    public Personne getPersonneByCin() {
        return personneByCin;
    }

    public void setPersonneByCin(Personne personneByCin) {
        this.personneByCin = personneByCin;
    }

    @OneToMany(mappedBy = "adminByCin")
    public Collection<Resultat> getResultatsByCin() {
        return resultatsByCin;
    }

    public void setResultatsByCin(Collection<Resultat> resultatsByCin) {
        this.resultatsByCin = resultatsByCin;
    }
}
