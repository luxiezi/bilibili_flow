package bilibilidemo.lyq.com.lyq.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import bilibilidemo.lyq.com.lyq.BilibiliApp;

/**
 * Created by lu on 2017/4/22.
 */

public final class PreferenceUtil {

    public static void reset(Context context){
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.clear();
        edit.apply();
    }

    public static SharedPreferences getSharedPreference(){
        return PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance());
    }

    public static String getString(String key,String defValue){
        return getSharedPreference().getString(key,defValue);
    }

    public static long getLong(String key, long defValue) {
        return getSharedPreference().getLong(key, defValue);
    }

    public static float getFloat(String key, float defValue) {

        return getSharedPreference().getFloat(key, defValue);
    }

    public static int getInt(String key,int defValue){
        return getSharedPreference().getInt(key,defValue);
    }

    public static boolean getBoolean(String key,boolean defValue){
        return getSharedPreference().getBoolean(key,defValue);
    }

    public static void put(String key,String value){
        putString(key,value);
    }
    private static void putString(String key, String value) {
        SharedPreferences sharedPrefenrences = PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance());
        SharedPreferences.Editor editor=sharedPrefenrences.edit();
        editor.putString(key,value);
        editor.apply();
    }


    public static void put(String key, float value) {
        putFloat(key, value);
    }
    private static void putFloat(String key, float value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance());
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putFloat(key,value);
        editor.apply();
    }


    public static void put(String key, boolean value) {
        putBoolean(key, value);
    }
    private static void putBoolean(String key, boolean value) {
        SharedPreferences sharedPrefenrences = PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance());
        SharedPreferences.Editor editor=sharedPrefenrences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }


    public static void put(String key, int value) {
        putInt(key, value);
    }
    private static void putInt(String key, int value) {
        SharedPreferences sharedPrefenrences = PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance());
        SharedPreferences.Editor editor=sharedPrefenrences.edit();
        editor.putInt(key,value);
        editor.apply();
    }

    public static void put(String key,long value){
        putLong(key,value);
    }

    private static void putLong(String key, long value) {
        SharedPreferences sharedPrefenrences = PreferenceManager.getDefaultSharedPreferences(BilibiliApp.getInstance());
        SharedPreferences.Editor editor=sharedPrefenrences.edit();
        editor.putLong(key,value);
        editor.apply();
    }


    public static void putStringProcess(String key,String value){
        SharedPreferences sharedPrefenrences = BilibiliApp.getInstance()
                .getSharedPreferences("preference_mu",Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor = sharedPrefenrences.edit();
        editor.putString(key,value);
        editor.apply();
    }

    public static String getStringProcess(String key,String value){
        SharedPreferences sharedPrefenrences = BilibiliApp.getInstance()
                .getSharedPreferences("preference_mu",Context.MODE_MULTI_PROCESS);
        return getSharedPreference().getString(key,value);
    }

    public static boolean hasString(String key){
        return getSharedPreference().contains(key);
    }

    public static void remove(String... key){
        if (key!=null){
            SharedPreferences.Editor editor =getSharedPreference().edit();
            for (String s : key) {
                editor.remove(s);
            }
            editor.apply();
        }
    }
}
