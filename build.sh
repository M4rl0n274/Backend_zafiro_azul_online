#!/bin/bash
# Instalar Maven
apt-get update && apt-get install -y maven

# Ejecutar el comando de construcción de Maven
mvn clean package

chmod +x build.sh