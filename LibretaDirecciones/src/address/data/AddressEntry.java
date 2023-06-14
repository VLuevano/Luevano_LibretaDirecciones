package address.data;

import address.Address;

/**
 * Clase que almacena la entrada de información a la libreta de direcciones
 *
 * @author Víctor Adrián
 */
public class AddressEntry {

    private String nombre;
    private String apellido;
    private Address direccion;
    private String correo;
    private String telefono;

    /**
     * Constructor de la clase que inicializa las variables de la entrada y las
     * almacena localmente
     *
     * @param nombre
     * @param apellido
     * @param direccion
     * @param correo
     * @param telefono
     */
    public AddressEntry(String nombre, String apellido, Address direccion,
            String correo, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    /**
     * Método que retorna el nombre guardado en la entrada de la lista
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que permite establecer el nombre en la entrada de la lista
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método que retorna el apellido guardado en la entrada de la lista
     *
     * @return
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Método que permite establecer el apellido en la entrada de la lista
     *
     * @param apellido
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * Método que retorna la dirección guardada en la entrada de la lista
     *
     * @return
     */
    public Address getDireccion() {
        return direccion;
    }

    /**
     * Método que permite establecer la dirección en la entrada de la lista
     *
     * @param direccion
     */
    public void setDireccion(Address direccion) {
        this.direccion = direccion;
    }

    /**
     * Método que retorna el correo electrónico guardado en la entrada de la
     * lista
     *
     * @return
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Método que permite establecer el correo electrónico en la entrada de la
     * lista
     *
     * @param correo
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Método que retorna el número telefónico guardado en la entrada de la
     * lista
     *
     * @return
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Método que permite establecer el número telefónico en la entrada de la
     * lista
     *
     * @param telefono
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método que retorna la cadena de texto con los valores de la lista
     *
     * @return
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + " " + apellido + "\n"
                + "Dirección: " + direccion.toString() + "\n"
                + "Correo electrónico: " + correo + "\n"
                + "No. telefónico: " + telefono + "\n";
    }

    /**
     * Método para comparar el apellido de la entrada actual con el de otra
     * entrada
     *
     * @param entrada
     * @return
     */
    public int Comparar(AddressEntry entrada) {
        return this.apellido.compareTo(entrada.apellido);
    }
}
