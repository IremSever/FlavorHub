package com.irem.flavorhub.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Equipment(
    val id: Int,
    val image: String,
    val localizedName: String,
    val name: String
): Parcelable