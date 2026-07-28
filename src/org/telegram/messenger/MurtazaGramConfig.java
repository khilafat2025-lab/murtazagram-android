package org.telegram.messenger;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * MurtazaGram Configuration - Power features settings
 * Handles ghost mode, anti-delete, auto-translate, and other MurtazaGram-specific features
 */
public class MurtazaGramConfig {

    private static final String PREFS_NAME = "murtazagram_config";
    private static SharedPreferences prefs;
    private static MurtazaGramConfig instance;

    // Feature keys
    public static final String KEY_GHOST_MODE = "ghost_mode";
    public static final String KEY_GHOST_MODE_CHATS = "ghost_mode_chats";
    public static final String KEY_ANTI_DELETE = "anti_delete";
    public static final String KEY_AUTO_TRANSLATE = "auto_translate";
    public static final String KEY_TRANSLATE_LANG = "translate_lang";
    public static final String KEY_AUTO_TRANSLATE_CHATS = "auto_translate_chats";
    public static final String KEY_HIDE_ONLINE = "hide_online";
    public static final String KEY_CUSTOM_FONT = "custom_font";
    public static final String KEY_NO_READ_RECEIPT = "no_read_receipt";
    public static final String KEY_NO_TYPING = "no_typing";
    public static final String KEY_MARK_ALL_READ = "mark_all_read";
    public static final String KEY_ARCHIVE_READ = "archive_read";

    // Pinned messages limit
    public static final int MAX_PINNED_MESSAGES = 20;

    // Download settings
    public static final int MAX_DOWNLOAD_CONNECTIONS = 16;
    public static final int DOWNLOAD_CHUNK_SIZE = 1024 * 512; // 512KB

    public static synchronized MurtazaGramConfig getInstance() {
        if (instance == null) {
            instance = new MurtazaGramConfig();
        }
        return instance;
    }

    private MurtazaGramConfig() {
    }

    public static void init(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public static SharedPreferences getPrefs() {
        if (prefs == null) {
            init(ApplicationLoader.applicationContext);
        }
        return prefs;
    }

    // Ghost mode - read messages without sending read receipts
    public static boolean isGhostModeEnabled() {
        return getPrefs().getBoolean(KEY_GHOST_MODE, false);
    }

    public static void setGhostMode(boolean enabled) {
        getPrefs().edit().putBoolean(KEY_GHOST_MODE, enabled).commit();
    }

    public static boolean isGhostModeForChat(long dialogId) {
        return isGhostModeEnabled() || getPrefs().getBoolean(KEY_GHOST_MODE_CHATS + "_" + dialogId, false);
    }

    public static void setGhostModeForChat(long dialogId, boolean enabled) {
        getPrefs().edit().putBoolean(KEY_GHOST_MODE_CHATS + "_" + dialogId, enabled).commit();
    }

    // Anti-delete - save messages before they are deleted
    public static boolean isAntiDeleteEnabled() {
        return getPrefs().getBoolean(KEY_ANTI_DELETE, true);
    }

    public static void setAntiDelete(boolean enabled) {
        getPrefs().edit().putBoolean(KEY_ANTI_DELETE, enabled).commit();
    }

    // Auto-translate
    public static boolean isAutoTranslateEnabled() {
        return getPrefs().getBoolean(KEY_AUTO_TRANSLATE, false);
    }

    public static void setAutoTranslate(boolean enabled) {
        getPrefs().edit().putBoolean(KEY_AUTO_TRANSLATE, enabled).commit();
    }

    public static String getTranslateLanguage() {
        return getPrefs().getString(KEY_TRANSLATE_LANG, "en");
    }

    public static void setTranslateLanguage(String lang) {
        getPrefs().edit().putString(KEY_TRANSLATE_LANG, lang).commit();
    }

    public static boolean isAutoTranslateForChat(long dialogId) {
        return isAutoTranslateEnabled() || getPrefs().getBoolean(KEY_AUTO_TRANSLATE_CHATS + "_" + dialogId, false);
    }

    public static void setAutoTranslateForChat(long dialogId, boolean enabled) {
        getPrefs().edit().putBoolean(KEY_AUTO_TRANSLATE_CHATS + "_" + dialogId, enabled).commit();
    }

    // Hide online status
    public static boolean isHideOnlineEnabled() {
        return getPrefs().getBoolean(KEY_HIDE_ONLINE, false);
    }

    public static void setHideOnline(boolean enabled) {
        getPrefs().edit().putBoolean(KEY_HIDE_ONLINE, enabled).commit();
    }

    // No read receipt (global)
    public static boolean isNoReadReceiptEnabled() {
        return getPrefs().getBoolean(KEY_NO_READ_RECEIPT, false);
    }

    public static void setNoReadReceipt(boolean enabled) {
        getPrefs().edit().putBoolean(KEY_NO_READ_RECEIPT, enabled).commit();
    }

    // No typing indicator
    public static boolean isNoTypingEnabled() {
        return getPrefs().getBoolean(KEY_NO_TYPING, false);
    }

    public static void setNoTyping(boolean enabled) {
        getPrefs().edit().putBoolean(KEY_NO_TYPING, enabled).commit();
    }

    // Custom font
    public static String getCustomFont() {
        return getPrefs().getString(KEY_CUSTOM_FONT, "");
    }

    public static void setCustomFont(String font) {
        getPrefs().edit().putString(KEY_CUSTOM_FONT, font).commit();
    }
}
