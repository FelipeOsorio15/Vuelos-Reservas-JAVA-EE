package entidad;

import entidad.Ciudad;
import entidad.Reserva;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-11-22T11:45:45")
@StaticMetamodel(Vuelo.class)
public class Vuelo_ { 

    public static volatile SingularAttribute<Vuelo, String> destino;
    public static volatile SingularAttribute<Vuelo, String> codigo;
    public static volatile CollectionAttribute<Vuelo, Reserva> reservaCollection;
    public static volatile SingularAttribute<Vuelo, Short> idvuelo;
    public static volatile SingularAttribute<Vuelo, Ciudad> idciudad;
    public static volatile SingularAttribute<Vuelo, String> origen;

}