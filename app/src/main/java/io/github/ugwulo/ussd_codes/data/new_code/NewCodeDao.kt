package io.github.ugwulo.ussd_codes.data.new_code

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object class for performing CRUD operations on our db
 */
@Dao
interface NewCodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewCode(newCode: NewCode)

    @Query("SELECT * FROM ussd_codes")
    fun getSavedCodes(): LiveData<List<NewCode>>

    /**
     * to check when the database is empty
     */
    @Query("SELECT COUNT(*) FROM ussd_codes")
    fun getDataCount(): LiveData<Int>

/* TODO(Add Delete operation) */

}