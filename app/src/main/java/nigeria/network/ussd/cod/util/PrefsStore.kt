package nigeria.network.ussd.cod.util

import kotlinx.coroutines.flow.Flow

interface PrefsStore {
    fun isNightMode(): Flow<Boolean>

    suspend fun toggleNightMode()

    fun isFirstTimeLaunch(): Flow<Boolean>

    suspend fun setFirstTimeLaunch()
}