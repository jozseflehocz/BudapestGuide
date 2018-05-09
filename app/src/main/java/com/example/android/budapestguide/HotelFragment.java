package com.example.android.budapestguide;


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
 * {@link Fragment} that displays a list of number vocabulary words.
 */
public class HotelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
        guides.add(new Guide(getString(R.string.l_and_a_title), getString(R.string.l_and_a_description), R.drawable.landa));
        guides.add(new Guide(getString(R.string.broadway_residence_title), getString(R.string.broadway_residence_description), R.drawable.broadwayresidence));
        guides.add(new Guide(getString(R.string.parliament_corner_apartment_title), getString(R.string.parliament_corner_apartment_description), R.drawable.parlaimentcornerapartment));

        GuideAdapter adapter = new GuideAdapter(getActivity(), guides);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link GuideAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Guide} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                // Get the {@link Guide} object at the given position the user clicked on
                Guide guide = guides.get(position);

                Intent itemDetailsIntent = new Intent(getActivity(), ItemDetails.class);

                /**
                 * https://stackoverflow.com/questions/2405120/how-to-start-an-intent-by-passing-some-parameters-to-it
                 * adding track info as parameters to the intent
                 */
                itemDetailsIntent.putExtra("title", guide.getTitle());
                itemDetailsIntent.putExtra("description", guide.getDescription());
                itemDetailsIntent.putExtra("detailImgId", guide.getImageResourceId());
                itemDetailsIntent.putExtra("phone", guide.getPhone());
                startActivity(itemDetailsIntent);


            }
        });

        return rootView;
    }

}