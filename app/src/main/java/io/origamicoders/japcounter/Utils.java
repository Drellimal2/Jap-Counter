package io.origamicoders.japcounter;

import android.content.Context;
import android.graphics.Typeface;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

import io.origamicoders.japcounter.Models.Counter;

/**
 * Created by DM036497 on 1/8/2017.
 */
public class Utils {
    public static ArrayList<Counter> counters = new ArrayList<>();
    private static FirebaseDatabase mDatabase;
    private static Typeface noto;
    public static boolean done = false;
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
                    "fonts/honokamin.ttf");
        }
        return noto;
    }

    private static HashMap<String, Typeface> fontCache = new HashMap<>();

    public static Typeface getTypeface(Context context) {
        Typeface typeface = fontCache.get("honokamin.ttf");

        if (typeface == null) {
            try {
                typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + "honokamin.ttf");
            } catch (Exception e) {
                return null;
            }

            fontCache.put("honokamin.ttf", typeface);
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
