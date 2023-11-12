package com.uniftec.volumecaixaretangular;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtComprimento,edtAltura,edtLargura;
    private Button btnCalcular,btnLimpar,btnPassarDadosProximaTela;
    private TextView txtResultado;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtComprimento = (EditText) findViewById(R.id.edtComprimento);
        edtAltura = (EditText) findViewById(R.id.edtAltura);
        edtLargura = (EditText) findViewById(R.id.edtLargura);
        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnPassarDadosProximaTela = (Button) findViewById(R.id.btnPassarDadosProximaTela);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        res = getResources();

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float comprimento,largura, altura,volume;
                try
                {
                    comprimento = Float.parseFloat(edtComprimento.getText().toString());
                    largura = Float.parseFloat(edtLargura.getText().toString());
                    altura = Float.parseFloat(edtAltura.getText().toString());
                    volume = comprimento * largura * altura;
                    txtResultado.setText(String.format(res.getString(R.string.resultado)) + " " + volume);
                }catch (Exception erro)
                {
                    Toast.makeText(getApplicationContext(), String.format(res.getString(R.string.erro)), Toast.LENGTH_LONG).show();
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtComprimento.setText("");
                edtAltura.setText("");
                edtLargura.setText("");
                txtResultado.setText(String.format(res.getString(R.string.resultado)));
            }
        });

        btnPassarDadosProximaTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent enviaDados = new Intent(MainActivity.this,Dados.class);
                String dados = "Comprimento: " + edtComprimento.getText().toString() + "\n" +
                               "Altura: " + edtAltura.getText().toString() + "\n" +
                               "Largura: " + edtLargura.getText().toString() + "\n" +
                               txtResultado.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("dados",dados);
                enviaDados.putExtras(bundle);
                startActivity(enviaDados);
            }
        });
    }
}