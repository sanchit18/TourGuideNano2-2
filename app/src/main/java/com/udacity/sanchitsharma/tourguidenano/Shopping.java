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
public class Shopping extends AppCompatActivity {
    private ArrayList<Place> places;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listlayout);
        places = new ArrayList<Place>();
        Location shop1 = new Location(getResources().getString(R.string.shop1_name));
        shop1.setLatitude(53.348803);
        shop1.setLongitude(-6.3303511);
        places.add(new Place(getResources().getString(R.string.shop1_name), getResources().getString(R.string.shop1_phone),
                getResources().getString(R.string.shop1_address), getResources().getString(R.string.shop1_image), shop1));
        Location shop2 = new Location(getResources().getString(R.string.shop2_name));
        shop2.setLatitude(53.3400675);
        shop2.setLongitude(-6.3306095);
        places.add(new Place(getResources().getString(R.string.shop2_name), getResources().getString(R.string.shop2_phone),
                getResources().getString(R.string.shop2_address), getResources().getString(R.string.shop2_image), shop2));
        ViewAdapter adapter = new ViewAdapter(this, places);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                double lat = places.get(position).getLocation().getLatitude();
                double lon = places.get(position).getLocation().getLongitude();
                String name = places.get(position).getName();
                Uri uri = Uri.parse("geo:" + lat + "," + lon + "?q=" + Uri.encode(name));
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });
    }
}
