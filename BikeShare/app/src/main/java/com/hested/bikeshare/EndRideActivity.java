package com.hested.bikeshare;

import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndRideActivity extends AppCompatActivity {

    // GUI variables
    private Button endRide;
    private TextView lastAdded;
    private TextView newWhat, newWhere;
    private Ride last= new Ride("", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_end_ride);

        // Set title
        setTitle("End Ride Activity");

        // Texts
        lastAdded = (TextView) findViewById(R.id.last_ride);
        newWhat = (TextView) findViewById(R.id.what_text);
        newWhere = (TextView) findViewById(R.id.where_text);

        // Button
        endRide = (Button) findViewById(R.id.add_button);

        // view products click event
        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((newWhat.getText().length()>0) && (newWhere.getText().length()>0 )){
                    last.setBikeName(newWhat.getText().toString().trim());
                    last.setStartRide(newWhere.getText().toString().trim());

                    // reset text fields
                    newWhat.setText("");
                    newWhere.setText("");
                    updateUI();
                }
            }
        });

        updateUI();
    }

    private void updateUI(){
        lastAdded.setText(last.toString());
    }
}
