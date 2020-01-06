package entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "personne", schema = "miniprojetsoa", catalog = "")
public class Personne {
    private int cin;
    private String nom;
    private String prenom;
    private String email;
    private String tel;
    private Collection<Absence> absencesByCin;
    private Admin adminByCin;
    private Enseignant enseignantByCin;
    private Etudiant etudiantByCin;

    @Id
    @Column(name = "cin")
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "tel")
    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne that = (Personne) o;

        if (cin != that.cin) return false;
        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (tel != null ? !tel.equals(that.tel) : that.tel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cin;
        result = 31 * result + (nom != null ? nom.hashCode() : 0);
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (tel != null ? tel.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "personneByCin")
    public Collection<Absence> getAbsencesByCin() {
        return absencesByCin;
    }

    public void setAbsencesByCin(Collection<Absence> absencesByCin) {
        this.absencesByCin = absencesByCin;
    }

    @OneToOne(mappedBy = "personneByCin")
    public Admin getAdminByCin() {
        return adminByCin;
    }

    public void setAdminByCin(Admin adminByCin) {
        this.adminByCin = adminByCin;
    }

    @OneToOne(mappedBy = "personneByCin")
    public Enseignant getEnseignantByCin() {
        return enseignantByCin;
    }

    public void setEnseignantByCin(Enseignant enseignantByCin) {
        this.enseignantByCin = enseignantByCin;
    }

    @OneToOne(mappedBy = "personneByCin")
    public Etudiant getEtudiantByCin() {
        return etudiantByCin;
    }

    public void setEtudiantByCin(Etudiant etudiantByCin) {
        this.etudiantByCin = etudiantByCin;
    }
}
