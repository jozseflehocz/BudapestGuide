package com.example.android.budapestguide;


import android.app.FragmentManager;
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
public class SightseeingFragment extends Fragment {


    public SightseeingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
        guides.add(new Guide(getString(R.string.margaret_island_title), getString(R.string.margaret_island_description), R.drawable.margaretisland));
        guides.add(new Guide(getString(R.string.kobanya_title), getString(R.string.kobanya_description), R.drawable.kobanyastonemine));
        guides.add(new Guide(getString(R.string.bunker_title), getString(R.string.bunker_description), R.drawable.szikla_korhaz3__big));
        guides.add(new Guide(getString(R.string.railway_title), getString(R.string.railway_description), getString(R.string.railway_phone), R.drawable.vasuttorteneti_park_program));
        guides.add(new Guide(getString(R.string.city_park_title), getString(R.string.city_park_description), R.drawable.citypark));
        guides.add(new Guide(getString(R.string.gellert_hill_title), getString(R.string.gellert_hill_description), R.drawable.gellerthegy));
        guides.add(new Guide(getString(R.string.romai_part_title), getString(R.string.romai_part_description), R.drawable.romaipart));

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