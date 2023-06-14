package address;

/**
 * Clase que almacena las variables y métodos para almacenar los datos de la
 * dirección en la entrada
 * @author Víctor Adrián
 */
public class Address {
    private String calle;
    private String ciudad;
    private String estado;
    private String codigoPostal;

    /**
     * Constructor de la clase que inicializa los datos de la dirección
     * @param calle
     * @param ciudad
     * @param estado
     * @param codigoPostal 
     */
    public Address(String calle, String ciudad, String estado, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método que retorna la calle guardada en la entrada de la lista
     * @return 
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Método que permite establecer la calle en la entrada de la lista
     * @param calle 
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Método que retorna la ciudad guardada en la entrada de la lista
     * @return 
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Método que permite establecer la ciudad en la entrada de la lista
     * @param ciudad 
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Método que retorna el estado guardado en la entrada de la lista
     * @return 
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Método que permite establecer el estado en la entrada de la lista
     * @param estado 
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Método que retorna el código postal guardado en la entrada de la lista
     * @return 
     */
    public String getCodigoPostal() {
        return codigoPostal;
    }

    /**
     * Método que permite establecer el código postal en la entrada de la lista
     * @param codigoPostal 
     */
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    /**
     * Método que retorna la cadena de texto con los valores de la lista
     * @return 
     */
    @Override
    public String toString() {
        return calle + ", " + ciudad + ", " + estado + ", " + codigoPostal;
    }
}
