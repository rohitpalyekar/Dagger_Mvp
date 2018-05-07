package demo.dagger_mvp.screens.itemlist.itemlistdagger;

import dagger.Module;
import dagger.Provides;
import demo.dagger_mvp.api.JsonApi;
import demo.dagger_mvp.model.apimodel.ApiGetDemo;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;
import demo.dagger_mvp.screens.itemlist.itemlistmvp.ItemListModel;
import demo.dagger_mvp.screens.itemlist.itemlistmvp.ItemListPresenter;
import demo.dagger_mvp.screens.itemlist.itemlistmvp.ItemListView;
import demo.dagger_mvp.utils.rx.RxSchedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by sony on 05-05-2018.
 */
@Module
public class ItemListModule {
    ItemListActivity itemListActivity;

    public ItemListModule(ItemListActivity itemListActivity) {
        this.itemListActivity = itemListActivity;
    }


    @ItemListScope
    @Provides
    ItemListView provideView(){
        return new ItemListView(itemListActivity);
    }

    @ItemListScope
    @Provides
    ItemListPresenter providePresenter(RxSchedulers rxSchedulers , ItemListView itemListView, ItemListModel itemListModel){
        CompositeSubscription subscriptions = new CompositeSubscription();
        return new ItemListPresenter(rxSchedulers,itemListView,itemListModel,subscriptions);

    }

    @ItemListScope
    @Provides
    ItemListActivity provideContext(){
        return itemListActivity;
    }

    @ItemListScope
    @Provides
    ItemListModel provideModel(JsonApi api){
        return  new ItemListModel(itemListActivity,api);
    }
}
