@echo off

rem 独立的class文件和依赖jar包的运行
goto testng
rem -----------------经测试能够运行需要用的包
commons-codec-1.8.jar                 commons-collections-3.2.1.jar
commons-exec-1.1.jar                  commons-io-2.2.jar
commons-lang3-3.4.jar                 commons-logging-1.2.jar
guava-15.0.jar                        httpclient-4.3.1.jar
httpcore-4.3.jar                      httpmime-4.3.1.jar
jcommander-1.48.jar
json-20080701.jar                     log4j-1.2.14.jar
selenium-android-driver-2.39.0.jar    selenium-api-2.39.0.jar
selenium-chrome-driver-2.39.0.jar     selenium-firefox-driver-2.39.0.jar
selenium-htmlunit-driver-2.39.0.jar   selenium-ie-driver-2.39.0.jar
selenium-iphone-driver-2.39.0.jar     selenium-java-2.39.0.jar
selenium-remote-driver-2.39.0.jar     selenium-safari-driver-2.39.0.jar
selenium-server-2.39.0.jar            selenium-support-2.39.0.jar
testng-6.9.10.jar
rem -----------------

:testng

set CP=.
rem FOR /R "C:\Program Files\Java\jdk1.5.0_06\lib" %%F IN (*.jar) DO call :addcp %%~sF
FOR /R "lib" %%F IN (*.jar) DO call :addcp %%~sF

goto extlibe

:addcp
set CP=%CP%;%1
goto :eof

:extlibe
echo %CP%

set CLASSPATH=%CLASSPATH%;%CP%

echo %CLASSPATH%
java org.testng.TestNG testng.xml