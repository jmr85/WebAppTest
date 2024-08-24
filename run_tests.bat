@echo off
setlocal enabledelayedexpansion

title Test Runner
color 0A

:menu
cls
echo ====================================
echo          Test Runner
echo ====================================
echo 1. Ejecutar test Login
echo 2. Ejecutar test Logout
echo 3. Ejecutar test VisitFaceToFace
echo 4. Ejecutar test GeneratePIN
echo 5. Ejecutar todos los tests
echo 6. Salir
echo ====================================
set /p choice=Elige una opción (1-6): 

if "%choice%"=="1" set "profile=Login"
if "%choice%"=="2" set "profile=Logout"
if "%choice%"=="3" set "profile=VisitFaceToFace"
if "%choice%"=="4" set "profile=GeneratePIN"
if "%choice%"=="5" set "profile=All"
if "%choice%"=="6" goto exit

if not defined profile (
    echo Opción inválida. Por favor elige un número del 1 al 6.
    pause
    goto menu
)

echo Ejecutando mvn test -P%profile%...
start cmd /k "mvn test -Dsurefire.suiteXmlFiles=%profile%Test.xml && pause && exit"
echo Comando iniciado en una nueva ventana. Por favor, espera a que termine la ejecución.
pause
set "profile="
goto menu

:exit
echo Saliendo...
pause
exit