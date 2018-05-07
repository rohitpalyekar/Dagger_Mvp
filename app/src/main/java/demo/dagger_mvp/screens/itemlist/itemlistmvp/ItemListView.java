package demo.dagger_mvp.screens.itemlist.itemlistmvp;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import demo.dagger_mvp.R;
import demo.dagger_mvp.model.apimodel.SourceItemsModel;
import demo.dagger_mvp.screens.itemlist.ItemListActivity;
import demo.dagger_mvp.screens.itemlist.list.ItemListAdapter;
import rx.Observable;

/**
 * Created by sony on 05-05-2018.
 */

public class ItemListView {

    @BindView(R.id.item_list_recycleview)
    RecyclerView list;


    View view;

    ItemListAdapter adapter;
    ItemListActivity itemListActivity;

    public ItemListView(ItemListActivity context) {
        FrameLayout parent = new FrameLayout(context);
        parent.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view = LayoutInflater.from(context).inflate(R.layout.activity_itemlist, parent, true);
        ButterKnife.bind(this, view);

        this.itemListActivity=context;
        adapter = new ItemListAdapter();

        list.setAdapter(adapter);
        int tilePadding = context.getResources().getDimensionPixelSize(R.dimen.tile_padding);
        list.setPadding(tilePadding, tilePadding, tilePadding, tilePadding);
        list.setLayoutManager(new GridLayoutManager(context, 2));
    }

    public Observable<Integer> itemClicks()
    {
        return adapter.observeClicks();
    }

    public View view() {
        return view;
    }

    public void swapItemAdapter(ArrayList<SourceItemsModel> items_list)
    {
       adapter.swapItemAdapter(items_list,itemListActivity);
    }
}
