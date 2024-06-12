package com.irem.flavorhub.model
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Measures(
    val metric: Metric,
    val us: Us
):Parcelable