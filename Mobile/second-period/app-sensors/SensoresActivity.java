package com.uniftec.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;

public class SensoresActivity extends AppCompatActivity {

    private TextView txtValor;
    private Button btnAcelerometro,btnGiroscopio, btnLuminosidade, btnProximidade;
    private SensorManager mSensores;
    private Sensor sAcelerometro, sGiroscopio, sLuminosidade, sProximidade;
    private String txtAcelerometro,txtGiroscopio,txtLuminosidade, txtProximidade;
    private DecimalFormat df = new DecimalFormat("0.0");
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensores);
        mSensores = (SensorManager) getSystemService(SENSOR_SERVICE);
        txtValor = findViewById(R.id.txtValor);
        btnAcelerometro = findViewById(R.id.btnAcelerometro);
        btnGiroscopio = findViewById(R.id.btnGiroscopio);
        btnLuminosidade = findViewById(R.id.btnLuminosidade);
        btnProximidade = findViewById(R.id.btnProximidade);

        sAcelerometro = mSensores.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sGiroscopio= mSensores.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sLuminosidade = mSensores.getDefaultSensor(Sensor.TYPE_LIGHT);
        sProximidade = mSensores.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        mSensores.registerListener(
                new Acelerometro(),
                sAcelerometro,
                mSensores.SENSOR_DELAY_GAME
        );

        mSensores.registerListener(
                new Giroscopio(),
                sGiroscopio,
                mSensores.SENSOR_DELAY_GAME
        );

        mSensores.registerListener(
                new Luminosidade(),
                sLuminosidade,
                mSensores.SENSOR_DELAY_GAME
        );

        mSensores.registerListener(
                new Proximidade(),
                sProximidade,
                mSensores.SENSOR_DELAY_GAME
        );

        btnAcelerometro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtValor.setText(txtAcelerometro);
                narrar(txtAcelerometro);
            }
        });

        btnGiroscopio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtValor.setText(txtGiroscopio);
                narrar(txtGiroscopio);
            }
        });

        btnLuminosidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtValor.setText(txtLuminosidade);
                narrar(txtLuminosidade);
            }
        });

        btnProximidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtValor.setText(txtProximidade);
                narrar(txtProximidade);
            }
        });

        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR){
                    tts.setLanguage(Locale.getDefault());
                }else
                {
                    Toast.makeText(SensoresActivity.this,"O seu aplicativo não está preparado para trabalhar com a narração de voz. O assistente será desativado",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    class Acelerometro implements SensorEventListener {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            double x = sensorEvent.values[0];
            double y = sensorEvent.values[1];
            double z = sensorEvent.values[2];

            txtAcelerometro = "";
            txtAcelerometro += "Valor de X: " + df.format(x) + "\n";
            txtAcelerometro += "Valor de Y: " + df.format(y) + "\n";
            txtAcelerometro += "Valor de Z: " + df.format(z) + "\n";

            if (x>=15 || x<=-15)
                System.exit(0);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

    class Giroscopio implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            double x = sensorEvent.values[0];
            double y = sensorEvent.values[1];
            double z = sensorEvent.values[2];

            txtGiroscopio = "";
            txtGiroscopio += "Valor de X: " + df.format(x) + "\n";
            txtGiroscopio += "Valor de Y: " + df.format(y) + "\n";
            txtGiroscopio += "Valor de Z: " + df.format(z) + "\n";
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

    class Luminosidade implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float lux = sensorEvent.values[0];
            txtLuminosidade = "Luminosidade: " + df.format(lux);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

    class Proximidade implements SensorEventListener{

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float distancia = sensorEvent.values[0];
            txtProximidade = "Distância: " + df.format(distancia);
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    }

    private void narrar(String textoNarrar)
    {
        tts.speak(textoNarrar,TextToSpeech.QUEUE_FLUSH, null);
    }

    public void onBackPressed()
    {
        Intent activityPrincipal = new Intent(SensoresActivity.this,MainActivity.class);
        SensoresActivity.this.startActivity(activityPrincipal);
        SensoresActivity.this.finish();
    }

}