package page;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CarritoPage extends PageObject {

    @FindBy(css = ".shopping_cart_link")
    public WebElementFacade btnCarrito;

    @FindBy(css = ".shopping_cart_badge")
    public WebElementFacade lblBadgeCarrito;

    @FindBy(className = "cart_item")
    public List<WebElementFacade> listaItemsCarrito;

    public void irAlCarrito() {
        btnCarrito.click();
    }

    public String obtenerCantidadCarrito() {
        return lblBadgeCarrito.getText();
    }

    public boolean badgeCarritoEsVisible() {
        return lblBadgeCarrito.isVisible();
    }

    public void clickRemoverEnVistaCarrito(String nombreProducto) {
        String idBoton = "remove-" + nombreProducto.toLowerCase().replace(" ", "-");
        find(By.id(idBoton)).click();
    }

    public boolean productoExisteEnCarrito(String nombreProducto) {
        return listaItemsCarrito.stream()
                .anyMatch(item -> item.containsText(nombreProducto));
    }

    public void recargarPagina() {
        getDriver().navigate().refresh();
    }

    @FindBy(id = "checkout")
    public WebElementFacade btnCheckout;

    public void clickCheckout() {
        btnCheckout.waitUntilClickable().click();
    }

    public int obtenerCantidadDeItemsEnLista() {
        return listaItemsCarrito.size();
    }
}