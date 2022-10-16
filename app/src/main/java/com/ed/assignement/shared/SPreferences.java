package com.ed.assignement.shared;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Singleton to handle application shared preferences
 */
public final class SPreferences {
    private static final String APPLICATION_PREFERENCE_NAME = "Assignment";
    private static SPreferences instance;

    private SPreferences() {
    }

    /**
     * @return class instance
     */
    public static SPreferences getInstance() {
        if (instance == null) {
            instance = new SPreferences();
        }
        return instance;
    }

    /**
     * @param context        application context
     * @param preferenceName preference key value
     * @return String instance preference value
     */
    public String getPreferenceString(final Context context, final String preferenceName, final String initialStatus) {
        final SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return preferences.getString(preferenceName, initialStatus);
    }

    /**
     * @param context        application context
     * @param preferenceName preference key value
     * @return int instance preference value
     */
    public int getPreferenceInt(final Context context, final String preferenceName, final int initialStatus) {
        final SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return preferences.getInt(preferenceName, initialStatus);
    }

    public float getPreferenceFloat(final Context context, final String preferenceName, final float initialStatus) {
        final SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return preferences.getFloat(preferenceName, initialStatus);
    }

    /**
     * @param context        application context
     * @param preferenceName preference key value
     * @param initialStatus  initial preference value if it is not already set
     * @return boolean instance preference value
     */
    public boolean getPreferenceBoolean(final Context context, final String preferenceName, final boolean initialStatus) {
        final SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return preferences.getBoolean(preferenceName, initialStatus);
    }

    /**
     * @param context        application context
     * @param preferenceName preference key value
     * @param initialStatus  initial preference value if it is not already set
     * @return long instance preference value
     */
    public long getPreferenceLong(final Context context, final String preferenceName, final long initialStatus) {
        final SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE);
        return preferences.getLong(preferenceName, initialStatus);
    }

    /**
     * Sets preference value
     *
     * @param context        application context
     * @param preferenceName preference key value
     * @param object         object to save
     * @return true if preference is saved successfully, false if not
     */
    public boolean setPreference(final Context context, final String preferenceName, final Object object) {
        try {
            final SharedPreferences preferences = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE);
            final SharedPreferences.Editor editor = preferences.edit();
            if (object instanceof String) {
                editor.putString(preferenceName, (String) object);
            } else if (object instanceof Integer) {
                editor.putInt(preferenceName, (Integer) object);
            } else if (object instanceof Boolean) {
                editor.putBoolean(preferenceName, (Boolean) object);
            } else if (object instanceof Long) {
                editor.putLong(preferenceName, (Long) object);
            } else if (object instanceof Float) {
                editor.putFloat(preferenceName, (Float) object);
            }
            editor.commit();
        } catch (final Exception e) {

            return false;
        }
        return true;
    }

    /**
     * Clear application all shared preferences
     */
    public void clearAllPreferences(final Context context) {
        final SharedPreferences.Editor editor = context.getSharedPreferences(APPLICATION_PREFERENCE_NAME, Context.MODE_PRIVATE).edit();
        editor.clear();
        editor.commit();
    }
}
