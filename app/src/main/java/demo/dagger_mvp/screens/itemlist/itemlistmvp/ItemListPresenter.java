package demo.dagger_mvp.screens.itemlist.itemlistmvp;

import android.util.Log;

import java.util.ArrayList;

import demo.dagger_mvp.model.apimodel.ApiGetDemo;
import demo.dagger_mvp.model.apimodel.SourceItemsModel;
import demo.dagger_mvp.utils.UiUtils;
import demo.dagger_mvp.utils.rx.RxSchedulers;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sony on 05-05-2018.
 */

public class ItemListPresenter {
    ItemListView view;
    ItemListModel model;
    RxSchedulers rxSchedulers;
    CompositeSubscription subscriptions;

    ArrayList<SourceItemsModel> item_list = new ArrayList<>();


    public ItemListPresenter(RxSchedulers rxSchedulers, ItemListView view, ItemListModel model, CompositeSubscription subscriptions) {
        this.view = view;
        this.model = model;
        this.rxSchedulers = rxSchedulers;
        this.subscriptions = subscriptions;
    }


    public void onCreate() {
        Log.d("enter to presenter", "oki");
        subscriptions.add(getItemList());
        subscriptions.add(respondToClick());
    }

    public void onDestroy() {
        subscriptions.clear();
    }

    private Subscription respondToClick() {

        return view.itemClicks().subscribe(integer -> model.gotoItemDetailsActivity(item_list.get(integer)));
    }

    private Subscription getItemList() {
        return model.isNetworkAvailable().doOnNext(networkAvailable -> {
            if (!networkAvailable) {
                Log.d("Network","No Internet");
            }
        }).
                filter(isNetworkAvailable -> true).
                flatMap(isAvailable -> model.provideItemList("1")).
                subscribeOn(rxSchedulers.internet()).
                observeOn(rxSchedulers.androidThread()).subscribe(response -> {
                    Log.d("Alert Type", response.getRetro_source().getAlert_type());
                    view.swapItemAdapter((ArrayList<SourceItemsModel>) response.getRetro_source().getSource_items());
                    item_list.addAll(response.getRetro_source().getSource_items());

                }, throwable -> {
                    UiUtils.handleThrowable(throwable);
                }
        );

    }
}
