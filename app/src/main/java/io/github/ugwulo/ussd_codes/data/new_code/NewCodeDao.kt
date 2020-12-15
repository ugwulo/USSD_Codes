package io.github.ugwulo.ussd_codes.data.new_code

import androidx.lifecycle.LiveData
import androidx.room.*
import io.github.ugwulo.ussd_codes.data.new_code.NewCode

/**
 * Data Access Object class for performing CRUD operations on our db
 */
@Dao
interface NewCodeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNewCode(vararg newCode: NewCode)

    @Query("SELECT * FROM ussd_codes")
    fun getSavedCodes(): LiveData<List<NewCode>>

}