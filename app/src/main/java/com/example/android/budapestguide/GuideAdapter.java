/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.budapestguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link GuideAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Guide} objects.
 */
public class GuideAdapter extends ArrayAdapter<Guide>  {

    /**
     * Create a new {@link GuideAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param guides is the list of {@link Guide}s to be displayed.
     *      */
    public GuideAdapter(Context context, ArrayList<Guide> guides) {
        super(context, 0, guides);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Guide} object located at this position in the list
        Guide currentGuide = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID title_text_view.
        TextView TitleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);
        // Get the title the currentGuide object and set this text on
        // the title TextView.
        TitleTextView.setText(currentGuide.getTitle());

        // Find the phone text view in the list_item.xml layout.
        TextView phoneView = (TextView) listItemView.findViewById(R.id.phone_text_view);
        // Check if an phone is provided for this place or not
        if (currentGuide.hasPhone()) {
            // If an phone is available, display the phone number
            phoneView.setText(currentGuide.getPhone());
            // Make sure the view is visible
            phoneView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            phoneView.setVisibility(View.GONE);
        }


        // Find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView DescriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the description from the currentGuide object and set the first 50 characters of this text on
        // the description TextView.
        DescriptionTextView.setText(currentGuide.getDescription().substring(0,50)+"...");

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this place or not
        if (currentGuide.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentGuide.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.

        ImageView playIconView = (ImageView) listItemView.findViewById(R.id.play_icon);
        playIconView.setImageResource(R.drawable.ic_play_arrow);

        return listItemView;
    }
}