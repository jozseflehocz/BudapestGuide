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
public class SpaFragment extends Fragment {



    public SpaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
        guides.add(new Guide("Szechenyi Bath", "Margaret Island provides a peaceful hideaway from hectic downtown Budapest with large green areas, flowery gardens, old trees, and lots of entertainment.",R.drawable.szechenyi));
        guides.add(new Guide("Rudas Thermal Bath", "The centerpiece of the bath today, the Turkish bath, was built during the 16th century in the period of the Turkish occupation. Below the 10 m diameter dome, sustained by 8 pillars, there is an octagonal pool. The swimming pool, operating as a therapeutic swimming facility and with a sauna, was built in 1896. The thermal bath has been visited from 1936 o\u00ADn exclusively by men.",R.drawable.rudas));
        guides.add(new Guide("Palatinus", "The Open-Air Bath, located o\u00ADn the Margit island, in a nature conservation area, was opened as a beach o\u00ADn the bank of the Danube in 1919. With the construction of the large pool it was transformed in 1921 into an open-air bath. Owing to its high popularity it had to be expanded, therefore an architectural  project tender was launched in 1937, as a result of which the plans composed by István Janáky were accepted. The current installation was completed o\u00ADn the basis of these plans. Its pools are supplied by the thermal springs of the Margit Island.",R.drawable.palatinus));

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
                itemDetailsIntent.putExtra("title",guide.getTitle());
                itemDetailsIntent.putExtra("description",guide.getDescription());
                itemDetailsIntent.putExtra("detailImgId",guide.getImageResourceId());
                itemDetailsIntent.putExtra("phone", guide.getPhone());
                startActivity(itemDetailsIntent);



            }
        });

        return rootView;
    }
}