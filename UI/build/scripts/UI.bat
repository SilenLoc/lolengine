@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  UI startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and UI_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\kotlinx-coroutines-core-jvm-1.6.0-RC.jar;%APP_HOME%\lib\kotlinx-coroutines-javafx-1.6.0-RC.jar;%APP_HOME%\lib\javafx-controls-17.jar;%APP_HOME%\lib\javafx-media-17.jar;%APP_HOME%\lib\javafx-graphics-17.jar;%APP_HOME%\lib\javafx-base-17.jar;%APP_HOME%\lib\validatorfx-0.1.13.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.6.0.jar;%APP_HOME%\lib\annotations-13.0.jar
set MODULE_PATH=%APP_HOME%\lib\UI-1.0-SNAPSHOT.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.6.0.jar;%APP_HOME%\lib\javafx-fxml-17-win.jar;%APP_HOME%\lib\javafx-web-17-win.jar;%APP_HOME%\lib\javafx-controls-17-win.jar;%APP_HOME%\lib\javafx-media-17-win.jar;%APP_HOME%\lib\javafx-graphics-17-win.jar;%APP_HOME%\lib\javafx-base-17-win.jar;%APP_HOME%\lib\controlsfx-11.1.0.jar;%APP_HOME%\lib\formsfx-core-11.3.2.jar;%APP_HOME%\lib\ikonli-javafx-12.2.0.jar;%APP_HOME%\lib\bootstrapfx-core-0.4.0.jar;%APP_HOME%\lib\tilesfx-11.48.jar;%APP_HOME%\lib\kotlinx-serialization-json-jvm-1.3.1.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.6.0.jar;%APP_HOME%\lib\kotlinx-serialization-core-jvm-1.3.1.jar;%APP_HOME%\lib\kotlin-stdlib-1.6.0.jar;%APP_HOME%\lib\ikonli-core-12.2.0.jar

@rem Execute UI
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %UI_OPTS%  -classpath "%CLASSPATH%" --module-path "%MODULE_PATH%" --module view.ui/LolApplication %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable UI_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%UI_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
