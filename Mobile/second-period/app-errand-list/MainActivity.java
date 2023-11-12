package com.uniftec.recados;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtRecado;
    private Button btnLimpar,btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtRecado = (EditText) findViewById(R.id.edtRecado);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        retornaRecado();
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (salvar() == 1)
                {
                    alertSalvar();
                }else
                {
                    Toast.makeText(getApplicationContext(), "Erro ao salvar!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void retornaRecado()
    {
        Cursor cursor = DBAdapter.getConexao(getApplicationContext()).query("recados",
                null,null,null,null,null,null);
        if (cursor.getCount() != 0)
        {
            cursor.moveToFirst();
            StringBuilder recado = new StringBuilder();
            recado.append(cursor.getString(0));
            edtRecado.setText(recado.toString());
        }
    }

    public void limpar()
    {
        edtRecado.setText("");
        edtRecado.requestFocus();
    }

    public int salvar()
    {
        int cadastrado = 0;
        DBAdapter.getConexao(getApplicationContext()).delete("recados",null,null);
        ContentValues recado = new ContentValues();
        recado.put("recado", edtRecado.getText().toString());
        DBAdapter.getConexao(getApplicationContext()).insert("recados",null,recado);
        DBAdapter.close();
        cadastrado = 1;
        return cadastrado;
    }

    public void alertSalvar()
    {
        AlertDialog alertSalvar;
        AlertDialog.Builder builderSalvar = new AlertDialog.Builder(this);
        builderSalvar.setTitle("Salvar");
        builderSalvar.setMessage("Recado salvo com sucesso");
        builderSalvar.setPositiveButton("ok",null);
        alertSalvar = builderSalvar.create();
        alertSalvar.show();
    }

}