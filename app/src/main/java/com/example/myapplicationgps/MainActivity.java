package com.example.myapplicationgps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LocationListener {
LocationManager local;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getLocal(View v) {
        Toast.makeText(this, "Obtendo Posicao", Toast.LENGTH_LONG).show();

        try {
            local = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            local.requestLocationUpdates(LocationManager.GPS_PROVIDER, 50,
                    5, this);

        } catch (SecurityException e) {
            Toast.makeText(this, "Problemas no GPS" +e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        EditText lat = findViewById(R.id.editTextLatitude);
        EditText lon = findViewById(R.id.editTextLongitude);

        lat.setText(String.valueOf(location.getLatitude()));
        lon.setText(String.valueOf(location.getLongitude()));

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Ative o GPS", Toast.LENGTH_LONG).show();

    }

}
