package demo.dagger_mvp.screens.splash.splashdagger;

import dagger.Component;
import demo.dagger_mvp.application.builder.AppComponent;
import demo.dagger_mvp.screens.splash.SplashScreenActivity;

/**
 * Created by sony on 04-05-2018.
 */

@SplashScope
@Component(modules = {SplashModule.class,SplashContextModule.class},dependencies = {AppComponent.class})

public interface SplashComponent {
    void inject(SplashScreenActivity activity);
}
