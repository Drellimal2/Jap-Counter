package io.origamicoders.japcounter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
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
                    "fonts/ming.ttf");
        }
        return noto;
    }

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(String fontname, Context context) {
        Typeface typeface = fontCache.get(fontname);

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + fontname);
            } catch (Exception e) {
                return null;
            }

            fontCache.put(fontname, typeface);
        }

        return typeface;
    }

    public static String usesToStringList(String s){
        String res = "";
        for(String i: s.split(",") ) {
            res += "- " + i +"\n";

        }
        int len = res.length();
        res = res.substring(0, len-1);
        return res;
    }

    public static FirebaseUser getCurrentUser(){
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user != null) {
            return user;
        } else {
            // No user is signed in
            mAuth.signInAnonymously();
            user = mAuth.getCurrentUser();
            return user;
        }
    }
}
