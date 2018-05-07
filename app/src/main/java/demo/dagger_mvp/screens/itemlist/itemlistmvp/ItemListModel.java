package demo.dagger_mvp.screens.itemlist.itemlistmvp;



import android.widget.Toast;

import demo.dagger_mvp.api.JsonApi;
import demo.dagger_mvp.model.apimodel.ApiGetDemo;
import demo.dagger_mvp.model.apimodel.SourceItemsModel;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;
import demo.dagger_mvp.utils.NetworkUtils;
import rx.Observable;

/**
 * Created by sony on 05-05-2018.
 */

public class ItemListModel {

    ItemListActivity itemListActivity;
    JsonApi api;

    public ItemListModel(ItemListActivity itemListActivity, JsonApi api) {
        this.itemListActivity = itemListActivity;
        this.api = api;
    }

    Observable<ApiGetDemo> provideItemList(String parameter){
        return api.getResponse(parameter);
    }

    Observable<Boolean> isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailableObservable(itemListActivity);
    }

    public void gotoItemDetailsActivity(SourceItemsModel item) {
        itemListActivity.goToItemDetailsActivity(item);
    }
    public void networkAlert(){
        Toast.makeText(itemListActivity, "Network Connection Fail",
                Toast.LENGTH_LONG).show();
    }
}
