package com.udacity.sanchitsharma.tourguidenano;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
/**
 * Created by sanchitsharma on 9/24/17.
 */
public class Pubs extends AppCompatActivity {
    private ArrayList<Place> places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        places = new ArrayList<Place>();
        Location pub1 = new Location(getResources().getString(R.string.pub1_name));
        pub1.setLatitude(53.346237);
        pub1.setLongitude(-6.259543);
        places.add(new Place(getResources().getString(R.string.pub1_name), getResources().getString(R.string.pub1_phone),
                getResources().getString(R.string.pub1_address), getDrawable(R.drawable.palacebar), pub1));
        Location pub2 = new Location(getResources().getString(R.string.pub2_name));
        pub2.setLatitude(53.3449326);
        pub2.setLongitude(-6.2763323);
        places.add(new Place(getResources().getString(R.string.pub2_name), getResources().getString(R.string.pub2_phone),
                getResources().getString(R.string.pub2_address), getDrawable(R.drawable.brazenheadbar), pub2));

        Location pub4 = new Location(getResources().getString(R.string.pub4_name));
        pub4.setLatitude(53.3334783);
        pub4.setLongitude(-6.2648143);
        places.add(new Place(getResources().getString(R.string.pub4_name), getResources().getString(R.string.pub4_phone),
                getResources().getString(R.string.pub4_address), getDrawable(R.drawable.bar4), pub4));
        ViewAdapter adapter = new ViewAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = places.get(position).getLocation().getLatitude();
                double lon = places.get(position).getLocation().getLongitude();
                String name = places.get(position).getName();
                Uri uri = Uri.parse(getString(com.udacity.sanchitsharma.tourguidenano.R.string.geoparse1) + lat + getString(com.udacity.sanchitsharma.tourguidenano.R.string.geoparse2) + lon + getString(com.udacity.sanchitsharma.tourguidenano.R.string.geoparse3) + Uri.encode(name));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName(getString(com.udacity.sanchitsharma.tourguidenano.R.string.geoparse4), getString(com.udacity.sanchitsharma.tourguidenano.R.string.geoparse5));
                startActivity(intent);
            }
        });
    }
}
