package demo.dagger_mvp.application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import demo.dagger_mvp.BuildConfig;
import demo.dagger_mvp.application.builder.AppComponent;
import demo.dagger_mvp.application.builder.AppContextModule;
import demo.dagger_mvp.application.builder.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by sony on 12-04-2018.
 */

public class AppController extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initialiseLogger();
        initAppComponent();

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);

    }
    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder().appContextModule(new AppContextModule(this)).build();
    }
    private void initialiseLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            Timber.plant(new Timber.Tree() {
                @Override
                protected void log(int priority, String tag, String message, Throwable t) {
                    //TODO  decide what to log in release version
                }
            });
        }
    }

    public static AppComponent getNetComponent() {
        return appComponent;
    }
}
