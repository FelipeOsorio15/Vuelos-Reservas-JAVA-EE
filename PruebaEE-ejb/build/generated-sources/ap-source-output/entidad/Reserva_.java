package entidad;

import entidad.Cliente;
import entidad.Vuelo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-11-22T11:45:45")
@StaticMetamodel(Reserva.class)
public class Reserva_ { 

    public static volatile SingularAttribute<Reserva, Date> fechareserva;
    public static volatile SingularAttribute<Reserva, Cliente> idcliente;
    public static volatile SingularAttribute<Reserva, Short> idreserva;
    public static volatile SingularAttribute<Reserva, Vuelo> idvuelo;

}