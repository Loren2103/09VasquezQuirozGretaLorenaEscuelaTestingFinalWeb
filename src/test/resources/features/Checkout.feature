# language: es
Característica: Módulo de Checkout en SauceDemo - Flujos Exitosos
  Como comprador del e-commerce
  Quiero completar el proceso de pago de mis productos
  Para finalizar mi pedido correctamente

  Antecedentes:
    Dado que estoy logueado con el usuario "standard"
    Y estoy en la pagina de productos

  @HappyPath @FlujoCompraCompleto
  Escenario: Completar exitosamente una compra (E2E)
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y hago click en agregar al carrito el producto "Sauce Labs Bike Light"
    Y me dirijo a la pagina del carrito
    Y hago click en el boton de Checkout
    Y lleno el formulario de envio con Nombre "Juan", Apellido "Perez" y Codigo Postal "12345"
    Y verifico en el resumen que la suma del subtotal y los impuestos coincide con el total
    Y hago click en el boton Finish
    Entonces se muestra el mensaje de confirmacion "Thank you for your order!"

  @HappyPath @CancelarCheckout
  Escenario: Cancelar la compra en la pantalla de resumen
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y me dirijo a la pagina del carrito
    Y hago click en el boton de Checkout
    Y lleno el formulario de envio con Nombre "Maria", Apellido "Gomez" y Codigo Postal "54321"
    Y hago click en el boton Cancelar en la pantalla de resumen
    Entonces la URL actual deberia contener "inventory.html"

  @UnhappyPath @CheckoutFaltaNombre
  Escenario: Intentar avanzar sin ingresar el Nombre
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y me dirijo a la pagina del carrito
    Y hago click en el boton de Checkout
    Y lleno el formulario de envio con Nombre "", Apellido "Perez" y Codigo Postal "12345"
    Entonces se muestra el mensaje de error de checkout "Error: First Name is required"

  @UnhappyPath @CheckoutFaltaApellido
  Escenario: Intentar avanzar sin ingresar el Apellido
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y me dirijo a la pagina del carrito
    Y hago click en el boton de Checkout
    Y lleno el formulario de envio con Nombre "Juan", Apellido "" y Codigo Postal "12345"
    Entonces se muestra el mensaje de error de checkout "Error: Last Name is required"

  @UnhappyPath @CheckoutFaltaCodigoPostal
  Escenario: Intentar avanzar sin ingresar el Codigo Postal
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y me dirijo a la pagina del carrito
    Y hago click en el boton de Checkout
    Y lleno el formulario de envio con Nombre "Juan", Apellido "Perez" y Codigo Postal ""
    Entonces se muestra el mensaje de error de checkout "Error: Postal Code is required"