package com.uniftec.appjogovelha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnRecomecar;
    private int numero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnRecomecar = (Button) findViewById(R.id.btnRecomecar);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn1.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn1.setText("X");
                    else
                        btn1.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn2.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn2.setText("X");
                    else
                        btn2.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn3.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn3.setText("X");
                    else
                        btn3.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn4.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn4.setText("X");
                    else
                        btn4.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn5.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn5.setText("X");
                    else
                        btn5.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn6.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn6.setText("X");
                    else
                        btn6.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn7.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn7.setText("X");
                    else
                        btn7.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn8.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn8.setText("X");
                    else
                        btn8.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn9.getText().equals(""))
                {
                    numero++;
                    if (numero % 2 == 1)
                        btn9.setText("X");
                    else
                        btn9.setText("O");
                    jogadorVenceu();
                }
            }
        });

        btnRecomecar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recomecar();
            }
        });

    }

    public void jogadorVenceu()
    {
        boolean venceu = false;
        if (!btn1.getText().equals("") && btn1.getText().equals(btn2.getText().toString()) && btn2.getText().equals(btn3.getText().toString()))
            venceu = true;
        else if (!btn4.getText().equals("") && btn4.getText().equals(btn5.getText().toString()) && btn5.getText().equals(btn6.getText().toString()))
            venceu = true;
        else if (!btn7.getText().equals("") && btn7.getText().equals(btn8.getText().toString()) && btn8.getText().equals(btn9.getText().toString()))
            venceu = true;
        else if (!btn1.getText().equals("") && btn1.getText().equals(btn4.getText().toString()) && btn4.getText().equals(btn7.getText().toString()))
            venceu = true;
        else if (!btn2.getText().equals("") && btn2.getText().equals(btn5.getText().toString()) && btn5.getText().equals(btn8.getText().toString()))
            venceu = true;
        else if (!btn3.getText().equals("") && btn3.getText().equals(btn6.getText().toString()) && btn6.getText().equals(btn9.getText().toString()))
            venceu = true;
        else if (!btn1.getText().equals("") && btn1.getText().equals(btn5.getText().toString()) && btn5.getText().equals(btn9.getText().toString()))
            venceu = true;
        else if (!btn3.getText().equals("") && btn3.getText().equals(btn5.getText().toString()) && btn5.getText().equals(btn7.getText().toString()))
            venceu = true;
        if (venceu == true)
        {
            Toast.makeText(getApplicationContext(), "Você venceu!!!", Toast.LENGTH_LONG).show();
            recomecar();
        }else if (numero == 9)
        {
            Toast.makeText(getApplicationContext(), "Nenhum jogador venceu a partida!!!", Toast.LENGTH_LONG).show();
            recomecar();
        }
    }

    private void recomecar()
    {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        numero = 0;
    }

}