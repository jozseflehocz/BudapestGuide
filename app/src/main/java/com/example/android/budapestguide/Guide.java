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

/**
 * {@link Guide} represents a sight, hotel, restaurant or spa which can be visited by tourists.
 * It contains a title, a description, a website, a location and an image for that place.
 */
public class Guide {

    /** title for the place */
    private String mTitle;

    /** description for the place */
    private String mDescription;

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Guide object.
     *
     * @param title is the place in a language that the user is already familiar with
     *                           (such as English)
     * @param description is the place in the budapestguide language
     */
    public Guide(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    /**
     * Create a new Guide object.
     *
     * @param title is the place in a language that the user is already familiar with
     *                           (such as English)
     * @param description is the place in the budapestguide language
     * @param imageResourceId is the resource ID for the audio file associated with this place
     */
    public Guide(String title, String description, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the default translation of the place.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the budapestguide translation of the place.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Return the image resource ID of the place.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this place.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

}