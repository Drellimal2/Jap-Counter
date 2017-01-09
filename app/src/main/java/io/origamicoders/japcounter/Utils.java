package io.origamicoders.japcounter;

import android.content.Context;
import android.graphics.Typeface;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by DM036497 on 1/8/2017.
 */
public class Utils {
    private static FirebaseDatabase mDatabase;
    private static Typeface noto;

    public static FirebaseDatabase getDatabase() {
        if (mDatabase == null) {
            mDatabase = FirebaseDatabase.getInstance();
            mDatabase.setPersistenceEnabled(true);
        }
        return mDatabase;
    }

    public static Typeface getFont(Context context){
        if(noto == null){
            noto = Typeface.createFromAsset(context.getApplicationContext().getAssets(),
                    "fonts/Noto-Thin.ttf");
        }
        return noto;
    }

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = fontCache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), fontname);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(fontname, typeface);
        }

        return typeface;
    }

}
