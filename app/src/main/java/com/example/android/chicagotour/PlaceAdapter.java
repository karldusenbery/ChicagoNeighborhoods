package com.example.android.chicagotour;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    //Resource id for background color of list
    private int mColorResourceId;

    public PlaceAdapter(Activity context, ArrayList<Place> places, int colorResourceId) {
        super(context, 0, places);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // check if the current view is reused else inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        //get the Place object located at position
        Place place_item = getItem(position);

        //find the textview in list_item with id place_type_text_view
        TextView placeTypeTextView = (TextView) listItemView.findViewById(R.id.place_type_text_view);
        //gets the place type and sets it to the text of this textView
        placeTypeTextView.setText(place_item.getPlaceType());

        //find the textview in list_item with id place_text_view
        TextView placeTextView = (TextView) listItemView.findViewById(R.id.place_text_view);
        //gets the place name and sets it to the text of this textView
        placeTextView.setText(place_item.getPlaceName());

        //find the image view with id image
        ImageView mImageView = (ImageView) listItemView.findViewById(R.id.image);
        if(place_item.hasImage()) {

            //get the imageResource get and set it as source of the image view
            mImageView.setImageResource(place_item.getImageResourceId());

            //make the image view visible
            mImageView.setVisibility(View.VISIBLE);
        }
        else {
            mImageView.setVisibility(View.GONE);
        }

        //seach for the view with the give id
        View textContainer = listItemView.findViewById(R.id.text_container);

        // set its background resource to the mColorResourceId
        textContainer.setBackgroundResource(mColorResourceId);

        return listItemView;
    }
}
