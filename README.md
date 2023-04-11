El trabajo se va a organizar en distintas ramas.

Cada uno creará la suya y trabajará ahí. Una vez esté completa y haya comprobado la compatibilidad con el main actual, hace un merge al main.

Se recuerda que es recomendable añadir tests para facilitar encontrar fallos durante el desarrollo. Tenéis un ejemplo en src/test/java/com/vutarem/common/FabricaDniTest.java

Para ejecutar los tests, usar:
```
mvn test
```

Para ejecutar el código, modificar el pom.xml para cambiar la clase principal. Luego, ejecutar:
```
mvn exec:java
```