package com.uniftec.sortearnumero;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btnSortearNumero;
    private int numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btnSortearNumero = (Button) findViewById(R.id.btnSortearNumero);

        sortearNumero();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 1)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 2)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 3)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 4)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 5)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 6)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 7)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 8)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 9)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 10)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 11)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numero == 12)
                    alertParabens();
                else
                    alertIncorreto();
            }
        });

        btnSortearNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortearNumero();
            }
        });
    }

    private void sortearNumero()
    {
        Random rnd = new Random();
        int x = rnd.nextInt(12);
        numero = x + 1;
    }

    private void alertParabens()
    {
        AlertDialog alertParabens;
        AlertDialog.Builder builderParabens = new AlertDialog.Builder(this);
        builderParabens.setTitle("Parabéns");
        builderParabens.setMessage("Parabéns! Você acertou o número sorteado! Deseja sortear novamente outro número?");
        builderParabens.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                sortearNumero();
            }
        });
        builderParabens.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });
        alertParabens = builderParabens.create();
        alertParabens.show();
    }

    private void alertIncorreto()
    {
        AlertDialog alertIncorreto;
        AlertDialog.Builder builderIncorreto = new AlertDialog.Builder(this);
        builderIncorreto.setTitle("Número Sorteado Incorreto");
        builderIncorreto.setMessage("Infelizmente o número sorteado não foi o escolhido!");
        builderIncorreto.setPositiveButton("OK",null);
        alertIncorreto = builderIncorreto.create();
        alertIncorreto.show();
    }

}