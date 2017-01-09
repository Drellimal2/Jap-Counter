package io.origamicoders.japcounter.View;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import io.origamicoders.japcounter.Utils;

/**
 * Created by DM036497 on 1/9/2017.
 */

public class JapTextView extends TextView {
    public JapTextView(Context context) {
        super(context);
        applyCustomFont(context);

    }

    public JapTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        applyCustomFont(context);

    }

    public JapTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        applyCustomFont(context);
    }

    private void applyCustomFont(Context context) {
        Typeface customFont = Utils.getTypeface("Noto-Thin.ttf", context);
        setTypeface(customFont);
    }
}
