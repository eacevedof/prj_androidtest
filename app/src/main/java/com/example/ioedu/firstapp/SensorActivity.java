package com.example.ioedu.firstapp;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

/**
 * Created by ioedu on 30/05/15.
 * VIDEO(1:24:54) SENSORES
 * Se implementa SensorEventListener para mostrar informacion obtenida por un sensor VIDEO(1:29:48)
 */
public class SensorActivity extends Activity implements SensorEventListener
{
    private SensorManager oSensorManager;
    @Override
    public void onCreate(Bundle oBunSavedInstanceState)
    {
        super.onCreate(oBunSavedInstanceState);
        //Inicializamos nuestro manager
        this.oSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Log.d("oSensoManager","Created");
        //queremos leer todos los sensores que se encuentran en el dispositivo
        List<Sensor> oSensorList = this.oSensorManager.getSensorList(Sensor.TYPE_ALL);

        for(Sensor oSensor :oSensorList)
        {
            Log.d("sensor",oSensor.getName());
            //imprime esto
            /*05-30 20:51:54.977  17613-17613/? D/sensor﹕ LIS3DH 3-axis Accelerometer
            05-30 20:51:54.977  17613-17613/? D/sensor﹕ AK8963 3-axis Magnetic field sensor
            05-30 20:51:54.977  17613-17613/? D/sensor﹕ AK8963 Orientation sensor
            05-30 20:51:54.977  17613-17613/? D/sensor﹕ CT406 Proximity sensor
            05-30 20:51:54.977  17613-17613/? D/sensor﹕ CT406 Light sensor
            05-30 20:51:54.977  17613-17613/? D/sensor﹕ Display Rotation sensor
            */
        }
    }


    @Override
    public void onSensorChanged(SensorEvent oSensorEvent)
    {
        Log.d("ONSENSORCHANGED","EVENTO EJECUTADO");
        //se disparara cada vez que haya nueva info desde un sensor
        //cada sensor puede provocar que cada thread (hilo) llame a este metodo en paralelo (asincrono) asi que
        //forzaremos su comportamiento sincrono
        synchronized(this)
        {
            switch(oSensorEvent.sensor.getType())
            {
                case Sensor.TYPE_ACCELEROMETER:
                    //el acelerometro tiene una componente de 3
                    //esto funciona así para cada uno de los distintos tipos
                    for(int i=0; i<3; i++)
                    {
                        Log.d("SensorActivityACEL",String.valueOf(oSensorEvent.values[i]));
                    }
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD:
                    for(int i=0; i<3; i++)
                    {
                        Log.d("SensorActivityMAG",String.valueOf(oSensorEvent.values[i]));
                    }
                    break;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
        //se disparara cada vez q la presicion del sensor  cambie
    }
}
