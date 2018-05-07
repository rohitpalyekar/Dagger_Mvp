package demo.dagger_mvp.screens.itemlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import demo.dagger_mvp.application.AppController;
import demo.dagger_mvp.model.apimodel.SourceItemsModel;
import demo.dagger_mvp.screens.itemdetail.ItemDetailsActivity;
import demo.dagger_mvp.screens.itemlist.itemlistdagger.DaggerItemListComponent;
import demo.dagger_mvp.screens.itemlist.itemlistdagger.ItemListModule;
import demo.dagger_mvp.screens.itemlist.itemlistmvp.ItemListPresenter;
import demo.dagger_mvp.screens.itemlist.itemlistmvp.ItemListView;

public class ItemListActivity extends AppCompatActivity {

    @Inject
    ItemListPresenter itemListPresenter;

    @Inject
    ItemListView itemListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DaggerItemListComponent.builder().appComponent(AppController.getNetComponent()).itemListModule(new ItemListModule(this)).build().inject(this);
        setContentView(itemListView.view());
        itemListPresenter.onCreate();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        itemListPresenter.onDestroy();
    }

    public void goToItemDetailsActivity(SourceItemsModel item) {

        Intent in = new Intent(this, ItemDetailsActivity.class);
        in.putExtra("item", item);
        startActivity(in);

    }

}
