package ma.projet.model;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "StatutContrats")
public enum StatutContrat {
    ACTIF, INACTIF, SUSPENDU
}
