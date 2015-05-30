package com.example.ioedu.firstapp;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ioedu on 30/05/15.
 */
public class LocationActivity extends Activity implements LocationListener
{
    private static final long MIN_DISTANCE = 5; //5 metros
    private static final long MIN_TIME = 10 * 1000; //10 segundos

    private TextView tvwLocation;
    private LocationManager lmgLocation;
    //para acceder al proveedor que hemos creado
    private String sProvider;

    @Override
    public void onCreate(Bundle oBunSavedInstance)
    {
        super.onCreate(oBunSavedInstance);
        setContentView(R.layout.geolocation);
        this.tvwLocation = (TextView) findViewById(R.id.tvwLocation);

        //VIDEO(1:15)
        //se utiliza para poder definir crieterios a la hora de poder acceder a la localizacion
        //su funcionalizacion es muy sencilla, tiene una serie de criterios, en base a estos empezara a funcionar el "lgm"
        //usando estos filtros.
        //Estos criterios pueden ser tales como: Cual es el margen de error, cual es la geoloc q queremos,
        Criteria oCriteria = new Criteria();
        oCriteria.setCostAllowed(false);
        oCriteria.setAltitudeRequired(true);
        oCriteria.setAccuracy(Criteria.ACCURACY_FINE);//precision con poco margen de error
        //con esto se puede acceder a las actualizaciones de la geolocalizacion VIDEO(1:19)
        this.lmgLocation = (LocationManager) getSystemService(LOCATION_SERVICE);
        //despue de tener el criterio y el lgm inicializado VIDEO(1:22:11)
        this.sProvider = lmgLocation.getBestProvider(oCriteria,true);
        //en este punto ya podemos pasar sProvider a onResume
        //vamos a solicitar la ultima localizacion
        Location oLocation = lmgLocation.getLastKnownLocation(sProvider);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        //nuestro gestor de localizacion empezara a capturar coord
        //requestLocationUpdates(proveedor,tiempo minimo,distancia minima,activity)
        this.lmgLocation.requestLocationUpdates(this.sProvider,this.MIN_TIME,MIN_DISTANCE,this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        //Hacemos que el gestor de coord deje de pedir actualizaciones.
        this.lmgLocation.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location)
    {
        //Para cada nueva localizacion recibia haremos lo siguiente:VIDEO(1:22:55)
        //Mostraremos el antiguo valor mas el nuevo
        this.tvwLocation.append(this.tvwLocation.getText().toString() + " - " +location.toString()+ "\n");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
