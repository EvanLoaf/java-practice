set currdate=%1
set folder=Screenshots_%currdate%
mkdir %folder%
move *.jpg %folder%
move *.png %folder%
cd %folder%
dir /b *.jpg >> ..\screenshots.found
dir /b *.png >> ..\screenshots.found
set path="C:\Program Files\WinRAR\"
rar a ..\screenshots
cd..
rmdir /s /q %folder%
pause