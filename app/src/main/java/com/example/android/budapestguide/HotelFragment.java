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
        guides.add(new Guide("L & A", "Located 600 m from Hungarian State Opera House, Apartment L&A offers accommodations in Budapest. Apartment L&A features views of the city and is 2.1 km from Széchenyi Thermal Bath.\n" +
                "\n" +
                "A dishwasher and an oven are provided in the kitchen and there is a private bathroom with bathrobes and slippers. A flat-screen TV with satellite channels and DVD player is provided.", R.drawable.landa));
        guides.add(new Guide("Broadway Residence", "Featuring free WiFi and air-conditioning, Broadway Residence is located in Budapest, just 452 m from Hungarian State Opera House. Keleti Railway Station is 2.3 km away.\n" +
                "\n" +
                "The accommodation is fitted with a satellite flat-screen TV. Some units have a seating and/or dining area. There is also a kitchen, equipped with a dishwasher and oven. A microwave and toaster are also featured, as well as a coffee machine. There is a private bathroom with free toiletries in each unit. Bed linen are available.", R.drawable.broadwayresidence));
        guides.add(new Guide("Parliament Corner Apartment", "This property is 1 minute walk from the beach. Parliament Corner Apartment offers accommodations in Budapest, 1.1 km from Hungarian State Opera House and 2.9 km from Keleti Railway Station.\n" +
                "\n" +
                "The kitchen is fitted with a dishwasher and an oven and there is a private bathroom with slippers, free toiletries and a hair dryer. A flat-screen TV with satellite channels is provided.", R.drawable.parlaimentcornerapartment));

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