package com.uniftec.despertador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btnAgendarParaDespertar,btnCancelarDespertador;
    private TimePicker timePicker;
    private CheckBox chkDespertadorHabilitado;
    protected static NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgendarParaDespertar = (Button) findViewById(R.id.btnAgendarParaDespertar);
        btnCancelarDespertador = (Button) findViewById(R.id.btnCancelarDespertador);
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        chkDespertadorHabilitado = (CheckBox) findViewById(R.id.chkDespertadorHabilitado);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(0);
        timePicker.setCurrentMinute(0);
        chkDespertadorHabilitado.setEnabled(false);

        btnAgendarParaDespertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentServico = new Intent("EXECUTAR_DESPERTADOR");
                PendingIntent pendingServico = PendingIntent.getBroadcast(MainActivity.this,0,intentServico,0);
                Calendar horaDespertador = Calendar.getInstance();
                horaDespertador.set(Calendar.HOUR_OF_DAY,timePicker.getCurrentHour());
                horaDespertador.set(Calendar.MINUTE,timePicker.getCurrentMinute());
                horaDespertador.set(Calendar.SECOND,0);
                horaDespertador.set(Calendar.MILLISECOND,0);
                if (horaDespertador.getTimeInMillis() < System.currentTimeMillis())
                    alertRestricaoDespertador();
                else
                {
                    AlarmManager alarmeDespertador = (AlarmManager) getSystemService(ALARM_SERVICE);
                    long milissegundosDespertar = horaDespertador.getTimeInMillis();
                    alarmeDespertador.set(AlarmManager.RTC_WAKEUP,milissegundosDespertar,pendingServico);
                    chkDespertadorHabilitado.setChecked(true);
                    chkDespertadorHabilitado.setText("Despertador Habilitado");
                    gerarNotificacao();
                }
            }
        });

        btnCancelarDespertador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelarDespertador();
            }
        });

    }

    protected void onDestroy()
    {
        super.onDestroy();
        cancelarDespertador();
    }

    private void alertRestricaoDespertador()
    {
        AlertDialog alertDespertador;
        AlertDialog.Builder builderDespertador = new AlertDialog.Builder(this);
        builderDespertador.setTitle("Restrição do Despertador");
        builderDespertador.setMessage("Não é possível agendar para despertar para o dia seguinte, somente para o mesmo dia!");
        builderDespertador.setPositiveButton("OK", null);
        alertDespertador = builderDespertador.create();
        alertDespertador.show();
    }

    protected void cancelarDespertador()
    {
        Intent intentServico = new Intent("EXECUTAR_DESPERTADOR");
        PendingIntent pendingServico = PendingIntent.getBroadcast(MainActivity.this,0,intentServico,0);
        AlarmManager alarmeDespertador = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmeDespertador.cancel(pendingServico);
        if (ReceberDespertador.vibrar != null)
            ReceberDespertador.vibrar.cancel();
        chkDespertadorHabilitado.setChecked(false);
        chkDespertadorHabilitado.setText("Despertador Desabilitado");
        try {
            notificationManager.cancel((R.drawable.ic_launcher_background));
        }catch (Exception e){}
    }

    protected void gerarNotificacao()
    {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this);
        builder.setTicker("Despertador Habilitado");
        builder.setContentTitle("Despertador");
        builder.setContentText("O despertador está habilitado");
        builder.setSmallIcon(R.drawable.ic_launcher_background);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.ic_launcher_background));
        Notification notificacao = builder.build();
        notificacao.vibrate = new long[]{150,600,150,600};
        notificacao.flags = Notification.FLAG_AUTO_CANCEL;
        notificationManager.notify(R.drawable.ic_launcher_background,notificacao);
        try {
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone toque = RingtoneManager.getRingtone(this,som);
            toque.play();
        }catch(Exception e){}
    }
}