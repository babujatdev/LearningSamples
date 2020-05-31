package com.prod.learningsamples.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.prod.learningsamples.R;
import com.prod.learningsamples.functions.ImageFadingEffect;

public class MainActivity extends AppCompatActivity {
    ImageFadingEffect imageFadingEffect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init(){
        imageFadingEffect = (ImageFadingEffect)findViewById(R.id.viewpagerImages);
    }
}