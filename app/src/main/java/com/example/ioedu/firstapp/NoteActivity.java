package com.example.ioedu.firstapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;

/**
 * Created by ioedu on 31/05/15.
 */
public class NoteActivity extends Activity
{
    private Button butAddNote;
    private LinearLayout llyNote;

    @Override
    public void onCreate(Bundle oBundle)
    {
        super.onCreate(oBundle);
        //android.app.Application@472b594
        Log.d("context", String.valueOf(getApplicationContext()));
        ///data/data/com.example.ioedu.firstapp
        Log.d("apppath",getApplicationInfo().dataDir);
        setContentView(R.layout.note);
        llyNote = (LinearLayout) findViewById(R.id.llyNote);
        butAddNote = (Button)findViewById(R.id.butAddNote);
        //cuando presionemos en este boton pasaremos a la otra activiad "NoteSaveActivity"
        butAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent oIntentNoteSave = new Intent(getApplicationContext(), NoteSaveActivity.class);
                startActivity(oIntentNoteSave);
            }
        });//butAddNote.setOnclikListener
        this.read_note();
    }

    private void read_note()
    {
        File oFiledir = getFilesDir();
        ///data/data/com.example.ioedu.firstapp/files
        Log.d("oFiledir",String.valueOf(oFiledir));
        for(String sFileName : oFiledir.list())
        {
            //Creacion controles por código
            TextView oTextView = new TextView(this);
            oTextView.setText(sFileName);
            oTextView.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.FILL_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            ));
            //VIDEO(2:04:23)tenemos que añadir estos textview a nuestro layout. Hay que darle un id y definir un objeto global
            llyNote.addView(oTextView);
        }
    }
}
