PWD=$(pwd)
CMD_FIN='read -p "Presiona enter para salir"'
VERSION='0.0.1'

# Se compila el proyecto
mvn clean compile package

# Se inicializa la base de datos
gnome-terminal -- bash -c 'cd $PWD/scripts && bash dbinit.sh && $CMD_FIN'

sleep 1

#Se lanza rmi
gnome-terminal -- bash -c 'cd $PWD/target/classes && rmiregistry -J-Djava.net.preferIPv4Stack=true 54321 && $CMD_FIN'

sleep 1

#Se lanza el servidor
gnome-terminal -- bash -c 'cd $PWD && java -cp target/vutarem-$VERSION.jar -Djava.security.policy=servidor.permisos -Djava.rmi.server.hostname=localhost com.vutarem.servidor.Servidor 54321 && $CMD_FIN'

sleep 1

#Se lanza la interfaz gráfica
gnome-terminal -- bash -c 'cd $PWD && java -cp target/vutarem-$VERSION.jar com.vutarem.gui.VentanaPrincipal && $CMD_FIN'

