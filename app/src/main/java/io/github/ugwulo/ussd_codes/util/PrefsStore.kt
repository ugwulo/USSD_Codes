package io.github.ugwulo.ussd_codes.util

import kotlinx.coroutines.flow.Flow

interface PrefsStore {
    fun isNightMode(): Flow<Boolean>

    suspend fun toggleNightMode()
}