package com.uniftec.circulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtRaio;
    private Button btnCalcular,btnLimpar;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtRaio = (EditText) findViewById(R.id.edtRaio);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float raio,area;
                try {
                    raio = Float.parseFloat(edtRaio.getText().toString());
                    area = (float)(3.14 * raio * raio);
                    txtResultado.setText("Resultado: A área é igual a " + area);
                }catch (Exception erro){
                    Toast.makeText(getApplicationContext(),"Você não digitou o valor do raio!",Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtRaio.setText("");
                txtResultado.setText("Resultado: ");
                edtRaio.requestFocus();
            }
        });

    }
}