package com.prod.learningsamples.functions;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

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
    boolean fadeRight = false;
    boolean fadeLeft = false;
    boolean fadeTop = false;
    boolean fadeBottom = false;
    int fadeLength = 0;

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
            ta = getContext().obtainStyledAttributes(set, R.styleable.ImageFadingEffect);
            fadeRight = ta.getBoolean(R.styleable.ImageFadingEffect_fadeRight, false);
            fadeLeft = ta.getBoolean(R.styleable.ImageFadingEffect_fadeLeft, false);
            fadeTop = ta.getBoolean(R.styleable.ImageFadingEffect_fadeTop, false);
            fadeBottom = ta.getBoolean(R.styleable.ImageFadingEffect_fadeBottom, false);
            fadeLength = ta.getInteger(R.styleable.ImageFadingEffect_fadeLength, fadeLength);

            // Enable horizontal fading
            this.setHorizontalFadingEdgeEnabled(true);
            // Apply vertical fading
            this.setVerticalFadingEdgeEnabled(true);
            // Apply default fading length
            this.setEdgeLength(fadeLength);
            this.setFadeRight(fadeRight);
            this.setFadeLeft(fadeLeft);
            this.setFadeTop(fadeTop);
            this.setFadeBottom(fadeBottom);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ta.recycle();
        }
    }

    public void setFadeRight(boolean fadeRight) {
        mFadeRight = fadeRight;
    }

    public void setFadeLeft(boolean fadeLeft) {
        mFadeLeft = fadeLeft;
    }

    public void setFadeTop(boolean fadeTop) {
        mFadeTop = fadeTop;
    }

    public void setFadeBottom(boolean fadeBottom) {
        mFadeBottom = fadeBottom;
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