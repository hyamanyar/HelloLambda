@echo off
echo Starting the build process...
gradle assembleDebug apkCopy assemblyCopy --daemon
pause
