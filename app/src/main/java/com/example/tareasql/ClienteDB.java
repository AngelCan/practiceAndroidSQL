package com.example.tareasql;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ClienteDB extends SQLiteOpenHelper{
    private static final String NOMBRE_BD = "cliente.db";
    private static final int VERSION_BD = 1;
    private static final String TABLA_CLIENTE = "CREATE TABLE CLIENTE(RCF TEXT PRIMARY KEY, NAME TEXT, PHONE TEXT, EMAIL TEXT)";

    public ClienteDB(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TABLA_CLIENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS cliente");
        sqLiteDatabase.execSQL(TABLA_CLIENTE);
    }
    public void addCliente(String rfc, String name, String phone, String email) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null) {
            db.execSQL("INSERT INTO CLIENTE VALUES('"+rfc+"', '"+name+"', '"+phone+"', '"+email+"')");
            db.close();
        }
    }

    public List<ClienteModel> show_cliente() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM CLIENTE", null);
        List<ClienteModel> clientes = new ArrayList<>();
        if(cursor.moveToFirst()) {
            do {
                clientes.add(new ClienteModel(cursor.getString(0), cursor.getString(1), Integer.parseInt(cursor.getString(2)),
                        cursor.getString(3)));
            } while (cursor.moveToNext());
        }

        cursor.close();
        return clientes;
    }
}
