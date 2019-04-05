package com.example.android.chicagotour;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
//public class Place {

    //Name of the place
    private String mPlaceName = NO_NAME_PROVIDED;
    /** Constant value that represents if no name was provided for this place */
    private static final String NO_NAME_PROVIDED = "No Name";

    //The type of business it is from the businessType ArrayList //TODO: make businessType ArrayList
    private String mPlaceType = NO_TYPE_PROVIDED;
    /** Constant value that represents if no type was provided for this place */
    private static final String NO_TYPE_PROVIDED = " ";

    //Address of the place
    private String mAddress = NO_ADDRESS_PROVIDED;
    /** Constant value that represents if no address was provided for this place */
    private static final String NO_ADDRESS_PROVIDED = "No address provided";

    //Phone number of the place
    private String mPhoneNumber = NO_PHONE_NUMBER_PROVIDED;
    /** Constant value that represents if no phone number was provided for this place */
    private static final String NO_PHONE_NUMBER_PROVIDED = "No phone number provided";

    //Hours of the place
    private String mHours = NO_HOURS_PROVIDED;
    /** Constant value that represents if no phone number was provided for this place */
    private static final String NO_HOURS_PROVIDED = "No business operation hours provided";

    /** Image resource ID for the place */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /** Constant value that represents if no image was provided for this place */
    private static final int NO_IMAGE_PROVIDED = -1;

    //Detailed description of the place
    private String mDetailedDescription = NO_DETAILED_DESCRIPTION_PROVIDED;
    /** Constant value that represents if no phone number was provided for this place */
    private static final String NO_DETAILED_DESCRIPTION_PROVIDED = "No detailed description provided";

    protected Place(Parcel in) {
        mPlaceName = in.readString();
        mPlaceType = in.readString();
        mAddress = in.readString();
        mPhoneNumber = in.readString();
        mHours = in.readString();
        mImageResourceId = in.readInt();
        mDetailedDescription = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write data in the same order the Parcel in constructor
        dest.writeString(mPlaceName);
        dest.writeString(mPlaceType);
        dest.writeString(mAddress);
        dest.writeString(mPhoneNumber);
        dest.writeString(mHours);
        dest.writeInt(mImageResourceId);
        dest.writeString(mDetailedDescription);
    }
    // This is to de-serialize the object
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>(){
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    // constructor for the new Place object with only a name and type
    public Place(String placeName, String placeType){
        mPlaceName = placeName;
        mPlaceType = placeType;
    }

    // constructor for the new Place object with a name, type, detailed description, address, phone number, and hours
    public Place(String placeName, String placeType, String address, String phoneNumber, String hours, String detailedDescription){
        mPlaceName = placeName;
        mPlaceType = placeType;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mHours = hours;
        mDetailedDescription = detailedDescription;
    }

    // constructor for the new place object all text and an image
    public Place(String placeName, String placeType, String address, String phoneNumber, String hours, int imageResourceId, String detailedDescription){
        mPlaceName = placeName;
        mPlaceType = placeType;
        mAddress = address;
        mPhoneNumber = phoneNumber;
        mHours = hours;
        mImageResourceId = imageResourceId;
        mDetailedDescription = detailedDescription;

    }

    // constructor for the new Place object with a name, type, detailed description, address, phone number, and hours [no phone number]
    public Place(String placeName, String placeType, String address, String hours, String detailedDescription){
        mPlaceName = placeName;
        mPlaceType = placeType;
        mAddress = address;
        mHours = hours;
        mDetailedDescription = detailedDescription;
    }

    // constructor for the new place object all text and an image [no phone number]
    public Place(String placeName, String placeType, String address, String hours, int imageResourceId, String detailedDescription){
        mPlaceName = placeName;
        mPlaceType = placeType;
        mAddress = address;
        mHours = hours;
        mImageResourceId = imageResourceId;
        mDetailedDescription = detailedDescription;

    }

    //gets the place name
    public String getPlaceName(){
        return mPlaceName;
    }

    //gets the place type
    public String getPlaceType() {
        return mPlaceType;
    }

    //gets the address
    public String getAddress() {
        return mAddress;
    }

    //gets the phone number
    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    //gets the hours
    public String getHours() {
        return mHours;
    }

    //gets the detailed description
    public String getDetailedDescription() {
        return mDetailedDescription;
    }

    //gets the image resource Id
    public int getImageResourceId() {
        return mImageResourceId;
    }

    // checks whether image resource id is provided or not
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    // checks whether an address has been provided or not
    public boolean hasAddress() {
        return mAddress != NO_ADDRESS_PROVIDED;
    }

    // checks whether a phone number has been provided or not
    public boolean hasPhoneNumber() {
        return mPhoneNumber != NO_PHONE_NUMBER_PROVIDED;
    }

    // checks whether hours have been provided or not
    public boolean hasHours() {
        return mHours != NO_HOURS_PROVIDED;
    }

    // checks whether a detailed description has been provided or not
    public boolean hasDetailedDescription() {
        return mDetailedDescription != NO_DETAILED_DESCRIPTION_PROVIDED;
    }

    // checks whether a name has been provided or not
    public boolean hasName() {
        return mPlaceName != NO_NAME_PROVIDED;
    }

    // checks whether a type has been provided or not
    public boolean hasType() {
        return mPlaceType != NO_TYPE_PROVIDED;
    }
}
