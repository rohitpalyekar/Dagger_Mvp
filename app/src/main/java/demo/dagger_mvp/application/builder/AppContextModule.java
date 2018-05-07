package demo.dagger_mvp.application.builder;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sony on 25-04-2018.
 */

@Module
public class AppContextModule {

    private final Context context;

    public AppContextModule(Context aContext) {
        this.context = aContext;
    }

    @AppScope
    @Provides
    Context provideAppContext() {
        return context;
    }
}
