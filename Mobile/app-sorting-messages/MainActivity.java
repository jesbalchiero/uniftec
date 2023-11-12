package com.uniftec.sortearmensagens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] mensagens;
    private TextView txtMensagem;
    private Button btnSortear,btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtMensagem = (TextView)findViewById(R.id.txtMensagem);
        btnSortear = (Button) findViewById(R.id.btnSortear);
        btnFechar = (Button) findViewById(R.id.btnFechar);

        mensagens = getResources().getStringArray(R.array.mensagens);

        btnSortear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random rnd = new Random();
                int x = rnd.nextInt(mensagens.length);
                txtMensagem.setText(mensagens[x]);
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.this.finish();
            }
        });
    }
}