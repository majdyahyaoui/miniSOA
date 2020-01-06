package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "enseignant", schema = "miniprojetsoa", catalog = "")
public class Enseignant {
    private int cin;
    private Timestamp dateEmbauche;
    private Personne personneByCin;

    @Id
    @Column(name = "cin")
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "date_embauche")
    public Timestamp getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(Timestamp dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Enseignant that = (Enseignant) o;

        if (cin != that.cin) return false;
        if (dateEmbauche != null ? !dateEmbauche.equals(that.dateEmbauche) : that.dateEmbauche != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cin;
        result = 31 * result + (dateEmbauche != null ? dateEmbauche.hashCode() : 0);
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
}
