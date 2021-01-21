package com.nytimes.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class NewFeed(
    @SerializedName("uri") val uri: String? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("id") val id: Long? = null,
    @SerializedName("asset_id") val asset_id: Long? = null,
    @SerializedName("source") val source: String? = null,
    @SerializedName("published_date") val published_date: String? = null,
    @SerializedName("updated") val updated: String? = null,
    @SerializedName("section") val section: String? = null,
    @SerializedName("subsection") val subsection: String? = null,
    @SerializedName("nytdsection") val nytdsection: String? = null,
    @SerializedName("adx_keywords") val adx_adx_keywordswords: String? = null,
    @SerializedName("column") val column: String? = null,
    @SerializedName("byline") val byline: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("abstract") val abstract: String? = null,
    @SerializedName("des_facet") val des_facet: List<String>,
    @SerializedName("org_facet") val org_facet: List<String>,
    @SerializedName("per_facet") val per_facet: List<String>,
    @SerializedName("geo_facet") val geo_facet: List<String>,
    @SerializedName("media") val media: List<Media>,
    @SerializedName("eta_id") val eta_id: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readLong(),
        parcel.readLong(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createStringArrayList()!!,
        parcel.createTypedArrayList(Media)!!,
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(uri)
        parcel.writeString(url)
        parcel.writeLong(id ?: -1)
        parcel.writeLong(asset_id ?: -1)
        parcel.writeString(source)
        parcel.writeString(published_date)
        parcel.writeString(updated)
        parcel.writeString(section)
        parcel.writeString(subsection)
        parcel.writeString(nytdsection)
        parcel.writeString(adx_adx_keywordswords)
        parcel.writeString(column)
        parcel.writeString(byline)
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeString(abstract)
        parcel.writeStringList(des_facet)
        parcel.writeStringList(org_facet)
        parcel.writeStringList(per_facet)
        parcel.writeStringList(geo_facet)
        parcel.writeTypedList(media)
        parcel.writeInt(eta_id)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<NewFeed> {
        override fun createFromParcel(parcel: Parcel): NewFeed {
            return NewFeed(parcel)
        }

        override fun newArray(size: Int): Array<NewFeed?> {
            return arrayOfNulls(size)
        }
    }

}