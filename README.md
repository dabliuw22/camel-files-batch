# Apache Camel Files

En este proyecto se utiliza el framework Apache Camel para hacer integración, moviendo loa archivos de una carpeta a otra.

1. Dependencia de Apache Camel:

```
compile('org.apache.camel:camel-core:2.22.0')
```

2. Conceptos de Apache Camel:

	* Message: Es la data a transferir por una ruta.
	* Exchange: Es el contenedor del mensaje.
	* Endpoint: Es el canal a travez del cual el sistema envia o recibe mensajes.
	* Component: Fabrica de endpoints.
	* Processor: Se utiliza para agregar lógica personalizada a una ruta.