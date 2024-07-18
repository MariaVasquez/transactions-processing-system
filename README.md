# Sistema de Procesamiento de Transacciones

Sistema para ejecutar las operaciones de transacción de información, se realiza diagrama de secuencia inicial para la explicación breve de su funcionamiento

[Diagrama secuencia procesamiento de transacciones](https://app.diagrams.net/#HMariaVasquez%2Ftransactions-processing-system%2Fmain%2Ftransaction-processing-system.drawio#%7B%22pageId%22%3A%222YBvvXClWsGukQMizWep%22%7D)

## Ejecución del sistema
Para realizar la ejecución del sistema se necesita:

> - Java versión 21 
> - Maven versión 3.8 en adelante
> - Postman como herramienta para consumo de servicios
> - JMeter para la validación de transacciones por minuto
> - Intellij como IDE para ejecución local

se deje ejecutar el docker-compose ubicado en la ruta 

> src\main\resource\deployment

donde se ejecuta el comando

````
docker-compose up -d
````

en este se encontrarán las conexiones de la base de datos y el Broker de mensajería

## Guía de Uso y ejemplo de envio de solicitud

- Para el servicio de guardado transaccional el curl de ejemplo sería:

````
curl --location 'http://localhost:8080/api/save-transaction' \
--header 'Content-Type: application/json' \
--data '{
    "deviceNumber":21343,
    "userId": "8732UYB",
    "geoPosition": "102938",
    "amount": 1000
}'
````

al agregarlo en la herramienta para consumo de servicios como por ejemplo postman, este va a agregar toda la información necesaria para su consumo.

- Para la ejecución de la tarea diaría al correr el sistema ya este va a empezar a hacer el funcionamiento para el guardado del documento.

## Estrategias Utilizadas

- Patrón de diseño DAO (Data Access Object): este se utiliza como estrategia para abstraer la lógica de acceso a datos de la lógica de negocio.
- Principios SOLID: se recalca el uso de los principios para mejorar la calidad de sofware.
- Patrón Queue-Based Load Leveling: inicialmente su alcance es realizar la producción de mensajes de transacciones pero adicional se realiza la escucha de estos.

## Consideraciones asumidas

Se agrega la escucha de mensajería para garantizar que el mensaje fue enviado correctamente al realizar el consumo de procesamiento de transacciones