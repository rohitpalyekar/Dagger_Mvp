package demo.dagger_mvp.screens.splash.splashdagger;

import dagger.Module;
import dagger.Provides;
import demo.dagger_mvp.api.JsonApi;
import demo.dagger_mvp.screens.splash.SplashScreenActivity;
import demo.dagger_mvp.screens.splash.splashmvp.SplashModel;
import demo.dagger_mvp.screens.splash.splashmvp.SplashPresenter;
import demo.dagger_mvp.screens.splash.splashmvp.SplashView;
import demo.dagger_mvp.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sony on 04-05-2018.
 */

@Module
public class SplashModule {


    @SplashScope
    @Provides
    SplashPresenter providePresenter(RxSchedulers schedulers, SplashModel model) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        return new SplashPresenter(model, schedulers, compositeSubscription);
    }


    @SplashScope
    @Provides
    SplashView provideSplashView(SplashScreenActivity context) {
        return new SplashView(context);
    }


    @SplashScope
    @Provides
    SplashModel provideSplashModel(JsonApi api, SplashScreenActivity ctx) {
        return new SplashModel(api, ctx);
    }

}
