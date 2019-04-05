package com.example.android.chicagotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_details);

        //gets the intent that contains the object of the item that was clicked on from the list view fragemnt
        Intent intent = getIntent();

        //creates a new place object with the object from our intent
        Place clickedOnPlace = intent.getParcelableExtra("Clicked On Place");

        //gets all the primitive data from that object that we just created
        String mPlaceName = clickedOnPlace.getPlaceName();
        String mPlaceType = clickedOnPlace.getPlaceType(); //never used in this activity, but could be in the future
        String mAddress = clickedOnPlace.getAddress();
        String mPhoneNumber = clickedOnPlace.getPhoneNumber();
        String mHours = clickedOnPlace.getHours();
        int mImageResourceId = clickedOnPlace.getImageResourceId();
        String mDetailedDescription = clickedOnPlace.getDetailedDescription();

        //and the booleans to check if the passed object even has these things to fill the appropriate views
        boolean mHasImage = clickedOnPlace.hasImage();
        boolean mHasAddress = clickedOnPlace.hasAddress();
        boolean mHasPhoneNumber = clickedOnPlace.hasPhoneNumber();
        boolean hasHours = clickedOnPlace.hasHours();
        boolean hasDetailedDescription = clickedOnPlace.hasDetailedDescription();
        boolean hasName = clickedOnPlace.hasName();
        boolean hasType = clickedOnPlace.hasType(); //never used in this activity, but could be in the future


        //creates the appropriate objects associated with their appropriate view types
        ImageView placeImage = (ImageView)findViewById(R.id.placeImage);
        TextView placeName_text_view = (TextView)findViewById(R.id.placeNameText);
        TextView placeDetailedDescription_text_view = (TextView)findViewById(R.id.placeDetailsText);
        TextView hours_text_view = (TextView)findViewById(R.id.hoursDetailedText);
        TextView address_text_view = (TextView)findViewById(R.id.addressDetailedText);
        TextView phone_text_view = (TextView)findViewById(R.id.phoneDetailedText);


        /**
         * sets the appropriate information in the views.
         * Checks for null pointers so that the app doesn't crash when we get an exception if an object doesn't contain all the elements we need to fill all the views
         * If anything is null, we place default things in the views
         */
        if (mHasImage == true){
            //put the image from the object gotten from the list item that was clicked on
            placeImage.setImageResource(mImageResourceId);
        } else {
            //put default image in the view
            placeImage.setImageResource(R.drawable.chicago_skyline);
        }

        if (hasName == true) {
            //put the text from the object gotten from the list item that was clicked on
            placeName_text_view.setText(mPlaceName);
        } else {
            //put the default text in the view
            placeName_text_view.setText(R.string.place_name);
        }

        if (hasDetailedDescription == true) {
            //put the text from the object gotten from the list item that was clicked on
            placeDetailedDescription_text_view.setText(mDetailedDescription);
        } else {
            //put the default text in the view
            placeDetailedDescription_text_view.setText(R.string.place_name);
        }

        if (hasHours == true) {
            //put the text from the object gotten from the list item that was clicked on
            hours_text_view.setText(mHours);
        } else {
            //put the default text in the view
            hours_text_view.setText(R.string.hours_details);
        }

        if (mHasAddress == true) {
            //put the text from the object gotten from the list item that was clicked on
            address_text_view.setText(mAddress);
        } else {
            //put the default text in the view
            address_text_view.setText(R.string.address_details);
        }

        if (mHasPhoneNumber == true) {
            //put the text from the object gotten from the list item that was clicked on
            phone_text_view.setText(mPhoneNumber);
        } else {
            //put the default text in the view
            phone_text_view.setText(R.string.phone_details);
        }
    }
}
