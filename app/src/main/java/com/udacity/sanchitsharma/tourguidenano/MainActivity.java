package com.udacity.sanchitsharma.tourguidenano;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void PubClicked(View view) {
        Intent Pub = new Intent(MainActivity.this, Pubs.class);
        startActivity(Pub);
    }
    public void BeachesClicked(View view) {
        Intent Beach = new Intent(MainActivity.this, Beaches.class);
        startActivity(Beach);
    }
    public void ParkClicked(View view) {
        Intent Park = new Intent(MainActivity.this, Parks.class);
        startActivity(Park);
    }
    public void ShoppingClicked(View view) {
        Intent Shop = new Intent(MainActivity.this, Shopping.class);
        startActivity(Shop);
    }
}
