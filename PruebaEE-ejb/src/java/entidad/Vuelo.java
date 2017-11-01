/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "VUELO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vuelo.findAll", query = "SELECT v FROM Vuelo v"),
    @NamedQuery(name = "Vuelo.findByIdvuelo", query = "SELECT v FROM Vuelo v WHERE v.idvuelo = :idvuelo"),
    @NamedQuery(name = "Vuelo.findByOrigen", query = "SELECT v FROM Vuelo v WHERE v.origen = :origen"),
    @NamedQuery(name = "Vuelo.findByDestino", query = "SELECT v FROM Vuelo v WHERE v.destino = :destino"),
    @NamedQuery(name = "Vuelo.findByCodigo", query = "SELECT v FROM Vuelo v WHERE v.codigo = :codigo")})
public class Vuelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IDVUELO")
    private Short idvuelo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ORIGEN")
    private String origen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DESTINO")
    private String destino;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CODIGO")
    private String codigo;
    @OneToMany(mappedBy = "idvuelo")
    private Collection<Reserva> reservaCollection;
    @JoinColumn(name = "IDCIUDAD", referencedColumnName = "IDCIUDAD")
    @ManyToOne
    private Ciudad idciudad;

    public Vuelo() {
    }

    public Vuelo(Short idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Vuelo(Short idvuelo, String origen, String destino, String codigo) {
        this.idvuelo = idvuelo;
        this.origen = origen;
        this.destino = destino;
        this.codigo = codigo;
    }

    public Short getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Short idvuelo) {
        this.idvuelo = idvuelo;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @XmlTransient
    public Collection<Reserva> getReservaCollection() {
        return reservaCollection;
    }

    public void setReservaCollection(Collection<Reserva> reservaCollection) {
        this.reservaCollection = reservaCollection;
    }

    public Ciudad getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(Ciudad idciudad) {
        this.idciudad = idciudad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvuelo != null ? idvuelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vuelo)) {
            return false;
        }
        Vuelo other = (Vuelo) object;
        if ((this.idvuelo == null && other.idvuelo != null) || (this.idvuelo != null && !this.idvuelo.equals(other.idvuelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Vuelo[ idvuelo=" + idvuelo + " ]";
    }
    
}
