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
public class Beaches extends AppCompatActivity {
    private ArrayList<Place> places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        places = new ArrayList<Place>();
        Location beach1 = new Location(getResources().getString(R.string.beach1_name));
        beach1.setLatitude(53.4891088);
        beach1.setLongitude(-6.0988327);
        places.add(new Place(getResources().getString(R.string.beach1_name), getResources().getString(R.string.beach1_phone),
                getResources().getString(R.string.beach1_address), getDrawable(R.drawable.beach1), beach1));
        Location beach2 = new Location(getResources().getString(R.string.beach2_name));
        beach2.setLatitude(53.4197312);
        beach2.setLongitude(-6.1582236);
        places.add(new Place(getResources().getString(R.string.beach2_name), getResources().getString(R.string.beach2_phone),
                getResources().getString(R.string.beach2_address), getDrawable(R.drawable.beach2), beach2));
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
