package com.uniftec.recados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter
{
    private static final String DATABASE_NAME = "recados.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper DBHelper;
    private static SQLiteDatabase db = null;
    public static SQLiteDatabase getConexao(Context contexto)
    {
        DBHelper = new DatabaseHelper(contexto);
        db = DBHelper.getWritableDatabase();
        return db;
    }
    public static void close()
    {
        db = null;
        DBHelper.close();
    }
    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context contexto)
        {
            super(contexto,DATABASE_NAME,null,DATABASE_VERSION);
        }
        public void onCreate(SQLiteDatabase db)
        {
            criarTabela(db);
        }
        public void onUpgrade(SQLiteDatabase db, int oldVersion,int newVersion){}
        private void criarTabela(SQLiteDatabase db)
        {
            String tabelaRecados = "CREATE TABLE IF NOT EXISTS  recados (recado TEXT NOT NULL);";
            db.execSQL(tabelaRecados);
        }
    }
}
