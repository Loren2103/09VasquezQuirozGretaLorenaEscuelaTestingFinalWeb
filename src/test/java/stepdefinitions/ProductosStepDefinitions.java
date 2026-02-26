package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.ProductosSteps;

public class ProductosStepDefinitions {

    @Steps
    ProductosSteps productosSteps;

    @Dado("que intento acceder directamente a la URL del inventario")
    public void queIntentoAccederDirectamenteALaURLDelInventario() {
        productosSteps.forzarAccesoAInventario();
    }

    @Dado("estoy en la pagina de productos")
    public void meEncuentroEnLaPaginaDeProductos() {
        productosSteps.validarFragmentoUrl("inventory.html");
    }

    @Cuando("selecciono la opcion {string} en el filtro")
    public void seleccionoLaOpcionEnElFiltro(String opcion) {
        productosSteps.usarFiltro(opcion);
    }

    @Entonces("el primer producto de la lista deberia ser {string}")
    public void elPrimerProductoDeLaListaDeberiaSer(String producto) {
        productosSteps.validarPrimerProducto(producto);
    }

    @Entonces("el precio del primer producto deberia ser {string}")
    public void elPrecioDelPrimerProductoDeberiaSer(String precio) {
        productosSteps.validarPrecioPrimerProducto(precio);
    }

    @Cuando("hago click en el titulo del producto {string}")
    public void hagoClickEnElTituloDelProducto(String producto) {
        productosSteps.ingresarADetalleProducto(producto);
    }

    @Entonces("se muestra el nombre del producto {string} en el detalle")
    public void seMuestraElNombreDelProductoEnElDetalle(String nombreProducto) {
        productosSteps.validarNombreDetalle(nombreProducto);
    }

    @Entonces("se muestra el boton {string}")
    public void seMuestraElBoton(String textoBoton) {
        productosSteps.validarBotonVolver(textoBoton);
    }

    @Cuando("hago click en agregar al carrito el producto {string}")
    public void hagoClickEnAgregarAlCarritoElProducto(String producto) {
        productosSteps.agregarProductoAlCarrito(producto);
    }

    @Entonces("el sistema muestra una alerta emergente con el mensaje {string}")
    public void elSistemaMuestraUnaAlertaEmergenteConElMensaje(String mensajeAlerta) {
        productosSteps.validarAlertaJSError(mensajeAlerta);
    }

    @Entonces("el boton del producto {string} no cambia su texto a {string}")
    public void elBotonDelProductoNoCambiaSuTextoA(String producto, String estadoEsperado) {
        productosSteps.validarBotonNoCambiaARemove(producto);
    }
}