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
import android.support.v4.content.ContextCompat;
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

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    /**
     * Create a new {@link GuideAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param guides is the list of {@link Guide}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of guides
     */
    public GuideAdapter(Context context, ArrayList<Guide> guides, int colorResourceId) {
        super(context, 0, guides);
        mColorResourceId = colorResourceId;
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
        // Get the budapestguide translation from the currentGuide object and set this text on
        // the budapestguide TextView.
        TitleTextView.setText(currentGuide.getTitle());

        // Find the TextView in the list_item.xml layout with the ID description_text_view.
        TextView DescriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the default translation from the currentGuide object and set this text on
        // the default TextView.
        DescriptionTextView.setText(currentGuide.getDescription().substring(0,50)+"...");

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentGuide.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentGuide.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.

        ImageView playIconView = (ImageView) listItemView.findViewById(R.id.play_icon);
        playIconView.setImageResource(R.drawable.ic_play_arrow_white_24dp);
        playIconView.setBackgroundColor(color);

        return listItemView;
    }
}