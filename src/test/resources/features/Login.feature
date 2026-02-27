# language: es
Característica: Autenticación en SauceDemo
  Como comprador del e-commerce
  Quiero iniciar sesión con mi cuenta
  Para poder acceder al catálogo de productos y realizar compras

  Antecedentes:
    Dado que estoy en la pagina de login de SauceDemo

  @HappyPath @LoginExitoso
  Escenario: Inicio de sesión exitoso con usuario estandar
    Cuando escribo el usuario "standard"
    Y escribo la contraseña "valida"
    Y hago click en el boton de Login
    Entonces se muestra el titulo "Products"
    Y la URL es "https://www.saucedemo.com/inventory.html"

  @HappyPath @Logout
  Escenario: Cierre de sesion exitoso
    Dado escribo el usuario "standard"
    Y escribo la contraseña "valida"
    Y hago click en el boton de Login
    Cuando hago click en el menu lateral
    Y hago click en el boton de Logout
    Entonces la URL es "https://www.saucedemo.com/"

  @UnhappyPath @UsuarioBloqueado
  Escenario: Intento de inicio de sesión con una cuenta bloqueada
    Cuando escribo el usuario "locked"
    Y escribo la contraseña "valida"
    Y hago click en el boton de Login
    Entonces se muestra el mensaje de error "Epic sadface: Sorry, this user has been locked out."

  @UnhappyPath @CredencialesIncorrectas
  Escenario: Intento de inicio de sesión con credenciales incorrectas
    Cuando escribo el usuario "standard"
    Y escribo la contraseña "invalida"
    Y hago click en el boton de Login
    Entonces se muestra el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  @UnhappyPath @CamposVacios
  Escenario: Intento de inicio de sesión con campos vacíos
    Cuando escribo el usuario ""
    Y escribo la contraseña ""
    Y hago click en el boton de Login
    Entonces se muestra el mensaje de error "Username is required"

  @UnhappyPath @PasswordVacio
  Escenario: Intento de inicio de sesión dejando la contraseña en blanco
    Cuando escribo el usuario "standard"
    Y escribo la contraseña ""
    Y hago click en el boton de Login
    Entonces se muestra el mensaje de error "Password is required"

  @UnhappyPath @LoginConLatencia
  Escenario: Inicio de sesión con latencia en la red
    Cuando escribo el usuario "performance"
    Y escribo la contraseña "valida"
    Y hago click en el boton de Login
    Entonces se muestra el titulo "Products"
    Y la URL es "https://www.saucedemo.com/inventory.html"