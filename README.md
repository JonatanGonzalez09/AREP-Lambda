# Laboratorio Amazon Gateway y Lambda #

## Prerrequisitos ##
Se debe tener conocimientos claros de la programación Orientada a objetos, y en el manejo de estructuras en AWSEducate.

## Construido con ##
[Maven](https://maven.apache.org/): Para la gestión de dependencias.

[Spark](http://sparkjava.com/): Para la gestion de la parte de aplicacion Web.

[AWSEducate](https://aws.amazon.com/es/education/awseducate/): Para utilizar la funcion Lambda.

[Java](https://www.java.com/es/download/): Como lenguaje de programación manejado.

## Puntos a realizar ##
**1. Usando Amazon Gateway y lambda crear un servicio que reciba un parámetro numérico y retorne el cuadrado del número.**

**2. Crear una máquina virtual Linux en AWS.**
 
**3. Crear una aplicación WEB, usando Spark, Que tenga un formulario que le pida al usuario un número y le regrese el cuadrado del mismo. Esta se debe desplegar en AWS. OJO: La aplicación Web debe usar el servicio de de Amazon GateWay para calcular el valor. Configure la aplicación dentro de un grupo de auto escalabilidad.**

**4. Probar la aplicación WEB.**

**5. Entregue el código desarrollado en Github y un reporte de las pruebas.**

## Nota: No es posible probar actualmente con los links proporcionados debido a que se eliminan en _AWSEducate_ para que no consuman recursos. ##

## Desarrollo ##

### Pruebas trabajo en clase ###
**Acá observamos otra prueba calculando el valor de 7:**

![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/prueba1.png)

![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/prueba2.png)

### Pruebas Finales ###
**Creamos el Rol RoleBasicLambda**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/rol.png)

**Creamos una nueva función lambda https://ukdez6464b.execute-api.us-east-1.amazonaws.com/Beta**

### Creando la Maquina Virtual ###
**Creamos una instancia de una EC2 que contenga Java**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/instanciaEC2.png)

**Configuramos el puerto 4567 en la seguridad:**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/protocolo.png)

**Luego nos conectamos por _ssh_ al EC2:**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/ssh.png)

**Ahora clonamos nuestro repositorio en la instancia de la EC2**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/clone.png)

**Ponemos a ejecutar nuestro _.jar_ en la instancia de EC2**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/jar.png)

**Ahora probamos que nuestra aplicación este corriendo en la instancia EC2 y utilizando el rol IAM y habiendo configurado el puerto por el que queremos que corra la aplicación en este caso 4567**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/pruebaFinal1.png)

**Para el ejemplo digitamos el numero 8**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/pruebaFinal2.png)

**Como resultado nos da 64, que lo consulta en la función _lambda square_ realizada anteriormente**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/pruebaFinal3.png)

**Realizamos otra prueba con un número negativo, en esta caso -3:**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/pruebaFinal4.png)

**Nos da como resultado 9, como se puede ver:**
![](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/Images/pruebaFinal5.png)

## Licencia ##
Este proyecto cuenta con la licencia [**GNU General Public License v3.0**](https://github.com/JonatanGonzalez09/AREP-Lambda/blob/master/LICENSE)

## Autor ##
Jonatan Esteban Gonzalez Rodriguez
