package com.hested.bikeshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class BikeShareActivity extends AppCompatActivity {

    private static final String TAG = "BikeShareActivity";
    // GUI variables
    private Button startRide, endRide, listRides;
    private RecyclerView recyclerView;

    private RidesDB mRides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_bike_share);

        mRides = RidesDB.getInstance();
        Log.d(TAG, "mRides size = " + mRides.getRides().size());

        // Set rideLocation
        setTitle("Bike Share Activity");

        // Button
        startRide = (Button) findViewById(R.id.start_button);
        endRide = (Button) findViewById(R.id.end_button);
        listRides = (Button) findViewById(R.id.list_rides_button);
        recyclerView = (RecyclerView) findViewById(R.id.list_rides_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new RidesAdapter(mRides.getRides()));
        recyclerView.setVisibility(View.GONE);

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

        listRides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
            }
        });
    }


    private class RidesAdapter extends RecyclerView.Adapter<RidesAdapter.MyViewHolder> {

        private List<Ride> rideList;

        RidesAdapter(List<Ride> rideList) {
            this.rideList = rideList;
            Log.d(TAG, "RidesAdapter created");
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rides, parent, false);
            Log.d(TAG, "onCreateViewHolder called");

            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Ride ride = rideList.get(position);
            holder.rideLocation.setText(ride.toString());
        }

        @Override
        public int getItemCount() {
            return rideList.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView rideLocation;

            MyViewHolder(View view) {
                super(view);
                rideLocation = (TextView) view.findViewById(R.id.ride_text_view);
                rideLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int fontSize = new Random().nextInt(30)+10;

                        boolean allCaps = false;
                        if (fontSize%2 == 0) allCaps = true;

                        rideLocation.setTextSize(fontSize);
                        rideLocation.setAllCaps(allCaps);
                    }
                });
            }
        }
    }
}
