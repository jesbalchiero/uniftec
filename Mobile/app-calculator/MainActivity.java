package com.uniftec.appcalculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtValor1,edtValor2;
    private Button btnSoma,btnSubtracao,btnMultiplicacao,btnDivisao,btnLimpar;
    private TextView txtResultado;
    private float valor1,valor2,resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtValor1 = (EditText) findViewById(R.id.edtValor1);
        edtValor2 = (EditText) findViewById(R.id.edtValor2);
        btnSoma = (Button) findViewById(R.id.btnSoma);
        btnSubtracao = (Button) findViewById(R.id.btnSubtracao);
        btnMultiplicacao = (Button) findViewById(R.id.btnMultiplicacao);
        btnDivisao = (Button) findViewById(R.id.btnDivisao);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        btnSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                somar();
            }
        });
        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtrair();
            }
        });
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplicar();
            }
        });
        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dividir();
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void somar()
    {
        try
        {
            valor1 = Float.parseFloat(edtValor1.getText().toString());
            try
            {
                valor2 = Float.parseFloat(edtValor2.getText().toString());
                resultado = valor1 + valor2;
                txtResultado.setText("Resultado: " + resultado);
            }catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), "Valor 2 é inválido",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Valor 1 é inválido",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void subtrair()
    {
        try
        {
            valor1 = Float.parseFloat(edtValor1.getText().toString());
            try
            {
                valor2 = Float.parseFloat(edtValor2.getText().toString());
                resultado = valor1 - valor2;
                txtResultado.setText("Resultado: " + resultado);
            }catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), "Valor 2 é inválido",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Valor 1 é inválido",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void multiplicar()
    {
        try
        {
            valor1 = Float.parseFloat(edtValor1.getText().toString());
            try
            {
                valor2 = Float.parseFloat(edtValor2.getText().toString());
                resultado = valor1 * valor2;
                txtResultado.setText("Resultado: " + resultado);
            }catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), "Valor 2 é inválido",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Valor 1 é inválido",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void dividir()
    {
        try
        {
            valor1 = Float.parseFloat(edtValor1.getText().toString());
            try
            {
                valor2 = Float.parseFloat(edtValor2.getText().toString());
                resultado = valor1 / valor2;
                txtResultado.setText("Resultado: " + resultado);
            }catch (Exception e)
            {
                Toast.makeText(getApplicationContext(), "Valor 2 é inválido",
                        Toast.LENGTH_LONG).show();
            }
        }catch (Exception e)
        {
            Toast.makeText(getApplicationContext(), "Valor 1 é inválido",
                    Toast.LENGTH_LONG).show();
        }
    }

    private void limpar()
    {
        edtValor1.setText("");
        edtValor2.setText("");
        txtResultado.setText("Resultado:");
        edtValor1.requestFocus();
    }
}