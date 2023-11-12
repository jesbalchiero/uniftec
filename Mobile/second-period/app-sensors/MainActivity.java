package com.uniftec.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView txtSensores;
    private Button btnListar,btnAvancar;
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSensores = findViewById(R.id.txtSensores);
        btnListar = findViewById(R.id.btnListar);
        btnAvancar = findViewById(R.id.btnAvancar);

        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtSensores.setText(getSensores());
            }
        });

        btnAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activitySensores = new Intent(MainActivity.this,SensoresActivity.class);
                MainActivity.this.startActivity(activitySensores);
                MainActivity.this.finish();
            }
        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR)
                {
                    tts.setLanguage(Locale.getDefault());
                } else
                {
                    Toast.makeText(MainActivity.this,"O seu aplicativo não está preparado para trabalhar com narração de voz. O assistente será desabilitado",
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private String getSensores()
    {
        String sensores = "";
        SensorManager mSensores = (SensorManager) getSystemService(SENSOR_SERVICE);
        List<Sensor> listaSensores = mSensores.getSensorList(Sensor.TYPE_ALL);
        for (int i = 0; i < listaSensores.size(); i++)
        {
            sensores += listaSensores.get(i).getName() + "\n";
        }
        narrar("Foram encontrados " + listaSensores.size() + " sensores no seu smartphone");
        return sensores;
    }

    private void narrar(String textoNarrar)
    {
        tts.speak(textoNarrar,TextToSpeech.QUEUE_FLUSH,null);
    }

}