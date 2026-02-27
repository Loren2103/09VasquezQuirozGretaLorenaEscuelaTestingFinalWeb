# language: es
Característica: Módulo de Checkout en SauceDemo - Errores
  Como usuario del sistema
  Quiero validar que el formulario de envio requiera informacion obligatoria
  Para asegurar que no se procesen ordenes incompletas

  Antecedentes:
    Dado que estoy logueado con el usuario "error"
    Y estoy en la pagina de productos

  @UnhappyPath @CheckoutFalloLogico
  Escenario: Validar fallo de captura de datos con el usuario defectuoso
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y me dirijo a la pagina del carrito
    Y hago click en el boton de Checkout
    Cuando intento escribir el Apellido "Perez" en el formulario
    Entonces el campo de Apellido permanece vacio bloqueando la compra