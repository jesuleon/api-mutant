API - mutant
==================

Aplicación Mutant usando Google Cloud Endpoints en Java.

## Productos
- App Engine

## Lenguaje
- Java

## APIs
- Google Cloud Endpoints
- Google App Engine Maven plugin

## Instrucciones

1. Para postear un mutante ejecutar el servicio POST: http://xxx.xxx.xxx/api/mutant

    Body:
        `{
            "dna": ["TTGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
        }`

   Este servicio retornará 200-Ok si el dna enviado es un mutante y 403-Forbidden en caso contrario

1. Para ver las estadísticas de las verificaciones de los ADN enviados ejecutar el servicio GET: http://xxx.xxx.xxx/api/mutant/stats, este retornará un JSON como el que se puede ver a continuación:

    JSON:
        `{
            "count_mutant_dna": 5,
            "count_human_dna": 10,
            "ratio": 0.5
        }`
    