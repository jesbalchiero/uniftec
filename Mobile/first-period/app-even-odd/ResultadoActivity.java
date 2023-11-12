package com.uniftec.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        Intent telaNumero = getIntent();
        double numero = telaNumero.getIntExtra("numeroDigitado",0);
        if (numero % 2 == 0) {
            txtResultado.setText("O número " + numero + " é PAR");
            txtResultado.setTextColor(Color.parseColor("#0000FF"));
        } else {
            txtResultado.setText("O número " + numero + " é ÍMPAR");
            txtResultado.setTextColor(Color.parseColor("FF0000"));
        }

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal = new Intent(getApplicationContext(), MainActivity.class);
                ResultadoActivity.this.finish();
                startActivity(telaPrincipal);
            }
        });

    }
}