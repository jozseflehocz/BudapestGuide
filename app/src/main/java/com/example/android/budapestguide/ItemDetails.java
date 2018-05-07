package com.example.android.budapestguide;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetails extends AppCompatActivity {

    //https://stackoverflow.com/a/17369359
    @Override
    public void onBackPressed(){
        FragmentManager fm = getFragmentManager();
        if (fm.getBackStackEntryCount() > 0) {
            Log.i("ItemDetails", "popping backstack");
            fm.popBackStack();
        } else {
            Log.i("ItemDetails", "nothing on backstack, calling super");
            super.onBackPressed();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_details);

        Intent thisIntent = getIntent(); // gets the previously created intent


        //Setting track attributes from intent parameters
        String title = thisIntent.getStringExtra("title");
        String description= thisIntent.getStringExtra("description");
        int detailImgId=thisIntent.getIntExtra("detailImgId",R.drawable.margaretisland);
        String phone= thisIntent.getStringExtra("phone");

        //replace android label "Now playing" to the title of the track
        setTitle(title);

        // Find the TextView in the layout with the ID artist_text_view
        TextView titleTextView = (TextView) findViewById(R.id.title_text_view);
        // Get the version name from the current track object and
        // set this text on the artistTextView
        titleTextView.setText(title);

//        // Find the TextView in the list_item.xml layout with the ID album_text_view
        TextView descriptionTextView = (TextView) findViewById(R.id.description_text_view);
//        // Get the album name from the current track object and
//        // set this text on the albumTextView
        descriptionTextView.setText(description);

        // Find the ImageView in the list_item.xml layout with the ID image.
        TextView phoneView = (TextView) findViewById(R.id.phone_text_view);
        // Check if an image is provided for this word or not
        if (phone.length()>0) {
            // If an image is available, display the provided image based on the resource ID
            phoneView.setText(phone);
            // Make sure the view is visible
            phoneView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            phoneView.setVisibility(View.GONE);
        }


        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView coverView = (ImageView) findViewById(R.id.image_view);
        // Get the image resource ID from the current track object and
        // set the image to iconView
        coverView.setImageResource(detailImgId);
    }
}
