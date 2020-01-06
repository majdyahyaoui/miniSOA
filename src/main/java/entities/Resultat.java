package entities;

import javax.persistence.*;

@Entity
@Table(name = "resultat", schema = "miniprojetsoa", catalog = "")
public class Resultat {
    private String anneeScolaire;
    private String resultat;
    private int idRes;
    private int cin;
    private int etuCin;
    private Admin adminByCin;
    private Etudiant etudiantByEtuCin;

    @Basic
    @Column(name = "annee_scolaire")
    public String getAnneeScolaire() {
        return anneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        this.anneeScolaire = anneeScolaire;
    }

    @Basic
    @Column(name = "resultat")
    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }

    @Id
    @Column(name = "id_res")
    public int getIdRes() {
        return idRes;
    }

    public void setIdRes(int idRes) {
        this.idRes = idRes;
    }

    @Basic
    @Column(name = "cin")
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "Etu_cin")
    public int getEtuCin() {
        return etuCin;
    }

    public void setEtuCin(int etuCin) {
        this.etuCin = etuCin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resultat that = (Resultat) o;

        if (idRes != that.idRes) return false;
        if (cin != that.cin) return false;
        if (etuCin != that.etuCin) return false;
        if (anneeScolaire != null ? !anneeScolaire.equals(that.anneeScolaire) : that.anneeScolaire != null)
            return false;
        if (resultat != null ? !resultat.equals(that.resultat) : that.resultat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = anneeScolaire != null ? anneeScolaire.hashCode() : 0;
        result = 31 * result + (resultat != null ? resultat.hashCode() : 0);
        result = 31 * result + idRes;
        result = 31 * result + cin;
        result = 31 * result + etuCin;
        return result;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "cin", referencedColumnName = "cin")
    public Admin getAdminByCin() {
        return adminByCin;
    }

    public void setAdminByCin(Admin adminByCin) {
        this.adminByCin = adminByCin;
    }

    @ManyToOne
    @PrimaryKeyJoinColumn(name = "Etu_cin", referencedColumnName = "cin")
    public Etudiant getEtudiantByEtuCin() {
        return etudiantByEtuCin;
    }

    public void setEtudiantByEtuCin(Etudiant etudiantByEtuCin) {
        this.etudiantByEtuCin = etudiantByEtuCin;
    }
}
