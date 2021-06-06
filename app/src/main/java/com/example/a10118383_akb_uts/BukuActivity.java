package com.example.a10118383_akb_uts;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by Miftahul Huda on 6/6/2021.
 * NIM.10118383
 * Kelas.IF 9
 */

public class BukuActivity extends AppCompatActivity {
    EditText judul, keterangan, isi;
    TextView textView;
    DB_Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buku);

        judul = (EditText)findViewById(R.id.judul_input);
        keterangan = (EditText)findViewById(R.id.keterangan_input);
        isi = (EditText)findViewById(R.id.isi_input);
        textView = (TextView)findViewById(R.id.textView);

        controller = new DB_Controller(this,"",null,1);
    }

    public void btn_click(View view){
        switch(view.getId()){
            case R.id.btn_add:
                try {
                    controller.insert_buku(judul.getText().toString(),keterangan.getText().toString(),isi.getText().toString());
                }catch (SQLiteException e){
                    Toast.makeText(BukuActivity.this, "ALREADY EXIST", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.btn_delete:
                controller.delete_buku(judul.getText().toString());
                break;
            case R.id.btn_update:
                AlertDialog.Builder dialog = new AlertDialog.Builder(BukuActivity.this);
                dialog.setTitle("Masukan Judul Baru ");

                final EditText new_judul = new EditText(this);
                dialog.setView(new_judul);

                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i){
                        controller.update_buku(judul.getText().toString(),new_judul.getText().toString());
                    }
                });
                dialog.show();
                break;
            case R.id.btn_list:
                controller.list_all_buku(textView);
                break;
        }

    }
}

