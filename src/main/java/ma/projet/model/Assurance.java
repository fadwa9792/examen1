package ma.projet.model;

import ma.projet.model.*;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Assurances")
public class Assurance {
    @Id
    @GeneratedValue
    private long id;
    private String type;
    private double montant;
    private String couverture;
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Contrat> contrats;

    public Assurance() {
    }

    public Assurance(long id, String type, double montant, String couverture, List<Contrat> contrats) {
        this.id = id;
        this.type = type;
        this.montant = montant;
        this.couverture = couverture;
        this.contrats = contrats;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public String getCouverture() {
        return couverture;
    }

    public void setCouverture(String couverture) {
        this.couverture = couverture;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrats) {
        this.contrats = contrats;
    }
}