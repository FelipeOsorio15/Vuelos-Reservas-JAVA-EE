/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlWeb;

import java.text.SimpleDateFormat;
import org.primefaces.event.DateSelectEvent;
import java.util.Date;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import ejb.ClienteEJB;
import ejb.CiudadEJB;
import ejb.VueloEJB;
import ejb.ReservaEJB;



import entidad.Cliente;
import entidad.Ciudad;
import entidad.Vuelo;
import entidad.Reserva; 
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;





/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class PruebaMB{ 
    private Cliente cliente; //permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Ciudad ciudad; //permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Vuelo vuelo; //permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Vuelo vuelo2;
    private Vuelo temporal;
    private Reserva reserva;
    private String mensaje;
    private String msjLogin;
    private List<Cliente> clientes;
    private List<Ciudad> ciudades;
    private List<Vuelo> vuelos;
    private List<Vuelo> vuelos2;
   // private List<Vuelo> temporales;
    private List<Reserva> reservas;
    private HtmlDataTable ciudadSelect;
    private HtmlDataTable clienteSelect;
    private HtmlDataTable vueloSelect;
    private ArrayList<SelectItem> origenCiudad;
    private ArrayList<SelectItem> destinoCiudad;
    private String fecha="",usuario="";
    
    private Date date1;

    public Vuelo getTemporal() {
        return temporal;
    }

    public void setTemporal(Vuelo temporal) {
        this.temporal = temporal;
    }
    
    

    public Vuelo getVuelo2() {
        return vuelo2;
    }

    public void setVuelo2(Vuelo vuelo2) {
        this.vuelo2 = vuelo2;
    }

    public List<Vuelo> getVuelos2() {
        return vuelos2;
    }

    public void setVuelos2(List<Vuelo> vuelos2) {
        this.vuelos2 = vuelos2;
    }

    
   
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    

    public CiudadEJB getCiuEJB() {
        return ciuEJB;
    }

    public void setCiuEJB(CiudadEJB ciuEJB) {
        this.ciuEJB = ciuEJB;
    }

    public ReservaEJB getResEJB() {
        return resEJB;
    }

    public void setResEJB(ReservaEJB resEJB) {
        this.resEJB = resEJB;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    

    public Date getDate1() {  
        return date1;  
    }  
  
    public void setDate1(Date date1) {  
        this.date1 = date1;  
    }
    
    
    
    public ArrayList<SelectItem> getOrigenCiudad() {
        Ciudad ciudadOrigen=new Ciudad();
        ciudades=new ArrayList<Ciudad>(); //vamos a crear la lista de vuelo
        ciudades=ciuEJB.obtenerCiudades();
        origenCiudad=new ArrayList<SelectItem>();
        for(int j=0; j<ciudades.size(); j++){
            
            ciudadOrigen=ciudades.get(j);
            origenCiudad.add(new SelectItem(ciudadOrigen.getNombre(), ciudadOrigen.getNombre()));
        }
        
        return origenCiudad;
    }
 


    public ArrayList<SelectItem> getDestinoCiudad() {
        Ciudad ciudadDestino=new Ciudad();
        ciudades=new ArrayList<Ciudad>();
        ciudades=ciuEJB.obtenerCiudades();
        destinoCiudad=new ArrayList<SelectItem>();
        for(int j=0; j<ciudades.size(); j++){
            //elcliente=clientes.get(i);
            ciudadDestino=ciudades.get(j);
            destinoCiudad.add(new SelectItem(ciudadDestino.getNombre(), ciudadDestino.getNombre()));
        }
        return destinoCiudad;
    }

    public void setOrigenCiudad(ArrayList<SelectItem> origenCiudad) {
        this.origenCiudad = origenCiudad;
    }
    public void setDestinoCiudad(ArrayList<SelectItem> destinoCiudad) {
        this.destinoCiudad = destinoCiudad;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
    
    
    
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    
    
    
    @EJB
    private ClienteEJB cliEJB ;
    @EJB 
    private CiudadEJB ciuEJB;
    @EJB
    private VueloEJB vueEJB=new VueloEJB();
    @EJB
    private ReservaEJB resEJB;
    
    /**
     * Creates a new instance of PruebaMB
     */
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }
    
    
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMsjLogin() {
        return msjLogin;
    }

    public void setMsjLogin(String msjLogin) {
        this.msjLogin = msjLogin;
    }

    public ClienteEJB getCliEJB() {
        return cliEJB;
    }

    public void setCliEJB(ClienteEJB cliEJB) {
        this.cliEJB = cliEJB;
    }
    
    

    
    

    public String crearCiudad(){
       
    if (ciuEJB.crearciudad(ciudad)== true) {
        mensaje= "Ciudad creada exitosamente!";
    
    }else {
        mensaje="Ciudad No Creada!";
    }  
    
    return mostrarlistarCiudades();
    //return "listarCiudades.xhtml";
    
    }
    
    public String crearCliente(){
    if (cliEJB.crearcliente(cliente) == true) {
        mensaje= "Cliente creado exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="Cliente No Creado!";
    }   
    return mostrarlistarClientes();
    //return "listarClientes.xhtml";
    
    }
    
    public String crearVuelo(){
    if (vueEJB.crearvuelo(vuelo)==true) {
        mensaje= "Vuelo creado exitosamente!";
    }
    else {
        mensaje="Vuelo No Creado!";
    }   
    
    //return mostrarlistarClientes();
    return mostrarlistarVuelos();
    //return "listarVuelos.xhtml";
    
    }
    
    
    public String editarCiudad(){
    
    if (ciuEJB.editarCiudad(ciudad)== true) {
        mensaje= "ciudad editada exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="La ciudad No pudo ser editada!";
    }   
    return "listarCiudades.xhtml";
    
    }
    
    public String editarCliente(){
    
    if (cliEJB.editarCliente(cliente)== true) {
        mensaje= "cliente editado exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="cliente No pudo ser editado!";
    }   
    return "listarClientes.xhtml";
    
    }
    
    
    
    public String editarVuelo(){
    if (vueEJB.editarVuelo(vuelo)== true) {
        mensaje= "vuelo editado exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="vuelo No pudo ser editado!";
    }   
    return "listarVuelos.xhtml";
    }
    
    public String eliminarCiudad(){
    
    if (ciuEJB.eliminarCiudad(ciudad)== true) {
        mensaje= "ciudad eliminada exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="ciudad No pudo ser Borrada!";
    }   
      return mostrarlistarCiudades();
    //return "listarCiudades.xhtml";
     }
     
     
     public String eliminarCliente()
     {
    
    if (cliEJB.eliminarCliente(cliente)== true) {
        mensaje= "cliente eliminado exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="cliente No pudo ser Eliminado!";
    } 
    return mostrarlistarClientes();
    //return "listarClientes.xhtml";
    
    }
     
     
     public String eliminarVuelo()
     {
       
     Date date1=new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
     fecha =sdf.format(date1);
     
    if (vueEJB.eliminarVuelo(vuelo)== true) {
        fecha="";
        mensaje= "Vuelo eliminado exitosamente!";
    //return "proveedorCreado.xhtml"; //Bean Gestionado maneja la navegacion
    }
    else {
        mensaje="El Vuelo No pudo ser Eliminado!";
    } 
    return mostrarlistarVuelos();
    //return "listarClientes.xhtml";
    
    }
    
    public String verificarLogin(){
    Cliente elcliente=new Cliente();
    clientes=new ArrayList<Cliente>(); //vamos a crear la lista
    clientes=cliEJB.obtenerClientes(); //capturo todos los clientes de la lista
    String retornar="";
    for(int i=0;i<clientes.size();i++){
         
     elcliente=clientes.get(i);

     //if(elcliente.getLogin()==cliente.getLogin() && cliente.getLogin()=="Admin"){           
     // if(elcliente.getClave()==cliente.getClave() && cliente.getClave()=="123"){
     if(cliente.getLogin().equals("Admin") && cliente.getClave().equals("123"))
     {
       msjLogin="";  
       usuario="Administrador";
       retornar= "menuAdmin.xhtml";
     }
     
     else if(cliente.getLogin().equals(elcliente.getLogin())&& cliente.getClave().equals(elcliente.getClave())){
          usuario=elcliente.getNombres();
          retornar="menuCliente.xhtml";
          msjLogin="";
          }
    else
      retornar="formLogin.xhtml";
     msjLogin="Login o Contraseña incorrectos!";
     
    }
        
        return retornar;
    
    }
    
    public String buscarVuelo(){
            
    Vuelo elvuelo=new Vuelo();
    vuelos=new ArrayList<Vuelo>(); //vamos a crear la lista
    vuelos=vueEJB.obtenerVuelos(); //capturo todos los clientes de la lista
    String retornar="";
    for(int i=0;i<vuelos.size();i++){
         
     elvuelo=vuelos.get(i);

     
     if(elvuelo.getOrigen().equals(vuelo.getOrigen()) && elvuelo.getDestino().equals(vuelo.getDestino()))
     {
       //msjLogin="";  
       //vuelo=new Vuelo();  
       vuelos= new ArrayList<Vuelo>();
        vuelos= vueEJB.obtenerVuelos();
       retornar= "vuelosEncontrados.xhtml";
     }
     else{
         retornar=null;}
     
    }
    
   // Vuelo vuereservado=new Vuelo();
   // Vuelo vueNoreservado=new Vuelo();
     return retornar;
    } 
    
    
    public String moverDatosTablaReservados(){ 
         
        
             
        vuelo2=new Vuelo();
        vuelos2= new ArrayList<Vuelo>();  
        vuelo2=(Vuelo) vueloSelect.getRowData();
        temporal=vuelo2;
              
        
        
        resEJB.eliminarVuelo(vuelo2);
        
        vuelos2= resEJB.obtenerVuelos();
        
        return "vuelosEncontrados.xhtml";
        
        
        
        
    }
    
    public String mostrarFormLogin(){
    msjLogin="";    
    mensaje="";//clareamos la vista
    cliente=new Cliente(); //creamos el objeto Cliente
    return "formLogin.xhtml";
    }
    
    public String mostrarlistarCiudades()
    {
        ciudades= new ArrayList<Ciudad>();
        ciudades= ciuEJB.obtenerCiudades();
        return "listarCiudades.xhtml";
    }
    
    public String mostrarlistarClientes()
    {
        clientes= new ArrayList<Cliente>();
        clientes= cliEJB.obtenerClientes();
        return "listarClientes.xhtml";
    }
    
    public String mostrarlistarVuelos()
    {
      vuelos=new ArrayList<Vuelo>();
      vuelos=vueEJB.obtenerVuelos();
      return "listarVuelos.xhtml";
    }
    
    
    public String mostrarlistarReservas()
    {
      //vuelo=new Vuelo();  
      reservas=new ArrayList<Reserva>();
      reservas=resEJB.obtenerReservas();
      return "listarReservas.xhtml";
    }        
    
    
    public String mostrarcrearCiudad(){
    ciudad=new Ciudad();    
    return "crearCiudad.xhtml";
    }
    public String mostrarcrearCliente(){
    cliente=new Cliente();    
    return "crearCliente.xhtml";
    }
    public String mostrarcrearVuelo(){
    vuelo=new Vuelo();
    return "crearVuelo.xhtml";
    }
    
    
    public String mostrarcrearReserva(){
    reserva=new Reserva();
    return "crearReserva.xhtml";
    }
    
     public String mostrareditarCiudad(){
        mensaje="";
        ciudad= new Ciudad();
        ciudad=(Ciudad)ciudadSelect.getRowData();
        return "editarCiudad.xhtml";
    }
     
        public String mostrareditarCliente(){
        mensaje="";
        cliente= new Cliente();
        cliente=(Cliente)clienteSelect.getRowData();
        return "editarCliente.xhtml";
    }
        
        public String mostrareditarVuelo(){
        mensaje="";
        vuelo=new Vuelo();
        vuelo=(Vuelo) vueloSelect.getRowData();
        return "editarVuelo.xhtml";
        }
        
       public String mostrareliminarCiudad(){
        mensaje="";
        ciudad= new Ciudad();
        ciudad=(Ciudad)ciudadSelect.getRowData();
        return "eliminarCiudad.xhtml";
    } 
       
       public String mostrareliminarVuelo(){
        mensaje="";
        vuelo= new Vuelo();
        vuelo=(Vuelo)vueloSelect.getRowData();
        return "eliminarVuelo.xhtml";
    }
       
    public String mostrareliminarCliente(){
      //  mensaje="";
        cliente= new Cliente();
        cliente=(Cliente)clienteSelect.getRowData();
        return "eliminarCliente.xhtml";
    }
    
    
   /* public String mostrarListaCiudades(){
        ciudades= new ArrayList<Ciudad>();
        ciudades= ciuEJB.obtenerCiudades();
        return "listarCiudades.xhtml";
    
    }*/
    
    
    
    public PruebaMB() {
        vuelo = new Vuelo();
    }

    /**
     * @return the ciudadSelect
     */
    public HtmlDataTable getCiudadSelect() {
        return ciudadSelect;
    }

    /**
     * @param ciudadSelect the ciudadSelect to set
     */
    public void setCiudadSelect(HtmlDataTable ciudadSelect) {
        this.ciudadSelect = ciudadSelect;
    }

    /**
     * @return the clienteSelect
     */
    public HtmlDataTable getClienteSelect() {
        return clienteSelect;
    }

    /**
     * @param clienteSelect the clienteSelect to set
     */
    public void setClienteSelect(HtmlDataTable clienteSelect) {
        this.clienteSelect = clienteSelect;
    }

    public HtmlDataTable getVueloSelect() {
        return vueloSelect;
    }

    public void setVueloSelect(HtmlDataTable vueloSelect) {
        this.vueloSelect = vueloSelect;
    }
    
    
    
//    public String mostrarFecha()
//    {
//      int dia,mes,ano;
//      dia=date1.getDay();
//      dia=date1.
//    }

    public VueloEJB getVueEJB() {
        return vueEJB;
    }

    public void setVueEJB(VueloEJB vueEJB) {
        this.vueEJB = vueEJB;
    }
    
        //Método para cerrar sesión
        public String cerrarSesion() {
//        FacesContext facesContext = FacesContext.getCurrentInstance();
//        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
//        if (session != null) {
//            session.invalidate(); //Cierre de sesion
//        }
            msjLogin="Hasta Pronto";
            FacesContext context = FacesContext.getCurrentInstance();

            ExternalContext externalContext = context.getExternalContext();

            Object session = externalContext.getSession(false);

            HttpSession httpSession = (HttpSession) session;

            httpSession.invalidate();
            
            return "formLogin.xhtml";// indica a donde quieres direccionar después de cerrar sesión 
        }
        
        
        
        public String irMenuAdmin(){
        return "menuAdmin.xhtml";
        }

     
}
