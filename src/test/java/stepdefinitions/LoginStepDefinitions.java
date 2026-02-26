package stepdefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.annotations.Steps;
import steps.LoginSteps;

public class LoginStepDefinitions {

    @Steps
    LoginSteps loginSteps;

    @Dado("que estoy en la pagina de login de SauceDemo")
    public void queNavegoALaPaginaDeLogin() {
        loginSteps.abrirPagina();
    }

    @Cuando("escribo el usuario {string}")
    public void escriboElUsuario(String tipoUsuario) {
        loginSteps.ingresarUsuario(tipoUsuario);
    }

    @Cuando("escribo la contraseña {string}")
    public void escriboLaContrasena(String tipoPassword) {
        loginSteps.ingresarPassword(tipoPassword);
    }

    @Cuando("hago click en el boton de Login")
    public void hagoClickEnElBotonDeLogin() {
        loginSteps.clickBotonLogin();
    }

    @Entonces("se muestra el titulo {string}")
    public void seMuestraElTitulo(String titulo) {
        loginSteps.validarTitulo(titulo);
    }

    @Entonces("la URL es {string}")
    public void laURLEs(String url) {
        loginSteps.validarUrl(url);
    }

    @Entonces("se muestra el mensaje de error {string}")
    public void seMuestraElMensajeDeError(String mensaje) {
        loginSteps.validarMensajeError(mensaje);
    }

    @Cuando("hago click en el menu lateral")
    public void hagoClickEnElMenuLateral() {
        loginSteps.abrirMenuLateral();
    }

    @Cuando("hago click en el boton de Logout")
    public void hagoClickEnElBotonDeLogout() {
        loginSteps.clickLogout();
    }
}