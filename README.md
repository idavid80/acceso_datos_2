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

## Indice
### :books: Index

- [Requisitos](#Requisitos)
- [Video](#Video)
- [Solución planteada para el ejercicio](#Solucion)
- [Dependencias](#Dependencias)
- [Contribuciones](#Contribuciones)
- [Instalaciones](#Instalaciones)
- [Estructura](#Estructura)
- [Roadmap](#bicyclist-Roadmap)
- [FAQ](#thinking-FAQ)
- [License](#page_facing_up-License)
- [Biografía](#Biografía)
- [Contact](#email-contact)



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

Para ver la demostración de la app en funcionamiento puede pulsar en las siguientes imagenes para ver los videos de demostración.


| Base de Datos | Vídeo |
| ------------------------------------ | --------- |
|<img align="center" src="https://exist-db.org/exist/apps/homepage/resources/img/existdb.gif" width="100" alt="ExistDB">|[![ExistDB](https://img.freepik.com/free-vector/modern-red-video-media-player-template_1017-23409.jpg)](https://youtu.be/efk1yyXK5rI "Vídeo ExistDB")|
| Hola|[![Object DB parte 1](https://dbdb.io/media/logos/objectdb.png.280x250_q85.png)](https://youtu.be/dsSX9mO604s "Demostración ObjectDB parte 1")|
### Ver demostración ExistDB
<p align="center">
    <a href="https://youtu.be/efk1yyXK5rI">
        <img src="https://img.freepik.com/free-vector/modern-red-video-media-player-template_1017-23409.jpg"/>
    </a>
</p>

<iframe width="320" height="180" src="https://www.youtube-nocookie.com/embed/FEa2diI2qgA" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen="1"></iframe>


| Base datos | Video|
|---|---|
| **ObjectDB** | [![Object DB parte 1](https://dbdb.io/media/logos/objectdb.png.280x250_q85.png)](https://youtu.be/dsSX9mO604s "Demostración ObjectDB parte 1") [![Object DB parte 1](https://dbdb.io/media/logos/objectdb.png.280x250_q85.png)](https://youtu.be/dsSX9mO604s "Demostración ObjectDB parte 1")|

<p align="center">
    <a href="https://youtu.be/dsSX9mO604s">
        <img src="https://dbdb.io/media/logos/objectdb.png.280x250_q85.png"/>
    </a>
</p>

<p align="center">
    <a href="https://youtu.be/ePjfWtgJYzg">
        <img src="https://dbdb.io/media/logos/objectdb.png.280x250_q85.png"/>
    </a>
</p>
</div>

[![Object DB parte 1](https://dbdb.io/media/logos/objectdb.png.280x250_q85.png)](https://youtu.be/dsSX9mO604s "Demostración ObjectDB parte 1")

### Ver demostración MongoDB
<p align="center">
    <a href="https://youtu.be/7VvJeQDOOZo">
        <img src="https://img.freepik.com/free-vector/modern-red-video-media-player-template_1017-23409.jpg"/>
    </a>
</p>

### Ver demostración JasperSoft
<p align="center">
    <a href="https://youtu.be/b5Mlb2rSKFM">
        <img src="https://img.freepik.com/free-vector/modern-red-video-media-player-template_1017-23409.jpg"/>
    </a>
</p>

<a id="Solucion"></a>

##  Solución planteada para el ejercicio

#### Base de datos existDB (XML)

Realizar una base de datos a partir de una api que nos genere preguntas con una lista de posibles respuestas que nos permita obtener unos test para examenes.


#### Bases de datos ObjectDB (Objeto relacional)

Relizar una base de datos de alumnos de un centro de formación, el curso que realizan y una lista de las asgnaturas de cada curso.

#### MongoDB

Obtener una base de datos de los alumnos, el curso y que almacene una lista de las notas obtenidas por asignaturas y su calificación media por asignatura. 

#### Jasper Report

[Jasper Tutorial](https://github.com/LaMalditaProgramadora)

Realizar un informe con


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


    
**Commit Your Changes**

- Commit your changes with a _clear commit message_. 
  e.g `git commit -m "Fix login bug by updating auth logic"`.

**Submit a Pull Request**

- Push your branch and changes to your fork on GitHub.
- Create a pull request, compare branches and submit.
- Provide a detailed description of what changes you've made and why. 
  Link the pull request to the issue it resolves. 🔗
    
**Review and Merge**

- Our team will review your pull request and provide feedback or request changes if necessary. 
- Once your pull request is approved, we will merge it into the main codebase 🥳

$~$

### :rocket: Deployment
- You can write your deployment instructions here.

$~$

<a id="Estructura"> </a>

## Estructura

### Estructura Archivos

### Endpoint ExistDB

### ObjectDB


#### crear-asignatura
* http://localhost:8000/evaluacion/crear-asignatura?asignatura=Acceso_datos&curso=DAM
* **Metodo: GET**
* **Parametros**
  * asignatura = String
  * curso = String



#### prueba-hash
* http://localhost:8000/evaluacion/crear-asignatura?asignatura=Acceso_datos&curso=DAM
* **Metodo: GET**
* **Parametros**
  * asignatura = String
  * curso = String


#### mostrar-asignatura
* http://localhost:8000/evaluacion/mostrar-asignatura
* **Metodo: GET**


#### crear-alumno
* http://localhost:8000/evaluacion/crear-alumno?nombre=David&curso=DAM
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


#### mostrar-Clase Curso
* http://localhost:8000/evaluacion/mostrar-curso
* **Metodo: POST**


#### mostrar asignaturas por cursos
* http://localhost:8000/evaluacion/mostrar-asignaturas-cursos?curso=DAM
* **Metodo: GET**


#### mostrar-asignaturas-cursos
* http://localhost:8000/evaluacion/mostrar-asignaturas-cursos
* **Metodo: GET**

### XML

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


#### Get-test-api
* http://localhost:8000/evaluacion/listado-api
* **Metodo: POST**


### MongoDB

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
* http://localhost:8000/evaluacion/mongo/curso-estudiante?id_estudiante=65d0b14abf619634746c8c35
* **Metodo: POST**

Query Params
id_estudiante
65d0b14abf619634746c8c35
POST
asignaturas-estudiante
http://localhost:8000/evaluacion/mongo/asignaturas-estudiante?id_estudiante
﻿

Query Params
id_estudiante
GET
prueba controlador
http://localhost:8000/evaluacion/prueba
﻿

POST
jasper
http://localhost:8000/jasper/prueba

* Crear pregunta

* Crear Respuesta

* Mostrar test

### ObjectDB

Para esta tarea lo ideal sería crear tres Clases con la anotación ***Entity***:

"""
@Entity
public class Asignatura {

	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String asignatura;
	    
	    @ManyToOne
	    private Curso curso;
}

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "curso")
    private List<Asignatura> asignaturas;

    // Getters and setters
}

@Entity
public class Asignatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    // Getters and setters

    @ManyToOne
    private Curso curso;
}
"""

Pero nosotros vamos a crear otra estructura para poder darle uso al HasMap para su posterior implementación en MongoDB.
Con nuestra estructura, sólo vamos a necesitar dos clases:

"""
@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "curso_id")
	private String curso;

	List<String> asignaturas = new ArrayList<>();

	// set y get
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public List<String> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<String> asignaturas) {
		this.asignaturas = asignaturas;
	}

}


@Entity
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String asignatura;
	private String curso;

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}

"""

### MongoDB

Para nuestro modelo de mongo vamos a crear dos colecciones que van a estar

```
.
├── client
│   ├── public
│   │   ├── favicon.ico
│   │   └── index.html
│   ├── src
│   │   ├── App.css
│   │   ├── App.js
│   │   ├── index.js
│   │   └── logo.svg
│   └── package.json
├── server
│   ├── controllers
│   │   └── userController.js
│   ├── models
│   │   └── userModel.js
│   ├── routes
│   │   └── userRoutes.js
│   ├── app.js
│   └── package.json
├── .gitignore
├── LICENSE
└── README.md
```

### :bicyclist: Roadmap
_Current version number_
- [x] Introduction of Concept
- [x] Feature 1
- [ ] Feature 2
- [ ] Revisit Feature 1
    - [ ] Improve XYZ
    - [ ] Revamp CSS

$~$

### :thinking: FAQ
Something that works quite well if you want to include an FAQ  here are **toggle lists.** 

<details>
  <summary>Toggle List Example</summary>
  
  ### Title
  1. ABC
  2. DEF
     * Hello
     * Bye

  ### Here's the MARKDOWN template to build your own toggle lists
  ```
    <details>
    <summary>Toggle List Example</summary>
    
    ### Heading
    1. ABC
    2. DEF
       * Hello
       * Bye
    </details>
  ```

</details>

If you have a documentation platform/file, you can change the title to _Documentation_ and add the link for it here.

$~$

### :page_facing_up: License
- State the license chosen and link it here.
- You can also provide a justification for the type of license chosen if you believe it to be necessary.

$~$

<a id="Biografía"> </a>

## Biografía

### Documentacion ExistDB

* [Descarga](https://github.com/eXist-db/exist/releases/tag/eXist-6.2.0)

* [Guia Instalacion](http://exist-db.org/exist/apps/doc/basic-installation)

* [Dependencias](https://central.sonatype.com/artifact/org.exist-db/exist-xqts-runner_2.13)

### Documentacion oficial ObjectDB



### :email: Contact 
- Email and social media links.
- Head over to [here](https://github.com/alexandresanlim/Badges4-README.md-Profile#-social-)
  * Copy paste the social links you enjoy and drop them below (make sure to change the `href` to your own links

<p align="left">
<a href="https://twitter.com/fernandezbap" target="blank"><img align="center" src="https://img.shields.io/badge/X-000000?style=for-the-badge&logo=x&logoColor=white" alt="fernandezbap" /></a>
</p>
<p align="left">
<a href="https://www.linkedin.com/in/baptiste-fernandez-%E5%B0%8F%E7%99%BD-0a958630/" target="blank"><img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white"  /></a>
</p>


Conclusiones:

Para ObjectDB he comprobado que existe un tipo de lista LinkedList, que quizás me hubiera venido mejor conocerla al principio del proyecto.




estudiante {
	nombre: "Juan"
	apellido: "Lopez"

	curso: {
	nombreCurso: "1 ESO"
	asignaturas: ["Matemáticas", "Lenguaje"]
	}

	calificaciones: {[
		id_test: 54,
		curso: "1 ESO"
		asignatura: "Matemáticas",
		nota: 6
	],
	[
		id_test: 58,
		curso: "1 ESO",
		asignatura: "Lenguaje",
		nota: 4
	],
	[
		id_test: 88,
		curso: "1 ESO",
		asignatura: "Lenguaje",
		nota: 8
	]
	}
}

