package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Dado;
import net.serenitybdd.annotations.Steps;
import steps.CarritoSteps;

public class CarritoStepDefinitions {

    @Steps
    CarritoSteps carritoSteps;

    @Dado("me encuentro en la pagina del carrito")
    public void meEncuentroEnLaPaginaDelCarrito() {
        carritoSteps.forzarNavegacionACarrito();
    }

    @Dado("valido que el carrito esta vacio")
    public void validoQueElCarritoEstaVacio() {
        carritoSteps.validarListaCarritoVacia();
    }

    @Dado("que intento acceder directamente a la URL del carrito")
    public void queIntentoAccederDirectamenteALaURLDelCarrito() {
        carritoSteps.forzarAccesoACarrito();
    }

    @Entonces("el boton del producto {string} cambia su texto a {string}")
    public void elBotonDelProductoCambiaSuTextoA(String producto, String textoEsperado) {
        carritoSteps.validarBotonCambiaARemove(producto);
    }

    @Entonces("el icono del carrito muestra la cantidad {string}")
    public void elIconoDelCarritoMuestraLaCantidad(String cantidad) {
        carritoSteps.validarCantidadCarrito(cantidad);
    }

    @Cuando("hago click en remover el producto {string} desde el inventario")
    public void hagoClickEnRemoverElProductoDesdeElInventario(String producto) {
        carritoSteps.removerProductoDesdeInventario(producto);
    }

    @Entonces("el icono del carrito ya no muestra ninguna cantidad")
    public void elIconoDelCarritoYaNoMuestraNingunaCantidad() {
        carritoSteps.validarCarritoVacio();
    }

    @Cuando("me dirijo a la pagina del carrito")
    public void meDirijoALaPaginaDelCarrito() {
        carritoSteps.navegarAlCarrito();
    }

    @Cuando("hago click en remover el producto {string} desde la vista del carrito")
    public void hagoClickEnRemoverElProductoDesdeLaVistaDelCarrito(String producto) {
        carritoSteps.removerProductoDesdeVistaCarrito(producto);
    }

    @Entonces("el producto {string} ya no aparece en la lista del carrito")
    public void elProductoYaNoApareceEnLaListaDelCarrito(String producto) {
        carritoSteps.validarProductoNoEstaEnCarrito(producto);
    }

    @Cuando("recargo la pagina actual")
    public void recargoLaPaginaActual() {
        carritoSteps.recargarNavegador();
    }

    @Cuando("hago click en el boton de Checkout")
    public void hagoClickEnElBotonDeCheckout() {
        carritoSteps.iniciarCheckout();
    }

    @Entonces("el sistema deberia mostrar un error indicando que el carrito esta vacio")
    public void elSistemaDeberiaMostrarUnErrorIndicandoQueElCarritoEstaVacio() {
        carritoSteps.validarBloqueoCheckoutVacio();
    }
}