package com.example.myScreenAdapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myScreenAdapter.density.DensityActivity;
import com.example.myScreenAdapter.notch.NotchActivity;
import com.example.myScreenAdapter.percent.PercentActivity;
import com.example.myScreenAdapter.pixel.PixelActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pixel(View view) {
        Intent intent = new Intent(MainActivity.this, PixelActivity.class);
        startActivity(intent);
    }

    public void percent(View view) {
        Intent intent = new Intent(MainActivity.this, PercentActivity.class);
        startActivity(intent);
    }

    public void density(View view) {
        Intent intent = new Intent(MainActivity.this, DensityActivity.class);
        startActivity(intent);
    }

    public void notch(View view) {
        Intent intent = new Intent(MainActivity.this, NotchActivity.class);
        startActivity(intent);
    }
}
