package com.uniftec.cronometro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    private Chronometer cronometro;
    private Button btnIniciar, btnPausar, btnZerar;
    long tempoAtual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cronometro = (Chronometer) findViewById(R.id.cronometro);
        btnIniciar = (Button) findViewById(R.id.btnIniciar);
        btnPausar = (Button) findViewById(R.id.btnPausar);
        btnZerar = (Button) findViewById(R.id.btnZerar);
        btnPausar.setEnabled(false);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIniciar.setEnabled(false);
                btnPausar.setEnabled(true);
                cronometro.setBase(SystemClock.elapsedRealtime() + tempoAtual);
            }
        });

        btnPausar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIniciar.setEnabled(true);
                btnPausar.setEnabled(false);
                tempoAtual = cronometro.getBase() - SystemClock.elapsedRealtime();
                cronometro.stop();
            }
        });

        btnZerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnIniciar.setEnabled(true);
                btnPausar.setEnabled(false);
                cronometro.stop();
                cronometro.setBase((SystemClock.elapsedRealtime()));
                tempoAtual = 0;
            }
        });
    }
}