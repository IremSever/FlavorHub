package com.irem.flavorhub.model

import android.os.Parcelable


data class AnalyzedInstruction(
    val name: String,
    val steps: List<Step>
)