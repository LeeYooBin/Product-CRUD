@echo off

cd products-register

echo Iniciando o servidor Spring Boot...
start cmd /c mvn spring-boot:run

:: Timeout para garantir que o servidor iniciou
timeout /t 20

cd ..

echo Abrindo a página HTML...
start "" "frontend\index.html"

echo Aplicação iniciada.
