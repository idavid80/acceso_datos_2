# Ejercicio Acceso a Datos.

<p align="center">
    <!--     You can add your logo here -->
    <img src="https://logovtor.com/wp-content/uploads/2020/11/cesur-centro-oficial-de-formacion-profesional-logo-vector.png" />
</p>
<p align="center">
  <!-- You can add your badges here -->
  <!-- If you have never added badges, head over to https://img.shields.io/badges/static-badge, follow the instructions and generate URL links to add below -->
  <img src="https://img.shields.io/badge/STARS-20K-green"  />
  <img src="https://img.shields.io/badge/FORKS-15K-blue"  />
  <img src="https://img.shields.io/badge/npm-v.0.21.0-red"  />
  <img src="https://img.shields.io/badge/LICENSE-MIT-green"  />
</p>

## :books: Indice

- [Requisitos](#Requisitos)
- [Video](#Video)
- [Solución planteada para el ejercicio](#Solucion)
- [Dependencias](#Dependencias)
- [Contribuciones](#Contribuciones)
- [Instalaciones](#Instalaciones)
- [Estructura](#Estructura)
- [Endpoint](#Endpoint)
- [Información del proyecto](#proyecto)
- [Concluciones](#Conclusiones)
- [Biografía](#Biografía)



<a id="Requisitos"> </a>

## Requisitos
1. Uso de Base de Datos Objeto Relacional - ObjectDB
2. Uso de Base de Datos XML - ExistDB
3. Uso de Base de Datos NoSQL - MongoDB
4. Creación de documentos PDF con JasperReports
5. Uso de HashMap
6. Para cada una de las bases de datos, utilizar al menos una clase que contenga un atributo con una lista de otra clase (como los ejemplos que hemos hecho en clase) 
7. Documentación: Explicación de los nuevos módulos desarrollados, o en caso de ser una aplicación nueva, de toda la aplicación. Y debe ser en PDF.
 - Los trabajos que se entreguen en grupo, los requisitos deben ser dobles, es decir, ambas personas deben hacer un módulo con cada una de los requisitos pedidos. 
 - Video explicativo de la aplicación mostrando su uso y cómo se ha desarrollado. Tiempo máximo: 5 minutos. 



<a id="Video"></a>

##  Video: Demo 

Para ver los videos de la app en funcionamiento, puede pulsar en las siguientes imagenes de la tabla.


| Base de Datos | Vídeo |
| ---- | ---- |
|<img align="center" src="https://exist-db.org/exist/apps/homepage/resources/img/existdb.gif" width="100" alt="ExistDB">|	[![ExistDB](https://cdn-icons-png.flaticon.com/256/4503/4503949.png)](https://youtu.be/efk1yyXK5rI "Vídeo ExistDB")|
|<img align="center" src="https://dbdb.io/media/logos/objectdb.png.280x250_q85.png" width="100" alt="ObjectDB">|[![ObjectDB](https://cdn-icons-png.flaticon.com/256/4503/4503949.png)](https://youtu.be/dsSX9mO604s "Vídeo ObjectDB 1ª parte")  [![ObjectDB](https://cdn-icons-png.flaticon.com/256/4503/4503949.png)](https://youtu.be/ePjfWtgJYzg "Vídeo ObjectDB 2ª parte")|
|<img align="center" src="https://cdn.freebiesupply.com/logos/thumbs/2x/mongodb-logo.png" width="100" alt="MongoDB">|[![MongoDB](https://cdn-icons-png.flaticon.com/256/4503/4503949.png)](https://youtu.be/7VvJeQDOOZo "Vídeo MongoDB")|
|<img align="center" src="https://pbs.twimg.com/profile_images/1597717009134911490/dT4XWf9__400x400.jpg" width="100" alt="JasperSoft">|[![JasperSoft](https://cdn-icons-png.flaticon.com/256/4503/4503949.png)](https://youtu.be/b5Mlb2rSKFM "Vídeo JasperSoft")|


<a id="Solucion"></a>

##  Solución planteada para el ejercicio

#### Base de datos existDB (XML)

Realizar una base de datos a partir de una api que nos genere preguntas, con una lista de posibles respuestas, que nos permita obtener unos test para examenes. Ver el [Repositorio de la API](https://github.com/idavid80/AccesoDatos/tree/master)


#### Bases de datos ObjectDB (Objeto relacional)

Relizar una base de datos de alumnos de un centro de formación, el curso que realizan y una lista de las asgnaturas de cada curso. La creación de los alumnos y asignaturas se realizarán por peticiones al controllador. En este ejercicio se utilizará estructura de datos HashMap (requisito punto 5 del ejercicio) para obtener un filtro y estructura de asignaturas por curso.

#### MongoDB

Obtener una base de datos de los alumnos, el curso y que almacene una lista de las notas obtenidas por asignaturas y su calificación media por asignatura. Los datos de los alumnos y las asignaturas así como la de los cursos se obtendrán de la base de datos ObjectDB que tiene este proyecto.

#### Jasper Report

Realizar un informe con una lista de los alumnos de la base de datos objectDB y de las asignaturas que estén cursando.


<a id="Dependencias"> </a>

## Dependencias SpringBoot

#### Base de datos existDB
<details><summary>Ver dependencias</summary>

~~~
	<!-- Repositorios para existDB -->
<repositories>
	<repository>
		<id>xqj</id>
		<name>XQJ Maven Repository</name>
		<url>http://xqj.net/maven</url>
	</repository>
</repositories>
<dependencies>
	<dependency>
		<groupId>net.sf.xmldb-org</groupId>
		<artifactId>xmldb-api</artifactId>
		<version>1.7.0</version>
	</dependency>
	<dependency>
		<groupId>org.exist-db</groupId>
		<artifactId>exist-core</artifactId>
		<version>5.0.0</version>
		<scope>runtime</scope>
	</dependency>
	<dependency>
		<groupId>com.xqj2</groupId>
		<artifactId>xqj2</artifactId>
		<version>0.1.0</version>
	</dependency>
	<dependency>
		<groupId>javax.xml.xquery</groupId>
		<artifactId>xqj-api</artifactId>
		<version>1.0</version>
	</dependency>
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web-services</artifactId>
	</dependency>
</dependencies>
~~~
</details>

#### Bases de datos ObjectDB
<details><summary>Ver dependencias</summary>

~~~
<dependency>
	<groupId>com.objectdb</groupId>
	<artifactId>objectdb</artifactId>
	<version>2.8.5</version>
</dependency>
<dependency>
	<groupId>org.eclipse.persistence</groupId>
	<artifactId>javax.persistence</artifactId>
	<version>2.1.0</version>
</dependency>
<dependency>
	<groupId>javax.transaction</groupId>
	<artifactId>jta</artifactId>
	<version>1.1</version>
</dependency>
~~~
</details>

#### MongoDB
<details><summary>Ver dependencias</summary>

~~~
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
~~~
</details>

#### JasperReports
<details><summary>Ver dependencias</summary>

~~~
<!-- JasperReport -->
<dependency>
	<groupId>net.sf.jasperreports</groupId>
	<artifactId>jasperreports</artifactId>
	<version>6.20.0</version>
</dependency>
~~~
</details>

<a id="Contribuciones"> </a>

## Colaboraciones

Este trabajo ha sido realizado de forma individual.
    
<a id="Instalaciones"> </a>
    
## Instalaciones


### eXistDB

#### Instalar eXistDB en Ubuntu

descargar archivo ‘exist-installer-6.2.0.jar’

y ejecutar 

> java -jar exist-installer-6.2.0.jar

> [!NOTE]
>
> [Guia instalación ObjectDB](https://www.objectdb.com/download)

La instalación por defecto es usuario admin y sin contraseña.

#### Inicialización

Comandos

> java -jar start.jar 

> sudo sh startup.sh

> [!IMPORTANT]
> La aplicacion se despliega en:
> http://localhost:8080/exist/apps/dashboard/index.html
> 
> La ruta de instalación en Linux es: /usr/local/eXist-db/


### ObjectDB

#### Instalación

Descargar, abrir carpeta bin donde se encuentran los archivos necesarios.

Para conectar el servicio ejecutar los archivos server.sh o objectdb.jar

> sudo sh server.sh start

> sudo java -jar objectdb.jar

Para entrar en el interfaz gráfico de la base de datos, ejecutar el archivo explorer.jar.

> sudo java -jar explorer.jar

 
### MongoDB

Descarga, instalación y ejecución en Linux. Otros sistemas, 

> wget https://downloads.mongodb.com/compass/mongodb-compass_1.40.4_amd64.deb
> sudo dpkg -i mongodb-compass_1.40.4_amd64.deb
> mongodb-compass

> [!NOTE]
> Para otros sistemas operativos puede consultar la página oficial de mongo.
> [ver en documentación oficial](https://www.mongodb.com/docs/compass/current/install/)
> 
> Es posible que necesitemos instalar mongodb si queremos trabajar en local. 
> [Ver guia de instalación](https://www.mongodb.com/docs/manual/tutorial/install-mongodb-on-ubuntu/#std-label-install-mdb-community-ubuntu)

#### Inicializar MongoDB

> sudo service mongod stop

<a id="Estructura"> </a>

## Estructura

### Estructura Archivos

El proyecto tiene una estructura de 7 paquetes y una carpeta.

Los paquetes están clasificados de la siguiente forma:

1. **datos:**  Contiene el archivo con la clase main de la aplicación de springboot.

2. **collection:** Contiene las clases de las colecciones de MongoDB.
	* Calificacion: Esta colección está comentada porque se utilizará para una futura funcionalidad.
	* Curso: colección que almacenará el nombre del curso y las asignaturas que contiene
	* Estudiante: Entidad con el nombre del alumno y el curso que está realizando.

3. **controller:** Contiene las clases controladores de la aplicación. En este caso, sería un archivo por tarea:
	* ControllerJasper.
	* ControllerMongoDB.
	* ControllerObjectDB.
	* ControllerXML.

4. **entities:** Almacena las entidades necesaria para el proyecto. Las clases entidades son:
	* Alumno y Asignatura para la base de datos de objectDB, de la cual van a utilizar mongoDB y JasperSoft.
	* Pregunta y Respuesta que obtendrán los datos de la API externa. 
	* PreguntaTest y RespuestaTest que contendrán las anotaciones necesarías para conectar con la base de datos XML.

5. **repository:** éste paquete está compuesto por las clases:
	* ApiRepository, que es la que se utiliza para conectar con la API externa al proyecto de la cual se obtienen los test para la base de datos XML.
	* RepositoryObjectDB que conecta con la base de datos de ObjectDB.
	* RepositoryXML, la cual es la que establece las conexiones y peticiones con ExistDB.
	* RepositoryObject que fue creada inicialmente para establecer conexiones con la base de datos ObjectDB, pero se ha dejado comentada porque para que el proyecto pueda funcionar sin generar problemas de conexiones entre las 3 bases de datos.

6. **repository.mongoDB:** paquete con los interfaces que conectan con la base de datos de mongoDB.
	* CalificacionRepository: Este interfaz está comentada porque se utilizará para una futura funcionalidad.
	* CursoRepository: interfaz para realizar peticiones con la colección Curso.
	* EstudianteRepository: interfaz para realizar peticiones con la colección Estudiante

7. **service:** paquete que almacena los servicios de la aplicacion. contiene las siguientes clases:
	* ServiceJasper: contiene el método **generarInforme** para crear archivos .pdf con una lista de alumnos y curso que están estudiando.
	* ServiceMongoDB: Interfaz que establece los servicios de crearEstudiante, crearCurso, getCursoByEstudiante, getAsignaturaEstudiante y getAll (obtiene todo los datos por estudiantes).
	* ServiceMongoDBImpl: Clase que implementa los interfaces de ServiceMongoDB.
	* ServiceObjectDB: interfaz de servicio de los métodos crearAsignatura, mostrarAsignatura, hashMapCurso, getAllAsignaturaByCurso, getAsignaturaByCurso, insertarAlumno y mostrarAlumnos.
	* ServiceObjectDBImpl: Clase que implementa los interfaces de ServiceObjectDB.
	* ServiceXML: interfaz de servicio de los métodos testXML (obtenemos un XML de los datos de la API), getTestBD (obtenemos los datos de ExistDB), insertar (almacena los datos en la base de datos) y crearArchivoXML.
	* ServiceXMLImpl: Clase que implementa los interfaces de ServiceXML.

La carpeta del proyecto es db, en la cual se almacenará la base de datos de objectDB, y los archivos .xml y .pdf que crea la aplicación.

<a id="Endpoint"> </a>

### Endpoint del proyecto

### XML
<details><summary>Ver Endpoint</summary>

#### obtener-test-xml
* http://localhost:8000/evaluacion/ver-test-xml
* **Metodo: GET**

#### insertar xml
* http://localhost:8000/evaluacion/insertar
* **Metodo: PUT**

#### obtener respuesta API
* http://localhost:8000/evaluacion/get-test-respuestas-api
* **Metodo: GET**

#### get-bbdd-test
* http://localhost:8000/evaluacion/get-bbdd-test
* **Metodo: GET**

#### get-api
* http://localhost:8000/evaluacion/get-api
* **Metodo: GET**

#### crear-archivo
* http://localhost:8000/evaluacion/crear-archivo
* **Metodo: GET**

#### get-api
* http://localhost:8000/evaluacion/get-test-api
* **Metodo: POST**

</details>


### ObjectDB
<details><summary>Ver Endpoint</summary>

#### crear-asignatura
* http://localhost:8000/evaluacion/crear-asignatura?asignatura=&curso=
* **Metodo: GET**
* **Parametros**
  * asignatura = String
  * curso = String

#### mostrar-asignatura
* http://localhost:8000/evaluacion/mostrar-asignatura
* **Metodo: GET**


#### crear-alumno
* http://localhost:8000/evaluacion/crear-alumno?nombre=&curso=
* **Metodo: POST**
* **Parametros**
  * nombre = String
  * curso = String

#### mostrar-alumno
* http://localhost:8000/evaluacion/mostrar-alumno
* **Metodo: GET**

#### mostrar-hashmap
* http://localhost:8000/evaluacion/mostrar-hashmap
* **Metodo: GET**

#### mostrar-todas-asignaturas-cursos
* http://localhost:8000/evaluacion/mostrar-todas-asignaturas-cursos
* **Metodo: GET**

#### mostrar asignaturas por cursos
* http://localhost:8000/evaluacion/mostrar-asignaturas-cursos?curso=
* **Metodo: GET**
* **Parametros**
  * curso = String

</details>


### MongoDB
<details><summary>Ver Endpoint</summary>

#### prueba
* http://localhost:8000/evaluacion/mongo/prueba
* **Metodo: GET**

#### crear-estudiante
* http://localhost:8000/evaluacion/mongo/crear-estudiante
* **Metodo: PUT**

#### crear-curso
* http://localhost:8000/evaluacion/mongo/crear-curso
* **Metodo: GET**

#### all-estudiante
* http://localhost:8000/evaluacion/mongo/all-estudiante
* **Metodo: GET**


#### curso-estudiante id
* http://localhost:8000/evaluacion/mongo/asignaturas-estudiante?id_estudiante=
* **Metodo: POST**
* **Parametros**
  * id_estudiante = String

</details>

#### Jasper
<details><summary>Ver Endpoint</summary>

http://localhost:8000/jasper/prueba
* **Metodo: POST**

</details>


<a id="proyecto"> </a>

### Información del proyecto

### ExistDB

Para esta tarea, es necesarío tener levantada la api desde la que se extraen las preguntas. Es posible descargar la api desde el este [repositorio](https://github.com/idavid80/AccesoDatos/tree/master). Las funciones de este proyecto, permite generar un archivo xml desde la api, insertarlo en la base de datos existDB y realizar consultas sobre la API y la base de datos. El archivo .xml creado, se almacena en la carpeta db del proyecto.

### ObjectDB

Para esta tarea lo más apropiado, quizás sería crear tres Clases ***Entity*** (Asignatura, Curso y Asignatura) con la anotaciónes ManyToOne y OneToMany.

Pero nosotros vamos a crear otra estructura para poder darle uso al HasMap. Con nuestra estructura, sólo vamos a necesitar dos clases. La primera, será una clase Asignatura, que guardará el nombre de la asignatura y el curso a la que pertenece. La segunda entidad, será una clase alumno que almacenará el nombre del alumno, el curso que está estudiando y una lista de string de las asignaturas (también se podría haber creado una lista de la clase Asignatura)

En la aplicación se puede almacenar los datos de alumnos, cursos y asignaturas, a través por peticiones a través de sus endpoints. La base de datos se almacena en la carpeta db del proyecto.

### MongoDB

Para nuestro modelo de mongoDB vamos a crear dos colecciones que van a estar dentro del paquete paquete collection. Una colección es Curso donde se almacenará una lista de asignatura por curso. La otra colección es Estudiante, que almacenará el nombre del alumno y la colección Curso.
Los datos de los estudiantes, así como el de los cursos que realizan y sus asignaturas, son extraidos de la base de datos de objectDB, que están almacenados en la carpeta db del proyecto.

<a id="Conclusiones"> </a>

### Conclusiones

El proyecto esta terminado, funcionando y cumple con los requisitos mínimos exigidos. Aún así, quedan pendiente muchas mejoras, así como la implementación de estructuras de control que no permitan crear duplicidades en la base de datos, crear métodos de testeo de la aplicación, etc.

Problemas destacados:

* obtención de calores null en peticiones con ExistDB, es posible que el prolema esté con las anotaciones de XML, o en la query por xpath.
* Implementación sin terminar de mongoDB al no implementar metodos aggregate o match para poder establecer una mejor muestra en la obtención de los datos de alumnos.
* Problema con la extracción de datos de objectDB, obtenemos valores null en la lista de asignaturas. El cambio de lista asignatura por lista string no ha funcionado. Pero el crear una iteración con estructura for con un método System.out.print, ha solucionado el problema 🤔
* Para ObjectDB he comprobado que existe un tipo de lista LinkedList, que quizás me hubiera venido mejor conocerla al principio del proyecto.

<a id="Biografía"> </a>

## Biografía

### Documentacion ExistDB

* [Descarga](https://github.com/eXist-db/exist/releases/tag/eXist-6.2.0)

* [Guia Instalacion](http://exist-db.org/exist/apps/doc/basic-installation)

* [Dependencias](https://central.sonatype.com/artifact/org.exist-db/exist-xqts-runner_2.13)

### Documentacion oficial ObjectDB
* [Guia Oficial](https://www.objectdb.com/)

### JasperReport

* [Jasper Tutorial](https://github.com/LaMalditaProgramadora)

### MongoDB

* [Modelo de estructura](https://learn.mongodb.com/learn/dashboard)
