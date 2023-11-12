package com.uniftec.appagenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.AdapterView;

import java.util.ArrayList;
import java.util.List;

public class Consultar extends AppCompatActivity {

    private Spinner spnNome,spnTelefone;
    private Button btnTelefonar,btnVoltar;
    private Cursor cursor;
    private int registros = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
        spnNome = (Spinner) findViewById(R.id.spnNome);
        spnTelefone = (Spinner) findViewById(R.id.spnTelefone);
        btnTelefonar = (Button) findViewById(R.id.btnTelefonar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);

        ActivityCompat.requestPermissions(Consultar.this, new String[]{Manifest.permission.CALL_PHONE}, 1);

        cursor = DBAdapter.getConexao(getApplicationContext()).query("contatos",null,null,null,
                null,null,"nome");
        registros = cursor.getCount();
        if (registros!=0)
        {
            List<String> nomesContatos = new ArrayList<String>();
            List<String> numerosContatos = new ArrayList<String>();
            cursor.moveToFirst();
            do
            {
                String nome = cursor.getString(1);
                nomesContatos.add(nome);
                String numero = cursor.getString(2);
                numerosContatos.add(numero);
            }while (cursor.moveToNext());
            ArrayAdapter<String> dataAdapterNomes = new ArrayAdapter<String>(this,R.layout.spinner_item, nomesContatos);
            dataAdapterNomes.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spnNome.setAdapter(dataAdapterNomes);
            ArrayAdapter<String> dataAdapterNumeros = new ArrayAdapter<String>(this,R.layout.spinner_item, numerosContatos);
            dataAdapterNumeros.setDropDownViewResource(R.layout.spinner_dropdown_item);
            spnTelefone.setAdapter(dataAdapterNumeros);
        }
        spnNome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int posicaoSelecionada, long id)
            {
                spnTelefone.setSelection(posicaoSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> view) {}
        });
        spnTelefone.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,int posicaoSelecionada, long id)
            {
                spnNome.setSelection(posicaoSelecionada);
            }

            @Override
            public void onNothingSelected(AdapterView<?> view) {}
        });

        btnTelefonar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registros == 0)
                    mensagemErro("Erro","Selecione o número da pessoa que deseja cadastrar!");
                else
                {
                    try
                    {
                        Intent chamada = new Intent(Intent.ACTION_CALL);
                        chamada.setData(Uri.parse("tel: +55" + spnTelefone.getSelectedItem().toString()));
                        if (ActivityCompat.checkSelfPermission(Consultar.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                        {
                            return;
                        }
                        startActivity(chamada);
                        Consultar.this.finish();
                    }catch (ActivityNotFoundException activity)
                    {
                        mensagemErro("Erro","Falha ao tentar realizar a ligação!\nTente novamente mais tarde!");
                    }
                }
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal = new Intent(Consultar.this,MainActivity.class);
                Consultar.this.startActivity(telaPrincipal);
                Consultar.this.finish();
            }
        });
    }

    private void mensagemErro(String titulo,String mensagem)
    {
        AlertDialog alertErro;
        AlertDialog.Builder builderErro = new AlertDialog.Builder(Consultar.this);
        builderErro.setTitle(titulo);
        builderErro.setMessage(mensagem);
        builderErro.setPositiveButton("OK",null);
        alertErro = builderErro.create();
        alertErro.show();
    }

}