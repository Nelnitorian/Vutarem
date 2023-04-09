sudo su
# Se comprueba si el gesto de bases de datos está insalado
status=$(service postgresql status)

if [[ status == *"Unit postgradawd.service could not be found."* ]]; then
    echo "Postgresql no está instalado. Intentando instalarlo..."
    apt-get install postgresql -y
else
    echo "Postgresql ya estaba instalado."
fi

service postgresql start
sleep 1

# Se crea el usuario admin y su base de datos
sudo -u postgres psql
CREATE USER admin WITH PASSWORD 'admin1234';
CREATE DATABASE admin;
GRANT ALL PRIVILEGES ON DATABASE admin TO admin;

# Se crea la base de datos de votante
sudo -u postgres psql -d admin -c "CREATE TABLE votante (dni VARCHAR(9) PRIMARY KEY, nombre VARCHAR(50) NOT NULL, ha_votado BOOLEAN NOT NULL);"