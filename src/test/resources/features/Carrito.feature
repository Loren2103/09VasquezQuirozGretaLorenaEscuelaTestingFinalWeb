# language: es
Característica: Módulo de Carrito de Compras en SauceDemo - Flujos Exitosos
  Como comprador del e-commerce
  Quiero agregar y quitar productos de mi carrito
  Para gestionar mi pedido antes de pagar

  Antecedentes:
    Dado que estoy logueado con el usuario "standard"
    Y estoy en la pagina de productos

  @HappyPath @AgregarUnProducto
  Escenario: Agregar un producto al carrito
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Entonces el boton del producto "Sauce Labs Backpack" cambia su texto a "Remove"
    Y el icono del carrito muestra la cantidad "1"

  @HappyPath @AgregarYRemoverInventario
  Escenario: Agregar y remover un producto desde el inventario
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y hago click en remover el producto "Sauce Labs Backpack" desde el inventario
    Entonces el icono del carrito ya no muestra ninguna cantidad

  @HappyPath @AgregarMultiplesProductos
  Escenario: Agregar multiples productos al carrito
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y hago click en agregar al carrito el producto "Sauce Labs Bike Light"
    Y hago click en agregar al carrito el producto "Sauce Labs Bolt T-Shirt"
    Entonces el icono del carrito muestra la cantidad "3"

  @HappyPath @RemoverDesdeCarrito
  Escenario: Remover un producto desde la vista interna del carrito
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y me dirijo a la pagina del carrito
    Y hago click en remover el producto "Sauce Labs Backpack" desde la vista del carrito
    Entonces el producto "Sauce Labs Backpack" ya no aparece en la lista del carrito

  @HappyPath @PersistenciaCarrito
  Escenario: Validar que el carrito mantenga los productos al recargar la pagina
    Cuando hago click en agregar al carrito el producto "Sauce Labs Backpack"
    Y recargo la pagina actual
    Entonces el icono del carrito muestra la cantidad "1"