package com.made_suande_1811010036.login2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_login;
    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String _email = "made@gmail.com"; // dari database
        String _pass = "1234"; // dari database
        String rule = "1"; // 1 atau 2 dr database

        btn_login = findViewById(R.id.btn_login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals(_email)) { //cek email
                    if (pass.getText().toString().equals(_pass)){ // cek pass
                        if (rule.equals("1")) { // cek user rule, 1(admin) atau 2(user)
                            Intent i = new Intent(getApplicationContext(), AdminActivity.class);
                            startActivity(i);
                        }else {
                            Intent i = new Intent(getApplicationContext(), UserActivity.class);
                            startActivity(i);
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "password tidak sesuai", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "email tidak terdaftar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}