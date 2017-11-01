package entidad;

import entidad.Vuelo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.2.v20111125-r10461", date="2013-11-22T11:45:45")
@StaticMetamodel(Ciudad.class)
public class Ciudad_ { 

    public static volatile SingularAttribute<Ciudad, String> nombre;
    public static volatile CollectionAttribute<Ciudad, Vuelo> vueloCollection;
    public static volatile SingularAttribute<Ciudad, Short> idciudad;

}