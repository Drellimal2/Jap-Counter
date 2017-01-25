package io.origamicoders.japcounter.View;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

import io.origamicoders.japcounter.Utils;

/**
 * Created by DM036497 on 1/12/2017.
 */

public class PaintTextView extends Button {
    public PaintTextView(Context context) {
        super(context);
        applyCustomFont(context);

    }

    public PaintTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);

    }

    public PaintTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
//        Typeface customFont = Utils.getTypeface("JKG.ttf", context);
//        Typeface customFont = Utils.getTypeface("LTG.ttf", context);
        Typeface customFont = Utils.getTypeface("KGLifeisMessy.ttf", context);
        setTypeface(customFont);
    }
}