package fr.INFO921;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author francoiscaillet
 */
@Entity
@Table(name = "Colis")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colis.FIND_ALL_COLIS", query = "SELECT c FROM Colis c"),
    @NamedQuery(name = "Colis.findById", query = "SELECT c FROM Colis c WHERE c.id = :id"),
    @NamedQuery(name = "Colis.findByPoids", query = "SELECT c FROM Colis c WHERE c.poids = :poids"),
    @NamedQuery(name = "Colis.findByValeur", query = "SELECT c FROM Colis c WHERE c.valeur = :valeur"),
    @NamedQuery(name = "Colis.findByOrigine", query = "SELECT c FROM Colis c WHERE c.origine = :origine"),
    @NamedQuery(name = "Colis.findByDestination", query = "SELECT c FROM Colis c WHERE c.destination = :destination"),
    @NamedQuery(name = "Colis.findByEtatCourant", query = "SELECT c FROM Colis c WHERE c.etatCourant = :etatCourant")})
public class Colis implements Serializable {
    
    public static final String FIND_ALL_COLIS = "Colis.FIND_ALL_COLIS";

    public static final String findByEtatCourant = "findByEtatCourant";
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
   
    @Column(name = "poids")
    private Float poids;
    
    @Column(name = "valeur")
    private Integer valeur;

    @Column(name = "origine")
    private String origine;

    @Column(name = "destination")
    private String destination;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "etat_courant")
    private Etat etatCourant;
    
    @Column(name = "date_enregistrement")
    private Date date_enregistrement;


    @OneToMany(mappedBy="colis")
    private Collection<Position> positions;

    public Colis() {
    }

    Colis(float poids, int valeur, String origine, String destination) {
        this.poids = poids;
        this.valeur = valeur;
        this.origine = origine;
        this.destination = destination;
        this.date_enregistrement = new Date(Calendar.getInstance().getTimeInMillis());
        this.etatCourant = Etat.enregistrement;
        this.positions = new ArrayList<>();
        
    }

    public Object getCurrentPosition(){
        final Iterator itr = positions.iterator();
        Object lastElement = itr.next();
        while(itr.hasNext()) {
            lastElement=itr.next();
        }
        return lastElement;
    }
    
    public Integer getId() {
        return id;
    }

    public Float getPoids() {
        return poids;
    }

    public void setPoids(Float poids) {
        this.poids = poids;
    }
    
    public Date getDate_enregistrement() {
        return date_enregistrement;
    }

    public void setDate_enregistrement(Date date_enregistrement) {
        this.date_enregistrement = date_enregistrement;
    }
    

    public Integer getValeur() {
        return valeur;
    }

    public void setValeur(Integer valeur) {
        this.valeur = valeur;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Etat getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

    public Collection<Position> getPositions() {
        return positions;
    }

    public void setPositions(Collection<Position> positions) {
        this.positions = positions;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Colis)) {
            return false;
        }
        Colis other = (Colis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Colis{" +
                "id=" + id +
                ", poids=" + poids +
                ", valeur=" + valeur +
                ", origine='" + origine + '\'' +
                ", destination='" + destination + '\'' +
                ", etatCourant=" + etatCourant +
                ", date_enregistrement=" + date_enregistrement +
                ", positions=" + positions +
                '}';
    }
}
