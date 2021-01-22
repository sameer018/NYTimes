package com.nytimes.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by sameer.khader on 21/01/2021.
 */
class MediaMetadata(
    @SerializedName("url") var url: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("width") var width: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(format)
        parcel.writeValue(height)
        parcel.writeValue(width)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MediaMetadata> {
        override fun createFromParcel(parcel: Parcel): MediaMetadata {
            return MediaMetadata(parcel)
        }

        override fun newArray(size: Int): Array<MediaMetadata?> {
            return arrayOfNulls(size)
        }
    }
}