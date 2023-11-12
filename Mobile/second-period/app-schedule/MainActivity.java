package com.uniftec.appagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnCadastrar,btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnConsultar = (Button) findViewById(R.id.btnConsultar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaCadastrar = new Intent(MainActivity.this,Cadastrar.class);
                MainActivity.this.startActivity(telaCadastrar);
                MainActivity.this.finish();
            }
        });
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaConsultar = new Intent(MainActivity.this,Consultar.class);
                MainActivity.this.startActivity(telaConsultar);
                MainActivity.this.finish();
            }
        });
    }
}