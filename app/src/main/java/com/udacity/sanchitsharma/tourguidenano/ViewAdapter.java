package com.udacity.sanchitsharma.tourguidenano;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
/**
 * Created by sanchitsharma on 10/10/17.
 */
public class ViewAdapter extends ArrayAdapter<Place> {
    public ViewAdapter(Context context, ArrayList<Place> places) {
        super(context, 0, places);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.itemlayout, parent, false);
        }
        Place currentPlace = getItem(position);
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name);
        nameTextView.setText(currentPlace.getName());
        TextView phoneTextView = (TextView) listItemView.findViewById(R.id.phone);
        if ("".equals(currentPlace.getPhone()))
            phoneTextView.setVisibility(View.GONE);
        else {
            phoneTextView.setVisibility(View.VISIBLE);
            phoneTextView.setText(currentPlace.getPhone());
        }
        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address);
        addressTextView.setText(currentPlace.getAddress());
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        Picasso.with(getContext())
                .load(currentPlace.getUrl())
                .resizeDimen(R.dimen.list_item_image_width, R.dimen.list_item_image_height)
                .centerInside()
                .into(imageView);
        return listItemView;
    }
}
