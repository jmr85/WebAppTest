@echo off
setlocal enabledelayedexpansion

title Test Runner
color 0A

:menu
cls
echo ====================================
echo          Test Runner
echo ====================================
echo 1. Ejecutar mvn test -PLogin
echo 2. Ejecutar mvn test -PLogout
echo 3. Ejecutar mvn test -PVisitFaceToFace
echo 4. Ejecutar mvn test -PGeneratePIN
echo 5. Salir
echo ====================================
set /p choice=Elige una opción (1-5): 

if "%choice%"=="1" set "profile=Login"
if "%choice%"=="2" set "profile=Logout"
if "%choice%"=="3" set "profile=VisitFaceToFace"
if "%choice%"=="4" set "profile=GeneratePIN"
if "%choice%"=="5" goto exit

if not defined profile (
    echo Opción inválida. Por favor elige un número del 1 al 5.
    pause
    goto menu
)

echo Ejecutando mvn test -P%profile%...
start cmd /k "mvn test -P%profile% && pause && exit"
echo Comando iniciado en una nueva ventana. Por favor, espera a que termine la ejecución.
pause
set "profile="
goto menu

:exit
echo Saliendo...
pause
exit