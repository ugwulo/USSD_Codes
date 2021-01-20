package nigeria.network.ussd.bank.cod.util;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class PrefsStoreImpl_Factory implements Factory<PrefsStoreImpl> {
  private final Provider<Context> contextProvider;

  public PrefsStoreImpl_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public PrefsStoreImpl get() {
    return newInstance(contextProvider.get());
  }

  public static PrefsStoreImpl_Factory create(Provider<Context> contextProvider) {
    return new PrefsStoreImpl_Factory(contextProvider);
  }

  public static PrefsStoreImpl newInstance(Context context) {
    return new PrefsStoreImpl(context);
  }
}
