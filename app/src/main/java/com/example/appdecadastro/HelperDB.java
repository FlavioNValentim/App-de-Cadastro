package com.example.appdecadastro;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;

public class HelperDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String TABELA = "contatos";
    private static final String DATABASE_NAME = "db_agenda";

    private static final String TABLE_CREATE = "create table " + TABELA +
            " (nome TEXT PRIMARY KEY, celular TEXT, email TEXT);";

    HelperDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Pode deixar vazio por enquanto
    }

    //  MÉTODO PARA EXCLUIR
    public boolean excluirContato(String nome) {
        SQLiteDatabase db = this.getWritableDatabase();

        int resultado = db.delete(
                TABELA,
                "nome = ?",
                new String[]{nome}
        );

        db.close();
        return resultado > 0;
    }

    //  MÉTODO PARA ALTERAR
    public boolean alterarContato(String nome, String novoCelular, String novoEmail) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("celular", novoCelular);
        valores.put("email", novoEmail);

        int resultado = db.update(
                TABELA,
                valores,
                "nome = ?",
                new String[]{nome}
        );

        db.close();
        return resultado > 0;
    }

    // MÉTODO PARA BUSCAR CONTATO
    public Cursor buscarContato(String nome) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(
                "SELECT * FROM " + TABELA + " WHERE nome = ?",
                new String[]{nome}
        );

        return cursor;
    }
}
