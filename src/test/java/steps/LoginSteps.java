package steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.thucydides.model.util.EnvironmentVariables;
import page.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    LoginPage loginPage;
    private EnvironmentVariables environmentVariables; // Leer serenity.conf

    @Step("Abrir la página de login de SauceDemo")
    public void abrirPagina() {
        loginPage.open();
    }

    @Step("Ingresar el usuario: {0}")
    public void ingresarUsuario(String tipoUsuario) {
        String usuarioReal = "";
        if (!tipoUsuario.isEmpty()) {
            usuarioReal = EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty("environments.default.sauce.user." + tipoUsuario);
        }
        loginPage.ingresarUsuario(usuarioReal);
    }

    @Step("Ingresar la contraseña: {0}")
    public void ingresarPassword(String tipoPassword) {
        String passwordReal = "";
        if (tipoPassword.equals("valida")) {
            passwordReal = EnvironmentSpecificConfiguration.from(environmentVariables)
                    .getProperty("environments.default.sauce.pass");
        } else if (tipoPassword.equals("invalida")) {
            passwordReal = "clave_falsa_123";
        }
        loginPage.ingresarPassword(passwordReal);
    }

    @Step("Hacer clic en el botón Login")
    public void clickBotonLogin() {
        loginPage.clickLogin();
    }

    @Step("Validar que el título sea: {0}")
    public void validarTitulo(String tituloEsperado) {
        assertThat(loginPage.lblTituloModulo.getText())
                .contains(tituloEsperado);
    }

    @Step("Validar que la URL actual sea: {0}")
    public void validarUrl(String urlEsperada) {
        assertEquals(urlEsperada, loginPage.getDriver().getCurrentUrl());
    }

    @Step("Validar mensaje de error: {0}")
    public void validarMensajeError(String mensajeEsperado) {
        assertThat(loginPage.obtenerMensajeError())
                .contains(mensajeEsperado);
    }

    @Step("Hacer clic en el menú lateral")
    public void abrirMenuLateral() {
        loginPage.btnMenuLateral.click();
    }

    @Step("Hacer clic en Logout")
    public void clickLogout() {
        loginPage.waitFor(loginPage.btnLogout).isVisible();
        loginPage.btnLogout.click();
    }
}