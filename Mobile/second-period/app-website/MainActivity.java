package com.uniftec.sites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnTerra, btnClicRBS,btnUol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTerra = (Button) findViewById(R.id.btnTerra);
        btnClicRBS = (Button) findViewById(R.id.btnClicRBS);
        btnUol = (Button) findViewById(R.id.btnUol);

        btnTerra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirSite = new Intent(Intent.ACTION_VIEW);
                abrirSite.setData(Uri.parse("http://www.terra.com.br"));
                MainActivity.this.startActivity(abrirSite);
            }
        });

        btnClicRBS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirSite = new Intent(Intent.ACTION_VIEW);
                abrirSite.setData(Uri.parse("http://www.clicrbs.com.br"));
                MainActivity.this.startActivity(abrirSite);
            }
        });

        btnUol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirSite = new Intent(Intent.ACTION_VIEW);
                abrirSite.setData(Uri.parse("http://www.uol.com.br"));
                MainActivity.this.startActivity(abrirSite);
            }
        });
    }
}