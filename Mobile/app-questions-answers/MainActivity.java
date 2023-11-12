package com.uniftec.jogo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int corretas = 0;
    private int erradas = 0;
    protected static int percentualCorretas,percentualErradas;
    private TextView txtQuestao,txtRespostasCorretas,txtRespostasErradas;
    private RadioButton rbAlt1,rbAlt2,rbAlt3,rbAlt4,rbAlt5;
    private Button btnAvancar;
    private int numeroQuestao = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtQuestao = (TextView) findViewById(R.id.txtQuestao);
        rbAlt1 = (RadioButton) findViewById(R.id.rbAlternativa1);
        rbAlt2 = (RadioButton) findViewById(R.id.rbAlternativa2);
        rbAlt3 = (RadioButton) findViewById(R.id.rbAlternativa3);
        rbAlt4 = (RadioButton) findViewById(R.id.rbAlternativa4);
        rbAlt5 = (RadioButton) findViewById(R.id.rbAlternativa5);
        btnAvancar = (Button) findViewById(R.id.btnAvancar);
        txtRespostasCorretas = (TextView) findViewById(R.id.txtRespostasCorretas);
        txtRespostasErradas = (TextView) findViewById(R.id.txtRespostasErradas);

        mostraQuestao();

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numeroQuestao==1)
                {
                    if (rbAlt3.isChecked())
                    {
                        corretas++;
                        Toast.makeText(getApplicationContext(),"Resposta correta!!!",Toast.LENGTH_LONG).show();
                    }else
                    {
                        erradas++;
                        Toast.makeText(getApplicationContext(),"Resposta errada!!!",Toast.LENGTH_LONG).show();
                    }
                    numeroQuestao++;
                    mostraQuestao();
                }else if (numeroQuestao==2)
                {
                    if (rbAlt1.isChecked())
                    {
                        corretas++;
                        Toast.makeText(getApplicationContext(),"Resposta correta!!!",Toast.LENGTH_LONG).show();
                    }else
                    {
                        erradas++;
                        Toast.makeText(getApplicationContext(),"Resposta errada!!!",Toast.LENGTH_LONG).show();
                    }
                    numeroQuestao++;
                    mostraQuestao();
                }else if (numeroQuestao==3)
                {
                    if (rbAlt5.isChecked())
                    {
                        corretas++;
                        Toast.makeText(getApplicationContext(),"Resposta correta!!!",Toast.LENGTH_LONG).show();
                    }else
                    {
                        erradas++;
                        Toast.makeText(getApplicationContext(),"Resposta errada!!!",Toast.LENGTH_LONG).show();
                    }
                    numeroQuestao++;
                    mostraQuestao();
                }else if (numeroQuestao==4)
                {
                    if (rbAlt2.isChecked())
                    {
                        corretas++;
                        Toast.makeText(getApplicationContext(),"Resposta correta!!!",Toast.LENGTH_LONG).show();
                    }else
                    {
                        erradas++;
                        Toast.makeText(getApplicationContext(),"Resposta errada!!!",Toast.LENGTH_LONG).show();
                    }
                    numeroQuestao++;
                    mostraQuestao();
                    btnAvancar.setText("Finalizar");
                }else if (numeroQuestao==5)
                {
                    btnAvancar.setEnabled(false);
                    if (rbAlt4.isChecked())
                    {
                        corretas++;
                        Toast.makeText(getApplicationContext(),"Resposta correta!!!",Toast.LENGTH_LONG).show();
                    }else
                    {
                        erradas++;
                        Toast toast = Toast.makeText(getApplicationContext(),"Resposta errada!!!",Toast.LENGTH_LONG);
                        toast.show();
                    }
                    percentualCorretas=20*corretas;
                    percentualErradas=20*erradas;
                    Intent telaResultado=new Intent(MainActivity.this,Resultado.class);
                    MainActivity.this.startActivity(telaResultado);
                    MainActivity.this.finish();
                }
                txtRespostasCorretas.setText("Respostas Corretas: " + corretas);
                txtRespostasErradas.setText("Respostas Erradas: " + erradas);
            }
        });
    }

    private void mostraQuestao()
    {
        if (numeroQuestao==1)
        {
            txtQuestao.setText("5+3x9 é igual a: ");
            rbAlt1.setText("72");
            rbAlt2.setText("28");
            rbAlt3.setText("32");
            rbAlt4.setText("36");
            rbAlt5.setText("22");
        }else if (numeroQuestao==2)
        {
            txtQuestao.setText("8/2+4*5 é igual a: ");
            rbAlt1.setText("24");
            rbAlt2.setText("40");
            rbAlt3.setText("-16");
            rbAlt4.setText("16");
            rbAlt5.setText("84");
        }else if (numeroQuestao==3)
        {
            txtQuestao.setText("100/10+42/2 é igual a: ");
            rbAlt1.setText("26");
            rbAlt2.setText("10");
            rbAlt3.setText("-26");
            rbAlt4.setText("11");
            rbAlt5.setText("31");
        }else if (numeroQuestao==4)
        {
            txtQuestao.setText("88/2-24+30 é igual a: ");
            rbAlt1.setText("-10");
            rbAlt2.setText("50");
            rbAlt3.setText("48");
            rbAlt4.setText("52");
            rbAlt5.setText("10");
        }else if (numeroQuestao==5)
        {
            txtQuestao.setText("12/3-4*4 é igual a: ");
            rbAlt1.setText("0");
            rbAlt2.setText("20");
            rbAlt3.setText("-16");
            rbAlt4.setText("-12");
            rbAlt5.setText("-20");
        }
    }

}