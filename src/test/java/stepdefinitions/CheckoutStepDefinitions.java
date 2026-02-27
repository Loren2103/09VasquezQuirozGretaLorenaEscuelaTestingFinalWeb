package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.CheckoutSteps;

public class CheckoutStepDefinitions {

    @Steps
    CheckoutSteps checkoutSteps;

    @Cuando("lleno el formulario de envio con Nombre {string}, Apellido {string} y Codigo Postal {string}")
    public void llenoElFormularioDeEnvioConNombreApellidoYCodigoPostal(String nombre, String apellido, String cp) {
        checkoutSteps.completarFormulario(nombre, apellido, cp);
    }

    @Cuando("verifico en el resumen que la suma del subtotal y los impuestos coincide con el total")
    public void verificoEnElResumenQueLaSumaDelSubtotalYLosImpuestosCoincideConElTotal() {
        checkoutSteps.validarCalculoMatematico();
    }

    @Cuando("hago click en el boton Finish")
    public void hagoClickEnElBotonFinish() {
        checkoutSteps.finalizarCompra();
    }

    @Entonces("se muestra el mensaje de confirmacion {string}")
    public void seMuestraElMensajeDeConfirmacion(String mensajeExito) {
        checkoutSteps.validarMensajeExito(mensajeExito);
    }

    @Cuando("hago click en el boton Cancelar en la pantalla de resumen")
    public void hagoClickEnElBotonCancelarEnLaPantallaDeResumen() {
        checkoutSteps.cancelarCompra();
    }

    @Entonces("la URL actual deberia contener {string}")
    public void laURLActualDeberiaContener(String fragmentoUrl) {
        checkoutSteps.validarRetornoInventario();
    }

    @Entonces("se muestra el mensaje de error de checkout {string}")
    public void seMuestraElMensajeDeErrorDeCheckout(String errorEsperado) {
        checkoutSteps.validarErrorFormulario(errorEsperado);
    }

    @Cuando("intento escribir el Apellido {string} en el formulario")
    public void intentoEscribirElApellidoEnElFormulario(String apellido) {
        checkoutSteps.intentarEscribirApellido(apellido);
    }

    @Entonces("el campo de Apellido permanece vacio bloqueando la compra")
    public void elCampoDeApellidoPermaneceVacioBloqueandoLaCompra() {
        checkoutSteps.validarBloqueoCampoApellido();
    }
}