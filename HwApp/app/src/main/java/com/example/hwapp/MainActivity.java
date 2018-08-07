package com.example.hwapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button hw_app;
    private Button hwapp_nodata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hw_app=(Button)findViewById(R.id.btn_hwapp);
        hwapp_nodata=(Button)findViewById(R.id.btn_hwapp_nodata);
        hw_app.setOnClickListener(this);
        hwapp_nodata.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_hwapp:
                Intent intent = new Intent(MainActivity.this,HwApplication.class);
                intent.putExtra("resultcode",1);
                startActivity(intent);
                break;
           /* case R.id.btn_hwapp_nodata:
                Intent intent1 = new Intent(MainActivity.this,HwApplication.class);
                intent1.putExtra("resultcode",2);
                startActivity(intent1);
                break;
                default:
                    break;*/
        }

    }
}
