package demo.dagger_mvp.screens.splash.splashmvp;


import android.widget.Toast;

import demo.dagger_mvp.api.JsonApi;
import demo.dagger_mvp.screens.splash.SplashScreenActivity;
import demo.dagger_mvp.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by sony on 26-04-2018.
 */

public class SplashModel {

    private JsonApi api;
    private SplashScreenActivity ctx;

    public SplashModel(JsonApi api, SplashScreenActivity ctx) {
        this.api = api;
        this.ctx = ctx;
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(ctx);
    }


    public void gotoItemListActivity() {
        ctx.showItemListActivity();

    }

    public void networkAlert(){
        Toast.makeText(ctx, "Network Connection Fail",
                Toast.LENGTH_LONG).show();
    }
}
