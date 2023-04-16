PWD=$(pwd)

# Se inicializa la base de datos
bash scripts/dbinit.sh

#Se lanza rmi
gnome-terminal -x 'rmiregistry -J-Djava.net.preferIPv4Stack=true 54321'

#Se lanza el servidor
gnome-terminal -x 'cd $PWD && mvn exec:java@sv -Dexec.args="54321"'

#Se lanza la interfaz gráfica
# gnome-terminal -e 'cd $PWD && mvn exec:java@gui'