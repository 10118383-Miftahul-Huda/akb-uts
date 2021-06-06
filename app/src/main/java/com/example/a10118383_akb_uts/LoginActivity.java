package com.example.a10118383_akb_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Miftahul Huda on 6/6/2021.
 * NIM.10118383
 * Kelas.IF 9
 */


public class LoginActivity extends AppCompatActivity {

    private Button btnlogin;
    private Button btnregis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin = findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        });

            btnregis = findViewById(R.id.btn_regis);
            btnregis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LoginActivity.this, RegisActivity.class);
                    startActivity(intent);
                }
            });
    }
}
