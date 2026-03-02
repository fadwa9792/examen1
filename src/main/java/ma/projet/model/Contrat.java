package ma.projet.model;

import javax.persistence.*;
import java.util.List;
import javax.persistence.Entity;
@Entity
@Table(name = "Contrats")

@NamedQuery(
        name = "Contrat.prixSuperieur100",
        query = "from Contrat p where p.prix > 100"
)
public class Contrat {
    @Id
    @GeneratedValue
    private int id;
    private String reference;
    private float prix;

    @ManyToOne
    @JoinColumn
    private Contrat contrat;

    public Contrat() {
    }

    public Contrat(int id, String reference, float prix, Contrat contrat) {
        this.id = id;
        this.reference = reference;
        this.prix = prix;
        this.contrat = contrat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public void add(Client byId) {
    }
}
