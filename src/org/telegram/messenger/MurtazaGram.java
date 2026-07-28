package org.telegram.messenger;

import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * MurtazaGram - Core feature implementations
 * Provides utility methods for MurtazaGram power features
 */
public class MurtazaGram {

    private static final String PREFS_NAME = "murtazagram_data";

    /**
     * Mark all dialogs as read
     */
    public static void markAllDialogsAsRead(int currentAccount) {
        MessagesController controller = MessagesController.getInstance(currentAccount);
        if (controller == null) return;

        ArrayList<TLRPC.Dialog> dialogs = controller.getDialogs(0);
        if (dialogs == null) return;

        for (int i = 0; i < dialogs.size(); i++) {
            TLRPC.Dialog dialog = dialogs.get(i);
            if (dialog.unread_count > 0) {
                controller.markDialogAsRead(dialog.id, dialog.top_message, 
                    dialog.top_message, 0, false, 0, dialog.unread_count, true, 0);
            }
        }
    }

    /**
     * Archive all read dialogs - moves read dialogs to archive folder (folderId=1)
     */
    public static void archiveAllReadDialogs(int currentAccount) {
        MessagesController controller = MessagesController.getInstance(currentAccount);
        if (controller == null) return;

        ArrayList<TLRPC.Dialog> dialogs = controller.getDialogs(0);
        if (dialogs == null) return;

        ArrayList<Long> toArchive = new ArrayList<>();
        for (int i = 0; i < dialogs.size(); i++) {
            TLRPC.Dialog dialog = dialogs.get(i);
            if (dialog.unread_count == 0 && !dialog.isPinned() && dialog.folder_id == 0) {
                toArchive.add(dialog.id);
            }
        }

        // Move each dialog to archive folder (folderId=1)
        for (Long dialogId : toArchive) {
            try {
                controller.getMessagesStorage().setDialogsFolderId(null, null, dialogId, 1);
            } catch (Exception e) {
                FileLog.e(e);
            }
        }
    }

    /**
     * Get MurtazaGram SharedPreferences
     */
    public static SharedPreferences getPrefs() {
        return ApplicationLoader.applicationContext.getSharedPreferences(PREFS_NAME, 0);
    }
}
