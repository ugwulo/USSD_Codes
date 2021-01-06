package io.github.ugwulo.ussd_codes.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import io.github.ugwulo.ussd_codes.util.PrefsStore
import io.github.ugwulo.ussd_codes.util.PrefsStoreImpl

@Module
@InstallIn(ApplicationComponent::class)
abstract class StoreModule {
    @Binds
    abstract fun bindPrefsStore(prefsStoreImpl: PrefsStoreImpl): PrefsStore
}