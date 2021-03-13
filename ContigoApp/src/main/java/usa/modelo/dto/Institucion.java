package usa.modelo.dto;


/**
 * 
 */
public class Institucion {

    /**
     * Default constructor
     */
    public Institucion() {
    }

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String correo;

    /**
     * 
     */
    private String direccion;

    /**
     * 
     */
    private boolean tipoInstitucion;

    /**
     * 
     */
    private boolean calendario;

    /**
     * 
     */
    private String barrio;

    /**
     * 
     */
    private String telefono;

    /**
     * 
     */
    private Municipio municipio;

    /**
     * 
     */
    private String contraseña;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isTipoInstitucion() {
        return tipoInstitucion;
    }

    public void setTipoInstitucion(boolean tipoInstitucion) {
        this.tipoInstitucion = tipoInstitucion;
    }

    public boolean isCalendario() {
        return calendario;
    }

    public void setCalendario(boolean calendario) {
        this.calendario = calendario;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }




}