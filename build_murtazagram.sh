#!/bin/bash
# MurtazaGram Build Script
# Clones official Telegram source and applies all MurtazaGram modifications
set -e
echo "=== MurtazaGram Build Script ==="
git clone --depth 1 https://github.com/DrKLO/Telegram.git Telegram
cd Telegram
# Apply all modifications (see .github/workflows/build.yml for details)
chmod +x gradlew
./gradlew assembleDebug --no-daemon -x lint
find . -name "*.apk" -path "*/debug/*" -exec ls -lh {} \;
