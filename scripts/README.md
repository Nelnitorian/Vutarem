En este directorio hay dos scripts que ayudan a la gestión del gestor de base de datos.

# dbsetup.sh

Comprueba si el gesto de base de datos postgresql está instalado. En caso de no estarlo trata de instalarlo. 
Después crea el usuario "admin", mediante el cual se harán todos los accesos a la base de datos.
```
bash dbsetup.sh
```

# dbinit.sh

Inicializa y resetea las tablas necesarias para que el proyecto funcione correctamente.
```
bash dbinit.sh
```
