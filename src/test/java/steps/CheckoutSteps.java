package steps;

import net.serenitybdd.annotations.Step;
import page.CheckoutPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckoutSteps {

    CheckoutPage checkoutPage;

    @Step("Llenar el formulario de envío")
    public void completarFormulario(String nombre, String apellido, String codigoPostal) {
        checkoutPage.ingresarDatosEnvio(nombre, apellido, codigoPostal);
    }

    @Step("Validar que Subtotal + Impuestos = Total")
    public void validarCalculoMatematico() {
        double subtotal = checkoutPage.obtenerMontoSubtotal();
        double impuesto = checkoutPage.obtenerMontoImpuesto();
        double totalEsperado = subtotal + impuesto;
        double totalReal = checkoutPage.obtenerMontoTotal();

        assertEquals(totalEsperado, totalReal, 0.01,
                "El cálculo matemático de la orden es incorrecto.");
    }

    @Step("Finalizar compra")
    public void finalizarCompra() {
        checkoutPage.clickTerminarCompra();
    }

    @Step("Cancelar compra")
    public void cancelarCompra() {
        checkoutPage.clickCancelar();
    }

    @Step("Validar mensaje de confirmación: {0}")
    public void validarMensajeExito(String mensajeEsperado) {
        assertEquals(mensajeEsperado, checkoutPage.lblMensajeConfirmacion.getText());
    }

    @Step("Validar URL después de cancelar")
    public void validarRetornoInventario() {
        assertTrue(checkoutPage.getDriver().getCurrentUrl().contains("inventory.html"),
                "El sistema no retornó al inventario después de cancelar.");
    }

    @Step("Validar mensaje de error en formulario: {0}")
    public void validarErrorFormulario(String errorEsperado) {
        assertEquals(errorEsperado, checkoutPage.lblErrorFormulario.getText());
    }

    @Step("Intentar escribir solo el apellido")
    public void intentarEscribirApellido(String apellido) {
        checkoutPage.ingresarSoloApellido(apellido);
    }

    @Step("Validar que el campo apellido bloquee la entrada")
    public void validarBloqueoCampoApellido() {
        String valorActual = checkoutPage.obtenerValorCampoApellido();
        assertTrue(valorActual.isEmpty(),
                "El campo apellido capturó el texto, pero el usuario 'error' no debería poder llenarlo. Valor actual: " + valorActual);
    }
}