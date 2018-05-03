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
public class HotelFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        // Create a list of guides
        final ArrayList<Guide> guides = new ArrayList<Guide>();
//        guides.add(new Guide("Where are you going?", "minto wuksus",
//                R.raw.phrase_where_are_you_going));
//        guides.add(new Guide("What is your name?", "tinnә oyaase'nә",
//                R.raw.phrase_what_is_your_name));
//        guides.add(new Guide("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
//        guides.add(new Guide("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
//        guides.add(new Guide("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
//        guides.add(new Guide("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
//        guides.add(new Guide("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
//        guides.add(new Guide("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
//        guides.add(new Guide("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
//        guides.add(new Guide("Come here.", "әnni'nem", R.raw.phrase_come_here));

        // Create an {@link GuideAdapter}, whose data source is a list of {@link Guide}s. The
        // adapter knows how to create list items for each item in the list.
        GuideAdapter adapter = new GuideAdapter(getActivity(), guides, R.color.category_phrases);

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