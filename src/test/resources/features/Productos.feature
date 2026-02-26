# language: es
Característica: Módulo de Productos en SauceDemo - Flujos Exitosos
  Como comprador del e-commerce
  Quiero navegar por el catálogo y usar los filtros
  Para encontrar los productos que deseo comprar fácilmente

  Antecedentes:
    Dado que estoy logueado con el usuario "standard"
    Y estoy en la pagina de productos

  @HappyPath @FiltroPrecioMenorMayor
  Escenario: Ordenar productos por precio de menor a mayor
    Cuando selecciono la opcion "Price (low to high)" en el filtro
    Entonces el primer producto de la lista deberia ser "Sauce Labs Onesie"
    Y el precio del primer producto deberia ser "$7.99"

  @HappyPath @FiltroPrecioMayorMenor
  Escenario: Ordenar productos por precio de mayor a menor
    Cuando selecciono la opcion "Price (high to low)" en el filtro
    Entonces el primer producto de la lista deberia ser "Sauce Labs Fleece Jacket"
    Y el precio del primer producto deberia ser "$49.99"

  @HappyPath @FiltroAlfabeticoZA
  Escenario: Ordenar productos alfabéticamente de la Z a la A
    Cuando selecciono la opcion "Name (Z to A)" en el filtro
    Entonces el primer producto de la lista deberia ser "Test.allTheThings() T-Shirt (Red)"

  @HappyPath @NavegacionDetalle
  Escenario: Ver el detalle de un producto específico
    Cuando hago click en el titulo del producto "Sauce Labs Backpack"
    Entonces se muestra el nombre del producto "Sauce Labs Backpack" en el detalle
    Y se muestra el boton "Back to products"