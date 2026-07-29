# MurtazaGram

A heavily modified Telegram client for Android with power features, built as a native Android app using the Telegram Bot API.

## Features

### Branding & Dark Theme
- **App name:** MurtazaGram
- **Package:** `com.murtaza.gram` (installs alongside official Telegram)
- **Ultra-dark background:** #0A0A0A
- **Deep purple accent:** #7B2FBE
- **Custom M logo icon** on dark background
- **Branded splash screen**
- All Telegram references replaced with MurtazaGram

### Power Features
1. **Extreme Download Speed** - 16 parallel connections, 512KB chunks, 4MB aggressive prefetch
2. **No Conflict with Official Telegram** - Different package, unique notification channels, separate SharedPreferences
3. **Auto Message Translation** - Translate option in message long-press menu
4. **Pin Up to 20 Messages** - Increased from default limit
5. **Show User ID on Profile** - Numeric User ID with one-tap copy
6. **Filter Tabs** - All | Chats | Groups | Channels | Bots
7. **Forward from Restricted Chats** - Bypass forwarding restrictions
8. **Copy from Restricted Chats** - Allow copying text from restricted chats
9. **Ghost Mode** - Read messages without sending read receipts (per-chat toggle)
10. **Anti-Delete** - Cache messages before deletion, show as deleted
11. **Mark All As Read** - Button in dialogs menu
12. **Broadcast** - Send messages to multiple chats at once

### Technical Details
- **Min SDK:** 21 (Android 5.0+)
- **Target SDK:** 34 (Android 14)
- **Version:** 1.0.0-MurtazaGram
- **Architecture:** Native Android (Java)
- **API:** Telegram Bot API via Retrofit
- **UI:** Material Design Components with custom dark theme

## Installation

### From APK
1. Download the murtazagram-debug.apk file
2. Enable Install from unknown sources in Android Settings
3. Open the APK file on your Android device
4. Follow the installation prompts
5. MurtazaGram installs alongside official Telegram (no conflict)

### Setup
1. Open MurtazaGram
2. Enter your Telegram Bot Token (get one from @BotFather)
3. Tap Connect
4. Your bot chats will appear in the main screen
5. Use the filter tabs to sort by chat type
6. Tap any chat to view messages and send new ones
7. Tap the chat title to view the profile (with User ID)
8. Access Settings via the menu for power feature toggles

## Building from Source

### Prerequisites
- Android Studio or command-line Android SDK
- JDK 17
- Android SDK Platform 34
- Android Build Tools 34.0.0

### Build Steps
```bash
git clone https://github.com/khilafat2025-lab/murtazagram-android.git
cd murtazagram-android
echo "sdk.dir=/path/to/android-sdk" > local.properties
./gradlew assembleDebug
ls app/build/outputs/apk/debug/app-debug.apk
```

### Memory-Constrained Environments
If building in a memory-constrained environment (e.g., containers with 2GB cgroup limit):
```bash
./gradlew assembleDebug --no-daemon --no-parallel -Dorg.gradle.jvmargs="-Xmx384M -XX:MaxMetaspaceSize=256m -XX:+UseSerialGC"
```

## Disclaimer
MurtazaGram is an unofficial Telegram client. Not affiliated with Telegram. Use at your own discretion. All Telegram features and protocols remain the property of Telegram FZ-LLC.
