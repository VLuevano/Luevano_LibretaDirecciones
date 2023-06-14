package address.data;

import address.Address;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * clase para realiza las pruebas unitarias de la clase AddressEntry
 * @author Víctor Adrián
 */
public class AddressEntryTest {
    
    private AddressEntry entrada;
    
    @Before
    public void setUp() {
        Address direccion = new Address("And. Río Uxpanapa #107 Col. El Tesoro",
                "Coatzacoalcos", "Veracruz", "96536");
        entrada = new AddressEntry("Víctor", "Luévano", direccion, "victorluevmon@gmail.com",
                "9211491589");
    }

    /**
     * Prueba el método getNombre
     */
    @Test
    public void testGetNombre() {
        Assert.assertEquals("Víctor", entrada.getNombre());
    }

    /**
     * Prueba el método setNombre
     */
    @Test
    public void testSetNombre() {
        entrada.setNombre("Víctor");
        Assert.assertEquals("Víctor", entrada.getNombre());
    }

    /**
     * Prueba el método getApellido
     */
    @Test
    public void testGetApellido() {
        Assert.assertEquals("Luévano", entrada.getApellido());
    }

    /**
     * Prueba el método setApellido
     */
    @Test
    public void testSetApellido() {
        entrada.setApellido("Luévano");
        Assert.assertEquals("Luévano", entrada.getApellido());
    }

    /**
     * Prueba el método getDirección
     */
    @Test
    public void testGetDireccion() {
        Address direccionEsperada = new Address("And. Río Uxpanapa #107 Col. El Tesoro",
                "Coatzacoalcos", "Veracruz", "96536");
        Assert.assertEquals(direccionEsperada, entrada.getDireccion());
    }

    /**
     * Prueba el método setDirección
     */
    @Test
    public void testSetDireccion() {
        Address nuevaDireccion = new Address("And. Río Uxpanapa #107 Col. El Tesoro",
                "Coatzacoalcos", "Veracruz", "96536");
        entrada.setDireccion(nuevaDireccion);
        Assert.assertEquals(nuevaDireccion, entrada.getDireccion());
    }

    /**
     * Prueba el método GetCorreo
     */
    @Test
    public void testGetCorreo() {
        Assert.assertEquals("victorluevmon@gmail.com", entrada.getCorreo());
    }

    /**
     * Prueba el método setCorreo
     */
    @Test
    public void testSetCorreo() {
        entrada.setCorreo("victorluevmon@gmail.com");
        Assert.assertEquals("victorluevmon@gmail.com", entrada.getCorreo());
    }

    /**
     * Prueba el método getTelefono
     */
    @Test
    public void testGetTelefono() {
        Assert.assertEquals("9211491589", entrada.getTelefono());
    }

    /**
     * Prueba el método setTelefono
     */
    @Test
    public void testSetTelefono() {
        entrada.setTelefono("9211491589");
        Assert.assertEquals("9211491589", entrada.getTelefono());
    }

    /**
     * Prueba el método toString
     */
    @Test
    public void testToString() {
        String textoEsperado = "Nombre: Víctor Luévano\n" +
                "Dirección: And. Río Uxpanapa #107 Col. El Tesoro,"
                + "Coatzacoalcos, Veracruz, 96536\n" +
                "Correo electrónico: victorluevmon@gmail.com\n"+
                "No. telefónico: 9211491589\n";
        Assert.assertEquals(textoEsperado, entrada.toString());
    }
    
}
