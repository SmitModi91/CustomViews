package com.smit.customlayouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by Stratecore on 6/19/2017.
 */

public class CustomButton extends Button {
    public CustomButton(Context context) {
        this(context, null, 0);
    }

    public CustomButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {


        float textsize = 0;
        int textcolor;
        int buttonBackgroundColor;
        Typeface typeface;
        boolean singleline = false;
        int CornerRoundColor;

        GradientDrawable gradientDrawable;
        if (attrs == null) {

            textsize = 16;
            textcolor = Color.BLACK;
            typeface = Typeface.DEFAULT;
            singleline = false;
            buttonBackgroundColor = Color.BLACK;
            gradientDrawable = new GradientDrawable();
            gradientDrawable.setStroke(2, Color.BLACK);
            gradientDrawable.setColor(buttonBackgroundColor);
            gradientDrawable.setCornerRadius(2);
        } else {
            gradientDrawable = new GradientDrawable();

            final TypedArray awt = context.obtainStyledAttributes(attrs, R.styleable.CustomButton, defStyleAttr, 0);

            //Text Typeface Getting
            String typefacedata = awt.getString(R.styleable.CustomButton_buttontypeface);

            //Set Text Typeface Getting
            typeface = Typeface.createFromAsset(context.getAssets(), typefacedata);

            //Text Color Getting
            textcolor = awt.getColor(R.styleable.CustomButton_buttontextcolor, 0);

            textsize = awt.getInt(R.styleable.CustomButton_buttontextsize, 0);

            singleline = awt.getBoolean(R.styleable.CustomButton_buttonsingleLine,false);



            buttonBackgroundColor = awt.getColor(R.styleable.CustomButton_buttonbackround, 0);

            int size = awt.getInt(R.styleable.CustomButton_buttonCornerRoundWidth, 0);

            CornerRoundColor = awt.getColor(R.styleable.CustomButton_buttonCornerRoundColor, 0);
            int CornerRadiaus = awt.getInt(R.styleable.CustomButton_buttonCornerRadius, 0);
            gradientDrawable.setColor(buttonBackgroundColor);
            gradientDrawable.setCornerRadius(CornerRadiaus);
            gradientDrawable.setStroke(size, CornerRoundColor);

        }
        setTypeface(typeface);
        setTextColor(textcolor);
        setTextSize(textsize);
        setSingleLine(singleline);

        setBackgroundDrawable(gradientDrawable);
    }
}
