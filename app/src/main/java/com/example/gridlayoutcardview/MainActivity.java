package com.example.gridlayoutcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemListener {

    RecyclerView recyclerView;
    ArrayList arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tab_toolBar);
        setSupportActionBar(toolbar);
        TextView mTitle = (TextView) toolbar.findViewById(R.id.toolbar_title);
        //mTitle.setText;
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        arrayList = new ArrayList();
        arrayList.add(new DataModel("Driver Behavior Assistance",R.drawable.driver_behavior, "#FFFFFF"));
        arrayList.add(new DataModel("Predictive Maintenance", R.drawable.predictive_maintenance, "#FFFFFF"));
        arrayList.add(new DataModel("FOTA", R.drawable.fota, "#FFFFFF"));
        arrayList.add(new DataModel("Remote Control of Vehicle", R.drawable.remote_control, "#FFFFFF"));
        arrayList.add(new DataModel("Current Vehicle Location", R.drawable.current_location, "#FFFFFF"));
        arrayList.add(new DataModel("Nearby Fuel Stations", R.drawable.ic_local_gas_station_black_24dp, "#FFFFFF"));
        arrayList.add(new DataModel("Navigate to Vehicle", R.drawable.navigate_to_car, "#FFFFFF"));
        arrayList.add(new DataModel("Live Route", R.drawable.ic_location_on_black_24dp, "#FFFFFF"));
        //arrayList.add(new DataModel("Share Location", R.drawable.ic_share_black_24dp, "#DEE4E7"));
        arrayList.add(new DataModel("Geo-Fencing", R.drawable.ic_vpn_lock_black_24dp, "#FFFFFF"));



        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, arrayList,this);
        recyclerView.setAdapter(adapter);


        /**
         AutoFitGridLayoutManager that auto fits the cells by the column width defined.
         **/

        /*AutoFitGridLayoutManager layoutManager = new AutoFitGridLayoutManager(this, 500);
        recyclerView.setLayoutManager(layoutManager);*/


        /**
         Simple GridLayoutManager that spans two columns
         **/
        GridLayoutManager manager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
    }

    @Override
    public void onItemClick(DataModel item) {

        Toast.makeText(getApplicationContext(), item.text + " is clicked", Toast.LENGTH_SHORT).show();

    }
}

