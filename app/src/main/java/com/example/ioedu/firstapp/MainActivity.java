package com.example.ioedu.firstapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.IntentFilter;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Contacts;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import theframework.ComponentTest;


//CURSO: https://www.youtube.com/watch?v=p3uGVNEaXMU
//Una actividad es una pantalla (formulario en .net FORM)
public class MainActivity extends Activity
{

    private HelloBroadcastReceiver oBcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Hello World", "onCreate");
        //this.access();
        //this.access_contact();
        //el intent se usa para pasar información entre actividades
        //params: (act sobre la ue se esta,clase con la q queremos comenzar este intent )
        //Intent oIntent = new Intent(this,SecondActivity.class);
        //creamos el valor a pasar (clave, valor)
        //oIntent.putExtra("firstValue","My first Value from MainActivity");
        //Inicia la actividad asociada al Intent
        //startActivity(oIntent);
        //30/05/2015.16:41 video(49:10)
        //Registrando un receiver por código de manera dinámica



    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d("Hello World", "onStart");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.d("Hello World","onRestart");
    }

    @Override
    protected void onResume()
    {
        //tenemos la variable declarada pero no inicializada oBcastReceiver
        this.oBcastReceiver = new HelloBroadcastReceiver();
        //(objeto receiver, oIntent(evento que esstara escuchando)
        registerReceiver(this.oBcastReceiver,new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        super.onResume();
        Log.d("Hello World", "onResume - Registro el receiver");
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
    }

    @Override
    protected void onPause()
    {
        //desregistrar el recevier cuando ya no se utilice
        unregisterReceiver(this.oBcastReceiver);
        super.onPause();
        Log.d("Hello World", "onPause - unregister receiver");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.d("Hello World", "onStop");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d("Hello World", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void access()
    {
        //Acceder a datos de otras aplicaciones
        ContentResolver a = getContentResolver();
        ComponentTest oComponentTest = new ComponentTest();
        oComponentTest.access(a);
    }

    public void access_contact()
    {
        ContentResolver oCR = getContentResolver();
        Cursor oCursor = oCR.query(Contacts.People.CONTENT_URI,null,null,null,null);
        if(oCursor.getCount()>0)
        {
            while (oCursor.moveToNext())
            {
                String sId = oCursor.getString(oCursor.getColumnIndex(Contacts.People._ID));
                String sName = oCursor.getString(oCursor.getColumnIndex(Contacts.People.NAME));
                Log.d("DATOS CONTACTO",sId+":"+sName);
            }
        }
    }
}
