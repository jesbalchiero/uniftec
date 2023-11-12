package com.uniftec.relogio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Date data = new Date();
    private DateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calendario = Calendar.getInstance();
    private int diaSemana;
    private Timer timer = new Timer();
    private TextView txtData,txtDiaSemana;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtData = (TextView) findViewById(R.id.txtData);
        txtDiaSemana = (TextView) findViewById(R.id.txtDiaSemana);
        dataAgora(data);
        atualizaData();
    }

    public void atualizaData()
    {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Date data = new Date();
                        dataAgora(data);
                    }
                });
            }
        },0,1000);
    }

    private void dataAgora(Date data)
    {
        txtData.setText(formataData.format(data));
        calendario.setTime(data);
        diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
        if (diaSemana == 1)
            txtDiaSemana.setText("Domingo");
        else if (diaSemana == 2)
            txtDiaSemana.setText("Segunda-feira");
        else if (diaSemana == 3)
            txtDiaSemana.setText("Terça-feira");
        else if (diaSemana == 4)
            txtDiaSemana.setText("Quarta-feira");
        else if (diaSemana == 5)
            txtDiaSemana.setText("Quinta-feira");
        else if (diaSemana == 6)
            txtDiaSemana.setText("Sexta-feira");
        else
            txtDiaSemana.setText("Sábado");
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (timer != null)
            timer.cancel();
    }
}