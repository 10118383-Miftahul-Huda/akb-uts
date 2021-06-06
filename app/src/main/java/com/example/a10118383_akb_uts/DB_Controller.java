package com.example.a10118383_akb_uts;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by Miftahul Huda on 6/6/2021.
 * NIM.10118383
 * Kelas.IF 9
 */

public class DB_Controller extends SQLiteOpenHelper {
    public DB_Controller(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.DB", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE BUKU(ID INTEGER PRIMARY KEY AUTOINCREMENT, JUDUL TEXT UNIQUE, KETERANGAN TEXT, ISI TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS BUKU;");
        onCreate(sqLiteDatabase);
    }

    public void insert_buku(String judul, String keterangan, String isi){
        ContentValues contentValues = new ContentValues();
        contentValues.put("JUDUL", judul);
        contentValues.put("KETERANGAN", keterangan);
        contentValues.put("ISI", isi);
        this.getWritableDatabase().insertOrThrow("BUKU","",contentValues);
    }

    public void delete_buku(String judul){
        this.getWritableDatabase().delete("BUKU","JUDUL='"+judul+"'",null);
    }

    public void update_buku(String old_judul, String new_judul){
        this.getWritableDatabase().execSQL("UPDATE BUKU SET JUDUL='"+new_judul+"' WHERE JUDUL='"+old_judul+"'");
    }

    public void list_all_buku(TextView textView){
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM BUKU", null);
        textView.setText("");
        while (cursor.moveToNext()){
            textView.append(cursor.getString(1)+" "+cursor.getString(3)+"\n");
        }
    }

}

