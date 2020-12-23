package com.example.gpstracker;


import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
{
    private Button ShowLocationButton;

    // GPSTracker nesnesi
    private GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ShowLocationButton = (Button) findViewById(R.id.ShowLocationButton);

        // ShowLocationButton butonuna tiklandiginda
        ShowLocationButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                gpsTracker = new GPSTracker(MainActivity.this);
                Location location = gpsTracker.getLocation();

                // Eger konum bilgisi alinabiliyorsa ekranda goruntulenir
                if (location != null)
                {
                    double latitude = location.getLatitude();
                    double longitude = location.getLongitude();

                    Toast.makeText(getApplicationContext(), "Konumunuz : \nEnlem " + latitude + "\nBoylam " + longitude, Toast.LENGTH_LONG).show();
                }
                else
                {
                    // Konum bilgisi alinamiyorsa mesaj kutusunu goster
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }
}