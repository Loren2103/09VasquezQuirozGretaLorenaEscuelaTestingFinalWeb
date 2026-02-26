package page;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    // Elementos web
    @FindBy(id = "user-name")
    public WebElementFacade txtUsuario;

    @FindBy(id = "password")
    public WebElementFacade txtPassword;

    @FindBy(id = "login-button")
    public WebElementFacade btnLogin;

    @FindBy(css = "[data-test='error']")
    public WebElementFacade lblError;

    @FindBy(id = "react-burger-menu-btn")
    public WebElementFacade btnMenuLateral;

    @FindBy(id = "logout_sidebar_link")
    public WebElementFacade btnLogout;

    @FindBy(css = ".title")
    public WebElementFacade lblTituloModulo;

    // Métodos
    public void ingresarUsuario(String usuario) {
        txtUsuario.sendKeys(usuario);
    }

    public void ingresarPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public String obtenerMensajeError() {
        return lblError.getText();
    }
}