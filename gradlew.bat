@echo off
setlocal
set DIR=%~dp0
if "%~1"=="" (
  set DEFAULT_TASK=help
) else (
  set DEFAULT_TASK=%~1
)
set JAVA_EXE=java
if defined JAVA_HOME (
  set JAVA_EXE=%JAVA_HOME%\bin\java.exe
)
"%JAVA_EXE%" -Dorg.gradle.appname=gradlew -classpath "%DIR%gradle\wrapper\gradle-wrapper.jar" org.gradle.wrapper.GradleWrapperMain %DEFAULT_TASK%
