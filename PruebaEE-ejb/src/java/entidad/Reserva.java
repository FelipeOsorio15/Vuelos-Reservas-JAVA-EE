/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pc
 */
@Entity
@Table(name = "RESERVA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reserva.findAll", query = "SELECT r FROM Reserva r"),
    @NamedQuery(name = "Reserva.findByIdreserva", query = "SELECT r FROM Reserva r WHERE r.idreserva = :idreserva"),
    @NamedQuery(name = "Reserva.findByFechareserva", query = "SELECT r FROM Reserva r WHERE r.fechareserva = :fechareserva")})
public class Reserva implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IDRESERVA")
    private Short idreserva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHARESERVA")
    @Temporal(TemporalType.DATE)
    private Date fechareserva;
    @JoinColumn(name = "IDVUELO", referencedColumnName = "IDVUELO")
    @ManyToOne
    private Vuelo idvuelo;
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE")
    @ManyToOne
    private Cliente idcliente;

    public Reserva() {
    }

    public Reserva(Short idreserva) {
        this.idreserva = idreserva;
    }

    public Reserva(Short idreserva, Date fechareserva) {
        this.idreserva = idreserva;
        this.fechareserva = fechareserva;
    }

    public Short getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(Short idreserva) {
        this.idreserva = idreserva;
    }

    public Date getFechareserva() {
        return fechareserva;
    }

    public void setFechareserva(Date fechareserva) {
        this.fechareserva = fechareserva;
    }

    public Vuelo getIdvuelo() {
        return idvuelo;
    }

    public void setIdvuelo(Vuelo idvuelo) {
        this.idvuelo = idvuelo;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idreserva != null ? idreserva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reserva)) {
            return false;
        }
        Reserva other = (Reserva) object;
        if ((this.idreserva == null && other.idreserva != null) || (this.idreserva != null && !this.idreserva.equals(other.idreserva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidad.Reserva[ idreserva=" + idreserva + " ]";
    }
    
}
