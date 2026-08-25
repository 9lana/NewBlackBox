package app.viscount.loader.closecode;


import app.viscount.loader.utils.Slog;

public class Entry {
    private static final String TAG = "Lib Injection";
    public static void attach() {
        Slog.d(TAG, "Custom closed code initialized; libviscount.so is loaded by BoxCore.");
    }
}