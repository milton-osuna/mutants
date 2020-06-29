# mutants
Mutants Challenge

Especificaciones TECNICAS
 - Tecnologias
 * SPRING BOOT
 * MYSQL
 * MAVEN
 * JUnit TEST
 
 
 Comentarios:
  Tarea interesante, Al empezar el desarrollo me di cuenta que hace poco cambie mi pc y siendo sincero pase mas tiempo configurando cosas que programando en si. Estime un tiempo de 7 dias de desarrollo para esta API de los cuales quizas estuve 3 dias dedicado a configuraciones sobre la marcha. Estaba familiarizado con el entorno que rodea java
  por experiencias anteriores asi que no tuve mayores dificultades para continuar avanzando a pesar de lo mencionado anteriormente. 
  
  
  
  - Instrucciones. 
  * Compilacion y ejecucion ( se necesita JDK 11 Y Maven ) //REQUISITO
  * Contar con instancia de MYSQL //REQUISITO 
  
  -Ejecucion
      Para ejecutar la api local se necesita una instancia MYSQL o configurar las variables de sistema presentes en aplication.properties
  
      Ejecutar la clase principal MutantsApiApplication en IDE otra opcion es dirigirse a la carpeta raiz del proyecto y ejecutar comando de MAVEN
      mvn spring-boot:run
      
      
     URL API
* URL local: http://localhost:8080

* URL Service Amazon AWS:  http://mutants-env-1.eba-baxnbsjr.us-east-2.elasticbeanstalk.com/


- SERVICIOS

* Caso Mutante 

POST http://mutants-env-1.eba-baxnbsjr.us-east-2.elasticbeanstalk.com/mutant

Request Body {“
dna”:["ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"]
}


Response  - 200 OK


* Caso HUMANO DNA

POST: http://mutants-env-1.eba-baxnbsjr.us-east-2.elasticbeanstalk.com/mutant

Request Body {“
dna”:["ATGCGA", "CTGTTC", "TTATTT", "AGAATG", "CCTCTA", "TCACTG"]
}

RESPONSE 403- {
    "message": "Mutant DNA detected! Access Granted"
}


 * Caso Validar DNA

POST: http://mutants-env-1.eba-baxnbsjr.us-east-2.elasticbeanstalk.com/mutant

Request Body {“
dna”:["ATGCGA", "CTGTGC", "TTZTGT", "AGAATG", "CXCCTA", "TCACTG"]
}
     Response  - 403 -  {
    "message": "
Error! Contaminated DNA, test again."}



- Obtener Estadisticas:

* GET : http://mutants-env-1.eba-baxnbsjr.us-east-2.elasticbeanstalk.com/stats/
Response 200 OK- 
{"count_mutant_dna":2,"count_human_dna":1,"ratio":0.6666667}




  
