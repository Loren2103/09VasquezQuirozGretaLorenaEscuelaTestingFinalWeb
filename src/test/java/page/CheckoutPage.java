package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageObject {

    @FindBy(id = "first-name")
    public WebElementFacade txtNombre;

    @FindBy(id = "last-name")
    public WebElementFacade txtApellido;

    @FindBy(id = "postal-code")
    public WebElementFacade txtCodigoPostal;

    @FindBy(id = "continue")
    public WebElementFacade btnContinue;

    @FindBy(id = "cancel")
    public WebElementFacade btnCancel;

    @FindBy(id = "finish")
    public WebElementFacade btnFinish;

    @FindBy(css = ".summary_subtotal_label")
    public WebElementFacade lblSubtotal;

    @FindBy(css = ".summary_tax_label")
    public WebElementFacade lblTax;

    @FindBy(css = ".summary_total_label")
    public WebElementFacade lblTotal;

    @FindBy(css = ".complete-header")
    public WebElementFacade lblMensajeConfirmacion;

    @FindBy(css = "[data-test='error']")
    public WebElementFacade lblErrorFormulario;

    public void ingresarDatosEnvio(String nombre, String apellido, String codigoPostal) {
        txtNombre.sendKeys(nombre);
        txtApellido.sendKeys(apellido);
        txtCodigoPostal.sendKeys(codigoPostal);
        btnContinue.click();
    }

    public void ingresarSoloApellido(String apellido) {
        txtApellido.sendKeys(apellido);
    }

    public String obtenerValorCampoApellido() {
        return txtApellido.getValue();
    }

    public void clickTerminarCompra() {
        btnFinish.click();
    }

    public void clickCancelar() {
        btnCancel.click();
    }

    public double obtenerMontoSubtotal() {
        return Double.parseDouble(lblSubtotal.getText().replace("Item total: $", ""));
    }

    public double obtenerMontoImpuesto() {
        return Double.parseDouble(lblTax.getText().replace("Tax: $", ""));
    }

    public double obtenerMontoTotal() {
        return Double.parseDouble(lblTotal.getText().replace("Total: $", ""));
    }
}