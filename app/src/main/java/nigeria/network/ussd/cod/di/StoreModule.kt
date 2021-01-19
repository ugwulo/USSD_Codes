package nigeria.network.ussd.cod.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import nigeria.network.ussd.cod.util.PrefsStore
import nigeria.network.ussd.cod.util.PrefsStoreImpl

@Module
@InstallIn(ApplicationComponent::class)
abstract class StoreModule {
    @Binds
    abstract fun bindPrefsStore(prefsStoreImpl: PrefsStoreImpl): PrefsStore
}