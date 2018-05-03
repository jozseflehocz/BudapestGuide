package com.example.android.budapestguide;


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
//        guides.add(new Guide("one", "lutti", R.drawable.number_one, R.raw.number_one));
//        guides.add(new Guide("two", "otiiko", R.drawable.number_two, R.raw.number_two));
//        guides.add(new Guide("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
//        guides.add(new Guide("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
//        guides.add(new Guide("five", "massokka", R.drawable.number_five, R.raw.number_five));
//        guides.add(new Guide("six", "temmokka", R.drawable.number_six, R.raw.number_six));
//        guides.add(new Guide("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
//        guides.add(new Guide("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
//        guides.add(new Guide("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
//        guides.add(new Guide("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

        // Create an {@link GuideAdapter}, whose data source is a list of {@link Guide}s. The
        // adapter knows how to create list items for each item in the list.
        GuideAdapter adapter = new GuideAdapter(getActivity(), guides, R.color.category_numbers);

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



            }
        });

        return rootView;
    }




}