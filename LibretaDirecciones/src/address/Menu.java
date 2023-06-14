package address;

import address.data.AddressBook;
import address.data.AddressEntry;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Método que contiene los métodos con el comportamiento de la libreta de
 * direcciones al seleccionar cada una de las opciones
 *
 * @author Víctor Adrián
 */
public class Menu {

    private final AddressBook addressBook;
    Scanner input = new Scanner(System.in);

    /**
     * Constructor de la clase que inicializa el objeto de la clase AddressBook
     */
    public Menu() {
        addressBook = new AddressBook();
    }

    /**
     * Método que muestra en pantalla las opciones de la libreta de direcciones
     * y cona yuda de una estructura switch-case llama al método correspondiente
     * de acuerdo a la selección
     */
    public void mostrarMenu() {
        while (true) {
            System.out.println("Menú de libreta de direciones");
            System.out.println("a) Cargar entrada por archivo");
            System.out.println("b) Agregar nueva entrada");
            System.out.println("c) Eliminar entrada");
            System.out.println("d) Buscar entrada por apellido");
            System.out.println("e) Mostrar entradas por orden alfabético");
            System.out.println("f) Salir");
            System.out.print("Elija una opción: ");

            String opcion = input.nextLine();

            switch (opcion) {
                case "a":
                    cargarDesdeArchivo();
                    break;
                case "b":
                    agregarNuevaEntrada();
                    break;
                case "c":
                    eliminarEntrada();
                    break;
                case "d":
                    buscarPorApellido();
                    break;
                case "e":
                    mostrarTodasLasEntradas();
                    break;
                case "f":
                    System.exit(0);
                default:
                    System.out.println("Error! Opción no válida\n");
            }
        }
    }

    /**
     * Método que permite cargar una entrada de datos a través de un archivo de texto
     */
    public void cargarDesdeArchivo() {

        System.out.print("Ingrese la dirección del archivo: ");
        String rutaArchivo = input.nextLine();

        //Abre el archivo utilizando un objeto Scanner
        try (Scanner scanner = new Scanner(new File(System.getProperty("user.home")+rutaArchivo))) {
            
            //Verifica si hay más líneas que leer en el archivo 
            while (scanner.hasNextLine()) {
                //se lee cada línea del archivo con ayuda del método nextLine
                String linea = scanner.nextLine();
                /*
                separa cada línea leída en campos separados por comas y los almacena
                en el arreglo
                */
                String[] campos = linea.split(", ");

                //Extrae los datos del arreglo y los almacena localmente
                String nombre = campos[0];
                String apellido = campos[1];
                String calle = campos[2];
                String ciudad = campos[3];
                String estado = campos[4];
                String codigoPostal = campos[5];
                String correo = campos[6];
                String telefono = campos[7];

                //Agrega los datos ingresados en la entrada
                Address direccion = new Address(calle, ciudad, estado, codigoPostal);
                AddressEntry entrada = new AddressEntry(nombre, apellido, direccion,
                        correo, telefono);

                //Agrega la entrada de información en la lista
                addressBook.agregarEntrada(entrada);
            }
            System.out.println("Datos cargados correctamente desde el archivo\n");
        } catch (FileNotFoundException e) {
            System.out.println("No se pudo encontrar el archivo\n");
        }
    }

    /**
     * Método que permite agregar una nueva entrada a la lista de la libreta de
     * direcciones agregando cada uno de los datos de la entrada
     */
    private void agregarNuevaEntrada() {
        System.out.print("Ingrese su nombre: ");
        String firstName = input.nextLine();

        System.out.print("Ingrese su apellido: ");
        String lastName = input.nextLine();

        System.out.print("Ingrese su calle: ");
        String street = input.nextLine();

        System.out.print("Ingrese su ciudad: ");
        String city = input.nextLine();

        System.out.print("Ingrese su estado: ");
        String state = input.nextLine();

        System.out.print("Ingrese su código postal: ");
        String postalCode = input.nextLine();

        System.out.print("Ingrese su correo electrónico: ");
        String email = input.nextLine();

        System.out.print("Ingrese su número telefónico: ");
        String phone = input.nextLine();

        //Agrega los datos ingresados en la entrada
        Address direccion = new Address(street, city, state, postalCode);
        AddressEntry entrada = new AddressEntry(firstName, lastName, direccion, email, phone);

        //Agrega la entrada de información en la lista
        addressBook.agregarEntrada(entrada);
        System.out.println("¡Entrada agregada correctamente!\n");
    }

    /**
     * Método que permite eliminar una entrada de la lista
     */
    private void eliminarEntrada() {

        System.out.print("Ingrese el apellido para realizar la búsqueda: ");
        String apellido = input.nextLine();

        /*
        Llama al método buscarPorApellido para obtener la lista de las entrada
        que coincidan con el apellido ingresado
         */
        List<AddressEntry> resultados = addressBook.buscarPorApellido(apellido);

        /*
        Verifica si la lista de resultados está vacía, es decir, si no se encontraron
        coincidencias para el apellido ingresado
         */
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias\n");
        } else {
            System.out.println("Entradas encontradas:");
            //itera sobre la lista de resultados para mostrar todas las entradas de datos
            for (int i = 0; i < resultados.size(); i++) {
                AddressEntry entrada = resultados.get(i);
                System.out.println((i + 1) + ") " + entrada.toString());
            }

            //Solicita al usuario que introduzca el índice de la entrada que desea eliminar
            System.out.print("\nIntroduzca el índice de la entrada a eliminar: ");
            int indice = Integer.parseInt(input.nextLine()) - 1;

            //verifica que el índice esté dentro válido
            if (indice >= 0 && indice < resultados.size()) {
                //obtiene la entrada correspondiente de la lista en base a su índice
                AddressEntry entrada = resultados.get(indice);
                //llama al método para eliminar la entrada de la lista
                addressBook.eliminarEntrada(entrada);
                System.out.println("¡Entrada eliminada correctamente!\n");
            } else {
                System.out.println("Indice incorrecto\n");
            }
        }
    }

    /**
     * Método para buscar entradas de la lista por el apellido
     */
    private void buscarPorApellido() {
        System.out.print("Ingrese el apellido para realizar la búsqueda: ");
        String apellido = input.nextLine();

        /*
        Llama al método buscarPorApellido para obtener la lista de las entrada
        que coincidan con el apellido ingresado
         */
        List<AddressEntry> resultados = addressBook.buscarPorApellido(apellido);

        /*
        Verifica si la lista de resultados está vacía, es decir, si no se encontraron
        coincidencias para el apellido ingresado
         */
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron coincidencias\n");
        } else {
            System.out.println("Entradas encontradas:");
            //itera sobre la lista de resultados para mostrar todas las entradas de datos
            for (AddressEntry entrada : resultados) {
                System.out.println(entrada.toString());
            }
        }

    }

    /**
     *
     */
    private void mostrarTodasLasEntradas() {
        //llama al método obtenerEntrada para obtener todas las entradas de la lista
        List<AddressEntry> lista = addressBook.obtenerEntrada();
        //Ordena la lista de entradas utilizando el método Comparar
        lista.sort(AddressEntry::Comparar);

        /*
        obtiene todas las entradas de la libreta de direcciones, las ordena por
        apellido y las muestra en la pantalla
         */
        for (AddressEntry entrada : lista) {
            System.out.println(entrada.toString());
        }
    }
}
