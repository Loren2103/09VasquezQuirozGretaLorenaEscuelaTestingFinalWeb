package steps;

import net.serenitybdd.annotations.Step;
import page.ProductosPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductosSteps {

    ProductosPage productosPage;

    @Step("Forzar navegación directa a /inventory.html")
    public void forzarAccesoAInventario() {
        productosPage.getDriver().get("https://www.saucedemo.com/inventory.html");
    }

    @Step("Seleccionar el filtro: {0}")
    public void usarFiltro(String opcion) {
        productosPage.cbxFiltro.click();
        productosPage.seleccionarFiltro(opcion);
    }

    @Step("Validar que el primer producto sea: {0}")
    public void validarPrimerProducto(String productoEsperado) {
        assertEquals(productoEsperado, productosPage.obtenerNombrePrimerProducto());
    }

    @Step("Validar que el precio del primer producto sea: {0}")
    public void validarPrecioPrimerProducto(String precioEsperado) {
        assertEquals(precioEsperado, productosPage.obtenerPrecioPrimerProducto());
    }

    @Step("Ingresar al detalle del producto: {0}")
    public void ingresarADetalleProducto(String nombreProducto) {
        productosPage.clickEnProducto(nombreProducto);
    }

    @Step("Validar nombre en el detalle: {0}")
    public void validarNombreDetalle(String nombreEsperado) {
        assertEquals(nombreEsperado, productosPage.lblNombreDetalleProducto.getText());
    }

    @Step("Validar botón volver a productos: {0}")
    public void validarBotonVolver(String textoBoton) {
        assertTrue(productosPage.btnVolverProductos.isVisible());
        assertEquals(textoBoton, productosPage.btnVolverProductos.getText());
    }

    @Step("Agregar producto al carrito: {0}")
    public void agregarProductoAlCarrito(String nombreProducto) {
        productosPage.clickAgregarAlCarrito(nombreProducto);
    }

    @Step("Validar texto de alerta JS: {0}")
    public void validarAlertaJSError(String mensajeEsperado) {
        String textoAlerta = productosPage.obtenerTextoAlertaJS();
        productosPage.aceptarAlertaJS();
        assertTrue(textoAlerta.contains(mensajeEsperado),
                "El mensaje de la alerta no fue el esperado. Texto real: " + textoAlerta);
    }

    @Step("Validar que el botón NO cambie a Remove para el producto: {0}")
    public void validarBotonNoCambiaARemove(String nombreProducto) {
        assertTrue(productosPage.obtenerBotonPorProducto(nombreProducto).isVisible(),
                "El botón 'Add to cart' desapareció, la acción parece haber funcionado cuando debía fallar.");
    }

    @Step("Validar URL actual contiene: {0}")
    public void validarFragmentoUrl(String fragmentoEsperado) {
        assertTrue(productosPage.getDriver().getCurrentUrl().contains(fragmentoEsperado));
    }
}