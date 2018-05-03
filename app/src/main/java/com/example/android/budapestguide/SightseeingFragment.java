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
//        guides.add(new Guide("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
//        guides.add(new Guide("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow,
//                R.raw.color_mustard_yellow));
//        guides.add(new Guide("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow,
//                R.raw.color_dusty_yellow));
//        guides.add(new Guide("green", "chokokki", R.drawable.color_green, R.raw.color_green));
//        guides.add(new Guide("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
//        guides.add(new Guide("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
//        guides.add(new Guide("black", "kululli", R.drawable.color_black, R.raw.color_black));
//        guides.add(new Guide("white", "kelelli", R.drawable.color_white, R.raw.color_white));

        // Create an {@link GuideAdapter}, whose data source is a list of {@link Guide}s. The
        // adapter knows how to create list items for each item in the list.
        GuideAdapter adapter = new GuideAdapter(getActivity(), guides, R.color.category_colors);

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