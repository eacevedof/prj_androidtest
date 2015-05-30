package com.example.ioedu.firstapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ioedu on 30/05/15.
 */
public class LayoutActivity extends Activity
{

    private EditText etxLogin;
    private EditText etxPassword;
    private Button butSubmit;

    @Override
    public void onCreate(Bundle oBunSavedInstance)
    {
        super.onCreate(oBunSavedInstance);
        //setContentView(R.layout.lin_tworows_container);
        //video(1:06)
        setContentView(R.layout.table);

        //asociar nuestras variables con las definidas en el <layout>.xml
        this.etxLogin = (EditText) findViewById(R.id.etxLogin);
        this.etxPassword = (EditText) findViewById(R.id.etxPassword);
        this.butSubmit = (Button) findViewById(R.id.butSubmit);

        this.butSubmit.setOnClickListener
        (
            new View.OnClickListener()
            {
                @Override
                //oView: Vista sobre la que se ha hecho click
                public void onClick(View oView)
                {
                    if(etxLogin.getText().toString().equals("admin") && etxPassword.getText().toString().equals("go"))
                    {
                        Log.d("Password correcto","us//pass");
                        //cierro la app
                        finish();
                    }
                    else
                    {
                        Log.d("login.click", "Error login o pass");
                    }
                }
            }
        );
    }

    private void onsubmit()
    {
        View.OnClickListener oClickListen = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

            }
        };

    }
}
