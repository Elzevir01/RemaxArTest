# RemaxArTest
## Descripcion:
Este proyecto de Automation Web Testing, navegación y recolección de datos sobre la web [https://www.remax.com.ar/](https://www.remax.com.ar/), consiste en ingresar la web principal, colocar filtros básicos como la ciudad y especificar el alquiler como parámetro y buscarlos, una vez accedamos a los resultados de la búsqueda continuar colocando mas parámetros de búsquedas: tipo de propiedad, transacción y precio.
Finalmente ingresar a los tres primeros resultados de búsqueda, recolectar los datos de las viviendas(titulo, precio, descripción, etc) y escribirlos en un archivo txt.

## Procedimiento:

1. Navegar hacia la web e ingresar filtros iniciales de busqueda

   - Navegar a "https://www.remax.com.ar/".
   - Hacer click en el boton "Quiero alquilar" para filtrar con este parametro.
   - Ingresar en el campo de busqueda la palabra "Cordoba", despliega una lista de la que se seleccionara "Capital, Cordoba" al que se dara click.
   - Hacer click en el menu desplegable "Tipo de propiedad" y seleccionar los campos: "Consultorio" y "Oficina".
   - Click en el boton "Buscar".

2. En la pagina de resultados de busqueda hacer un nuevo filtro de busqueda, cambiando "alquiler" a "venta" y agregando un monto minimo y maximo.

   - Click en la casilla de filtro "Alquiler", en la lista desplegable darle click al boton "Comprar" y finalmente click en "Aplicar filtro".
   - Click en la casilla de "Precio", en el menu desplegable ingresar en la casilla "Desde" el numero "10000" y en la casilla "maximo" un monto de "50000", finalmente click en el boton "Aplicar filtro".

3. Ingresar en las 3 primeras link de los resultados de la busqueda capturar sus datos y guardarlos en un archivo de texto

   - Hacer una lista con los 3 primeros link de los resultados, entrar a cada uno de ellos
     - Hacer click en link correspondiente y cambiar de ventana tras abrirse una nueva pestaña.
     - En la pagina de detalles de la vivienda capturar los siguientes elementos: "Titulo, Descripcion, Precio Dolar, Superficie Total, Superficie Cubierta, Baños, Pisos de la Propiedad, Apto Profecional y Expensas".
     - Cerrar la pestaña y volver al la busqueda para seguir con el siguiente link o terminar.
   - Crear un archivo de texto si no existe, colocar los datos obtenido de los tres link y guardar el archivo.

