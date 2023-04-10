# Se comprueba si el gesto de bases de datos está insalado
status=$(service postgresql status)

if [[ status == *"Unit postgradawd.service could not be found."* ]]; then
    echo "Postgresql no está instalado. Intentando instalarlo..."
    sudo apt-get install postgresql -y
else
    echo "Postgresql ya estaba instalado."
fi

service postgresql start
sleep 1

# Se crea el usuario admin y su base de datos
sudo -u postgres psql -f setup.sql

bash ./dbinit.sh