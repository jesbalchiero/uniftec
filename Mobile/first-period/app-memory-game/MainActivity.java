package com.uniftec.appjogomemoria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageButton btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
    private int[] botao = new int[12];
    private int tipoJogada = 1;
    private int[] ocultarImagens = new int[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0 = (ImageButton) findViewById(R.id.btn0);
        btn1 = (ImageButton) findViewById(R.id.btn1);
        btn2 = (ImageButton) findViewById(R.id.btn2);
        btn3 = (ImageButton) findViewById(R.id.btn3);
        btn4 = (ImageButton) findViewById(R.id.btn4);
        btn5 = (ImageButton) findViewById(R.id.btn5);
        btn6 = (ImageButton) findViewById(R.id.btn6);
        btn7 = (ImageButton) findViewById(R.id.btn7);
        btn8 = (ImageButton) findViewById(R.id.btn8);
        btn9 = (ImageButton) findViewById(R.id.btn9);
        btn10 = (ImageButton) findViewById(R.id.btn10);
        btn11 = (ImageButton) findViewById(R.id.btn11);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (btn0.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn0.setImageResource(botao[0]);
                        btn0.setEnabled(false);
                        ocultarImagens[0]=0;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn0.setImageResource(botao[0]);
                        btn0.setEnabled(false);
                        ocultarImagens[1]=0;
                        if (acertou(0)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn0.setImageResource(botao[0]);
                        btn0.setEnabled(false);
                        ocultarImagens[0]=0;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn1.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn1.setImageResource(botao[1]);
                        btn1.setEnabled(false);
                        ocultarImagens[0]=1;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn1.setImageResource(botao[1]);
                        btn1.setEnabled(false);
                        ocultarImagens[1]=1;
                        if (acertou(1)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn1.setImageResource(botao[1]);
                        btn1.setEnabled(false);
                        ocultarImagens[0]=1;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn2.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn2.setImageResource(botao[2]);
                        btn2.setEnabled(false);
                        ocultarImagens[0]=2;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn2.setImageResource(botao[2]);
                        btn2.setEnabled(false);
                        ocultarImagens[1]=2;
                        if (acertou(2)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn2.setImageResource(botao[2]);
                        btn2.setEnabled(false);
                        ocultarImagens[0]=2;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn3.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn3.setImageResource(botao[3]);
                        btn3.setEnabled(false);
                        ocultarImagens[0]=3;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn3.setImageResource(botao[3]);
                        btn3.setEnabled(false);
                        ocultarImagens[1]=3;
                        if (acertou(3)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn3.setImageResource(botao[3]);
                        btn3.setEnabled(false);
                        ocultarImagens[0]=3;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn4.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn4.setImageResource(botao[4]);
                        btn4.setEnabled(false);
                        ocultarImagens[0]=4;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn4.setImageResource(botao[4]);
                        btn4.setEnabled(false);
                        ocultarImagens[1]=4;
                        if (acertou(4)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn4.setImageResource(botao[4]);
                        btn4.setEnabled(false);
                        ocultarImagens[0]=4;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn5.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn5.setImageResource(botao[5]);
                        btn5.setEnabled(false);
                        ocultarImagens[0]=5;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn5.setImageResource(botao[5]);
                        btn5.setEnabled(false);
                        ocultarImagens[1]=5;
                        if (acertou(5)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn5.setImageResource(botao[5]);
                        btn5.setEnabled(false);
                        ocultarImagens[0]=5;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn6.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn6.setImageResource(botao[6]);
                        btn6.setEnabled(false);
                        ocultarImagens[0]=6;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn6.setImageResource(botao[6]);
                        btn6.setEnabled(false);
                        ocultarImagens[1]=6;
                        if (acertou(6)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn6.setImageResource(botao[6]);
                        btn6.setEnabled(false);
                        ocultarImagens[0]=6;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn7.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn7.setImageResource(botao[7]);
                        btn7.setEnabled(false);
                        ocultarImagens[0]=7;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn7.setImageResource(botao[7]);
                        btn7.setEnabled(false);
                        ocultarImagens[1]=7;
                        if (acertou(7)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn7.setImageResource(botao[7]);
                        btn7.setEnabled(false);
                        ocultarImagens[0]=7;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn8.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn8.setImageResource(botao[8]);
                        btn8.setEnabled(false);
                        ocultarImagens[0]=8;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn8.setImageResource(botao[8]);
                        btn8.setEnabled(false);
                        ocultarImagens[1]=8;
                        if (acertou(8)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn8.setImageResource(botao[8]);
                        btn8.setEnabled(false);
                        ocultarImagens[0]=8;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn9.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn9.setImageResource(botao[9]);
                        btn9.setEnabled(false);
                        ocultarImagens[0]=9;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn9.setImageResource(botao[9]);
                        btn9.setEnabled(false);
                        ocultarImagens[1]=9;
                        if (acertou(9)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn9.setImageResource(botao[9]);
                        btn9.setEnabled(false);
                        ocultarImagens[0]=9;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn10.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn10.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn10.setImageResource(botao[10]);
                        btn10.setEnabled(false);
                        ocultarImagens[0]=10;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn10.setImageResource(botao[10]);
                        btn10.setEnabled(false);
                        ocultarImagens[1]=10;
                        if (acertou(10)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn10.setImageResource(botao[10]);
                        btn10.setEnabled(false);
                        ocultarImagens[0]=10;
                        tipoJogada=2;
                    }
                }
            }
        });
        btn11.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if (btn11.isEnabled()==true)
                {
                    if (tipoJogada==1)
                    {
                        btn11.setImageResource(botao[11]);
                        btn11.setEnabled(false);
                        ocultarImagens[0]=11;
                        tipoJogada++;
                    }else if (tipoJogada==2)
                    {
                        btn11.setImageResource(botao[11]);
                        btn11.setEnabled(false);
                        ocultarImagens[1]=11;
                        if (acertou(11)==true)
                        {
                            Toast toast = Toast.makeText(getApplicationContext(),"Parabéns!!! Você acertou!!!",Toast.LENGTH_LONG);
                            toast.show();
                            ocultarImagens[0]=-1;
                            ocultarImagens[1]=-1;
                            testaEncerrouJogo();
                        }
                        tipoJogada++;
                    }else if (tipoJogada==3)
                    {
                        remontarTabuleiro();
                        btn11.setImageResource(botao[11]);
                        btn11.setEnabled(false);
                        ocultarImagens[0]=11;
                        tipoJogada=2;
                    }
                }
            }
        });
    }

    public void remontarTabuleiro()
    {
        if (ocultarImagens[0]==0 || ocultarImagens[1]==0)
        {
            btn0.setEnabled(true);
            btn0.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==1 || ocultarImagens[1]==1)
        {
            btn1.setEnabled(true);
            btn1.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==2 || ocultarImagens[1]==2)
        {
            btn2.setEnabled(true);
            btn2.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==3 || ocultarImagens[1]==3)
        {
            btn3.setEnabled(true);
            btn3.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==4 || ocultarImagens[1]==4)
        {
            btn4.setEnabled(true);
            btn4.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==5 || ocultarImagens[1]==5)
        {
            btn5.setEnabled(true);
            btn5.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==6 || ocultarImagens[1]==6)
        {
            btn6.setEnabled(true);
            btn6.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==7 || ocultarImagens[1]==7)
        {
            btn7.setEnabled(true);
            btn7.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==8 || ocultarImagens[1]==8)
        {
            btn8.setEnabled(true);
            btn8.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==9 || ocultarImagens[1]==9)
        {
            btn9.setEnabled(true);
            btn9.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==10 || ocultarImagens[1]==10)
        {
            btn10.setEnabled(true);
            btn10.setImageResource(R.drawable.ic_launcher);
        }
        if (ocultarImagens[0]==11 || ocultarImagens[1]==11)
        {
            btn11.setEnabled(true);
            btn11.setImageResource(R.drawable.ic_launcher);
        }
    }

    protected void sorteiaImagens()
    {
        btn0.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn10.setEnabled(true);
        btn11.setEnabled(true);
        btn0.setImageResource(R.drawable.ic_launcher);
        btn1.setImageResource(R.drawable.ic_launcher);
        btn2.setImageResource(R.drawable.ic_launcher);
        btn3.setImageResource(R.drawable.ic_launcher);
        btn4.setImageResource(R.drawable.ic_launcher);
        btn5.setImageResource(R.drawable.ic_launcher);
        btn6.setImageResource(R.drawable.ic_launcher);
        btn7.setImageResource(R.drawable.ic_launcher);
        btn8.setImageResource(R.drawable.ic_launcher);
        btn9.setImageResource(R.drawable.ic_launcher);
        btn10.setImageResource(R.drawable.ic_launcher);
        btn11.setImageResource(R.drawable.ic_launcher);
        for (int i=0;i<=11;i++)
            botao[i]=-1;
        Random random=new Random();
        int imagem=1;
        while (botao[0]==-1 || botao[1]==-1 || botao[2]==-1 || botao[3]==-1 || botao[4]==-1 || botao[5]==-1 ||
                botao[6]==-1 || botao[7]==-1 || botao[8]==-1 || botao[9]==-1 || botao[10]==-1 || botao[11]==-1)
        {
            int botaoSorteado=random.nextInt(12);
            if (botao[botaoSorteado]==-1)
            {
                if (imagem==1)
                    botao[botaoSorteado]=R.drawable.imagem1;
                else if (imagem==2)
                    botao[botaoSorteado]=R.drawable.imagem2;
                else if (imagem==3)
                    botao[botaoSorteado]=R.drawable.imagem3;
                else if (imagem==4)
                    botao[botaoSorteado]=R.drawable.imagem4;
                else if (imagem==5)
                    botao[botaoSorteado]=R.drawable.imagem5;
                else
                    botao[botaoSorteado]=R.drawable.imagem6;
                imagem++;
                if (imagem==7)
                    imagem=1;
            }
        }
        tipoJogada=1;
    }

    protected void testaEncerrouJogo()
    {
        if (btn0.isEnabled()==false && btn1.isEnabled()==false && btn2.isEnabled()==false &&
                btn3.isEnabled()==false && btn4.isEnabled()==false && btn5.isEnabled()==false &&
                btn6.isEnabled()==false && btn7.isEnabled()==false && btn8.isEnabled()==false &&
                btn9.isEnabled()==false && btn10.isEnabled()==false && btn11.isEnabled()==false)
        {
            AlertDialog alertEncerrouJogo;
            AlertDialog.Builder builderEncerrouJogo=new AlertDialog.Builder(this);
            builderEncerrouJogo.setTitle("Jogo Encerrou");
            builderEncerrouJogo.setMessage("Deseja jogar novamente?");
            builderEncerrouJogo.setPositiveButton("Sim", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    sorteiaImagens();
                }
            });
            builderEncerrouJogo.setNegativeButton("Não", new DialogInterface.OnClickListener()
            {
                public void onClick(DialogInterface dialog, int id)
                {
                    MainActivity.this.finish();
                }
            });
            alertEncerrouJogo=builderEncerrouJogo.create();
            alertEncerrouJogo.show();
        }
    }
    public boolean acertou(int numeroBotao)
    {
        if (numeroBotao!=0 && botao[0]==botao[numeroBotao] && btn0.isEnabled()==false)
            return true;
        else if (numeroBotao!=1 && botao[1]==botao[numeroBotao] && btn1.isEnabled()==false)
            return true;
        else if (numeroBotao!=2 && botao[2]==botao[numeroBotao] && btn2.isEnabled()==false)
            return true;
        else if (numeroBotao!=3 && botao[3]==botao[numeroBotao] && btn3.isEnabled()==false)
            return true;
        else if (numeroBotao!=4 && botao[4]==botao[numeroBotao] && btn4.isEnabled()==false)
            return true;
        else if (numeroBotao!=5 && botao[5]==botao[numeroBotao] && btn5.isEnabled()==false)
            return true;
        else if (numeroBotao!=6 && botao[6]==botao[numeroBotao] && btn6.isEnabled()==false)
            return true;
        else if (numeroBotao!=7 && botao[7]==botao[numeroBotao] && btn7.isEnabled()==false)
            return true;
        else if (numeroBotao!=8 && botao[8]==botao[numeroBotao] && btn8.isEnabled()==false)
            return true;
        else if (numeroBotao!=9 && botao[9]==botao[numeroBotao] && btn9.isEnabled()==false)
            return true;
        else if (numeroBotao!=10 && botao[10]==botao[numeroBotao] && btn10.isEnabled()==false)
            return true;
        else if (numeroBotao!=11 && botao[11]==botao[numeroBotao] && btn11.isEnabled()==false)
            return true;
        else
            return false;
    }
}