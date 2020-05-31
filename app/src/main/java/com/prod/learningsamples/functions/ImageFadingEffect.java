package com.prod.learningsamples.functions;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;

import com.prod.learningsamples.R;

public class ImageFadingEffect extends AppCompatImageView {

    Context context;
    public boolean mFadeRight;
    public boolean mFadeLeft;
    public boolean mFadeTop;
    public boolean mFadeBottom;
    TypedArray ta;
    float fadeRight = 0;
    float fadeLeft = 0;
    float fadeTop = 0;
    float fadeBottom = 0;
    float fadeLength = 0;

    public ImageFadingEffect(Context context) {
        super(context);
        this.context = context;
        init(null);
    }

    public ImageFadingEffect(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init(attrs);
    }

    public ImageFadingEffect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        init(attrs);
    }

    private void init(@Nullable AttributeSet set) {
        try {
            // Enable horizontal fading
            this.setHorizontalFadingEdgeEnabled(true);
            //Apply vertical fading
            this.setVerticalFadingEdgeEnabled(true);
            // Apply default fading length
            this.setEdgeLength(14);
            ta = getContext().obtainStyledAttributes(set, R.styleable.ImageFadingStyle);
            fadeRight = ta.getInteger(R.styleable.ImageFadingStyle_fadeRight,0);
            fadeLeft = ta.getInteger(R.styleable.ImageFadingStyle_fadeLeft,0);
            fadeTop = ta.getInteger(R.styleable.ImageFadingStyle_fadeTop,0);
            fadeBottom = ta.getInteger(R.styleable.ImageFadingStyle_fadeBottom,0);
            fadeLength = ta.getInteger(R.styleable.ImageFadingStyle_fadeLength,0);
            mFadeRight = ta.getBoolean(R.styleable.ImageFadingStyle_enableRightFadeEdge,false);
            mFadeLeft = ta.getBoolean(R.styleable.ImageFadingStyle_enableLeftFadeEdge,false);
            mFadeTop = ta.getBoolean(R.styleable.ImageFadingStyle_enableTopFadeEdge,false);
            mFadeBottom = ta.getBoolean(R.styleable.ImageFadingStyle_enableBottomFadeEdge,false);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ta.recycle();
        }
    }


    public void setEdgeLength(int length) {
        this.setFadingEdgeLength(getPixels(length));
    }

    @Override
    protected float getLeftFadingEdgeStrength() {
        return mFadeLeft ? 1.0f : 0.0f;
    }

    @Override
    protected float getRightFadingEdgeStrength() {
        return mFadeRight ? 1.0f : 0.0f;
    }

    @Override
    protected float getTopFadingEdgeStrength() {
        return mFadeTop ? 1.0f : 0.0f;
    }

    @Override
    protected float getBottomFadingEdgeStrength() {
        return mFadeBottom ? 1.0f : 0.0f;
    }

    @Override
    public boolean hasOverlappingRendering() {
        return true;
    }

    @Override
    public boolean onSetAlpha(int alpha) {
        return false;
    }

    private int getPixels(int dipValue) {
        Resources r = context.getResources();

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dipValue, r.getDisplayMetrics());
    }
}