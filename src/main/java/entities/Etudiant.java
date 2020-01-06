package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "etudiant", schema = "miniprojetsoa", catalog = "")
public class Etudiant {
    private int cin;
    private Integer nce;
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
    @Column(name = "nce")
    public Integer getNce() {
        return nce;
    }

    public void setNce(Integer nce) {
        this.nce = nce;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Etudiant that = (Etudiant) o;

        if (cin != that.cin) return false;
        if (nce != null ? !nce.equals(that.nce) : that.nce != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cin;
        result = 31 * result + (nce != null ? nce.hashCode() : 0);
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

    @OneToMany(mappedBy = "etudiantByEtuCin")
    public Collection<Resultat> getResultatsByCin() {
        return resultatsByCin;
    }

    public void setResultatsByCin(Collection<Resultat> resultatsByCin) {
        this.resultatsByCin = resultatsByCin;
    }
}
