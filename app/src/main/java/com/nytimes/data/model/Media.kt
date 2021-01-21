package com.nytimes.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Media(
    @SerializedName("type") var type: String? = null,
    @SerializedName("subtype") var subtype: String? = null,
    @SerializedName("caption") var caption: String? = null,
    @SerializedName("copyright") var copyright: String? = null,
    @SerializedName("approved_for_syndication") var approvedForSyndication: Int? = null,
    @SerializedName("media-metadata") var mediaMetadata: ArrayList<MediaMetadata> = arrayListOf()
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.createTypedArrayList(MediaMetadata.CREATOR)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(type)
        parcel.writeString(subtype)
        parcel.writeString(caption)
        parcel.writeString(copyright)
        parcel.writeValue(approvedForSyndication)
        parcel.writeTypedList(mediaMetadata)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Media> {
        override fun createFromParcel(parcel: Parcel): Media {
            return Media(parcel)
        }

        override fun newArray(size: Int): Array<Media?> {
            return arrayOfNulls(size)
        }
    }
}