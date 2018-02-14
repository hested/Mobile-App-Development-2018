package com.hested.bikeshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BikeShareActivity extends AppCompatActivity {

    // GUI variables
    private Button startRide, endRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_bike_share);

        // Set title
        setTitle("Bike Share Activity");

        // Button
        startRide = (Button) findViewById(R.id.start_button);
        endRide = (Button) findViewById(R.id.end_button);

        startRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BikeShareActivity.this, StartRideActivity.class);
                startActivity(i);
            }
        });

        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BikeShareActivity.this, EndRideActivity.class);
                startActivity(i);
            }
        });
    }
}
