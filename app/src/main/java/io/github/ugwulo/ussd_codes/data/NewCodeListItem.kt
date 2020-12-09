package io.github.ugwulo.ussd_codes.data

import android.os.Parcelable
import androidx.room.ColumnInfo
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NewCodeListItem(
    @ColumnInfo(name = "id") var id: Int,
    @ColumnInfo(name = "codeName") val codeName: String = "",
    @ColumnInfo(name = "code") val code: String = ""
) : Parcelable