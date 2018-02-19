package com.hested.bikeshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

/**
 * Project:  BikeShare
 * Package:  com.hested.bikeshare
 * Date:     19-02-2018
 * Time:     21:12
 * Author:   Johnni Hested
 */
public class BikeShareFragment extends Fragment{

    private static final String TAG = "BikeShareActivity";
    // GUI variables
    private Button startRide, endRide, listRides;
    private RecyclerView recyclerView;

    private RidesDB mRides;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRides = RidesDB.getInstance();
        Log.d(TAG, "mRides size = " + mRides.getRides().size());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bike_share, container, false);

        startRide = (Button) view.findViewById(R.id.start_button);
        endRide = (Button) view.findViewById(R.id.end_button);
        listRides = (Button) view.findViewById(R.id.list_rides_button);
        recyclerView = (RecyclerView) view.findViewById(R.id.list_rides_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(new RidesAdapter(mRides.getRides()));
        recyclerView.setVisibility(View.GONE);

        startRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), StartRideActivity.class);
                startActivity(i);
            }
        });

        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), EndRideActivity.class);
                startActivity(i);
            }
        });

        listRides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerView.setVisibility(View.VISIBLE);
            }
        });

        return view;
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
