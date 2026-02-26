# language: es
Característica: Módulo de Productos en SauceDemo - Flujos Alternos y Errores
  Como usuario del sistema
  Quiero validar el manejo de errores y seguridad en el catalogo
  Para asegurar que las fallas esten notificadas o controladas

  @UnhappyPath @AccesoNoAutorizado
  Escenario: Intento de acceso al inventario sin iniciar sesión
    Dado que intento acceder directamente a la URL del inventario
    Entonces se muestra el mensaje de error "Epic sadface: You can only access '/inventory.html' when you are logged in."

  @UnhappyPath @AlertaFiltroRoto
  Escenario: Validar alerta de error cuando el filtro de ordenamiento falla
    Dado que estoy logueado con el usuario "error"
    Y estoy en la pagina de productos
    Cuando selecciono la opcion "Price (low to high)" en el filtro
    Entonces el sistema muestra una alerta emergente con el mensaje "Sorting is broken!"

  @UnhappyPath @FalloBotonAgregar
  Escenario: Validar fallo visual al intentar agregar un producto conflictivo
    Dado que estoy logueado con el usuario "problem"
    Y estoy en la pagina de productos
    Cuando hago click en agregar al carrito el producto "Sauce Labs Fleece Jacket"
    Entonces el boton del producto "Sauce Labs Fleece Jacket" no cambia su texto a "Remove"