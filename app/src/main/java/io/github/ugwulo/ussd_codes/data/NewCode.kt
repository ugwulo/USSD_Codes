package io.github.ugwulo.ussd_codes.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "ussd_codes",
    indices = [Index(value = ["codeName", "code"], unique = true)]
)
@Parcelize
data class NewCode(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @SerializedName("code name") val codeName: String = "",
    @SerializedName("code") val code: String = ""
) : Parcelable