package com.example.android.budapestguide;


import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
        guides.add(new Guide("Margaret Island", "Margaret Island provides a peaceful hideaway from hectic downtown Budapest with large green areas, flowery gardens, old trees, and lots of entertainment.",R.drawable.margaretisland));
        guides.add(new Guide("Kobanya cellar system", "The Kobanya cellar system or cellar system of Kobanya (IPA: [ˈkøːbaːɲɒ]; in Hungarian: kobanyai pincerendszer, \"cellar system of Kobanya\", or kobanyai alagútrendszer, \"tunnel system of Kobanya\"), sometimes known to non-Hungarians simply as the Kobanya Mine, or the Kobanya Mine, is an extensive network of subterranea, or underground spaces, in the 10th district of Budapest (Kobanya), in Hungary.",R.drawable.kobanyastonemine));
        guides.add(new Guide("Hospital in the Rock Nuclear Bunker Museum", "The history of the emergency hospital goes back to World War II, when Castle District was part of the Government Quarter. The caves and tunnels were connected and fortified and used as an air raid shelter. On the orders of the Mayor of Budapest an emergency surgical hospital was also built within the caves beneath Buda Castle Hill. The hospital was actively used during WW II until July 1945 and then during the 1956 Revolution to treat wounded civilians and soldiers.",R.drawable.szikla_korhaz3__big));
        guides.add(new Guide("Hungarian Railway Museum", "The foundation-stone of the Hungarian Railway Museum was laid on 22 November 1999, on the site of the former Budapest North Depot of the Hungarian State Railways (MÁV). The first phase of the project was completed in less than eight months, funded by the Ministry of Transport and Waterways, MÁV and MÁV Nosztalgia Ltd, the heritage division of MÁV. After many months of effort, Europe's first interactive railway museum opened on 14 July 2000, displaying over a hundred railway vehicles and equipment of varying ages on a site of over 70,000 m2.","0036(1)111-1111",R.drawable.vasuttorteneti_park_program));
        guides.add(new Guide("City Park", "The City Park (Hungarian: Varosliget; German: Stadtwäldchen) is a public park close to the centre of Budapest, Hungary. It is a 0.9-by-0.6-mile (1,400 by 970 m) rectangle, with an area of 302 acres (1.2 km2),[1] located in District XIV of Budapest. Its main entrance is at Heroes' Square (Hosok tere), one of Hungary's World Heritage sites.",R.drawable.citypark));
        guides.add(new Guide("Gellert Hill", "Gellert Hill (Hungarian: Gellert-hegy; German: Blocksberg; Latin: Mons Sancti Gerhardi; Turkish: Gurz İlyas Bayırı) is a 235 m (771 ft) high hill overlooking the Danube in Budapest, Hungary. It is part of the 1st and 11th Districts. Gellert Hill was named after Saint Gerard who was thrown to death from the hill. The famous Hotel Gellert and the Gellert Baths can be found in Gellert Square at the foot of the hill, next to Liberty Bridge.",R.drawable.gellerthegy));
        guides.add(new Guide("Romai part", "The Danube is one of the most defining parts of the breathtaking Budapest view. And yet, we don’t have much contact with the river in our everyday lives. In Budapest, there are no cafes and restaurants by the river like in Rome or Seville as massive traffic took over both river banks. However, there is an area in Óbuda, called Romai-part, a 10-kilometer-long river bank and it’s the best relaxing place in Budapest. The air at Romai-part is filled with the smell of fried fish and langos, just like in the towns around Lake Balaton.",R.drawable.romaipart));

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