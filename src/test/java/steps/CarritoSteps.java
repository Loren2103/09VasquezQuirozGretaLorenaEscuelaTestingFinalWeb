package steps;

import net.serenitybdd.annotations.Step;
import page.CarritoPage;
import page.ProductosPage;

import static org.junit.jupiter.api.Assertions.*;

public class CarritoSteps {

    CarritoPage carritoPage;
    ProductosPage productosPage;

    @Step("Validar que el botón cambia a Remove para: {0}")
    public void validarBotonCambiaARemove(String nombreProducto) {
        assertTrue(productosPage.obtenerBotonRemovePorProducto(nombreProducto).isVisible(),
                "El botón no cambió a 'Remove' después de agregar el producto.");
    }

    @Step("Validar que el badge del carrito muestra: {0}")
    public void validarCantidadCarrito(String cantidadEsperada) {
        assertTrue(carritoPage.badgeCarritoEsVisible(), "El badge numérico del carrito no está visible.");
        assertEquals(cantidadEsperada, carritoPage.obtenerCantidadCarrito());
    }

    @Step("Remover producto desde el inventario: {0}")
    public void removerProductoDesdeInventario(String nombreProducto) {
        productosPage.obtenerBotonRemovePorProducto(nombreProducto).click();
    }

    @Step("Validar que el carrito está vacío (sin badge)")
    public void validarCarritoVacio() {
        assertFalse(carritoPage.badgeCarritoEsVisible(), "El badge del carrito sigue visible cuando debería estar vacío.");
    }

    @Step("Ir a la vista del carrito")
    public void navegarAlCarrito() {
        carritoPage.irAlCarrito();
    }

    @Step("Remover producto desde la vista del carrito: {0}")
    public void removerProductoDesdeVistaCarrito(String nombreProducto) {
        carritoPage.clickRemoverEnVistaCarrito(nombreProducto);
    }

    @Step("Validar que el producto {0} ya no está en la lista del carrito")
    public void validarProductoNoEstaEnCarrito(String nombreProducto) {
        assertFalse(carritoPage.productoExisteEnCarrito(nombreProducto),
                "El producto " + nombreProducto + " aún aparece en el carrito.");
    }

    @Step("Recargar la página actual")
    public void recargarNavegador() {
        carritoPage.recargarPagina();
    }

    @Step("Navegar directamente a la página del carrito")
    public void forzarNavegacionACarrito() {
        carritoPage.getDriver().get("https://www.saucedemo.com/cart.html");
    }

    @Step("Validar que el carrito está completamente vacío")
    public void validarListaCarritoVacia() {
        assertEquals(0, carritoPage.obtenerCantidadDeItemsEnLista(),
                "El carrito debería estar vacío, pero se encontraron productos.");
    }

    @Step("Hacer clic en Checkout")
    public void iniciarCheckout() {
        carritoPage.clickCheckout();
    }

    @Step("Validar que el sistema bloquea el checkout de un carrito vacío")
    public void validarBloqueoCheckoutVacio() {
        assertFalse(carritoPage.getDriver().getCurrentUrl().contains("checkout-step-one"),
                "El sistema permitió avanzar al Checkout con un carrito de 0 items.");
    }

    @Step("Forzar navegación directa a /cart.html")
    public void forzarAccesoACarrito() {
        carritoPage.getDriver().get("https://www.saucedemo.com/cart.html");
    }
}