package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class ProductosPage extends PageObject {

    @FindBy(className = "product_sort_container")
    public WebElementFacade cbxFiltro;

    @FindBy(className = "inventory_item_name")
    public List<WebElementFacade> listaNombresProductos;

    @FindBy(className = "inventory_item_price")
    public List<WebElementFacade> listaPreciosProductos;

    @FindBy(id = "back-to-products")
    public WebElementFacade btnVolverProductos;

    @FindBy(css = ".inventory_details_name.large_size")
    public WebElementFacade lblNombreDetalleProducto;

    public void seleccionarFiltro(String opcion) {
        cbxFiltro.selectByVisibleText(opcion);
    }

    public String obtenerNombrePrimerProducto() {
        return listaNombresProductos.get(0).getText();
    }

    public String obtenerPrecioPrimerProducto() {
        return listaPreciosProductos.get(0).getText();
    }

    public void clickEnProducto(String nombreProducto) {
        getDriver().findElement(By.xpath("//div[text()='" + nombreProducto + "']")).click();
    }

    public WebElementFacade obtenerBotonPorProducto(String nombreProducto) {
        String idBoton = "add-to-cart-" + nombreProducto.toLowerCase().replace(" ", "-");
        return find(By.id(idBoton));
    }

    public void clickAgregarAlCarrito(String nombreProducto) {
        obtenerBotonPorProducto(nombreProducto).click();
    }

    public String obtenerTextoAlertaJS() {
        return getDriver().switchTo().alert().getText();
    }

    public void aceptarAlertaJS() {
        getDriver().switchTo().alert().accept();
    }

    public WebElementFacade obtenerBotonRemovePorProducto(String nombreProducto) {
        String idBoton = "remove-" + nombreProducto.toLowerCase().replace(" ", "-");
        return find(By.id(idBoton));
    }
}