package com.hjg.inject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.btn1)
    Button btn1;
    @ViewInject(R.id.btn2)
    Button btn2;
    @ViewInject(R.id.btn3)
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtilsTest.bind(this);
        btn1.setText("3324324");
    }


    @OnClick({R.id.btn1, R.id.btn2})
    public void onClick(View view) {
        Log.d("MainActivity", "onclick");
        switch (view.getId()) {

        }
    }
}
