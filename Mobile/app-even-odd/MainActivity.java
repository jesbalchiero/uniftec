package com.uniftec.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumero;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numero = Integer.parseInt(edtNumero.getText().toString());
                Intent telaResultado = new Intent(getApplicationContext(),ResultadoActivity.class);
                telaResultado.putExtra("numeroDigitado",numero);
                MainActivity.this.finish();
                startActivity(telaResultado);
            }
        });
    }
}