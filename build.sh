#!/bin/bash
# Instalar Maven
apt-get update && apt-get install -y openjdk-11-jdk maven

# Ejecutar el comando de construcción de Maven
mvn clean package

chmod +x build.sh