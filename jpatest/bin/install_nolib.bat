@echo off
echo.
echo [信息] 安装中央仓库缺失jar。
echo.
rem pause
rem echo.

set MAVEN_OPTS=%MAVEN_OPTS% -Xms256m -Xmx512m -XX:PermSize=128m -XX:MaxPermSize=256m

cd ../lib
call mvn install:install-file -Dfile=dagger-1.3.jar -DgroupId=com.netease -DartifactId=dagger -Dversion=1.3 -Dpackaging=jar

cd ../bin
