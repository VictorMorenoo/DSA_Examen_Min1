Minimo 1 2020Tardor

Los alumnos de 3A y en particular aquellos que están matriculados de DSA están muy
concienciados con la situación actual provocada por la pandemia del covid-19 y, han decidido
aportar su grano de arena, desarrollando una aplicación que permita simplificar la gestión de
las muestras de los test PCR y antígenos y la asignación a los diferentes laboratorios clínicos.
Después una lluvia de ideas, se ha propuesto implementar esta aplicación
SE PIDE:
PARTE I: 5 puntos
1.- Especificación de un componente (Covid19Manager.java,<<interfaz>>) que tiene las
siguientes operaciones:
● Crear una persona en el sistema. De cada persona sabemos: identificador,
nombre y apellidos, fecha de nacimiento (o edad) y una valoración del nivel de
salud de la persona (A, B, C, D) siendo ‘A’ el nivel de enfermedad menos
avanzada y D el nivel de enfermedad más avanzada. La consecuencia de esta
operación es que se crea un nuevo usuario en el sistema
● Extraer una muestra sobre una persona y enviarla a un laboratorio. De cada
muestra sabemos: un identificador que lo identifica unívocamente, un
identificador del clínico que ha extraído la muestra, un identificador de la persona
y la fecha de extracción y el identificador del laboratorio a enviar.. El resultado de
esta acción es el envío a un laboratorio que se ha especificado.
● Procesar una muestra por parte de un laboratorio. Las muestras se almacenan a
la espera de ser procesadas y se procesan por orden de llegada. Una vez
procesada la muestra se genera un informe asociado a esa muestra:
positivo/negativo y un comentario
● Listado de muestras de un usuario procesadas (en el que se puede mostrar el
resultado y comentario)
● OPCIONAL: Crear un Laboratorio. De cada laboratorio sabemos: identificador,
nombre. La consecuencia de esta operación es que el número de laboratorios se
incrementará en una unidad. En caso de no implementarse esta operación se
puede popular la estructura de laboratorios con laboratorios precargados.
2.- Implementación de una Fachada (patrón de diseño) que implemente el interfaz
definido previamente (Covid19ManagerImpl.java, clase Java).
2.1 Elección de las estructuras de datos.
● El contenedor de usuarios debe implementarse como un diccionario
(<clave, valor>).
● El contenedor de laboratorios será un vector de Java (Array).
● Contenedor que se utilizará para las muestras pendientes de procesarse
en un laboratorio. ¿Qué estructura de datos proponéis?
● Contenedor de las muestras de un usuario: lista encadenada de
muestras.
2.2 La fachada deberá implementarse como un Singleton .
2.3 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J
que muestre el valor de los parámetros al inicio de los métodos y al final.
También debe contemplarse trazas de otros niveles (ERROR o FATAL)
3.- Implementación de un test (JUNIT) sobre el componente (Covid19Manager) con los
siguientes puntos:
- método setUp que inicializa la estructura de datos y crea un juego de pruebas
inicial.
- método tearDown que libera los recursos. Tened en cuenta que al tratarse de
un singleton, debéis ofrecer una operación para inicializar/limpiar las estructuras de
datos
- método de test para crear un nuevo usuario
- método de test para procesar una muestra
PARTE II: 5 puntos
1.- Definir (servicio, operaciones, rutas, métodos HTTP, peticiones, respuestas, códigos
de respuesta) e implementar un servicio REST que permita realizar las operaciones
especificadas en la primera parte del ejercicio. Todas las operaciones deben retornar
“objetos de transferencia” y evitar ciclos/relaciones
NOTA: El servicio debe utilizar el componente construido en el punto anterior
(Covid19Manager)
NOTA:
- No se permite el uso de System.out.println
- La gestión de dependencias (librerías) debe realizarse ÚNICAMENTE con Maven:
junit, log4j, etc
- La entrega debe realizarse sobre un repositorio de GITHUB. En dicho repositorio debe
existir un fichero readme.md que describa el proyecto. NO SE DEBE REALIZAR
NINGÚN PUSH hasta finalizar el ejercicio para evitar compartir el código entre
compañeros. Si se comprueba un porcentaje de similitudes del código
alto se presentará el caso al jefe de estudios con la propuesta de
suspenso global de la asignatura.
- Adicionalmente debéis realizar una grabación en vídeo de vuestra pantalla. En
concreto debéis mostrar el funcionamiento del ejercicio desarrollado y enseñar/explicar
con vuestra propia voz el código de vuestra aplicación