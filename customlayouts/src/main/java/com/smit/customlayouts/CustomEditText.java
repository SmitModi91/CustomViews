package com.smit.customlayouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.InputType;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Stratecore on 6/19/2017.
 */

public class CustomEditText extends EditText {


    public CustomEditText(Context context) {
        this(context, null, 0);
    }

    public CustomEditText(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
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


        int texthintcolor;
        if (attrs == null) {

            textsize = 16;
            textcolor = Color.BLACK;
            typeface = Typeface.DEFAULT;

            texthintcolor = Color.BLACK;
            singlineText = false;
            buttonBackgroundColor = Color.BLACK;
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(2, Color.BLACK);
            gradientDrawable.setColor(buttonBackgroundColor);
            gradientDrawable.setCornerRadius(2);
        } else {
            gradientDrawable = new GradientDrawable();

            final TypedArray awt = context.obtainStyledAttributes(attrs, R.styleable.CustomEditText, defStyleAttr, 0);

            //Text Typeface Getting
            String typefacedata = awt.getString(R.styleable.CustomEditText_edittypeface);

            //Set Text Typeface Getting
            typeface = Typeface.createFromAsset(context.getAssets(), typefacedata);

            //Text Color Getting
            textcolor = awt.getColor(R.styleable.CustomEditText_edittextcolor, 0);


            //Text Size Getting
            textsize = awt.getInt(R.styleable.CustomEditText_edittextsize, 0);

            //Text hint color Getting
            texthintcolor = awt.getColor(R.styleable.CustomEditText_edittextColorHint, 0);

            //Text Single line  Getting
            singlineText = awt.getBoolean(R.styleable.CustomEditText_editsingleLine, false);


            int size = awt.getInt(R.styleable.CustomEditText_edittextCornerRoundWidth, 0);
            buttonBackgroundColor = awt.getColor(R.styleable.CustomEditText_edittextbackround, 0);
            CornerRoundColor = awt.getColor(R.styleable.CustomEditText_edittextCornerRoundColor, 0);
            int CornerRadiaus = awt.getInt(R.styleable.CustomEditText_edittextCornerRadius, 0);
            gradientDrawable.setCornerRadius(CornerRadiaus);
            gradientDrawable.setColor(buttonBackgroundColor);
            gradientDrawable.setStroke(size, CornerRoundColor);

        }

        setTypeface(typeface);
        setTextColor(textcolor);
        setTextSize(textsize);

        setHintTextColor(texthintcolor);
        setSingleLine(singlineText);
        setBackgroundDrawable(gradientDrawable);

    }
}
