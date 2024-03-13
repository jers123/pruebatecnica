# API Depreciación de activos

#### Autor:
Julian Enrique Rodriguez Saavedra
#### Descripción:
Esta es una API para poder calcular la depreciación de los activos que se registren según el tipo de activo.
### Depreciación
Se determina la depreciación de un activo según el tipo de activo ya que de este depende el valor de vida útil y porcentaje
de depreciación<br><br>
<table>
    <thead>
        <tr>
            <th>Tipo de activo</th>
            <th>Vida util (años)</th>
            <th>Porsentaje de depresiacion</th>
            <th>Valor(Clase Depreciation - tipo Enum)</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Construcciones y edificaciones</td>
            <td>45</td>
            <td>2.22%</td>
            <td>0</td>
        </tr>
        <tr>
            <td>Acueducto, planta y redes</td>
            <td>40</td>
            <td>2.5%</td>
            <td>1</td>
        </tr>
        <tr>
            <td>Vías de comunicación</td>
            <td>40</td>
            <td>2.5%</td>
            <td>2</td>
        </tr>
        <tr>
            <td>Flota y equipo aéreo</td>
            <td>30</td>
            <td>3.33%</td>
            <td>3</td>
        </tr>
        <tr>
            <td>Flota y equipo férreo</td>
            <td>20</td>
            <td>5%</td>
            <td>4</td>
        </tr>
        <tr>
            <td>Flota y equipo fluvial</td>
            <td>15</td>
            <td>6.67%</td>
            <td>5</td>
        </tr>
        <tr>
            <td>Armamento y equipo de vigilancia</td>
            <td>10</td>
            <td>10%</td>
            <td>6</td>
        </tr>
        <tr>
            <td>Equipo eléctrico</td>
            <td>10</td>
            <td>10%</td>
            <td>7</td>
        </tr>
        <tr>
            <td>Flota y equipo de transporte terrestre</td>
            <td>10</td>
            <td>10%</td>
            <td>8</td>
        </tr>
        <tr>
            <td>Maquinaria, equipos</td>
            <td>10</td>
            <td>10%</td>
            <td>9</td>
        </tr>
        <tr>
            <td>Muebles y enseres</td>
            <td>10</td>
            <td>10%</td>
            <td>10</td>
        </tr>
        <tr>
            <td>Equipo médico científico</td>
            <td>8</td>
            <td>12.5%</td>
            <td>11</td>
        </tr>
        <tr>
            <td>Envases, empaques y herramientas</td>
            <td>5</td>
            <td>20%</td>
            <td>12</td>
        </tr>
        <tr>
            <td>Computadores y equipos de oficina</td>
            <td>5</td>
            <td>20%</td>
            <td>13</td>
        </tr>
        <tr>
            <td>Redes de procesamiento de datos</td>
            <td>5</td>
            <td>20%</td>
            <td>14</td>
        </tr>
    </tbody>
</table>

Para calcular la depreciación se utiliza la siguiente formula:<br>
Depreciación anual = valor compra * %depreciación<br>
Y para poder calcular la depreciación de cada año lo que se hace es:
Valor activo = valor activo anterior - Depreciación anual<br>
Esto se repite la cantidad de veces que indique la vida útil y se tendrá el calculo completo
###### Ejemplo:
* Activo: computador
* Tipo de activo: Computadores y equipos de oficina
* Valor compra: $2.000.000
* %depreciación: 20%
* Vida útil: 5 años

Depreciación anual = 2.000.000 * (20 / 100) = 400.000<br>
Valor activo 1 = 2.000.000 - 400.000 = 1.600.000<br>
Valor activo 2 = 1.600.000 - 400.000 = 1.200.000<br>
Valor activo 3 = 1.200.000 - 400.000 = 800.000<br>
Valor activo 4 = 800.000 - 400.000 = 400.000<br>
Valor activo 5 = 400.000 - 400.000 = 0<br>

