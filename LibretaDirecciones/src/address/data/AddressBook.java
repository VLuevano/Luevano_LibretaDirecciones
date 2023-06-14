package address.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Clase que contiene la lista que almacena todos los registros de la libreta 
 * de direcciones y contiene los métodos con las operaciones básicas de la libreta
 * @author Víctor Adrián
 */
public class AddressBook {

    //estructura de datos que permite almacenar los registros de la lista de direcciones
    private final List<AddressEntry> lista;

    /**
     * Constructor de la clase que inicializa la lista
     */
    public AddressBook() {
        lista = new ArrayList<>();
    }

    /**
     * Método que permite agregar una entrada de datos a la lista
     * @param entrada 
     */
    public void agregarEntrada(AddressEntry entrada) {
        lista.add(entrada);
    }

    /**
     * Método que permite eliminar una entrada de datos de la lista
     * @param entrada 
     */
    public void eliminarEntrada(AddressEntry entrada) {
        lista.remove(entrada);
    }

    /**
     * Método que retorna una entrada de la lista buscada por el apellido
     * @param apellido
     * @return 
     */
    public List<AddressEntry> buscarPorApellido(String apellido) {
        //crea una lista que almacenará las entradas que coincidan con el criterio de búsqueda
        List<AddressEntry> resultados = new ArrayList<>();
        
        //bucle for-each que recorre cada elemento de la lista
        for (AddressEntry entrada : lista) {
            //evalua si el apellido comienza con el criterio de búsqueda especificado
            if (entrada.getApellido().startsWith(apellido)) {
                //si cumple con el criterio, agrega la entrada a la lista "resultados"
                resultados.add(entrada);
            }
        }
        return resultados;
    }

    /**
     * Método que retorna todas las entradas de la lista
     * @return 
     */
    public List<AddressEntry> obtenerEntrada() {
        return lista;
    }

    /**
     * Método que ordena las entradas de la lista por apellido
     */
    public void filtrarEntradas() {
        /*
        Ordena la lista de entradas con ayuda de un comparador funcional que compara
        dos elementos de la lista en base a los apellidos e ignorando las mayúsculas
        y minúsculas
        */
        Collections.sort(lista,
                (a1, a2) -> a1.getApellido().compareToIgnoreCase(a2.getApellido()));
    }
}
