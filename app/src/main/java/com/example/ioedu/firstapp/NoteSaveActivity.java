package com.example.ioedu.firstapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by ioedu on 31/05/15.
 */
public class NoteSaveActivity extends Activity
{

    private EditText edtNote;
    private Button butSave;

    @Override
    public void onCreate(Bundle oBundle)
    {
        super.onCreate(oBundle);
        setContentView(R.layout.note_write);
        butSave = (Button)findViewById(R.id.butSave);
        edtNote = (EditText)findViewById(R.id.edtNote);

        butSave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //VIDEO(2:01:04)tomaremos el texto que se guarda en edtNote y lo almacenaremos en un fichero de texto
                //fichero de texto teniendo como nombre unixtime
                long lngUxtime = System.currentTimeMillis()/1000L;
                String sFileName = String.valueOf(lngUxtime);
                save_into_file(sFileName);
            }
        });//butSave.setOnClickListener
    }

    private void save_into_file(String sFileName)
    {
        try
        {
            Log.d("sFileName",sFileName);
            //FileOutputStream oFileOutStream = null;
            FileOutputStream oFileOutStream = openFileOutput(sFileName, Context.MODE_PRIVATE);
            Log.d("TEXTO A GUARDAR",edtNote.getText().toString());
            oFileOutStream.write(edtNote.getText().toString().getBytes());
            oFileOutStream.close();
        }
        catch(IOException e)
        {
            Log.d("save EXEP",e.toString());
            e.printStackTrace();
        }
    }
}
