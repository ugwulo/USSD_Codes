package nigeria.network.ussd.bank.cod.util

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject

private const val STORE_NAME = "ussd_data_store"
class PrefsStoreImpl @Inject constructor(
    @ApplicationContext context: Context
) : PrefsStore {

    private val dataStore = context.createDataStore(
        name = STORE_NAME
    )

    override fun isNightMode() = dataStore.data.catch { exception ->
        // dataStore.data throws an IOException when an error is encountered when reading data
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[PreferencesKeys.NIGHT_MODE_KEY] ?: false }

    override suspend fun toggleNightMode() {
        dataStore.edit {
            it[PreferencesKeys.NIGHT_MODE_KEY] = !(it[PreferencesKeys.NIGHT_MODE_KEY] ?: false)
        }
    }

    override fun isFirstTimeLaunch(): Flow<Boolean> = dataStore.data.catch {exception ->
        if (exception is IOException) {
            emit(emptyPreferences())
        } else {
            throw exception
        }
    }.map { it[PreferencesKeys.FIRST_TIME_LAUNCH] ?: false }

    override suspend fun setFirstTimeLaunch() {
        dataStore.edit {
            it[PreferencesKeys.FIRST_TIME_LAUNCH] = !(it[PreferencesKeys.FIRST_TIME_LAUNCH] ?: false)
        }
    }

    private object PreferencesKeys {
        val NIGHT_MODE_KEY = preferencesKey<Boolean>("dark_theme_enabled")
        val FIRST_TIME_LAUNCH = preferencesKey<Boolean>("app_is_launched")
    }
}