package demo.dagger_mvp.screens.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import demo.dagger_mvp.application.AppController;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;
import demo.dagger_mvp.screens.splash.splashdagger.DaggerSplashComponent;
import demo.dagger_mvp.screens.splash.splashdagger.SplashContextModule;
import demo.dagger_mvp.screens.splash.splashmvp.SplashPresenter;
import demo.dagger_mvp.screens.splash.splashmvp.SplashView;


public class SplashScreenActivity extends AppCompatActivity {
    @Inject
    SplashView view;
    @Inject
    SplashPresenter splashPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerSplashComponent.builder().
                appComponent(AppController.getNetComponent()).
                splashContextModule(new SplashContextModule(this)).
                build().inject(this);

        setContentView(view.constructView());
        splashPresenter.onCreate();

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.onDestroy();
    }


    public void showItemListActivity() {
        Log.d("loaded", "ok showed");
     Intent i = new Intent(this, ItemListActivity.class);
     startActivity(i);
     finish();
    }
}
