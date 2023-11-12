package com.uniftec.telefonar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtNumero;
    private Button btnTelefonar,btnLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNumero = (EditText) findViewById(R.id.edtNumero);
        btnTelefonar = (Button) findViewById(R.id.btnTelefonar);
        btnLimpar = (Button)findViewById(R.id.btnLimpar);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);

        btnTelefonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNumero.length() == 0) {
                    mensagemErro("Erro","Digite o número da pessoa que deseja telefonar!!!");
                }else {
                    try {
                        Intent chamada = new Intent(Intent.ACTION_CALL);
                        chamada.setData(Uri.parse("tel: +55" + edtNumero.getText().toString()));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                            return;
                        }
                        startActivity(chamada);
                        MainActivity.this.finish();
                    } catch (ActivityNotFoundException erro)
                    {
                        mensagemErro("Erro","Falha ao tentar realizar a ligação!!!\nTente novamente mais tarde!!!");
                    }
                }
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNumero.setText("");
            }
        });

    }

    private void mensagemErro(String titulo, String mensagem)
    {
        AlertDialog alertErro;
        AlertDialog.Builder builderErro = new AlertDialog.Builder(this);
        builderErro.setTitle(titulo);
        builderErro.setMessage(mensagem);
        builderErro.setPositiveButton("OK",null);
        alertErro = builderErro.create();
        alertErro.show();
    }

}