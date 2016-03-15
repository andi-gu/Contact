package com.hawk.contact.module;

import android.content.Context;

import com.google.common.base.Preconditions;
import com.hawk.contact.qualifier.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by heyong on 16/3/11.
 */

@Module(
        library = true
)
public class ContextProvider {

    private final Context mApplicationContext;

    public ContextProvider(Context context) {
        mApplicationContext = Preconditions.checkNotNull(context, "context cannot be null");
    }

    @Provides @ApplicationContext
    public Context provideApplicationContext() {
        return mApplicationContext;
    }

}
