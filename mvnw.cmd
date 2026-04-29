@echo off
REM AI 生成 By Peng.Guo
setlocal

set WRAPPER_JAR=%~dp0\.mvn\wrapper\maven-wrapper.jar
set WRAPPER_PROPERTIES=%~dp0\.mvn\wrapper\maven-wrapper.properties

if not exist "%WRAPPER_JAR%" (
  echo Cannot find "%WRAPPER_JAR%"
  exit /b 1
)

if not exist "%WRAPPER_PROPERTIES%" (
  echo Cannot find "%WRAPPER_PROPERTIES%"
  exit /b 1
)

if defined JAVA_HOME (
  set JAVA_EXE=%JAVA_HOME%\bin\java.exe
) else (
  set JAVA_EXE=java
)

"%JAVA_EXE%" -Dmaven.multiModuleProjectDirectory="%~dp0" -classpath "%WRAPPER_JAR%" org.apache.maven.wrapper.MavenWrapperMain %*
