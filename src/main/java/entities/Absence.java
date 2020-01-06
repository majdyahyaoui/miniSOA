package entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "absence", schema = "miniprojetsoa", catalog = "")
public class Absence {
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private int idAbs;
    private int cin;
    private Personne personneByCin;

    @Basic
    @Column(name = "date_debut")
    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    @Basic
    @Column(name = "date_fin")
    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    @Id
    @Column(name = "id_abs")
    public int getIdAbs() {
        return idAbs;
    }

    public void setIdAbs(int idAbs) {
        this.idAbs = idAbs;
    }

    @Basic
    @Column(name = "cin")
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Absence that = (Absence) o;

        if (idAbs != that.idAbs) return false;
        if (cin != that.cin) return false;
        if (dateDebut != null ? !dateDebut.equals(that.dateDebut) : that.dateDebut != null) return false;
        if (dateFin != null ? !dateFin.equals(that.dateFin) : that.dateFin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dateDebut != null ? dateDebut.hashCode() : 0;
        result = 31 * result + (dateFin != null ? dateFin.hashCode() : 0);
        result = 31 * result + idAbs;
        result = 31 * result + cin;
        return result;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "cin", referencedColumnName = "cin")
    public Personne getPersonneByCin() {
        return personneByCin;
    }

    public void setPersonneByCin(Personne personneByCin) {
        this.personneByCin = personneByCin;
    }
}
