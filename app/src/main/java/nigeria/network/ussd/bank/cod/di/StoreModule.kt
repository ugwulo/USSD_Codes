package nigeria.network.ussd.bank.cod.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import nigeria.network.ussd.bank.cod.util.PrefsStore
import nigeria.network.ussd.bank.cod.util.PrefsStoreImpl

@Module
@InstallIn(ApplicationComponent::class)
abstract class StoreModule {
    @Binds
    abstract fun bindPrefsStore(prefsStoreImpl: PrefsStoreImpl): PrefsStore
}