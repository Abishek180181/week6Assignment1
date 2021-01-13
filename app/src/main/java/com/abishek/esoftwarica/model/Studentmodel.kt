package com.abishek.esoftwarica.model

import android.os.Parcel
import android.os.Parcelable

data class Studentmodel (var name:String?, var age: Int?, var address : String?, var gender : String?, var display: String?):Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeValue(age)
        parcel.writeString(address)
        parcel.writeString(gender)
        parcel.writeString(display)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Studentmodel> {
        override fun createFromParcel(parcel: Parcel): Studentmodel {
            return Studentmodel(parcel)
        }

        override fun newArray(size: Int): Array<Studentmodel?> {
            return arrayOfNulls(size)
        }
    }
}
