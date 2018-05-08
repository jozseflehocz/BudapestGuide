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
 * See the License of the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.budapestguide;

import android.content.res.Resources;

/**
 * {@link Guide} represents a sight, hotel, restaurant or spa which can be visited by tourists.
 * It contains a title, a description, a phone and an image of that place.
 */
public class Guide {

    /** Title of the place */
    private String mTitle;

    /** Description of the place */
    private String mDescription;

    /** Constant value that represents no image was provided of this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Image resource ID of the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents no phone was provided of this place */
    private static final String NO_PHONE_PROVIDED = "";

    /** Phone number of the place */
    private String mPhone = NO_PHONE_PROVIDED;

    /**
     * Create a new Guide object.
     *
     * @param title of the place
     * @param description is the description of the place
     */
    public Guide(String title, String description) {
        mTitle = title;
        mDescription = description;
    }

    /**
     * Create a new Guide object.
     *
     * @param title is title of the place
     * @param description is the description of the place
     * @param imageResourceId is the resource ID of the place
     */
    public Guide(String title, String description, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    /**
     * Create a new Guide object.
     *
     * @param title is title of the place
     * @param description is the description of the place     *
     * @param phone is the phone of the place
     * @param imageResourceId is the resource ID of the audio file associated with this place
     */
    public Guide(String title, String description,String phone, int imageResourceId) {
        mTitle = title;
        mDescription = description;
        mImageResourceId = imageResourceId;
        mPhone=phone;
    }

    /**
     * Get the Title of the place.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the description of the place.
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
     * Returns whether or not there is an image of this place.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Get the phone number of the place.
     */
    public String getPhone() {
        return mPhone;
    }

    /**
     * Returns whether or not there is phone of this place.
     */
    public boolean hasPhone() {
        return mPhone != NO_PHONE_PROVIDED;
    }

}