package com.example.ioedu.fristapp;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


//CURSO: https://www.youtube.com/watch?v=p3uGVNEaXMU
//Una actividad es una pantalla (formulario en .net FORM)
public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.access();
        Log.d("Hello World", "onCreate");
        //el intent se usa para pasar información entre actividades
        //params: (act sobre la ue se esta,clase con la q queremos comenzar este intent )
        Intent oIntent = new Intent(this,SecondActivity.class);
        //creamos el valor a pasar (clave, valor)
        oIntent.putExtra("firstValue","My first Value from MainActivity");
        //Inicia la actividad asociada al Intent
        //startActivity(oIntent);
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
        super.onResume();
        Log.d("Hello World", "onResume");
    }

    @Override
    protected void onPostResume()
    {
        super.onPostResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.d("Hello World", "onPause");
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
        ContentResolver a = getContentResolver();
        //ComponentTest oComponentTest = new ComponentTest();
        //oComponentTest.access(a);
    }
}
