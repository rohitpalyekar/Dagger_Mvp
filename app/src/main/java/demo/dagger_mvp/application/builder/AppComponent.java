package demo.dagger_mvp.application.builder;

import dagger.Component;
import demo.dagger_mvp.api.JsonApi;
import demo.dagger_mvp.utils.rx.RxSchedulers;

/**
 * Created by sony on 25-04-2018.
 */
@AppScope
@Component(modules = {NetworkModule.class, AppContextModule.class, RxModule.class, ApiServiceModule.class})
public interface AppComponent {
    RxSchedulers rxSchedulers();
    JsonApi apiService();
}
