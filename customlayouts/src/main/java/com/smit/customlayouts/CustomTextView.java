package com.smit.customlayouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ScaleXSpan;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Stratecore on 6/19/2017.
 */

public class CustomTextView extends TextView {


    public CustomTextView(Context context) {
        this(context, null, 0);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {

        float textsize = 0;
        int textcolor;
        Typeface typeface;
        boolean singlineText;
        int CornerRoundColor;
        int buttonBackgroundColor;
        GradientDrawable gradientDrawable;

        String text="";
        if (attrs == null) {

            textsize = 16;
            textcolor = Color.BLACK;
            typeface = Typeface.DEFAULT;
            singlineText = false;
            text = "";
            buttonBackgroundColor = Color.BLACK;
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(2, Color.BLACK);
            gradientDrawable.setColor(buttonBackgroundColor);
            gradientDrawable.setCornerRadius(2);

        } else {
            gradientDrawable = new GradientDrawable();

            final TypedArray awt = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView, defStyleAttr, 0);

            //Text Typeface Getting
            String typefacedata = awt.getString(R.styleable.CustomTextView_texttypeface);

            //Set Text Typeface Getting
            typeface = Typeface.createFromAsset(context.getAssets(), typefacedata);

            //Text Color Getting
            textcolor = awt.getColor(R.styleable.CustomTextView_textcolor, 0);

            textsize = awt.getInt(R.styleable.CustomTextView_textsize, 0);

            singlineText = awt.getBoolean(R.styleable.CustomTextView_textsingleline,false);

            buttonBackgroundColor = awt.getColor(R.styleable.CustomTextView_textbackround, 0);
            int size = awt.getInt(R.styleable.CustomTextView_textCornerRoundWidth, 0);
            CornerRoundColor = awt.getColor(R.styleable.CustomTextView_textCornerRoundColor, 0);
            int CornerRadiaus = awt.getInt(R.styleable.CustomTextView_textCornerRadius, 0);
            gradientDrawable.setColor(buttonBackgroundColor);
            gradientDrawable.setCornerRadius(CornerRadiaus);
            gradientDrawable.setStroke(size, CornerRoundColor);

            text = awt.getString(R.styleable.CustomTextView_text);

        }
        setTypeface(typeface);
        setTextColor(textcolor);
        setTextSize(textsize);
        setSingleLine(singlineText);
        setBackgroundDrawable(gradientDrawable);
//        applyLetterSpacing(text);
    }


//    private void applyLetterSpacing(String text) {
//        StringBuilder builder = new StringBuilder();
//        for(int i = 0; i < text.length(); i++) {
//            String c = ""+ text.charAt(i);
//            builder.append(c.toLowerCase());
//            if(i+1 < text.length()) {
//                builder.append("\u00A0");
//            }
//        }
//        SpannableString finalText = new SpannableString(builder.toString());
//        if(builder.toString().length() > 1) {
//            for(int i = 1; i < builder.toString().length(); i+=2) {
//                finalText.setSpan(new ScaleXSpan((letterSpacing+1)/10), i, i+1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//            }
//        }
//        super.setText(finalText, BufferType.SPANNABLE);
//    }
//
//    public class LetterSpacing {
//        public final static float NORMAL = 0;
//        public final static float NORMALBIG = (float)0.025;
//        public final static float BIG = (float)0.05;
//        public final static float BIGGEST = (float)0.2;
//    }

}
