package com.uniftec.appagenda;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompatSideChannelService;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Cadastrar extends AppCompatActivity {

    private EditText edtNome,edtTelefone;
    private Button btnCadastrar,btnLimpar,btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        edtNome = (EditText) findViewById(R.id.edtNome);
        edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNome.length() == 0)
                    Toast.makeText(getApplicationContext(), "Digite o nome do contato que deseja cadastrar!", Toast.LENGTH_LONG).show();
                else if (edtTelefone.length() == 0)
                    Toast.makeText(getApplicationContext(), "Digite o número de telefone do contato que deseja cadastrar", Toast.LENGTH_LONG).show();
                else
                {
                    ContentValues dados = new ContentValues();
                    dados.put("nome",edtNome.getText().toString());
                    dados.put("telefone",edtTelefone.getText().toString());
                    DBAdapter.getConexao(getApplicationContext()).insert("contatos",null,dados);
                    DBAdapter.close();
                    alertCadastrado();
                    edtNome.setText("");
                    edtTelefone.setText("");
                    edtNome.requestFocus();
                }
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNome.setText("");
                edtTelefone.setText("");
                edtNome.requestFocus();
            }
        });
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent telaPrincipal = new Intent(Cadastrar.this,MainActivity.class);
                Cadastrar.this.startActivity(telaPrincipal);
                Cadastrar.this.finish();
            }
        });
    }
    private void alertCadastrado()
    {
        AlertDialog alertCadastrado;
        AlertDialog.Builder builderCadastrado = new AlertDialog.Builder(this);
        builderCadastrado.setTitle("Cadastrado com Sucesso");
        builderCadastrado.setMessage("Contato cadastrado com sucesso!");
        builderCadastrado.setPositiveButton("OK",null);
        alertCadastrado = builderCadastrado.create();
        alertCadastrado.show();
    }
}