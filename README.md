# MurtazaGram

A heavily modified Telegram Android client with custom dark theme, extreme download speed, auto-translation, ghost mode, anti-delete, and many power features.

Based on the official Telegram open-source code ([DrKLO/Telegram](https://github.com/DrKLO/Telegram)).

## 📱 Features

### Branding & Theme
- **App Name:** MurtazaGram
- **Package:** `com.murtaza.gram` (installs alongside official Telegram — no conflict)
- **Ultra-dark background:** `#0A0A0A`
- **Deep purple/violet accent:** `#7B2FBE`
- **Dark chat bubbles** with subtle gradient
- **Near-black action bar:** `#111111`
- **Custom app icon** with "M" logo on dark background
- All visible "Telegram" references replaced with "MurtazaGram"

### Extreme Download Speed
- **16 parallel download connections** (up from 4)
- **512KB download chunks** (up from 128KB)
- **4MB aggressive prefetching** (up from 2MB)

### No Conflict with Official Telegram
- Different package name (`com.murtaza.gram`)
- Unique notification channel IDs (`murtazagram_*` prefix)
- Separate SharedPreferences keys and data directory

### Auto Message Translation
- Context translate always enabled
- Translate button available on every message

### Pin Up to 20 Dialogs
- Increased pinned dialogs limit from 5 to 20
- Filter tabs enabled by default

### Show User ID on Profile
- Numeric Telegram User ID displayed on every user profile
- One-tap copy to clipboard

### Forward & Copy from Restricted Groups/Channels
- Bypass `noforwards` flag — forwarding always allowed
- Copy text from restricted chats enabled
- Text selection in restricted chats enabled

### Ghost Mode
- Read messages without sending read receipts
- Per-chat toggle

### Anti-Delete
- Intercepts `deleteMessages` and caches message content before deletion
- Enabled by default

### Mark All As Read
- One-tap button in the main menu

## 🔨 Building the APK

### Method 1: GitHub Actions (Recommended — Free)

1. This repo has a GitHub Actions workflow that automatically builds the APK
2. Push any change to `main` branch (or trigger manually via "Run workflow")
3. GitHub Actions will:
   - Clone the official Telegram source
   - Apply all MurtazaGram modifications
   - Build the debug APK
   - Upload it as a workflow artifact
   - Create a GitHub Release with the APK
4. Download the APK from:
   - **Actions tab** → Select the latest run → Download artifacts
   - **Releases page** → Download the APK from the latest release

### Method 2: Local Build

```bash
git clone https://github.com/DrKLO/Telegram.git
cd Telegram

# Apply modifications
bash build_murtazagram.sh

# Or build manually
chmod +x gradlew
./gradlew assembleDebug
```

## 📲 Installation

1. **Download** the APK file
2. **Enable** "Install from unknown sources" in Android Settings
3. **Install** the APK
4. **Open** MurtazaGram — installs alongside official Telegram
5. **Log in** with your Telegram phone number and OTP

## ⚖️ License

GPL-3.0 — Based on Telegram's open-source code.

## ⚠️ Disclaimer

MurtazaGram is an unofficial modified Telegram client. Not affiliated with Telegram. Use at your own discretion.