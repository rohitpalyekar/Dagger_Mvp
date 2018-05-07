package demo.dagger_mvp.screens.splash.splashdagger;

import dagger.Module;
import dagger.Provides;
import demo.dagger_mvp.screens.splash.SplashScreenActivity;

/**
 * Created by sony on 04-05-2018.
 */

@Module
public class SplashContextModule {
    SplashScreenActivity splashContext;

    public SplashContextModule(SplashScreenActivity context) {
        this.splashContext = context;
    }

    @SplashScope
    @Provides
    SplashScreenActivity provideSplashContext() {
        return splashContext;
    }
}
