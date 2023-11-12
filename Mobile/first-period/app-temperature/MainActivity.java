package com.uniftec.apptemperatura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtCelsius;
    private Button btnCalcular,btnLimpar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtCelsius = (EditText) findViewById(R.id.edtCelsius);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float c,k;
                try
                {
                    c = Float.parseFloat(edtCelsius.getText().toString());
                    k = (float)(c + 273.15);
                    txtResultado.setText("Resultado: " + k + " Kelvin");
                }catch (Exception e)
                {
                    Toast.makeText(MainActivity.this,"Você digitou um valor inválido",Toast.LENGTH_LONG).show();
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtCelsius.setText("");
                txtResultado.setText("Resultado: ");
                edtCelsius.requestFocus();
            }
        });
    }
}