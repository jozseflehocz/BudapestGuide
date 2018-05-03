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
//        guides.add(new Guide("father", "әpә", R.drawable.family_father, R.raw.family_father));
//        guides.add(new Guide("mother", "әṭa", R.drawable.family_mother, R.raw.family_mother));
//        guides.add(new Guide("son", "angsi", R.drawable.family_son, R.raw.family_son));
//        guides.add(new Guide("daughter", "tune", R.drawable.family_daughter, R.raw.family_daughter));
//        guides.add(new Guide("older brother", "taachi", R.drawable.family_older_brother,
//                R.raw.family_older_brother));
//        guides.add(new Guide("younger brother", "chalitti", R.drawable.family_younger_brother,
//                R.raw.family_younger_brother));
//        guides.add(new Guide("older sister", "teṭe", R.drawable.family_older_sister,
//                R.raw.family_older_sister));
//        guides.add(new Guide("younger sister", "kolliti", R.drawable.family_younger_sister,
//                R.raw.family_younger_sister));
//        guides.add(new Guide("grandmother ", "ama", R.drawable.family_grandmother,
//                R.raw.family_grandmother));
//        guides.add(new Guide("grandfather", "paapa", R.drawable.family_grandfather,                R.raw.family_grandfather));

        // Create an {@link GuideAdapter}, whose data source is a list of {@link Guide}s. The
        // adapter knows how to create list items for each item in the list.
        GuideAdapter adapter = new GuideAdapter(getActivity(), guides, R.color.category_family);

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