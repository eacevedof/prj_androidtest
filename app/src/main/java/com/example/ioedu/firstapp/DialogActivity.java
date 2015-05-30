package com.example.ioedu.firstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;


/**
 * Created by ioedu on 30/05/15.
 * VIDEO(1:32:10)
 */
public class DialogActivity extends Activity
{
    final CharSequence[] arItems = {"Red","Blue","Yellow"};
    private ProgressDialog oBarProgress;
    //Esto no esta en el video, faltaba construir el objeto handler
    private Handler oBarHandler = new Handler();

    /*
    * tipos de dialogo: AlertDialog,
    * ProgressDialog VIDEO(1:41:33)
    * ,DatePickerDialog,TimePickerDialog
    * Dialogos Personalizados VIDEO(1:49:38)
    * */
    @Override
    public void onCreate(Bundle oBundle)
    {
        super.onCreate(oBundle);
        //this.show_dialog();
        //this.show_dialog_list();
        //this.show_dialog_listcheck();
        //this.show_ringdialog();
        //this.show_bar_dialog();
        this.show_customdialog();
    }

    //VIDEO(1:51:20)
    private void show_customdialog()
    {
        AlertDialog.Builder oAlertDialogBuilder = new AlertDialog.Builder(this);
        //los inflater se usan para poder utilizar los layout personalizados
        LayoutInflater oLayoutInflater = getLayoutInflater();
        //se pasa null para la vista padre ya que no habra vista padre
        oAlertDialogBuilder.setView(oLayoutInflater.inflate(R.layout.dialog_custom,null))
            .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            })
            .setNegativeButton(android.R.string.no,new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
        AlertDialog oAlertDialog = oAlertDialogBuilder.create();
        oAlertDialog.show();

    }

    //VIDEO(1:44:35)
    private void show_bar_dialog()
    {
        this.oBarProgress = new ProgressDialog(DialogActivity.this);
        this.oBarProgress.setTitle("Titulo barra");
        this.oBarProgress.setMessage(".. descargando..");
        this.oBarProgress.setProgressStyle(oBarProgress.STYLE_HORIZONTAL);
        this.oBarProgress.setProgress(0);
        this.oBarProgress.setMax(20);
        this.oBarProgress.show();

        //VIDEO(1:46:23)
        //procederemos a gestionar la evolucion de este dialogo
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {
                    Log.d("FIRST RUN","RUN_1");
                    //mientras el progreso de la barra a la que accedemos
                    while (oBarProgress.getProgress() <= oBarProgress.getMax())
                    {
                        Thread.sleep(2000);
                        //post significa postejecucion
                        oBarHandler.post
                                (
                                        new Runnable() {
                                            @Override
                                            public void run() {
                                                //esto quiere decier, cada 2 segundos (2000) incrementaremos la barra en 2
                                                oBarProgress.incrementProgressBy(2);
                                            }//run
                                        }
                                );

                        if(oBarProgress.getProgress()==oBarProgress.getMax())
                        {
                            oBarProgress.dismiss();
                        }
                    }//while
                }//try
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }//run()

        }).start();
    }

    //VIDEO(1:42:08)
    private void show_ringdialog()
    {
        final ProgressDialog oProgressDialog = ProgressDialog.show(DialogActivity.this,"Espere","Descargando...",true);
        //especificar si es cancelable
        oProgressDialog.setCancelable(true);
        //crearemos un hilo para que la app espere
        new Thread
        (
            new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        Thread.sleep(10000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                    //cuando el metodo sleep ha finalizado
                    //llamamos a dismiss() para que desaparezca de pantalla
                    oProgressDialog.dismiss();
                }
            }
        ).start();
    }

    private void show_dialog()
    {
        new AlertDialog.Builder(this)
                .setTitle("titulo")
                .setMessage("Cerrar app??")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Log.d("RESPUESTA SI","SE PRECIONO SI, APP SE CERRARA");
                                finish();
                            }
                        }
                )
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Log.d("RESPUESTA NO","SE PRECIONO NO, NO SE CERRARA");
                            }
                        }
                ).show();
    }

    private void show_dialog_list()
    {
        AlertDialog.Builder oAlerDialogBuilder = new AlertDialog.Builder(this);
        oAlerDialogBuilder.setTitle("Pick a color");
        oAlerDialogBuilder.setItems(this.arItems, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast lo necesitamos para saber donde ha presionado el usuario
                //which: el elemento sobre el que se ha hecho click
                //Taost.Length_long cuanto durara en pantalla
                //Toast es el mecanismo que usa android para mostrar notificaciones por pantall
                //generalmente en la parte inferior pero esto puede ser personalizado
                Toast.makeText(getApplicationContext(), arItems[which], Toast.LENGTH_LONG).show();
            }
        });
        //guardamos una instancia creada desde builder
        AlertDialog oAlertDialog = oAlerDialogBuilder.create();
        oAlertDialog.show();
    }

    //VIDEO(1:40:27)
    private void show_dialog_listcheck()
    {
        AlertDialog.Builder oAlerDialogBuilder = new AlertDialog.Builder(this);
        oAlerDialogBuilder.setTitle("Pick a color");
        oAlerDialogBuilder.setSingleChoiceItems(this.arItems,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Toast lo necesitamos para saber donde ha presionado el usuario
                //which: el elemento sobre el que se ha hecho click
                //Taost.Length_long cuanto durara en pantalla
                //Toast es el mecanismo que usa android para mostrar notificaciones por pantall
                //generalmente en la parte inferior pero esto puede ser personalizado
                Toast.makeText(getApplicationContext(), arItems[which], Toast.LENGTH_LONG).show();
            }
        });
        //guardamos una instancia creada desde builder
        AlertDialog oAlertDialog = oAlerDialogBuilder.create();
        oAlertDialog.show();
    }
}
