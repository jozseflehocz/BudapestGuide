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
public class RestaurantFragment extends Fragment {


    public RestaurantFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
        guides.add(new Guide("Aranyhal", "In addition to the traditional pastries of Hungarian cuisine, we offer a wide range of regional specialties. We offer varied, different flavors and rich menus every week.", R.drawable.aranyhal));
        guides.add(new Guide("Belvarosi Disznotoros", "We believe that good food can only be made from good ingredients, therefore their quality is our first priority – be it the frying oil, the meat or the fresh vegetables. It is important for us that our guests leave satisfied and even more important, that they choose us again. We review our restaurants’ permanent menu regularly and improve the recipes, so we can ensure good taste and freshness.", R.drawable.belvarosidisznotoros));
       // guides.add(new Guide("Hospital in the Rock Nuclear Bunker Museum", "", R.drawable.szikla_korhaz3__big));

        GuideAdapter adapter = new GuideAdapter(getActivity(), guides, R.color.tan_background);

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
                startActivity(itemDetailsIntent);


            }
        });

        return rootView;
    }


}