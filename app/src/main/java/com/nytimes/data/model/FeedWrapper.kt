package com.nytimes.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by sameer.khader on 21/01/2021.
 */
class FeedWrapper(
    @SerializedName("status") var status: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("num_results") var num_results: Int = 0,
    @SerializedName("results") var newFeeds: ArrayList<NewFeed>? = arrayListOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.createTypedArrayList(NewFeed.CREATOR) as ArrayList<NewFeed>
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeString(copyright)
        parcel.writeInt(num_results)
        parcel.writeTypedList(newFeeds)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<FeedWrapper> {
        override fun createFromParcel(parcel: Parcel): FeedWrapper {
            return FeedWrapper(parcel)
        }

        override fun newArray(size: Int): Array<FeedWrapper?> {
            return arrayOfNulls(size)
        }
    }

}

