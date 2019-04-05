package com.example.android.chicagotour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TheLoopFragment extends Fragment {

    public TheLoopFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.place_list, container, false);

        //TODO: add more places
        final ArrayList<Place> places = new ArrayList<Place>();
        places.add(new Place(getString(R.string.loop_name_1), getString(R.string.type_3)));

        // setting up the array adapter
        PlaceAdapter itemsAdapter= new PlaceAdapter(getActivity(), places,  R.color.light_black);

        // finding the listView and setting the adapter to it
        ListView listView = (ListView)rootView.findViewById(R.id.place_list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                /**
                 * The code that's executed when a list item is clicked on.
                 */
                //creates an intent to launch the PlaceDetailsActivity
                Intent intent = new Intent(getActivity(), PlaceDetailsActivity.class);

                //sends the object at the postion that we clicked on to the intent
                intent.putExtra("Clicked On Place", places.get(position));

                //starts that intent
                startActivity(intent);
            }
        });

        return rootView;
    }
}