### Descripción de la API
Para mayor control o acceso de la API o de la base de datos para validaciones se puede hacer los siguientes pasos:
* Ejecutar la aplicación
* La documentación de la API se puede encontrar en [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
* Si se desea consultar la base de datos H2 en memoria, se puede encontrar en [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  verificar que en JDBC URL diga: [jdbc:h2:mem:test]() de no ser asi colocarlo, Usuario es: [sa]() y la contraseña es vacía.
#####
Existen cuatro métodos en la API los cuales son:
#### Crear
Este método permite crear nuevos registros de activos bajo el path: [http://localhost:8080/assetdepreciation/create](http://localhost:8080/assetdepreciation/create)
el cual tiene los siguientes campos:
* "idActivo": Número entero (Integer)
* "serial": Texto (String - tamaño: 1, 10)
* "nombre": Texto (String - tamaño: 1, 50)
* "descripcion": Texto (String - tamaño: 0, 100)
* "fechaCompra": Fecha (LocalDate)
* "valorCompra": Número entero o decimal (Double)
* "depreciacion": Número entero o número entero en texto (Depreciation - clase personalizado tipo Enum)

Hace uso del método [POST]() de HTTP con el Header "Content-Type" - "application/json" para permitir que el body se ingrese
los datos del activo donde el único dato a tener más cuidado es el que se llama "depreciacion" ya que este solo permite
valores entre 0 y 14 de lo contrario mostrara error. Otra condición es que el "serial" no puede repetirse ya que este es
un valor único en la base de datos, el campo "idActivo" no es necesario en el JSON de entada y si se agrega no será
tenido en cuenta, el campo "descripcion" es el único que no es obligatorio".<br>
La respuesta de este método muestra la fecha y hora de la petición, HTTP status, error (true si es error de lo contrario
false), mensaje y el objeto o activo creado incluyendo su depreciación anual con respecto a porcentaje de depreciación
y su vida útil según el tipo de activo.<br>
#### Listar todos los activos
Este método permite consultar todos los de activos bajo el path: [http://localhost:8080/assetdepreciation/get-all](http://localhost:8080/assetdepreciation/get-all)<br>
Hace uso del método [GET]() de HTTP.<br>
La respuesta de este método muestra la misma estructura que el metodo [Crear]() pero aquí trae todos los activos registrados
pero no incluye el cálculo de depreciación de todos los años de vida útil de cada uno puesto que la cantidad de datos a
mostrar dependen de la vida útil (Ej: Apartamento - Edificios y construcciones - % depreciación = 5% - vida útil = 20
años - se hacen 20 cálculos de depreciación con el 5%) y si hay muchos registros de este tipo, se puede volver tedioso
la lectura de la respuesta de la API por lo que para ver el cálculo de la depreciación es mejor consultar el activo por
ID o verlo cuando se crea o actualiza un registro
#### Mostrar activo por ID
Este método permite consultar un activo según su ID bajo el path: [http://localhost:8080/assetdepreciation/get-id/{id}](http://localhost:8080/assetdepreciation/get-id/1)
donde [{id}]() se debe remplazar por el valor numérico del ID del activo o registro que desea consultar.<br>
Hace uso del método [GET]() de HTTP.<br>
La respuesta de este método muestra la misma estructura que el método [Listar todo]() solo que aquí muestra solo un registro
o activo y aquí si se muestra el cálculo de depreciación de todos los años de vida útil
#### Actualizar
Este método permite actualizar un activo según su ID bajo el path: [http://localhost:8080/assetdepreciation/update](http://localhost:8080/assetdepreciation/update)
donde [{id}]() se debe remplazar por el valor numérico del ID del activo o registro que desea consultar.<br>
Hace uso del método [PUT]() de HTTP, aquí se debe tener un body con el mismo formato JSON que se utiliza en el método
[Crear]() y se siguen las mismas reglas pero aquí si es importante dejar el campo "idActivo" con valor numérico ya que de
lo contrario mostrara error.<br>
La respuesta de este método muestra la misma estructura que el método [Crear]()
#### Eliminar
Este método permite eliminar un activo según su ID bajo el path: [http://localhost:8080/assetdepreciation/delete/{id}](http://localhost:8080/assetdepreciation/delete/1)
donde [{id}]() se debe remplazar por el valor numérico del ID del activo o registro que desea eliminar.<br>
Hace uso del método [DELETE]() de HTTP.<br>
La respuesta de este método muestra la misma estructura que el método [Mostrar por ID]() solo que aquí no se muestra el
objeto eliminado sino un mensaje indicando si se pudo eliminar o no.
