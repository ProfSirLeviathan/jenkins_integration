@echo off
setlocal enabledelayedexpansion

set /a randNum=%random% %% 60 + 1
echo Random number (1-60): !randNum!

if !randNum! lss 30 (
    echo Number is less than 30. Failing the script.
    exit /b 1
) else (
    echo Number is 30 or greater. Passing the script.
    exit /b 0
)