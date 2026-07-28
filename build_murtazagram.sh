#!/bin/bash
set -e
echo "=== MurtazaGram Build Script ==="
echo "Cloning official Telegram source..."
git clone --depth 1 https://github.com/DrKLO/Telegram.git Telegram
cd Telegram

echo "Applying MurtazaGram branding..."
sed -i 's/APP_VERSION_CODE=.*/APP_VERSION_CODE=1/' gradle.properties
sed -i 's/APP_VERSION_NAME=.*/APP_VERSION_NAME=1.0-MurtazaGram/' gradle.properties
sed -i 's/APP_PACKAGE=.*/APP_PACKAGE=com.murtaza.gram/' gradle.properties
sed -i 's/<string name="AppName">Telegram<\/string>/<string name="AppName">MurtazaGram<\/string>/' TMessagesProj/src/main/res/values/strings.xml
sed -i 's/<string name="AppNameBeta">Telegram Beta<\/string>/<string name="AppNameBeta">MurtazaGram Beta<\/string>/' TMessagesProj/src/main/res/values/strings.xml
sed -i 's/Welcome to Telegram/Welcome to MurtazaGram/g' TMessagesProj/src/main/res/values/strings.xml
sed -i 's/Your contacts on Telegram/Your contacts on MurtazaGram/g' TMessagesProj/src/main/res/values/strings.xml
sed -i 's/Check your Telegram messages/Check your MurtazaGram messages/g' TMessagesProj/src/main/res/values/strings.xml

echo "Applying dark theme..."
sed -i 's/public static final int TELEGRAM_COLOR = 0xFF229AF0;/public static final int TELEGRAM_COLOR = 0xFF7B2FBE;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/public static final int TELEGRAM_COLOR_TEXT = 0xFF298ACF;/public static final int TELEGRAM_COLOR_TEXT = 0xFF7B2FBE;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/public static final int DEFAULT_BLACK_TEXT = 0xFF1A1D21;/public static final int DEFAULT_BLACK_TEXT = 0xFFE0E0E0;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_windowBackgroundWhite\] = 0xffffffff;/defaultColors[key_windowBackgroundWhite] = 0xff0A0A0A;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_windowBackgroundGray\] = 0xffF1F1F3;/defaultColors[key_windowBackgroundGray] = 0xff111111;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_actionBarDefault\] = 0xffffffff;/defaultColors[key_actionBarDefault] = 0xff111111;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_chat_inBubble\] = 0xffffffff;/defaultColors[key_chat_inBubble] = 0xff1A1A2E;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_chat_outBubble\] = 0xffefffde;/defaultColors[key_chat_outBubble] = 0xff2D1B4E;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_windowBackgroundChecked\] = 0xff229AF0;/defaultColors[key_windowBackgroundChecked] = 0xff7B2FBE;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java
sed -i 's/defaultColors\[key_progressCircle\] = 0xff1c93e3;/defaultColors[key_progressCircle] = 0xff7B2FBE;/' TMessagesProj/src/main/java/org/telegram/ui/ActionBar/ThemeColors.java

echo "Applying feature modifications..."
sed -i 's/maxPinnedDialogsCountDefault = mainPreferences.getInt("maxPinnedDialogsCountDefault", 5);/maxPinnedDialogsCountDefault = mainPreferences.getInt("maxPinnedDialogsCountDefault", 20);/g' TMessagesProj/src/main/java/org/telegram/messenger/MessagesController.java
sed -i 's/maxPinnedDialogsCountPremium = mainPreferences.getInt("maxPinnedDialogsCountPremium", 5);/maxPinnedDialogsCountPremium = mainPreferences.getInt("maxPinnedDialogsCountPremium", 20);/g' TMessagesProj/src/main/java/org/telegram/messenger/MessagesController.java
sed -i 's/filtersEnabled = mainPreferences.getBoolean("filtersEnabled", false);/filtersEnabled = mainPreferences.getBoolean("filtersEnabled", true);/' TMessagesProj/src/main/java/org/telegram/messenger/MessagesController.java
sed -i 's/"mg_Other/"murtazagram_Other/g' TMessagesProj/src/main/java/org/telegram/messenger/NotificationsController.java
sed -i 's/"mg_channels"/"murtazagram_channels"/g' TMessagesProj/src/main/java/org/telegram/messenger/NotificationsController.java
sed -i 's/"mg_groups"/"murtazagram_groups"/g' TMessagesProj/src/main/java/org/telegram/messenger/NotificationsController.java
sed -i 's/"mg_private"/"murtazagram_private"/g' TMessagesProj/src/main/java/org/telegram/messenger/NotificationsController.java
sed -i 's/"mg_stories"/"murtazagram_stories"/g' TMessagesProj/src/main/java/org/telegram/messenger/NotificationsController.java
sed -i 's/"mg_other"/"murtazagram_other"/g' TMessagesProj/src/main/java/org/telegram/messenger/NotificationsController.java

echo "All MurtazaGram modifications applied!"
