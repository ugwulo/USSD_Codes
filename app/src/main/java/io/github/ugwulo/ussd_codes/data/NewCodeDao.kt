package io.github.ugwulo.ussd_codes.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewCodeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAllPlayers(players: List<NewCode>)

    @Query("SELECT id, codeName, code FROM ussd_codes")
    fun getAllPlayers(): List<NewCodeListItem>
}