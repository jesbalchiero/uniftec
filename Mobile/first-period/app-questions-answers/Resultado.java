package com.uniftec.jogo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView txtCorretas,txtErradas,txtParabens;
    private Button btnFinalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);
        txtCorretas = (TextView) findViewById(R.id.txtCorretas);
        txtErradas = (TextView) findViewById(R.id.txtErradas);
        txtParabens = (TextView) findViewById(R.id.txtParabens);

        txtCorretas.setText("Total de Respostas Corretas: " + MainActivity.percentualCorretas + "%");
        txtErradas.setText("Total de Respostas Erradas: " + MainActivity.percentualErradas + "%");
        if (MainActivity.percentualCorretas == 100)
            txtParabens.setText("Parabéns!");

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Resultado.this.finish();
            }
        });
    }
}