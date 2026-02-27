# language: es
Característica: Módulo de Carrito en SauceDemo - Errores
  Como usuario no autenticado
  Quiero validar la seguridad de la vista del carrito
  Para asegurar que no se exponga informacion sin sesion activa

  @UnhappyPath @AccesoNoAutorizadoCarrito
  Escenario: Intento de acceso a la vista del carrito sin iniciar sesión
    Dado que intento acceder directamente a la URL del carrito
    Entonces se muestra el mensaje de error "You can only access '/cart.html' when you are logged in."

  @UnhappyPath @CheckoutCarritoVacio
  Escenario: Intentar proceder al pago con el carrito vacio
    Dado que estoy logueado con el usuario "standard"
    Y me encuentro en la pagina del carrito
    Y valido que el carrito esta vacio
    Cuando hago click en el boton de Checkout
    Entonces el sistema deberia mostrar un error indicando que el carrito esta vacio