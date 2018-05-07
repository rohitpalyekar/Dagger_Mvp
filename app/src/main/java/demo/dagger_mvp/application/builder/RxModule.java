package demo.dagger_mvp.application.builder;

import dagger.Module;
import dagger.Provides;
import demo.dagger_mvp.utils.rx.AppRxSchedulers;
import demo.dagger_mvp.utils.rx.RxSchedulers;

/**
 * Created by sony on 25-04-2018.
 */

@Module
public class RxModule {
    @Provides
    RxSchedulers provideRxSchedulers() {
        return new AppRxSchedulers();
    }
}
