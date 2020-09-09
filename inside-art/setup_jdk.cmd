@echo off

REM install jdk
REM https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html

set JAVA_HOME="D:\Program Files\Java\jdk1.8.0_261"
set JRE_HOME=%JAVA_HOME%\jre
set CLASSPATH=%JAVA_HOME%\lib;%JRE_HOME%\lib;%CLASSPATH%
set PATH=%PATH%;%JAVA_HOME%\bin;%JRE_HOME%\bin
