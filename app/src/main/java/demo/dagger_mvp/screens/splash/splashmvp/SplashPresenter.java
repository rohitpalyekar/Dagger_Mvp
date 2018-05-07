package demo.dagger_mvp.screens.splash.splashmvp;

import android.util.Log;
import android.widget.Toast;

import demo.dagger_mvp.utils.UiUtils;
import demo.dagger_mvp.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sony on 27-04-2018.
 */

public class SplashPresenter {
    private SplashModel model;
    private RxSchedulers rxSchedulers;
    private CompositeSubscription subscriptions;

    public SplashPresenter(SplashModel model, RxSchedulers rxSchedulers, CompositeSubscription subscriptions) {
        this.model = model;
        this.rxSchedulers = rxSchedulers;
        this.subscriptions = subscriptions;
    }

    public void onCreate(){
        subscriptions.add(getNetworkAvailable());
    }

    public void onDestroy(){
        subscriptions.clear();
    }

    private Subscription getNetworkAvailable() {

        return model.isNetworkAvailable().subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(aBoolean ->
        {
            if(aBoolean==true) {
                model.gotoItemListActivity();
            }else{
                model.networkAlert();
            }
        }, throwable -> UiUtils.handleThrowable(throwable));
    }

}
