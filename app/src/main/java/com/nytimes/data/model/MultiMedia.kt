package com.nytimes.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * Created by sameer.khader on 23/01/2021.
 */
class MultiMedia(
    @SerializedName("url") var url: String? = null,
    @SerializedName("format") var format: String? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("subtype") var subtype: String? = null,
    @SerializedName("caption") var caption: String? = null,
    @SerializedName("copyright") var copyright: String? = null

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
        parcel.writeString(format)
        parcel.writeValue(height)
        parcel.writeValue(width)
        parcel.writeString(type)
        parcel.writeString(subtype)
        parcel.writeString(caption)
        parcel.writeString(copyright)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MultiMedia> {
        override fun createFromParcel(parcel: Parcel): MultiMedia {
            return MultiMedia(parcel)
        }

        override fun newArray(size: Int): Array<MultiMedia?> {
            return arrayOfNulls(size)
        }
    }

}