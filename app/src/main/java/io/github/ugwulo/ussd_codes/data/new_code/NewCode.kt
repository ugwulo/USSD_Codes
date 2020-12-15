package io.github.ugwulo.ussd_codes.data.new_code

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * POJO class for setting up our database for saving New Codes
 */
@Entity(tableName = "ussd_codes")
data class NewCode(
    @ColumnInfo(name = "id") @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "code_name") val codeName: String,
    @ColumnInfo(name = "code") val code: String
)